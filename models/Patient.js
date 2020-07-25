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
        patientID: {
            type: Number,
        
        },
        name: {
            
        }
});

module.exports = Patient = mongoose.model('User', PatientSchema);