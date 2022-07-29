"use strict";

function reviewTheory() {
    ExerciseInterface.reviewTheory();
}

function onLoad() {
    let input = ExerciseInterface.getExerciseQuestion();
    let output = document.getElementById("question");
    convertOnLoad(input, output, ExerciseInterface);
}

function addStep(input) {
    let steps = document.getElementById("steps");
    MathJax.tex2chtmlPromise(input).then(function (node) {
        node = styleStepNode(node);
        steps.appendChild(node);
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseInterface.showToast(err.message);
    });
}

function addSimplifiedStep(input) {
    let steps = document.getElementById("steps");
    MathJax.tex2chtmlPromise(input).then(function (node) {
        node = styleStepNode(node);
        node.innerHTML = "E: " + node.innerHTML;
        steps.appendChild(node);
        MathJax.startup.document.clear();
        MathJax.startup.document.updateDocument();
    }).catch(function (err) {
        ExerciseInterface.showToast(err.message);
    });
}

function styleStepNode(node) {
    node.style.paddingTop = "8px";
    node.style.paddingBottom = "8px";
    node.style.borderTop = "1px solid black";
    return node;
}

function selectStep(stepType) {
    if (steps.childNodes.length <= 1) {
        ExerciseInterface.setFirstStep();
    }
    ExerciseInterface.selectStep(stepType);
}

function checkAnswer() {
    let answer = document.getElementById("answer").value.trim();
    ExerciseInterface.checkAnswer(answer);
}