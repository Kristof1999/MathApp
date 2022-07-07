function createExercise() {
    let name = document.getElementById("name").value.trim();
    if (name.length == 0) {
        ExerciseCreateFragment.showToast("A feladat neve nem lehet üres!");
    }
    let question = document.getElementById("questionInput").value.trim();
    if (question.length == 0) {
        ExerciseCreateFragment.showToast("A kérdés nem lehet üres!");
    }
    let answer = document.getElementById("answerInput").value.trim();
    if (answer.length == 0) {
        ExerciseCreateFragment.showToast("A válasz nem lehet üres!");
    }
    ExerciseCreateFragment.createExercise(name, question, answer);
}

function convert(inputId, buttonId, outputId) {
    var input = document.getElementById(inputId).value.trim();

    var button = document.getElementById(buttonId);
    button.disabled = true;

    output = document.getElementById(outputId);
    output.innerHTML = '';

    //
    //  Reset the tex labels (and automatic equation numbers, though there aren't any here).
    //  Get the conversion options (metrics and display settings)
    //  Convert the input to CommonHTML output and use a promise to wait for it to be ready
    //    (in case an extension needs to be loaded dynamically).
    //
    MathJax.texReset();
    var options = MathJax.getMetricsFor(output);
    MathJax.tex2chtmlPromise(input, options).then(function (node) {
        //
        //  The promise returns the typeset node, which we add to the output
        //  Then update the document to include the adjusted CSS for the
        //    content of the new equation.
        //
        output.appendChild(node);
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseCreateFragment.showToast(err.message);
    }).then(function () {
        button.disabled = false;
    });
}