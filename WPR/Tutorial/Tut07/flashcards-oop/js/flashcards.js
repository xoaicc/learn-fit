class FlashCards {
    constructor (word, definition){
        this.word = word;
        this.definition = definition;
        this.box = document.createElement('div');
    }

    flipcard (event){
        const clickedCard = event.currentTarget;
        const wordCard = clickedCard.querySelector('.word');
        const defCard = clickedCard.querySelector('.definition')
    
        wordCard.classList.toggle('hidden')
        defCard.classList.toggle('hidden')
    }

    render() {
        const box = this.box;
        box.classList.add('flashcard-box');
        box.innerHTML = `<div class="flashcard word">${this.word}</div>
        <div class="flashcard definition hidden">${this.definition}</div>`;
        box.addEventListener('click', this.flipcard);
        return box;
    }
}