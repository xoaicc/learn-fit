class StatusBar {
    // TASK 1: custom event
    // constructor(container, maxIndex) {
    
    // TASK 2: callbacks
    constructor(container, maxIndex, prevCallback, nextCallback) {
        this._container = container;
        this._maxIndex = maxIndex;

        // TASK 2: callbacks
        this._prevCallback = prevCallback;
        this._nextCallback = nextCallback;

        // bind events
        this.onPrevClick = this.onPrevClick.bind(this);
        this.onNextClick = this.onNextClick.bind(this);
        this.onKeyDown = this.onKeyDown.bind(this);


        this._fillContainer();
    }

    _fillContainer() {
        const btnPrev = document.createElement('button');
        btnPrev.textContent = '<';
        this._container.appendChild(btnPrev);

        const lblCurrentIndex = document.createElement('strong');
        this._container.appendChild(lblCurrentIndex);

        this._container.appendChild(document.createTextNode('/'));

        const lblMaxIndex = document.createElement('span');
        lblMaxIndex.textContent = this._maxIndex;
        this._container.appendChild(lblMaxIndex);

        const btnNext = document.createElement('button');
        btnNext.textContent = '>';
        this._container.appendChild(btnNext);

        // 

        btnPrev.addEventListener('click', this.onPrevClick);
        btnNext.addEventListener('click', this.onNextClick);
        // keyboard events
        document.addEventListener('keydown', this.onKeyDown);
        

        this._lblCurrentIndex = lblCurrentIndex;
        this._btnPrev = btnPrev;
        this._btnNext = btnNext;
    }

    onKeyDown(event) {
        const key = event.key;
    
        if (key === 'ArrowLeft') {
            this.onPrevClick();
        } else if (key === 'ArrowRight') {
            this.onNextClick();
        }
    }
    
    onPrevClick() {
        this.setCurrentIndex(this._currentIndex-1);
        
        // TASK 1: custom event
        // document.dispatchEvent(new CustomEvent('prev-clicked'));

        // TASK 2: callback
        this._prevCallback();

    }

    onNextClick() {
        this.setCurrentIndex(this._currentIndex+1);

        // TASK 1: custom event
        // document.dispatchEvent(new CustomEvent('next-clicked'));

        // TASK 2: callback
        this._nextCallback();
    }

    setCurrentIndex(index) {
        if (index < 0 || index > this._maxIndex-1) {
            return;
        }

        this._currentIndex = index;
        
        this._lblCurrentIndex.textContent = index + 1;
        this._btnPrev.disabled = index == 0;
        this._btnNext.disabled = index == this._maxIndex;
    }
}