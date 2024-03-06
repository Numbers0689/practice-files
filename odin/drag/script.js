function drag(e) {
    e.dataTransfer.setData("id", e.target.id);
};

function adrag(e) {
    e.preventDefault();
};

function drop(e) {
    e.preventDefault();
    let data = e.dataTransfer.getData("id");
    e.target.appendChild(document.querySelector("#i"));
};