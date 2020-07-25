const mongoose = require('mongoose');

const DonorFAQSchema = new mongoose.Schema({
    question: {
        type: String,
        required: true,
    },
    answer: {
        type: String,
        required: true,
    },
});

module.exports = DonorFAQ = mongoose.model('donorfaq', DonorFAQSchema);
