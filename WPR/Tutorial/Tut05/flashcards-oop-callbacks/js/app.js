class App {
  /**
   * 
   * @param {HTMLDivElement} appContainer 
   * @param {{}} wordsWithDefinitions 
   */
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

    this._renderAnotherCard = this._renderAnotherCard.bind(this);
    
    // status bar
    const statusBar = new StatusBar(
      this.cards.length, this._renderAnotherCard
    ).statusBarDiv;

    // add to app container
    appContainer.appendChild(this.flashcardContainer);
    appContainer.appendChild(statusBar);

  }

  _renderAnotherCard(currentIndex, newIndex) {
    const currentCard = this.cards[currentIndex];
    currentCard.hide();
    const newCard = this.cards[newIndex];
    newCard.show();
  }
}

const path = "https://wpr-quiz-api.herokuapp.com/words";
// fetch data from API
fetch(path, {
  method: "GET",
  headers: {
    "Content-Type": "application/json"
  }
}).then((response) => response.json())
  .then((koreanWords) => {
    const appContainer = document.querySelector("#main");
    const app = new App(appContainer, koreanWords);
  });