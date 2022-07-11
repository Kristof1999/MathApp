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

    let prevMathBlockStartIdx = 0;
    let prevMathBlockEndIdx = 0;
    let mathBlockStartIdx = input.indexOf("$");
    let mathBlockEndIdx = mathBlockStartIdx + input.substring(mathBlockStartIdx + 1).indexOf("$");
    while (mathBlockEndIdx != prevMathBlockEndIdx) {
        let prevNonMathBlock = input.substring(prevMathBlockEndIdx, mathBlockStartIdx + 1);
        let mathBlock = input.substring(mathBlockStartIdx, mathBlockEndIdx + 1);

        MathJax.tex2chtmlPromise(mathBlock).then(function (node) {
            output.innerHTML += prevNonMathBlock;
            output.innerHTML += node.innerHTML;
            MathJax.startup.document.clear();
            MathJax.startup.document.updateDocument();
        }).catch(function (err) {
            ExerciseCreateInterface.showToast(err.message);
        });

        prevMathBlockStartIdx = mathBlockStartIdx;
        prevMathBlockEndIdx = mathBlockEndIdx;
        mathBlockStartIdx = prevMathBlockEndIdx + input.substring(prevMathBlockEndIdx + 1).search("$");
        mathBlockEndIdx = mathBlockStartIdx + input.substring(mathBlockStartIdx + 1).search("$");
    }
    let lastNonMathBlock = input.substring(prevMathBlockEndIdx + 1);
    output.innerHTML += lastNonMathBlock;

    button.disabled = false;
}