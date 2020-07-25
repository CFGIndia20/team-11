const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const DonorFAQ = require('../../models/DonorFAQ');
const User = require('../../models/User');
const Center = require('../../models/Center');

// @route    GET api/donorfaq
// @desc     Get Donor FAQ,
// @access   Public
router.post(
    '/',
    [auth, check('q', 'No Question').isNumeric()],
    async (req, res) => {
        try {
            const user = await User.findById(req.user.id);

            if (user['roleStatus'] !== 'Donor') {
                return res.status(400).json({
                    errors: [{ msg: 'Access Denied' }],
                });
            }

            const q = req.body;

            switch (q) {
                case 1:
                    const center = Center.findOne({ centerCode: user['centerCode']});
                    return res.status(200).json({ ans: center['capacity'] });

                case 2:
                    return res.status(200).json({ ans: "John Wick" });

                case 3:
                    return res.status(200).json({ ans: 1 });

                default:
                    break;
            }
            res.status(200).json(newDonorFAQ);
        } catch (err) {
            console.log(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
