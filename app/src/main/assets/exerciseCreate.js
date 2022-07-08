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

function convert(inputId, buttonId, outputId) {
    var input = document.getElementById(inputId).value.trim();

    var button = document.getElementById(buttonId);
    button.disabled = true;

    output = document.getElementById(outputId);
    output.innerHTML = '';

    MathJax.tex2chtmlPromise(input).then(function (node) {
        //
        //  The promise returns the typeset node, which we add to the output
        //  Then update the document to include the adjusted CSS for the
        //    content of the new equation.
        //
        output.appendChild(node);
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseCreateInterface.showToast(err.message);
    }).then(function () {
        button.disabled = false;
    });
}