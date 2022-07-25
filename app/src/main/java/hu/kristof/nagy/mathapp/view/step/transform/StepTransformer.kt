package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.mathapp.view.step.model.Expression

interface StepTransformer<T : StepTransformer.MyBundle> {
    fun transform(myBundle: T): Expression

    open class MyBundle(
        val step: Expression
    )

    class SingleVariableMyBundle(
        step: Expression,
        val x: Expression
    ) : MyBundle(step)
}