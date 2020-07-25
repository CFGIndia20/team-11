const router = require('express').Router();
const { check, validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const Feedback = require('../../models/Feedback');
require('dotenv').config();

router.get('/', async (req, res) => {
    try {
        const feedbacks = await Feedback.find();

        console.log(feedbacks);
    } catch (err) {}
});

module.exports = router;
