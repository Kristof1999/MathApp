package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.mathapp.view.step.model.*

object AddBothSide : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Addition(equation.leftSide, x!!), Addition(equation.rightSide, x))
    }
}

object SubtractBothSide : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, x!!), Subtraction(equation.rightSide, x))
    }
}

object MultiplyBothSide : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Multiplication(equation.leftSide, x!!), Multiplication(equation.rightSide, x))
    }
}

object DivideBothSide : StepTransformer {
    override fun transform(step: Expression, x: Expression?): Expression {
        val equation = step as Equation
        return Equation(Division(equation.leftSide, x!!), Division(equation.rightSide, x))
    }
}