function onLoad() {
    let nameElement = document.getElementById("name");
    nameElement.innerHtml = ExerciseInterface.getExerciseName();

    let input = ExerciseInterface.getExerciseQuestion();

    output = document.getElementById("question");
    output.innerHTML = '';

    //
    //  Reset the tex labels (and automatic equation numbers, though there aren't any here).
    //  Get the conversion options (metrics and display settings)
    //  Convert the input to CommonHTML output and use a promise to wait for it to be ready
    //    (in case an extension needs to be loaded dynamically).
    //
    MathJax.texReset();
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
        ExerciseInterface.showToast(err.message);
    });
}

function addStep() {

}

function selectStep(value) {
    // show dialog if needed
    // transform input/prev step, and add step
    ExerciseInterface.showToast(value);
}