package hu.kristof.nagy.mathapp.view.step.model

import hu.kristof.nagy.mathapp.view.step.parenthesizeIfNeeded

abstract class Function(
    val argument: Expression
) : Expression

open class CustomFunction(
    val name: String,
    argument: Expression
) : Function(argument) {
    override fun toLatex(): String =
        """\operatorname{${name}}${parenthesizeIfNeeded(argument)}"""
}

class Sin(argument: Expression) : Function(argument) {
    override fun toLatex(): String = """\\sin${parenthesizeIfNeeded(argument)}"""
}

class Cos(argument: Expression) : Function(argument) {
    override fun toLatex(): String = """\\cos${parenthesizeIfNeeded(argument)}"""
}

class Limit(
    val variable: Variable,
    argument: Expression,
    val limes: Value
) : Function(argument) {
    override fun toLatex(): String =
        """\lim_{${variable.toLatex()} \\to ${limes.toLatex()}}{${argument.toLatex()}}"""
}

class Sum(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    argument: Expression
) : Function(argument) {
    override fun toLatex(): String =
        """\\sum_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""
}

class Product(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    argument: Expression
) : Function(argument) {
    override fun toLatex(): String =
        """\\prod_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""
}