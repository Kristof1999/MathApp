function onLoad() {
    let nameElement = document.getElementById("topicName");
    nameElement.value = TopicEditInterface.getName();

    let summaryElement = document.getElementById("input");
    summaryElement.value = TopicEditInterface.getSummary();
}

function save() {
    let name = document.getElementById("topicName").value.trim();
    if (name.length == 0) {
        TopicEditInterface.showToast("A téma neve nem lehet üres!")
        return;
    }
    let summary = document.getElementById("input").value.trim();
    TopicEditInterface.save(name, summary)
}