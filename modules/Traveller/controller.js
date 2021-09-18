const InterstData = require('../../DB/InterestData');
const RatingData = require('../../DB/RatingData');

exports.getAllInterest = async (req, res) => {
  return res.status('200').json(InterstData);
};

exports.saveInterest = async (req, res) => {
  const userId = req.query.userId || 1;
  InterstData.Interstdata[userId] = req.body.interests;
  return res.status('200').json(InterstData.Interstdata[userId]);
};

exports.getInterest = async (req, res) => {
  const userId = req.query.userId || 1;
  return res.status('200').json(InterstData.Interstdata[userId]);
};

exports.getRating = async (req, res) => {
  const userId = req.query.userId || 1;
  return res.status('200').json(RatingData);
};

exports.postRating = async (req, res) => {
  const userId = req.query.userId || 1;
  RatingData.RatingData[userId] = req.body;
  return res.status('200').json(RatingData.RatingData[userId]);
};
