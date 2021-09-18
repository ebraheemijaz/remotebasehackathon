const InterstCategory = require('../../DB/InterestData');

exports.getAllInterest = async (req, res) => {
  return res.status('200').json(InterstCategory);
};

exports.saveInterest = async (req, res) => {
  return res.status('200').json(InterstData);
};
