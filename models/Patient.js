/**
 *
 * PatientId
 * Name
 * Disease
 * FamilyMember
 * EntryDate
 * ExitDate
 * Admission
 */

const mongoose = require('mongoose');

const PatientSchema = new mongoose.Schema({
    uid: {
        type: Number,
        required: true,
        unique: true,
    },
    name: {
        type: String,
        required: true,
    },
    disease: {
        type: String,
        required: true,
    },
    familyMember: {
        type: Array,
        required: true,
    },
    entryDate: {
        type: Date,
    },
    exitDate: {
        type: Date,
    },
    admission: {
        type: String,
        required: true,
    },
    center: {
        type: Number,
        required: true,
    },
});

module.exports = Patient = mongoose.model('patient', PatientSchema);
