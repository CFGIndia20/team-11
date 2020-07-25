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
    centre: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'centre',
    },
});

module.exports = Patient = mongoose.model('patient', PatientSchema);
