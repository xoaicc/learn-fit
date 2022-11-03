class StatusBar {
    constructor(numCards){
        this.numCards = numCards;
    }   

    render(){
        const statusBar = document.createElement('div');
        statusBar.id = "status-bar";
        statusBar.innerHTML = `
        <button disabled id="prev">&larr;</button>
        <strong>1</strong>/<span>${this.numCards}</span>
        <button id="next">&rarr;</button>`
        return statusBar;
    }
}