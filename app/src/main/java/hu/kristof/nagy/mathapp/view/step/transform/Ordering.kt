package hu.kristof.nagy.mathapp.view.step.transform

class LeftOrder : StepTransformer {
    override fun transform(step: Expression): Expression {
        val equation = step as Equation
        return Equation(Subtraction(equation.leftSide, equation.rightSide), Value(0))
    }
}