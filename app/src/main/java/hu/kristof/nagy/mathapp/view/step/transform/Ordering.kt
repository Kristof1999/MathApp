package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.mathapp.view.step.model.Equation
import hu.kristof.nagy.mathapp.view.step.model.Expression
import hu.kristof.nagy.mathapp.view.step.model.Subtraction
import hu.kristof.nagy.mathapp.view.step.model.Value

object LeftOrder : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, equation.rightSide), Value(0))
    }
}

object RightOrder : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Value(0), Subtraction(equation.rightSide, equation.leftSide))
    }
}