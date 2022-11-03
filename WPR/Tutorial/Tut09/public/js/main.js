const cardContainer = document.querySelector('#flashcard-container');
const statusBarContainer = document.querySelector('#status-bar');

// function onResponse(response) {
//     return response.json();
// }

// function onJson(json) {
//     const app = new App(cardContainer, statusBarContainer, json);
// }

// fetch('/words').then(onResponse).then(onJson);

async function loadData() {
    const response = await fetch('/words');
    const json = await response.json();

    const app = new App(cardContainer, statusBarContainer, json); 
}

loadData();