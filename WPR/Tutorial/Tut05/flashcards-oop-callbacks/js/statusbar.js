class StatusBar {
    constructor(numOfCards, renderNextCard) {
        this.numOfCards = numOfCards;
        this.currentIndex = 0;
        this.renderNextCard = renderNextCard; // don't bind!

        const statusBarDiv = document.createElement("div");
        statusBarDiv.innerHTML = `
            <button disabled id="prev">&larr;</button>
            <strong id="index-card">1</strong>/<span id="num-cards">${numOfCards}</span>
            <button id="next">&rarr;</button>
        `;
        this.statusBarDiv = statusBarDiv;

        this.btnNext = statusBarDiv.querySelector("#next");
        this.btnPrev = statusBarDiv.querySelector("#prev");
        this.textCurrentIndex = statusBarDiv.querySelector("#index-card");
        this.textNumCards = statusBarDiv.querySelector("#num-cards");

        this.btnNext.addEventListener("click", this.nextCard);
        this.btnPrev.addEventListener("click", this.prevCard);
    }

    /**
     * @param {number} index
     */
    validIndex(index) {
        return index >= 0 && index < this.numOfCards;
    }

    _disableButton = (index) => {
        // check if valid index
        if (index >= 0 && index < this.numOfCards) {
            // disable/ enable navigating buttons
            if (index === 0) {
                // disable previous button
                this.btnPrev.disabled = true;
            } else {
                // enable prev
                this.btnPrev.disabled = false;
            }
            if (index === this.numOfCards - 1) {
                // disable next button
                this.btnNext.disabled = true;
            } else {
                // enable next
                this.btnNext.disabled = false;
            }
        }
    }

    nextCard = () => {
        const newIndex = this.currentIndex + 1;
        if (this.validIndex(newIndex)) {
            this.textCurrentIndex.textContent = (newIndex + 1).toString();
            const currentIndex = this.currentIndex;
            this.currentIndex = newIndex;
            this._disableButton(newIndex);
            this.renderNextCard(currentIndex, newIndex);
        }
    }

    prevCard = () => {
        const newIndex = this.currentIndex - 1;
        if (this.validIndex(newIndex)) {
            this.textCurrentIndex.textContent = (newIndex + 1).toString();
            const currentIndex = this.currentIndex;
            this.currentIndex = newIndex;
            this._disableButton(newIndex);
            this.renderNextCard(currentIndex, newIndex);
        }
    }

}