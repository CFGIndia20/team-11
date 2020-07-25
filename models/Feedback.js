const mongoose = require('mongoose');

const FeedbackSchema = new mongoose.Schema({
    q1: {
        type: String,
        required: true,
    },
    q2: {
        type: Number,
        required: true,
    },
});
