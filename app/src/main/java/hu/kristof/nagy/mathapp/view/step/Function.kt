package hu.kristof.nagy.mathapp.view.step

abstract class Function(
    private val argument: Expression
) : Expression

open class CustomFunction(
    private val name: String,
    private val argument: Expression
) : Function(argument) {
    override fun toLatex(): String {
        return "\\operatorname{${name}}${Parentheses(argument)}"
    }
}

data class Sin(
    private val argument: Expression
) : CustomFunction("\\sin", argument)

data class Cos(
    private val argument: Expression
) : CustomFunction("\\cos", argument)

data class Limit(
    private val variable: Variable,
    private val argument: Expression,
    private val limes: Value
) : Function(argument) {
    override fun toLatex(): String {
        return "\\lim_{${variable.toLatex()} \\to ${limes.toLatex()}} ${argument.toLatex()}"
    }
}

data class Sum(
    private val lowerLimit: Expression,
    private val upperLimit: Expression,
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\sum_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}} ${variable.toLatex()}"
    }
}

data class Product(
    private val lowerLimit: Expression,
    private val upperLimit: Expression,
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\prod_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}} ${variable.toLatex()}"
    }
}