package hu.kristof.nagy.mathapp.view.step.transform

import hu.kristof.nagy.model.Equation
import hu.kristof.nagy.model.Subtraction
import hu.kristof.nagy.model.Value

object LeftOrder : StepTransformer<StepTransformer.MyBundle> {
    override fun transform(myBundle: StepTransformer.MyBundle): hu.kristof.nagy.model.Expression {
        val step = myBundle.step
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, equation.rightSide), Value(0))
    }
}

object RightOrder : StepTransformer<StepTransformer.MyBundle> {
    override fun transform(myBundle: StepTransformer.MyBundle): hu.kristof.nagy.model.Expression {
        val step = myBundle.step
        val equation = step as Equation
        return Equation(Value(0), Subtraction(equation.rightSide, equation.leftSide))
    }
}