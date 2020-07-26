const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const Center = require('../../models/Center');

// @route    GET api/center
// @desc     Get center data
// @access   Public
router.post(
    '/',
    [
        check('centerCode', 'Name required').isNumeric(),
        check('location', 'Name required').not().isEmpty(),
    ],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { centerCode, location } = req.body;

        try {
            const newCenter = new Center({ centerCode, location });

            await newCenter.save();

            res.status(200).json(newCenter);
        } catch (err) {
            console.log(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
