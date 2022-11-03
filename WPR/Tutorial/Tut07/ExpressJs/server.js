const express = require("express");
const app = express();

// serve static files
app.use(express.static(__dirname + "/public"));

const bodyParser = require("body-parser");
app.use(bodyParser.json());

// handle paths
app.get("/", (_, res) => {
  res.end('Hello World!');
});

app.get("/hello", (req, res) => {
  const name = req.query.name;
  if (name === undefined) {
    res.end("Hello no one!");
  }
  res.end(`Hello, ${name}!`)
});

// words
const words = {
  '네':'yes',
  '아니요':'no'
};

app.get("/words", (_, res) => {
  res.json(words);
});

app.post("/words", (req, res) => {
  const body = req.body;
  const word = body.word;
  if (word in words) {
    res.status(409).json({
      "message": `Word ${word} already exists in the dictionary!`
    }).end();
  } else {
    words[word] = body.definition;
    const resBody = {};
    resBody[word] = body.definition;
    res.status(201).json(resBody).end();
  }
});

app.put("/words/:word", (req, res) => {
  const toUpdate = req.params.word;
  if (toUpdate in words) {
    const body = req.body;
    words[toUpdate] = body.definition;
    const resBody = {};
    resBody[toUpdate] = body.definition;
    res.status(200).json(resBody).end();
  } else {
    res.status(404).json({
      "message": `Word ${toUpdate} is not found!`
    }).end();
  }
});

app.delete("/words/:word", (req, res) => {
  const toDelete = req.params.word;
  if (toDelete in words) {
    delete words[toDelete];
    res.status(204).end();
  } else {
    res.status(404).json({
      "message": `Word ${toDelete} is not found!`
    }).end();
  }
  
});

app.listen(3000, () => {
  console.log('Server running!');
})