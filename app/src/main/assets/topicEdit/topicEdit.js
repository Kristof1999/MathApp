"use strict";

function onLoad() {
    TopicEditInterface.setName();
    TopicEditInterface.setSummary();
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