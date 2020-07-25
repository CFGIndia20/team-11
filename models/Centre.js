const mongoose = require('mongoose');

const CentreSchema = new mongoose.Schema({
    centreCode: {
        type: String,
        required: false,
        unique: true,
    },
    location: {
        type: String,
        required: true,
    },
});
module.exports = Centre = mongoose.model('centre', CentreSchema);
