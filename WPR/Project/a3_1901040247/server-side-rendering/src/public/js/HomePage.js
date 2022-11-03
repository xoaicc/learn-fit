let delForm = document.forms["delete-question-form"]
let secForm = document.forms["search-question-form"]

const delBtns = document.querySelectorAll('.btn-delete-question')
delBtns.forEach(delBtn => {
    delBtn.onclick = ((e) => {
        e.preventDefault()
        if (confirm("Are you sure?") === true) {
            let id = delBtn.getAttribute('data-id')
            delForm.action = "delete/" + id + "?_method=DELETE"
            delForm.submit()
        }
    })
})

const secBtn = document.querySelector('#search input')
secBtn.addEventListener('key', searchEngine)
function searchEngine(e) {
    if (e.key === "Enter") secForm.submit()
    secBtn.addEventListener('key', searchEngine)
}