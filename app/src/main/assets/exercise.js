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
    // show dialog if needed -> prompt("please enter...","defaultText"); -> can be null or empty string
    let steps = document.getElementById("steps");
    var prev;
    if (steps.childNodes.length > 1) {
        prev = steps.lastChild.value;
    } else {
        prev = ExerciseInterface.getExerciseQuestion();
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