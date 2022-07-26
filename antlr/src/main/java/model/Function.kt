package model

import parenthesizeIfNeeded

data class CustomFunction(
    val name: String,
    val argument: Expression
) : Expression {
    override fun toLatex(): String =
        """\\operatorname{${name}}${parenthesizeIfNeeded(argument).toLatex()}"""
}

data class Sin(val argument: Expression) : Expression {
    override fun toLatex(): String = """\\sin${parenthesizeIfNeeded(argument).toLatex()}"""
}

data class Cos(val argument: Expression) : Expression {
    override fun toLatex(): String = """\\cos${parenthesizeIfNeeded(argument).toLatex()}"""
}

data class Limit(
    val variable: Variable,
    val argument: Expression,
    val limes: Value
) : Expression {
    override fun toLatex(): String =
        """\\lim_{${variable.toLatex()} \\to ${limes.toLatex()}}{${argument.toLatex()}}"""
}

data class Sum(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val argument: Expression
) : Expression {
    override fun toLatex(): String =
        """\\sum_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""
}

data class Product(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val argument: Expression
) : Expression {
    override fun toLatex(): String =
        """\\prod_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""
}