package hu.kristof.nagy.mathapp.view.step.model

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