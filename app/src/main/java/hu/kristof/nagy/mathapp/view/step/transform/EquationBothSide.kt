package hu.kristof.nagy.mathapp.view.step.transform

import model.*

object AddBothSideByX : StepTransformer<StepTransformer.SingleVariableMyBundle> {
    override fun transform(myBundle: StepTransformer.SingleVariableMyBundle): Expression {
        val step = myBundle.step
        val x = myBundle.x
        val equation = step as Equation
        return Equation(Addition(equation.leftSide, x), Addition(equation.rightSide, x))
    }
}

object SubtractBothSideByX : StepTransformer<StepTransformer.SingleVariableMyBundle> {
    override fun transform(myBundle: StepTransformer.SingleVariableMyBundle): Expression {
        val step = myBundle.step
        val x = myBundle.x
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, x), Subtraction(equation.rightSide, x))
    }
}

object MultiplyBothSideByX : StepTransformer<StepTransformer.SingleVariableMyBundle> {
    override fun transform(myBundle: StepTransformer.SingleVariableMyBundle): Expression {
        val step = myBundle.step
        val x = myBundle.x
        val equation = step as Equation
        return Equation(Multiplication(equation.leftSide, x), Multiplication(equation.rightSide, x))
    }
}

object DivideBothSideByX : StepTransformer<StepTransformer.SingleVariableMyBundle> {
    override fun transform(myBundle: StepTransformer.SingleVariableMyBundle): Expression {
        val step = myBundle.step
        val x = myBundle.x
        val equation = step as Equation
        return Equation(Division(equation.leftSide, x), Division(equation.rightSide, x))
    }
}