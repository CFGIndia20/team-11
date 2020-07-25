const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Feedback = require('../../models/Feedback');
require('dotenv').config();
const mongoose = require('mongoose');
const Patient = require('../../models/Patient');

// @route    GET api/feedback
// @desc     Get Feedback Avg. from DB
// @access   Public
router.post(
    '/',
    [
        check('name', 'Name required').not().isEmpty(),
        check('disease', 'Name required').not().isEmpty(),
        check('familyMember', 'Name required').not().isEmpty(),
        check('admission', 'Name required').not().isEmpty(),
        check('centre', 'Name required').not().isEmpty(),
    ],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { name, disease, familyMember, admission, centre } = req.body;

        try {
            const newPatient = Patient(
                name,
                disease,
                familyMember,
                admission,
                centre
            );

            await newPatient.save();
        } catch (err) {
            console.log(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
