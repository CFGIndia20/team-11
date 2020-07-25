const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Feedback = require('../../models/Feedback');
require('dotenv').config();
const mongoose = require('mongoose');
const Centre = require('../../models/Centre');

// @route    GET api/feedback
// @desc     Get Feedback Avg. from DB
// @access   Public

router.post(
    '/',
    [check('location', 'Name required').not().isEmpty()],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { location } = req.body;
        console.log(location);

        try {
            const newCentre = Centre(location);

            await newCentre.save();

            res.status(200).json(newCentre);
        } catch (err) {
            console.log(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
