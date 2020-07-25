/**
 * 
 * 
 * Role ID
 * Role
 * 
 */

 const mongoose = require('mongoose'),

 const RoleSchema = new mongoose.Schema({
    status: {
        type: String,
        enum : ['NEW', 'STATUS'],
        default: 'NEW'
    },
 });