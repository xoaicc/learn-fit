const path = require('path')
const route = require('./routes')
const express = require('express')
const mongoose = require('mongoose')
const { engine } = require('express-handlebars')
const mto = require('method-override')

const app = express()

app.use(express.static(path.join(__dirname, '/public')))
app.use(express.json());
app.use(express.urlencoded({ extended: true }))
app.use(mto('_method'))

app.engine('hbs', engine({
    extname: '.hbs',
    helpers: {
        sum: (a, b) => a + b,
        findIndex: (a, b) => a[b],
    }
}))

app.set('view engine', 'hbs')
app.set('views', path.join(__dirname, 'views'))

route(app)

app.listen(3000, async () => {
    await mongoose.connect('mongodb://127.0.0.1:27017/wpr-quiz')
    console.log('Connected to db!')
})