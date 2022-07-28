package hu.kristof.nagy.model

abstract class Expression {
    abstract fun toLatex(): String

    abstract fun simplify(): Expression

    protected fun simplifyUntilUnchanged(expr: Expression): Expression {
        var oldExpr = expr
        var simplifiedExpr = expr.simplify()
        while (simplifiedExpr != oldExpr) {
            oldExpr = simplifiedExpr
            simplifiedExpr = simplifiedExpr.simplify()
        }
        return simplifiedExpr
    }
}

data class Equation(
    val leftSide: Expression,
    val rightSide: Expression
) : Expression() {
    override fun toLatex(): String {
        return "${leftSide.toLatex()}=${rightSide.toLatex()}"
    }

    override fun simplify(): Expression {
        return Equation(
            simplifyUntilUnchanged(leftSide),
            simplifyUntilUnchanged(rightSide.simplify())
        )
    }
}

// Note: raw strings (""") with double escapes (\\) are preferable
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
) : Expression() {
    override fun toLatex(): String {
        return """\\left(${expr.toLatex()}\\right)"""
    }

    override fun simplify(): Expression {
        return Parentheses(simplifyUntilUnchanged(expr))
    }
}

data class SquareParentheses(
    private val expr: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\left[${expr.toLatex()}\\right]"""
    }

    override fun simplify(): Expression {
        return SquareParentheses(simplifyUntilUnchanged(expr))
    }
}

data class BlockParentheses(
    private val expr: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\left\\{${expr.toLatex()}\\right\\}"""
    }

    override fun simplify(): Expression =
        BlockParentheses(simplifyUntilUnchanged(expr))
}

data class StraightParentheses(
    private val expr: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\left|${expr.toLatex()}\\right|"""
    }

    override fun simplify(): Expression =
        StraightParentheses(simplifyUntilUnchanged(expr))
}

data class DoubleStraightParentheses(
    private val expr: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\Vert{${expr.toLatex()}}"""
    }

    override fun simplify(): Expression =
        DoubleStraightParentheses(simplifyUntilUnchanged(expr))
}