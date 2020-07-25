const router = require('express').Router();

router.get('/', (req, res) => {
    res.status(400).send('Hi Sir');
});

module.exports = router;
