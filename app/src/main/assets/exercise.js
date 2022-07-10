function onLoad() {
    let input = ExerciseInterface.getExerciseQuestion();

    output = document.getElementById("question");
    output.innerHTML = '';

    MathJax.tex2chtmlPromise(input).then(function (node) {
        //
        //  The promise returns the typeset node, which we add to the output
        //  Then update the document to include the adjusted CSS for the
        //    content of the new equation.
        //
        output.appendChild(node);
        // try to split output by \n and so call addChild multiple times?
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseInterface.showToast(err.message);
    });
}

function addStep() {
    // it should be a div with class="output"
}

function selectStep(value) {
    // show dialog if needed
    // transform input/prev step, and add step
    ExerciseInterface.showToast(value);
}

function checkAnswer() {
    let answer = document.getElementById("answer").value.trim();
    ExerciseInterface.checkAnswer(answer);
}