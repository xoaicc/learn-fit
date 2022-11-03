const express = require("express");
const mongodb = require("mongodb");
const { ObjectID } = require("bson");
const app = express();

app.use(express.static(__dirname + "/public"));
app.use(express.json());

let db = null;
let id = ObjectID();
let data = null;
let questions = [];

async function startServer() {
  const client  = await mongodb.MongoClient.connect("mongodb://127.0.0.1:27017/wpr-quiz");
  db = client.db();
  console.log("Connected to db");
  app.listen(3000);
  console.log("Server running!");
};
startServer();

app.post("/attempts", async (_, res) => {
  // create a new Attempt with 10 random questions from the questions collection
  data = await db.collection("questions").aggregate([{ $sample: { size: 10 }}]).toArray();

  data.forEach((ele, index) => {
    questions[index] = {
      _id: ele._id,
      answers: ele.answers,
      text: ele.text
    }
  });

  // create Attempt (contains attempt ID & an array of questions)
  const resBody = {
    _id: id,
    questions: questions,
    startedAt: new Date(),
    completed: false
  };
  return res.status(201).json(resBody).end();
});

app.post("/attempts/:id/submit", async (req, res) => {
  const userAnswers = req.body;
  let score = 0;
  let scoreText = "";

  data.forEach((ele, index) => {
    questions[index] = {
      _id: ele._id,
      correctAnswer: ele.correctAnswer
    }
    if (questions[index].correctAnswer === userAnswers[index].selectedIndex) score++;
  });

  if (score < 5) scoreText = "Practice more to improve it :D";
  else if (score >= 5 && score < 7) scoreText = "“Good, keep up!";
  else if (score >= 7 && score < 9) scoreText = "Well done!";
  else scoreText = "Perfect!!"

  const resBody = {
    _id: id,
    questions: questions,
    answers: userAnswers,
    score: score,
    scoreText: scoreText,
    startedAt: new Date(),
    completed: true
  };
  return res.status(200).json(resBody).end();
});