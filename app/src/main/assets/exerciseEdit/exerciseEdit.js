"use strict";

function saveEdit() {
    let name = document.getElementById("name").value.trim();
    if (name.length == 0) {
        ExerciseEditInterface.showToast("A feladat neve nem lehet üres!");
        return;
    }
    let question = document.getElementById("questionInput").value.trim();
    if (question.length == 0) {
        ExerciseEditInterface.showToast("A kérdés nem lehet üres!");
        return;
    }
    let answer = document.getElementById("answerInput").value.trim();
    if (answer.length == 0) {
        ExerciseEditInterface.showToast("A válasz nem lehet üres!");
        return;
    }
    ExerciseEditInterface.saveEdit(name, question, answer);
}

function loadName() {
    let nameElement = document.getElementById("name");
    nameElement.value = ExerciseEditInterface.getExerciseName();
}

function loadQuestion() {
    let questionElement = document.getElementById("questionInput");
    questionElement.innerHTML = ExerciseEditInterface.getExerciseQuestion();
}

function loadAnswer() {
    let answerElement = document.getElementById("answerInput");
    answerElement.innerHTML = ExerciseEditInterface.getExerciseAnswer();
}