class FlashCard {
    /**
     * @param {string} word 
     * @param {string} definition 
     */
    constructor(word, definition) {

        const flashcardBox = document.createElement("div");
        const wordElement = document.createElement("div");
        const definitionElement = document.createElement("div");
        flashcardBox.classList.add("flashcard-box");
        wordElement.classList.add("word");
        wordElement.classList.add("flashcard");
        wordElement.textContent = word;
        this.wordElement = wordElement;

        definitionElement.classList.add("definition");
        definitionElement.classList.add("flashcard");
        definitionElement.classList.add("hidden");
        definitionElement.textContent = definition;
        this.definitionElement = definitionElement;

        flashcardBox.appendChild(wordElement);
        flashcardBox.appendChild(definitionElement);
        flashcardBox.addEventListener("click", this.flipCard);

        this.flashcardBox = flashcardBox;
        
    }

    // lambda function --> no bind needed
    hide = () => {
        this.flashcardBox.classList.add("hidden");
    }

    show = () => {
        this.flashcardBox.classList.remove("hidden");
    }

    flipCard = () => {
        this.wordElement.classList.toggle("hidden");
        this.definitionElement.classList.toggle("hidden");
    }
}