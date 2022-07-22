"use strict";

function reviewTheory() {
    ExerciseInterface.reviewTheory();
}

function onLoad() {
    let input = ExerciseInterface.getExerciseQuestion();
    output = document.getElementById("question");
    convertOnLoad(input, output, ExerciseInterface);
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
    if (steps.childNodes.length <= 1) {
        ExerciseInterface.setFirstStep();
    }
    ExerciseInterface.selectStep(stepType);
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