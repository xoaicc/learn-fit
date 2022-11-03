const cardContainer = document.querySelector('#flashcard-container');
const statusBar = document.querySelector('#status-bar');
const btnPrev = statusBar.querySelector('#prev');
const btnNext = statusBar.querySelector('#next');

// Task 1: flip word/ definition
function flipCard(event) {
    const card = event.currentTarget;
    const word = card.querySelector('.word');
    const definition = card.querySelector('.definition');

    word.classList.toggle('hidden');
    definition.classList.toggle('hidden');
}

// const boxes = cardContainer.querySelectorAll('.flashcard-box');
// for (const card of boxes) {
//     card.addEventListener('click', flipCard);
// }


// Task 2: populate data
function createCard(word, definition) {
    const card = document.createElement('div');
    card.classList.add('flashcard-box');
    card.classList.add('hidden');

    card.innerHTML = `
        <div class="flashcard word">${word}</div>
        <div class="flashcard definition hidden">${definition}</div>
    `;

    return card;
}

function populateCards(cardContainer) {
    const cards = [];

    for (const word in WORDS) {
        const card = createCard(word, WORDS[word]);

        cardContainer.appendChild(card);
        cards.push(card);

        card.addEventListener('click', flipCard);
    }

    return cards;
}

const cards = populateCards(cardContainer);

const statusNoWords = statusBar.querySelector('span');
statusNoWords.textContent = cards.length;


// Task 3: mouse events - navigation
const statusCurrentIndex = statusBar.querySelector('strong');

// on start: show first word
let currentIndex = 0;
setIndex(currentIndex);


function setIndex(index) {
    // check if valid index
    if (index < 0 || index > cards.length-1) {
        return;
    }

    // hide current card
    cards[currentIndex].classList.add('hidden');


    // show card at index
    cards[index].classList.remove('hidden');
    currentIndex = index;


    // disable/ enable navigating buttons
    btnPrev.disabled = currentIndex == 0;
    btnNext.disabled = currentIndex == cards.length - 1;

}

function prevCard() {
    setIndex(currentIndex-1);
}

function nextCard() {
    setIndex(currentIndex+1);
}

btnPrev.addEventListener('click', prevCard);
btnNext.addEventListener('click', nextCard);


// Task 4: keyboard events - navigation
function onKeyDown(event) {
    const key = event.key;

    if (key === 'ArrowLeft') {
        prevCard();
    } else if (key === 'ArrowRight') {
        nextCard();
    }
}

document.addEventListener('keydown', onKeyDown);
