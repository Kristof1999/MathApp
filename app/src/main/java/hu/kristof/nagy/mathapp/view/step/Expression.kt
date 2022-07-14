package hu.kristof.nagy.mathapp.view.step

interface Expression {
    fun toLatex(): String
}

data class Equation(
    val leftSide: Expression,
    val rightSide: Expression
) : Expression {
    override fun toLatex(): String {
        return "${leftSide.toLatex()}=${rightSide.toLatex()}"
    }
}

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

data class IndefiniteIntegral(
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\int ${variable.toLatex()}"
    }
}

data class DefiniteIntegral(
    private val lowerLimit: Expression,
    private val upperLimit: Expression,
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\int_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}} ${variable.toLatex()}"
    }
}

data class DoubleIndefiniteIntegral(
    private val variable: Variable
) : Expression {
    override fun toLatex(): String {
        return "\\iint ${variable.toLatex()}"
    }
}

data class DoubleDefiniteIntegral(
    private val lowerLimit: Expression,
    private val upperLimit: Expression,
    private val variable: Variable
) : Expression {
    override fun toLatex(): String {
        return "\\iint_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}} ${variable.toLatex()}"
    }
}

data class Parentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\left(${expr.toLatex()}\\right)"
    }
}

data class SquareParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\left[${expr.toLatex()}\\right]"
    }
}

data class BlockParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\left\\{${expr.toLatex()}\\right\\}"
    }
}

data class StraightParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\left|${expr.toLatex()}\\right|"
    }
}

data class DoubleStraightParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\Vert{${expr.toLatex()}}"
    }
}