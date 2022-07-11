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
    let mathBlockStartIdx = input.search("$");
    let mathBlockEndIdx = mathBlockStartIdx + input.substr(mathBlockStartIdx).search("$");
    while (mathBlockEndIdx < input.length) {
        ExerciseCreateInterface.showToast(mathBlockEndIdx);

        let prevNonMathBlock = input.substr(prevMathBlockEndIdx, mathBlockStartIdx);
        let mathBlock = input.substr(mathBlockStartIdx, mathBlockEndIdx);

        MathJax.tex2chtmlPromise(mathBlock).then(function (node) {
            output.innerHTML += prevNonMathBlock;
            output.appendChild(node);
            MathJax.startup.document.clear();
            MathJax.startup.document.updateDocument();
        }).catch(function (err) {
            ExerciseCreateInterface.showToast(err.message);
        }).then(function () {
            button.disabled = false;
        });

        let tempStart = mathBlockStartIdx;
        let tempEnd = mathBlockEndIdx;
        mathBlockStartIdx = mathBlockEndIdx + input.substr(mathBlockEndIdx).search("$");
        mathBlockEdnIdx = mathBlockStartIdx + input.substr(mathBlockStartIdx).search("$");
        prevMathBlockStartIdx = tempStart;
        prevMathBlockEndIdx = tempEnd;
    }
    let prevNonMathBlock = input.substr(prevMathBlockEndIdx, mathBlockStartIdx);
}