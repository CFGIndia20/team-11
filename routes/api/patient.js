const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Center = require('../../models/Center');
require('dotenv').config();
const mongoose = require('mongoose');
const Patient = require('../../models/Patient');

// @route    GET api/patient/:patient_id
// @desc     Get Feedback Avg. from DB
// @access   Public
router.get('/:patient_id', async (req, res) => {
    try {
        const patient_id = req.params.patient_id;

        const patient = await Patient.findOne({ uid: patient_id });

        res.status(200).json(patient);
    } catch (err) {
        console.log(err.message);
        res.status(500).send('Server Error');
    }
});

// @route    GET api/feedback
// @desc     Get Feedback Avg. from DB
// @access   Public
router.post(
    '/',
    [
        check('uid', 'Uid required').not().isEmpty(),
        check('name', 'Name required').not().isEmpty(),
        check('disease', 'Name required').not().isEmpty(),
        check('familyMember', 'Name required').not().isEmpty(),
        check('admission', 'Name required').not().isEmpty(),
        check('center', 'Name required').not().isEmpty(),
    ],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const {
            uid,
            name,
            disease,
            familyMember,
            admission,
            center,
        } = req.body;

        try {
            const newPatient = Patient({
                uid,
                name,
                disease,
                familyMember,
                admission,
                center,
            });

            await newPatient.save();

            res.status(200).json(newPatient);
        } catch (err) {
            console.log(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
