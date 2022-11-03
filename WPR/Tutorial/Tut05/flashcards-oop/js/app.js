class App {
    constructor(appContainer, wordsWithDefinitions) {
        // create flashcard-container
        this.flashcardContainer = document.createElement("div");
        this.cards = [];
        let i = 0;

        // create flashcards
        for (const word in wordsWithDefinitions) {
            const definition = wordsWithDefinitions[word];
            const card = new FlashCard(word, definition);
            if (i > 0) {
                card.hide();
            }
            this.cards.push(card);
            this.flashcardContainer.appendChild(card.flashcardBox);
            i++;
        }

        // status bar
        const statusBar = new StatusBar(this.cards.length).statusBarDiv;

        // add to app container
        appContainer.appendChild(this.flashcardContainer);
        appContainer.appendChild(statusBar);

        // event handler
        this._renderAnotherCard = this._renderAnotherCard.bind(this);
        document.addEventListener("next-clicked", this._renderAnotherCard);
        document.addEventListener("prev-clicked", this._renderAnotherCard);
    }

    _renderAnotherCard(eventArgs) {
        const currentIndex = eventArgs.detail.currentIndex;
        const newIndex = eventArgs.detail.newIndex;
        const currentCard = this.cards[currentIndex];
        currentCard.hide();
        const newCard = this.cards[newIndex];
        newCard.show();
    }
}

const appContainer = document.querySelector("#main");
const app = new App(appContainer, KOREAN);