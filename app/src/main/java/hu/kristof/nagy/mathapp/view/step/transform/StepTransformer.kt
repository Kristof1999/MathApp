package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.mathapp.view.step.model.Expression

interface StepTransformer {
    fun transform(step: Expression, x: Expression?): Expression
}