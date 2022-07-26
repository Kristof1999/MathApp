package hu.kristof.nagy.mathapp.view.step.transform

import model.Equation
import model.Expression
import model.Subtraction
import model.Value

object LeftOrder : StepTransformer<StepTransformer.MyBundle> {
    override fun transform(myBundle: StepTransformer.MyBundle): Expression {
        val step = myBundle.step
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, equation.rightSide), Value(0))
    }
}

object RightOrder : StepTransformer<StepTransformer.MyBundle> {
    override fun transform(myBundle: StepTransformer.MyBundle): Expression {
        val step = myBundle.step
        val equation = step as Equation
        return Equation(Value(0), Subtraction(equation.rightSide, equation.leftSide))
    }
}