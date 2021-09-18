const express = require('express');
const router = express.Router();

const Controller = require('./controller');

router.get('/getAllInterest', Controller.getAllInterest);
router.post('/yourinterest', Controller.saveInterest);

module.exports = router;
