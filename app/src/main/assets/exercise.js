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

function addStep(input) {
    let steps = document.getElementById("steps");
    MathJax.tex2chtmlPromise(input).then(function (node) {
        node.style.width = "80%";
        node.style.marginTop = ".75em";
        node.style.border = "1px solid grey";
        node.style.height = "50px";
        node.style.overflow = "auto";
        node.style.padding = "5px";
        node.style.margin = "auto";
        steps.appendChild(node);
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseInterface.showToast(err.message);
    });
}

function selectStep(stepType) {
    let steps = document.getElementById("steps");
    var prev;
    if (steps.childNodes.length > 1) {
        prev = steps.lastChild.value;
    } else {
        prev = ExerciseInterface.getExerciseQuestion();
        if (prev.search(/$/g).length / 2 != 1) {
            //ask user which math block should we use?
        }
        let mathBlockStartIdx = prev.indexOf("$");
        let mathBlockEndIdx = prev.indexOf("$", mathBlockStartIdx + 1);
        prev = prev.substring(mathBlockStartIdx + 1, mathBlockEndIdx);
    }

    var stepInput = "";
    switch(stepType) {
        case "leftOrder":
            let sides = prev.split("=");
            stepInput = sides[0] + "-(" + sides[1] + ")=0";
    }
    stepInput = simplifyIdentities(stepInput);
    addStep(stepInput);
    // also call ExerciseInterface?
}

function simplifyIdentities(value) {
    value = value.replace(/[+-]\(?0\)?/g, "");
    value = value.replace(/\*\(?1\)?/g, "");
    // replace \frac{...}{1} with ...
    return value
}

function checkAnswer() {
    let answer = document.getElementById("answer").value.trim();
    ExerciseInterface.checkAnswer(answer);
}