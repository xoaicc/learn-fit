class App {
    constructor(cardContainer, statusBarContainer, words) {
        this._cardContainer = cardContainer;
        this._statusBarContainer = statusBarContainer;
        this._words = words;

        this._cards = [];

        // bind events
        this.prevCard = this.prevCard.bind(this);
        this.nextCard = this.nextCard.bind(this);
        
        this._fillCardContainer();

        // TASK 1: custom event
        // this._statusBar = new StatusBar(statusBarContainer, this._cards.length);

        // TASK 2: callbacks
        this._statusBar = new StatusBar(statusBarContainer, this._cards.length, this.prevCard, this.nextCard);

        // show first word if not empty
        if (this._cards.length > 0) {
            this._currentIndex = 0;
            this._cards[this._currentIndex].show();
            this._statusBar.setCurrentIndex(this._currentIndex);
        }

        // TASK 1: custom event
        // document.addEventListener('prev-clicked', this.prevCard);
        // document.addEventListener('next-clicked', this.nextCard);

    }

    /**
     * @modifies this.cards
     */
    _fillCardContainer() {
        for (const word in this._words) {
            // TASK 1: custom event
            // const card = new FlashCard(this._cardContainer, word, this._words[word]);

            // TASK 2: 
            const card = new FlashCard(this._cardContainer, word, this._words[word]);
    
            this._cards.push(card);
        }
    }

    prevCard() {
        if (this._currentIndex == 0) {
            return;
        }

        this._cards[this._currentIndex].hide();

        this._currentIndex--;
        this._cards[this._currentIndex].show();
    }

    nextCard() {
        if (this._currentIndex == this._cards.length-1) {
            return;
        }

        this._cards[this._currentIndex].hide();

        this._currentIndex++;
        this._cards[this._currentIndex].show();
    }
}