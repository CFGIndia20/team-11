const router = require('express').Router();

// @route    GET api/user
// @desc     Test api
// @access   Public
router.get('/', (req, res) => {
    res.status(400).send('Hi Sir');
});

module.exports = router;
