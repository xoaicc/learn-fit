const express = require("express");
const { MongoClient, Db, Collection } = require("mongodb");
const app = express();

// serve static files
app.use(express.static(__dirname + "/public"));

app.use(express.json());

// db setup
const DB_NAME = "eng-dict";
const MONGO_URL = `mongodb://localhost:27017/${DB_NAME}`;

/** @type {Db} */
let db;
/** @type {Collection} */
let collection;


// words
const words = {
  '네':'yes',
  '아니요':'no'
};

app.get("/words", async (_, res) => {
  /** @type {{word: string, definition: string}[]} */
  const entries = await collection.find().toArray();
  const words = {};
  for (const entry of entries) {
    words[entry.word] = entry.definition;
  }
  res.json(words);
});

app.post("/words", async (req, res) => {
  const body = req.body;
  const word = body.word;
  const existingEntry = await collection.findOne({ word: word });

  if (existingEntry !== null) {
    res.status(409).json({
      "message": `Word ${word} already exists in the dictionary!`
    }).end();
  } else {
    // words[word] = body.definition;
    // insert one
    await collection.insertOne({
      word: word,
      definition: body.definition
    });

    const resBody = {};
    resBody[word] = body.definition;
    res.status(201).json(resBody).end();
  }
});

app.put("/words/:word", async (req, res) => {
  // handle update word here
  const toUpdate = req.params.word; 
  const existingEntry = await collection.findOne({ word: toUpdate });
  if (existingEntry !== null) {
    // perform update
    const body = req.body;
    const definition = body.definition;

    // mongodb update
    const query = { _id: existingEntry._id };
    const newEntry = { $set: { definition: definition } };
    const params = { upsert: true };
    await collection.updateOne(query, newEntry, params);

    const resBody = {};
    resBody[toUpdate] = definition;
    res.status(200).json(resBody).end();
  } else {
    res.status(404).json({
      "message": `Word ${toUpdate} is not found!`
    }).end();
  }
});

app.delete("/words/:word", async (req, res) => {
  const toDelete = req.params.word;
  const existingEntry = await collection.findOne({ word: toDelete });
  if (existingEntry !== null) {
    await collection.deleteOne({ _id: existingEntry._id });
    res.status(204).end();
  } else {
    res.status(404).json({
      "message": `Word ${toDelete} is not found!`
    }).end();
  }
  
});

const setupDb = async () => {
  const client = await MongoClient.connect(MONGO_URL);
  db = client.db();
  collection = db.collection("words");
};

app.listen(3000, async () => {
  await setupDb();
  console.log('Server running!');
});
