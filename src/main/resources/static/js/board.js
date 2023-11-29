const createBtn = document.getElementById('create-btn');
const deleteBtn = document.getElementById('delete-btn');
const modifyBtn = document.getElementById('modify-btn');
const submitBtn = document.getElementById('submit-btn');

// create
if(createBtn){
    createBtn.addEventListener('click', event => {
        fetch("/boards/create", {
            method: 'POST',
            headers: {
                "Content-Type" : "application/json",
            },
            body: JSON.stringify({
                mem_id: document.getElementById("mem_id").value,
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
                category: document.getElementById("category").value
            })
        }).then(()=>{
            alert('등록');
            location.replace("/boards");
        });
    });
}

// delete
if(deleteBtn) {
    deleteBtn.addEventListener('click', event => {
        let id = document.getElementById('board-id').value;
        fetch(`/boards/delete/${id}`, {
            method: 'POST'
        }).then(()=> {
            alert('삭제');
            location.replace('/boards');
        });
    });
}

// modify -> edit
if(modifyBtn){
    modifyBtn.addEventListener('click', event => {
        location.href = `/boards/edit/${id}`;
    });
}

// modify
if(submitBtn){
    submitBtn.addEventListener('click', event => {

        const id = document.getElementById('board-id').value;

        fetch(`/boards/edit/${id}`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value,
                category: document.getElementById('category').value
            })
        }).then(()=>{
            alert('수정');
            location.replace(`/boards/${id}`);
        });
    });
}