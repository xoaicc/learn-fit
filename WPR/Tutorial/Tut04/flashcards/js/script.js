const cardContainer = document.querySelector('#flashcard-container');
const statusBar = document.querySelector('#status-bar');
const btnPrev = statusBar.querySelector('#prev');
const btnNext = statusBar.querySelector('#next');

// Task 1: flip word/ definition
function flipCard(event) {
    console.log([event]);
    const clickedFlashcardBox = event.currentTarget;
    const wordSide = clickedFlashcardBox.querySelector(".word");
    const definitionSide = clickedFlashcardBox.querySelector(".definition");

    wordSide.classList.toggle("hidden");
    definitionSide.classList.toggle("hidden");
}

// Task 2: populate data
function createCard(word, definition) {
    const flashcardBox = document.createElement("div");
    flashcardBox.classList.add("flashcard-box");

    const wordSide = document.createElement("div");
    wordSide.classList.add("flashcard", "word");
    wordSide.textContent = word;

    const definitionSide = document.createElement("div");
    definitionSide.classList.add("flashcard", "definition", "hidden");
    definitionSide.textContent = definition;

    flashcardBox.appendChild(wordSide);
    flashcardBox.appendChild(definitionSide);

    return flashcardBox;
}

function populateCards(cardContainer) {
    let i = 0;
    let cards = [];
    for (const word in KOREAN) {
        const definition = KOREAN[word];
        const card = createCard(word, definition);
        if (i !== 0) {
            card.classList.add("hidden");
        }
        cards.push(card);
        cardContainer.appendChild(card);
        card.addEventListener("click", flipCard);
        i++;
    }
    return cards;
}

const cards = populateCards(cardContainer);

const statusNoWords = statusBar.querySelector('span');
statusNoWords.textContent = cards.length.toString();

// Task 3: mouse events - navigation
const statusCurrentIndex = statusBar.querySelector('strong');
let currentIndex = 0;

function validIndex(index) {
    const numCards = cards.length;
    return index < numCards && index >= 0;
}

function setIndex(index) {
    if (!validIndex(index)) {
        return;
    }

    const currentCard = cards[currentIndex];
    currentCard.classList.toggle("hidden");

    const newVisibleCard = cards[index];
    newVisibleCard.classList.toggle("hidden");
    currentIndex = index;

    btnPrev.disabled = (index === 0);
    const maxIndex = cards.length - 1;
    btnNext.disabled = (index === maxIndex);
    statusCurrentIndex.textContent = (index + 1).toString();
}

function prevCard() {
    setIndex(currentIndex - 1);
}

function nextCard() {
    setIndex(currentIndex + 1);
}

btnPrev.addEventListener("click", prevCard);
btnNext.addEventListener("click", nextCard);

// Task 4: keyboard events - navigation
function onKeyDown(event) {
    const key = event.key;
    switch (key) {
        case "ArrowLeft":
            prevCard();
            break;
        case "ArrowRight":
            nextCard();
            break;
    }
}

document.addEventListener("keydown", onKeyDown);