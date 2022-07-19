function onLoad() {
    let nameElement = document.getElementById("topicName");
    nameElement.innerHTML = TopicEditInterface.getName();

    let summaryElement = document.getElementById("input");
    summaryElement.innerHTML = TopicEditInterface.getSummary();
}