const express = require('express');
const connectDB = require('./config/db');

const app = express();

// Connect DB
connectDB();

// Middlewares
app.use(express.json({ extended: false }));

// Route
app.use('/api/user', require('./routes/api/user'));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => console.log(`Server running on ${PORT}`));
