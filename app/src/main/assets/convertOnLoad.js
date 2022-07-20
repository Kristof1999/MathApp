async function convertOnLoadHelper(mathBlock) {
    return MathJax.tex2chtmlPromise(mathBlock);
}

async function convertOnLoad(input, output) {
    output.innerHTML = '';

    let prevMathBlockStartIdx = -1;
    let prevMathBlockEndIdx = -1;
    let mathBlockStartIdx = input.indexOf("$");
    let mathBlockEndIdx = input.indexOf("$", mathBlockStartIdx + 1);
    while (mathBlockEndIdx != -1) {
        let prevNonMathBlock = input.substring(prevMathBlockEndIdx + 1, mathBlockStartIdx);
        let mathBlock = input.substring(mathBlockStartIdx + 1, mathBlockEndIdx);

        // todo: handle errors
        let node = await convertOnLoadHelper(mathBlock);
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