const express = require('express');
const connectDB = require('./config/db');

const app = express();

// Connect DB
connectDB();

// Middlewares
app.use(express.json({ extended: false }));

// Route
app.use('/api/user', require('./routes/api/user'));
app.use('/api/auth', require('./routes/api/auth'));
app.use('/api/feedback', require('./routes/api/feedback'));
app.use('/api/patient', require('./routes/api/patient'));
app.use('/api/center', require('./routes/api/center'));
app.use('/api/donorfaq', require('./routes/api/donorfaq'));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => console.log(`Server running on ${PORT}`));
