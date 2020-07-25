const router = require('express').Router();

router.get('/donorfaq', (req, res) => {
    res.status(400).send('donor faq');
});

module.exports = router;