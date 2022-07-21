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

// Note: raw strings (""") are preferable
// when giving back special characters,
// because with escaped strings (""), these characters
// are escaped twice (once in Kotlin and once in JS).
// With raw strings, the escape of the characters
// only happens once on the JS side.
// Example: "\\left(x\\right)" becomes "\left(x\right)" in Kotlin,
// and it becomes "left(x ight)" in JS (\r is Carriage return).
// With raw strings: """\\left(x\\right)""" stays the same in Kotlin,
// and in JS, it becomes: "\left(x\right)".
data class Parentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\left(${expr.toLatex()}\\right)"""
    }
}

data class SquareParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\left[${expr.toLatex()}\\right]"""
    }
}

data class BlockParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\left\\{${expr.toLatex()}\\right\\}"""
    }
}

data class StraightParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\left|${expr.toLatex()}\\right|"""
    }
}

data class DoubleStraightParentheses(
    private val expr: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\Vert{${expr.toLatex()}}"""
    }
}