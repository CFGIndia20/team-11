const mongoose = require('mongoose');

const DonorFAQSchema = new mongoose.Schema({
    question: {
        type: String,
    },
    answer: {
        type: String,
    },
});

module.exports = DonorFAQ = mongoose.model('donorFAQ', DonorFAQSchema);
