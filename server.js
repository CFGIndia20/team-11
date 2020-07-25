const express = require('express');

const app = express();

// Middlewares
app.use(express.json({ extended: false }));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => console.log(`Server running on ${PORT}`));
