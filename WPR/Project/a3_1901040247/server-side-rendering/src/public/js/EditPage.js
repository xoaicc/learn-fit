const formGroup = document.querySelector('.form-editing')
let formCorrectAns = formGroup.getAttribute('data-correct')
const addAnsBox = formGroup.querySelector('.text-right')
const addAnswerBtn = addAnsBox.querySelector('.text-right button')
const saveUpdatedQuesBtn = document.querySelector('.save-update-ques')
saveUpdatedQuesBtn.addEventListener('click', saveUpdatedQuestion)
let ansNum = formGroup.querySelectorAll('.answer')

ansNum.forEach((ans, index) => {
    const checkedAnswer = ans.querySelector('input[type = "radio"]')
    if (formCorrectAns == index) {
        checkedAnswer.checked = true;
    }
    deleteAnswer(ans);
})

addAnswerBtn.addEventListener('click', addNewAnswer)
function addNewAnswer() {
    addAnswer(ansNum.length)
    ansNum = formGroup.querySelectorAll('.answer')
    ansNum.forEach(ans => {
        deleteAnswer(ans)
    })
}

function addAnswer(index) {
    const ansBox = document.createElement('div')
    const inpText = document.createElement('input')
    const correctAnsBox = document.createElement('div')
    const correctAnsInp = document.createElement('input')
    const correctAnsLab = document.createElement('label')
    correctAnsLab.textContent = `correct`
    const button = document.createElement('button')
    button.innerHTML = `<i class="fas fa-times"></i> Remove`
    
    setAttributes(ansBox, {'class': 'answer'})
    setAttributes(inpText, {'type': 'text', 'name': 'answers', 'value': ''})
    setAttributes(correctAnsInp, {'type': 'radio', 'name': 'correctAnswer', 'value': index, 'id': `answer${index}`})
    setAttributes(correctAnsLab, {'for': `answer${index}`})
    setAttributes(button, {'class': 'btn btn-orange', 'type': 'button'})
    
    ansBox.appendChild(inpText)
    ansBox.appendChild(correctAnsBox)
    ansBox.appendChild(button)
    correctAnsBox.appendChild(correctAnsInp)
    correctAnsBox.appendChild(correctAnsLab)
    formGroup.insertBefore(ansBox, addAnsBox)
}

function deleteAnswer(ans) {
    ans.querySelector('button').addEventListener('click', () => {ans.remove()})
}

function saveUpdatedQuestion () {
    const formUpdate = document.querySelector('#form-update')
    formUpdate.submit()
}

function setAttributes(ele, atts) {
    for (var key in atts) {
        ele.setAttribute(key, atts[key])
    }
}