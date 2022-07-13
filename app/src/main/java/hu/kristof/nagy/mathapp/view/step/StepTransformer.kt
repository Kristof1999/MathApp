package hu.kristof.nagy.mathapp.view.step

interface StepTransformer {
    fun transform(step: Expression): Expression
}