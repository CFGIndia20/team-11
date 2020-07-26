const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const User = require('../../models/User');
require('dotenv').config();

// @route    GET api/user
// @desc     Test api
// @access   Public
router.get('/', (req, res) => {
    res.status(400).send('Hi Sir');
});

// @route    POST api/user
// @desc     Add user to db
// @access   Public
router.post(
    '/',
    [
        check('name', 'Name is required').not().isEmpty(),
        check('email', 'Please include a valid email').isEmail(),
        check(
            'password',
            'Password should be atleast 6 characters long'
        ).isLength({ min: 6 }),
        check('roleStatus', 'Role Status is required').not().isEmpty(),
    ],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const {
            name,
            email,
            phone,
            password,
            roleStatus,
            centerCode,
        } = req.body;

        try {
            // See if user exists
            let user = await User.findOne({ email });

            if (user) {
                return res.status(400).json({
                    errors: [{ msg: 'User already exists' }],
                });
            }

            user = new User({
                name,
                email,
                phone,
                password,
                roleStatus,
                centerCode,
            });

            // Encrypt password
            user.password = await bcrypt.hash(
                password,
                await bcrypt.genSalt(10)
            );

            await user.save();

            // Return JWT
            const payload = {
                user: {
                    id: user.id,
                },
            };

            jwt.sign(
                payload,
                process.env.JWTSECRET,
                {
                    expiresIn: 360000,
                },
                (err, token) => {
                    if (err) throw err;
                    res.json({ token });
                }
            );
        } catch (err) {
            console.error(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
