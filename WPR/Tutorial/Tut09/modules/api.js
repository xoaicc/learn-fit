const express = require('express');
const router = express.Router();

// get all words
router.get('/words', async function(req, res) {
    const db = req.db;
    const docs = await db.collection('words').find().toArray();

    const WORDS = {};
    for (const doc of docs) {
        WORDS[doc.word] = doc.definition;
    }

    res.json(WORDS); // OK (by default)
});

// create a new word
router.post('/words', async function (req, res){
    const db = req.db;
    const word = req.body.word;
    const definition = req.body.definition;

    const doc = await db.collection('words').findOne({word: word});

    if (doc != null) { // word already exists
        return res.status(409).end(); // CONFLICT
    }

    const result = await db.collection('words').insertOne({word: word, definition: definition});
    console.log(result);
    res.status(201).json({word: definition});
});

// update a word
router.put('/words/:word', async function(req, res) {
    const db = req.db;
    const word = req.params.word;
    const definition = req.body.definition;

    const doc = await db.collection('words').findOne({word: word});

    if (doc == null) { // word not exist
        return res.status(404).end(); // NOT FOUND
    }

    const result = await db.collection('words').update({word: word}, {word: word, definition: definition});
    console.log(result);
    
    res.json({word: definition}); // OK (by default)
});

// delete a word
router.delete('/words/:word', async function (req, res){
    const db = req.db;
    const word = req.params.word;
    const definition = req.body.definition;
    
    const doc = await db.collection('words').findOne({word: word});

    if (doc == null) { // word not exist
        return res.status(404).end(); // NOT FOUND
    }

    const result = await db.collection('words').deleteOne({word: word});
    console.log(result);

    res.json({word: definition}); // OK (by default)
});

module.exports = router;
