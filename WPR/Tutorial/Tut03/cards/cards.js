function showCards(url) {
    const img = document.createElement("img");
    img.src = url;
    return img;
}

for (let i = 0; i < cards.length; i++) {
    const urlImg = cards[i];
    const img = showCards(urlImg);
    img.style.height = "160px";
    img.style.width = "120px";
    img.addEventListener("click", imgChoice);
    document.body.appendChild(img);
}

function imgChoice(event) {
    const allImg = document.querySelectorAll("img");
    for (const img of allImg) {
        img.style.height = "160px";
        img.style.width = "120px";
    }
    const clickedImg = event.currentTarget;
    clickedImg.style.height = "240px";
    clickedImg.style.width = "180px";
}   