package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.mathapp.view.step.model.*

object AddBothSideByX : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Addition(equation.leftSide, x!!), Addition(equation.rightSide, x))
    }
}

object SubtractBothSideByX : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, x!!), Subtraction(equation.rightSide, x))
    }
}

object MultiplyBothSideByX : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Multiplication(equation.leftSide, x!!), Multiplication(equation.rightSide, x))
    }
}

object DivideBothSideByX : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Division(equation.leftSide, x!!), Division(equation.rightSide, x))
    }
}