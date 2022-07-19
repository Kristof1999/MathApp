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