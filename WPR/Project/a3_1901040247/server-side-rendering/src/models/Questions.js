const mongoose = require('mongoose');
const schema = mongoose.Schema;

const Question = new schema({
    text: String,
    answers: Object,
    correctAnswer: Number,
})

module.exports = mongoose.model('Question', Question);