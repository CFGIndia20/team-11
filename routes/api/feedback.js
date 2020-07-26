const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Feedback = require('../../models/Feedback');
require('dotenv').config();
const mongoose = require('mongoose');

// @route    GET api/feedback
// @desc     Get Feedback Avg. from DB
// @access   Public
router.get('/', async (req, res) => {
    try {
        const feedbacks = await Feedback.find();

        let answer1 = 0,
            answer2 = 0,
            answer3 = 0;

        const feedbackSize = feedbacks.length;

        feedbacks.forEach((element) => {
            answer1 += element['answer1'];
            answer2 += element['answer2'];
            answer3 += element['answer3'];
        });

        answer1 /= feedbackSize;
        answer2 /= feedbackSize;
        answer3 /= feedbackSize;

        res.status(200).json({
            answer1,
            answer2,
            answer3,
        });
    } catch (err) {
        console.error(err.message);
        res.status(500).send('Server Error');
    }
});

// @route    POST api/feedback
// @desc     Add feedback to DB
// @access   Public
router.post(
    '/',
    [
        check('answer1', 'Answer is needed').isNumeric(),
        check('answer2', 'Answer is needed').isNumeric(),
        check('answer3', 'Answer is needed').isNumeric(),
    ],
    async (req, res) => {
        const errors = validationResult(req);

        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { phoneNo, answer1, answer2, answer3 } = req.body;

        try {
            const newFeedback = new Feedback({
                phoneNo,
                answer1,
                answer2,
                answer3,
            });

            await newFeedback.save();

            res.status(200).json(newFeedback);
        } catch (err) {
            console.error(err.message);
            res.status(500).send('Server Error');
        }
    }
);

module.exports = router;
