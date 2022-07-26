package model

import parenthesizeIfNeeded

interface Operator : Expression

data class Addition(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}+${right.toLatex()}"
    }
    }

/*
try writing it in infix style, or like hamcrest when testing:
instead of:
Equation(Subtraction(equation.leftSide, x), Subtraction(equation.rightSide, x))
should be:
Equation(equation.leftSide '-' x, equation.rightSide '-' x)
 */
data class Subtraction(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(left).toLatex()}-${parenthesizeIfNeeded(right).toLatex()}"
}

data class Multiplication(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(left).toLatex()}*${parenthesizeIfNeeded(right).toLatex()}"
}

data class Division(
    private val numerator: Expression,
    private val denominator: Expression
) : Operator {
    override fun toLatex(): String {
        return """\\frac{${numerator.toLatex()}}{${denominator.toLatex()}}"""
    }
}

data class Exponentiation(
    private val base: Expression,
    private val exponent: Expression
) : Operator {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(base).toLatex()}^{${exponent.toLatex()}}"
}

data class SquareRoot(
    private val base: Expression
) : Operator {
    override fun toLatex(): String {
        return """\\sqrt{${base.toLatex()}}"""
    }
}

data class NthRoot(
    private val base: Expression,
    private val root: Expression
) : Operator {
    override fun toLatex(): String {
        return """\\sqrt[${root.toLatex()}]{${base.toLatex()}}"""
    }
}

data class Logarithm(
    private val base: Expression,
    private val argument: Expression
) : Operator {
    override fun toLatex(): String {
        return """\\log_{${base.toLatex()}} ${argument.toLatex()}"""
    }
}