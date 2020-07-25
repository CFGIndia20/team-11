const mongoose = require('mongoose');
const dotenv = require('dotenv').config();

const connectDB = async () => {
    try {
        await mongoose.connect(process.env.MONGO_URI, {
            useNewUrlParser: true,
            useUnifiedTopology: true,
            useCreateIndex: true,
            useFindAndModify: false,
        });
        console.log('MongoDB connected');
    } catch (err) {
        console.error(err.message);

        // Exit process with failure
        process.emit(1);
    }
};

module.exports = connectDB;
