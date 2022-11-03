class App {
    constructor(appContainer, cards, statusBar){
        const cardContainer = document.createElement('div');
        cardContainer.classList.add('flashcard-container');
        let i = 0;
        for (const card of cards){
            if (i !== 0){
                card.classList.add('hidden');
            }

            cardContainer.appendChild(card);
            i++
        }
        appContainer.appendChild(cardContainer);
        appContainer.appendChild(statusBar);
        this.appContainer = appContainer;
    }

    render (){
        return this.appContainer;
    }
}

let cardElements = [];
for (const word in KOREAN){
    const flashCard = new FlashCards(word, KOREAN[word]);
    const cardElement = flashCard.render();
    cardElements.push(cardElement);
}

const statusBar = new StatusBar (cardElements.length).render();
const appContainer = document.querySelector("#main");
const app = new App (appContainer, cardElements, statusBar);