function saveEdit() {
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
    ExerciseCreateInterface.saveEdit(name, question, answer);
}

async function convertHelper(mathBlock) {
    return MathJax.tex2chtmlPromise(mathBlock);
}

async function convert(inputId, buttonId, outputId) {
    var input = document.getElementById(inputId).value.trim();

    var button = document.getElementById(buttonId);
    button.disabled = true;

    output = document.getElementById(outputId);
    output.innerHTML = '';

    let prevMathBlockStartIdx = -1;
    let prevMathBlockEndIdx = -1;
    let mathBlockStartIdx = input.indexOf("$");
    let mathBlockEndIdx = input.indexOf("$", mathBlockStartIdx + 1);
    while (mathBlockEndIdx != -1) {
        let prevNonMathBlock = input.substring(prevMathBlockEndIdx + 1, mathBlockStartIdx);
        let mathBlock = input.substring(mathBlockStartIdx + 1, mathBlockEndIdx);

        let node = await convertHelper(mathBlock);
        output.innerHTML += prevNonMathBlock;
        output.innerHTML += node.innerHTML;
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();

        prevMathBlockStartIdx = mathBlockStartIdx;
        prevMathBlockEndIdx = mathBlockEndIdx;
        mathBlockStartIdx = input.indexOf("$", prevMathBlockEndIdx);
        mathBlockEndIdx = input.indexOf("$", mathBlockStartIdx + 1);
    }
    let lastNonMathBlock = input.substring(prevMathBlockEndIdx + 1);
    output.innerHTML += lastNonMathBlock;

    button.disabled = false;
}

async function onLoadHelper(mathBlock) {
    return MathJax.tex2chtmlPromise(mathBlock);
}

async function onLoad() {
    let input = ExerciseInterface.getExerciseQuestion();

    output = document.getElementById("question");
    output.innerHTML = '';

    let prevMathBlockStartIdx = -1;
    let prevMathBlockEndIdx = -1;
    let mathBlockStartIdx = input.indexOf("$");
    let mathBlockEndIdx = input.indexOf("$", mathBlockStartIdx + 1);
    while (mathBlockEndIdx != -1) {
        let prevNonMathBlock = input.substring(prevMathBlockEndIdx + 1, mathBlockStartIdx);
        let mathBlock = input.substring(mathBlockStartIdx + 1, mathBlockEndIdx);

        let node = await onLoadHelper(mathBlock);
        output.innerHTML += prevNonMathBlock;
        output.innerHTML += node.innerHTML;
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();

        prevMathBlockStartIdx = mathBlockStartIdx;
        prevMathBlockEndIdx = mathBlockEndIdx;
        mathBlockStartIdx = input.indexOf("$", prevMathBlockEndIdx);
        mathBlockEndIdx = input.indexOf("$", mathBlockStartIdx + 1);
    }
    let lastNonMathBlock = input.substring(prevMathBlockEndIdx + 1);
    output.innerHTML += lastNonMathBlock;
}