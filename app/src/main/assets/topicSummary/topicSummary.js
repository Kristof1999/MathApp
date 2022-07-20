async function onLoad() {
    let summary = TopicSummaryInterface.getSummary();
    let output = document.getElementById("output");
    convertOnLoad(summary, output);
}