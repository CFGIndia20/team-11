const mongoose = require('mongoose');

const CentreSchema = new mongoose.Schema({
    centrecode: {
        type: Number,
        require: true,
        unique: true,
    },
    location: {
        type: String,
        require: true,
    },
});
module.exports = Centre = mongoose.model('Centre', CentreSchema);
