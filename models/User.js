/**
 *
 *
 * Name
 * Email ID
 * Phone No.
 * Password
 * Role ID
 */

const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
    },
    email: {
        type: String,
        required: true,
        unique: true,
    },
    phone: {
        type: Number,
    },
    password: {
        type: String,
        required: true,
    },
    roleStatus: {
        type: String,
        enum: ['NGO', 'CMS', 'DONOR'],
        default: 'CMS',
    },
});

module.exports = User = mongoose.model('User', UserSchema);
