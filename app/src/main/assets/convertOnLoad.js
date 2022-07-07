function convertOnLoad(outputId) {
    let input = ExerciseInterface.exercise.question;

    output = document.getElementById(outputId);
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