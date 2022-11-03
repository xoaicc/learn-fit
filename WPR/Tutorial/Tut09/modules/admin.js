const express = require('express');
const router = express.Router();

// admin routes
// Show all words
router.get("/admin/words", async (req, res) => {
    const db = req.db;
    const words = await db.collection('words').find().toArray();

    res.render("all-words", {
        title: "All words",
        words: words
    });
});

// Show one word
router.get("/admin/words/details/:word", async (req, res) => {

});

// Add new word screen
router.get("/admin/words/add", async (req, res) => {
    res.render("add-word", {
        title: "Add new word"
    });
});

// Add new word - action
router.post("/admin/words/add", async (req, res) => {
    const db = req.db;
    const body = req.body;
    const word = body.word;
    const definition = body.definition;
    const doc = await db.collection('words').findOne({word: word});

    if (doc != null) { // word already exists
        return res.render("add-word", {
            title: "Add new word",
            warning: "Word already exists: " + word
        });
    }

    const result = await db.collection('words').insertOne({word: word, definition: definition});
    console.log(result);
    res.redirect("/admin/words");
});

// Update word screen
router.get("/admin/words/update/:word", async (req, res) => {
    console.log("zzzzz")
});

// Update word - action
router.post("/admin/words/update/:word", async (req, res) => {

});

// Delete word - action
router.get("/admin/words/delete/:word", async (req, res) => {
    const db = req.db;
    const word = req.params.word;
    
    const doc = await db.collection('words').findOne({word: word});

    if (doc == null) { // word not exist
        return res.status(404).end(); // NOT FOUND
    }

    const result = await db.collection('words').deleteOne({word: word});
    console.log(result);
    res.redirect("/admin/words");
});

module.exports = router;
