function createExercise() {
    let name = document.getElementById("name").value.trim();
    if (name.length == 0) {
        ExerciseCreateInterface.showToast("A feladat neve nem lehet üres!");
        return;
    }
    let question = document.getElementById("questionInput").value.trim();
    if (question.length == 0) {
        ExerciseCreateInterface.showToast("A kérdés nem lehet üres!");
        return;
    }
    let answer = document.getElementById("answerInput").value.trim();
    if (answer.length == 0) {
        ExerciseCreateInterface.showToast("A válasz nem lehet üres!");
        return;
    }
    ExerciseCreateInterface.createExercise(name, question, answer);
}