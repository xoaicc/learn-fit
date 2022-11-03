// const WORDS = {
//     '네': 'yes', 
//     '아니요': 'no'
// };

const express = require('express');
const exphbs = require('express-handlebars');
const mongodb = require('mongodb');
const api = require("./modules/api");
const admin = require("./modules/admin");

const app = express();
let db = null;

const hbs = exphbs.create();
app.engine('handlebars', hbs.engine);
app.set('view engine', 'handlebars');

// serve static files (html, css, js, images...)
app.use(express.static('public'));

// decode req.body from form-data
app.use(express.urlencoded({ extended: true }));
// decode req.body from post body message
app.use(express.json());

app.use((req, res, next) => {
    req.db = db;
    next();
});

app.use(api);
app.use(admin);

app.get('/hello', function(req, res) {
    res.send('Hello ' + req.query.name + '!');
});


async function startServer() {
    const client = await mongodb.MongoClient.connect(
        'mongodb://localhost:27017/eng-dict', { useUnifiedTopology: true });
    db = client.db();
    console.log('connected to db.');

    await app.listen(3000);
    console.log('Listening on port 3000!');
}
startServer();

// app.listen(3000, function(){
//     console.log('Listening on port 3000!');
// }); 