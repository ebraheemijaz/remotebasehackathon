const InterstData = require('../../DB/InterestData');

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
