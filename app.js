const express = require('express');

const travellerRouter = require('./modules/Traveller/routes');

const app = express();
app.use(express.json());

app.use('/api/traveller', travellerRouter);

module.exports = app;
