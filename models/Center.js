const mongoose = require('mongoose');

const CenterSchema = new mongoose.Schema({
    centerCode: {
        type: Number,
    },
    location: {
        type: String,
    },
    capacity: {
        type: Number,
        min: 0,
        max: 5,
        default: 0,
    },
});

module.exports = mongoose.model('center', CenterSchema);
