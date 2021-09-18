const express = require('express');
const router = express.Router();

const Controller = require('./controller');

router.get('/getAllInterest', Controller.getAllInterest);
router.post('/yourinterest', Controller.saveInterest);
router.get('/getInterest', Controller.getInterest);
router.get('/rating', Controller.getRating);
router.post('/rating', Controller.postRating);

module.exports = router;
