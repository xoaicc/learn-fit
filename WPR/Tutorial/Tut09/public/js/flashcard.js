class FlashCard {
    constructor(container, word, definition) {
        this._container = container;
        this._word = word;
        this._definition = definition;

        // bind events
        this.flip = this.flip.bind(this);

        this._fillContainer();
    }

    _fillContainer() {
        const box = document.createElement('div');
        box.classList.add('flashcard-box', 'hidden');
        this._container.appendChild(box);

        const wordSide = document.createElement('div');
        wordSide.classList.add('flashcard', 'word');
        box.appendChild(wordSide);

        const definitionSide = document.createElement('div');
        definitionSide.classList.add('flashcard','definition', 'hidden');
        box.appendChild(definitionSide);
        
        // 
        wordSide.textContent = this._word;
        definitionSide.textContent = this._definition;

        // 
        box.addEventListener('click', this.flip);

        this._box = box;
        this._wordSide = wordSide;
        this._definitionSide = definitionSide;
    }

    flip() {
        this._wordSide.classList.toggle('hidden');
        this._definitionSide.classList.toggle('hidden');
    }

    hide() {
        this._box.classList.add('hidden');
    }

    show() {
        this._box.classList.remove('hidden');
    }
}