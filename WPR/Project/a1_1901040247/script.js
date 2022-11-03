const introScreen = document.querySelector("#introduction")
const attemptScreen = document.querySelector("#attempt-quiz")
const reviewScreen = document.querySelector("#review-quiz")
let attemptsBlock = document.querySelector("#attempts-block")
let resultBlock = document.querySelector("#result-block")

const startButton = introScreen.querySelector("#button-1")
const submitButton = attemptScreen.querySelector("#button-2")
const resetButton = reviewScreen.querySelector("#button-3")

const API = "https://wpr-quiz-api.herokuapp.com/attempts"

let questionsList = []
let questionsID = ""
let answersList = []
let scoreText = ""
let selectedAnswer = []

// Get answers from user
function getUserAnswers() {
    for (var i = 1; i <= questionsList.length; i++)
        for (let j = 0; j < questionsList[i-1].answers.length; j++) {
            const check = document.querySelector(`#opt-${i}-${j+1}`)
            if (check.checked === true) 
                selectedAnswer[i-1] = j
        }
}

// Render Quiz
async function renderAttempts() {
    // Fetch API & get questions
    await fetch(API, {method: "POST"})
    .then(response => response.json())
    .then(data => {
        questionsList = data.questions
        questionsID = data._id
    });

    // Show questions list
    for (let i = 1; i <= questionsList.length; i++) {
        const questionBlock = document.createElement("div")
        questionBlock.id = questionsList[i-1]._id

        // Question Num
        const h2Tag = document.createElement("h2")
        h2Tag.textContent = `Question ${i} of 10`

        // Question Content
        const questionText = document.createElement("p")
        questionText.textContent = questionsList[i-1].text

        // Answers
        const answersBox = document.createElement("div")
        answersBox.className = "ques"
        const answers = questionsList[i-1].answers
        for (let j = 0; j < answers.length; j++) {
            let ansBox = document.createElement("div")
            ansBox.className = "opt"

            // Input
            const input = document.createElement("input")
            input.setAttribute("type", "radio")
            input.setAttribute("name", `opt-${i}`)
            input.setAttribute("class", "rad")
            input.setAttribute("id", `opt-${i}-${j+1}`)

            // Label
            const label = document.createElement("label")
            label.setAttribute("for", `opt-${i}-${j+1}`)
            label.textContent = answers[j]

            // Append
            ansBox.appendChild(input)
            ansBox.appendChild(label)
            answersBox.appendChild(ansBox)
        }
        questionBlock.appendChild(h2Tag)
        questionBlock.appendChild(questionText)
        questionBlock.appendChild(answersBox)
        attemptsBlock.appendChild(questionBlock)
    }
}
renderAttempts()

// Render Results
async function renderResults() {
    const scoreResult = document.querySelector("#score")
    const percentResult = document.querySelector("#percent")
    const comment = document.querySelector("#comment")

    let score = 0
    let percent = 0

    getUserAnswers()

    // Fetch new API & get answers
    const submitAPI = `https://wpr-quiz-api.herokuapp.com/attempts/${questionsID}/submit`
    await fetch(submitAPI, {method: "POST"})
    .then(response => response.json())
    .then(data => {
        answersList = data.correctAnswers
        scoreText = data.scoreText
    });

    // Show Results
    for (let i = 1; i <= questionsList.length; i++) {
        const questionBlock = document.createElement("div")
        questionBlock.id = questionsList[i-1]._id;

        // Question Num
        const h2Tag = document.createElement("h2")
        h2Tag.textContent = `Question ${i} of 10`

        // Question Content
        const questionText = document.createElement("p")
        questionText.textContent = questionsList[i-1].text

        // Answers
        const answersBox = document.createElement("div")
        answersBox.className = "ques"
        const answers = questionsList[i-1].answers
        for (let j = 0; j < answers.length; j++) {
            let ansBox = document.createElement("div")
            ansBox.className = "res"
            const span = document.createElement("span")
            
            // Input
            const input = document.createElement("input")
            input.setAttribute("type", "radio")
            input.setAttribute("name", `opt-${i}`)
            input.setAttribute("class", "rad")
            input.setAttribute("id", `opt-${i}-${j+1}`)
            input.disabled = true

            // Label
            const label = document.createElement("label")
            label.setAttribute("for", `opt-${i}-${j+1}`)
            label.textContent = answers[j]
            ansBox.appendChild(span)

            // Render correct answer
            if (answersList[questionBlock.id] === j) {
                const correctAnswer = document.createElement('span')
                correctAnswer.classList.add("answer-flag")
                correctAnswer.textContent = "Correct Answer"
                ansBox.appendChild(correctAnswer)
                ansBox.classList.add("wrong-answer") // for default
            }

            // Render user answer & check correct answer
            if (selectedAnswer[i-1] === j) {
                const userAnswer = document.createElement('span')
                input.checked = true
                if (answersList[questionBlock.id] !== j) {
                    userAnswer.classList.add("answer-flag")
                    userAnswer.textContent = "Your answer"
                    ansBox.appendChild(userAnswer)
                    ansBox.classList.add("selected-answer")
                } else {
                    ansBox.classList.remove("wrong-answer")
                    ansBox.classList.add("correct-answer")
                    score++;
                }
            }

            // Append
            span.appendChild(input)
            span.appendChild(label)
            answersBox.appendChild(ansBox)
        }
        questionBlock.appendChild(h2Tag)
        questionBlock.appendChild(questionText)
        questionBlock.appendChild(answersBox)
        resultBlock.appendChild(questionBlock)
    }

    // Summary
    scoreResult.textContent = `${score}/${questionsList.length}`
    percentResult.textContent = `${score/questionsList.length*100}%`
    if (score/questionsList.length < 1) comment.textContent = scoreText
    else {
        comment.textContent = "Good job! You don't need to learn more :D"
        resetButton.classList.add("hidden")
        setTimeout(() => resetButton.classList.remove("hidden"), 5000); //:D
    }
}

// Start Quiz
startButton.onclick = function() {
    introScreen.classList.add("hidden")
    attemptScreen.classList.remove("hidden")
}

// Submit Quiz
submitButton.onclick = function() {
    const res = confirm("Do you want to finish?")
    if (res) {
        attemptScreen.classList.add("hidden")
        reviewScreen.classList.remove("hidden")
        renderResults()
    }
}

// Reset Quiz
resetButton.onclick = function() {
    reviewScreen.classList.add("hidden")
    attemptScreen.classList.remove("hidden")
    attemptsBlock.innerHTML = ""
    resultBlock.innerHTML = ""
    selectedAnswer = []
    renderAttempts()
}