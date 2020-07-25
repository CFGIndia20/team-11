const mongoose = require('mongoose');

const FeedbackSchema = new mongoose.Schema({
    phoneNo: {
        type: Number,
        required: false,
    },
    answer1: {
        type: Number,
        required: true,
    },
    answer2: {
        type: Number,
        required: true,
    },
    answer3: {
        type: Number,
        required: true,
    },
});

module.exports = Feedback = mongoose.model('feedback', FeedbackSchema);
