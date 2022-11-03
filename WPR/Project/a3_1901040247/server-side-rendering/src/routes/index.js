const Question = require('../models/Questions');
const { mulMongoObj } = require('../Mongo');
const { mongoObj } = require('../Mongo');

function routes(app) {
    app.get('/', (_, res) => {
        Question.find({}).then((question) => {res.render('home', {question: mulMongoObj(question)});})
    });

    app.get('/search', (req, res) => {
        const keyword = req.query.text;
        Question.find({"text": {"$regex": keyword, "$options": "i"}}).then((question) => {res.render('home', {question: mulMongoObj(question)});})
    });

    app.get('/add', (_, res) => {
        res.render('add');
    });

    app.post('/add/create', (req, res) => {
        const data = req.body;
        if (data.correctAnswer === undefined) data.correctAnswer = '-1';
        const question = new Question(data);
        question.save().then(() => {res.redirect('/')})
    });
    
    app.get('/edit/:id', (req, res) => {
        Question.findById(req.params.id).then((question) => {res.render('edit', {question: mongoObj(question)})})
    });

    app.put('/update/:id', (req, res) => {
        const data = req.body;
        if (data.correctAnswer === undefined) data.correctAnswer = '-1';
        Question.updateOne({ _id: req.params.id }, data).then(() => {res.redirect('/');})
    });

    app.delete('/delete/:id', (req, res) => {
        Question.deleteOne({ _id: req.params.id }).then(() => {res.redirect('/')})
    });
}

module.exports = routes