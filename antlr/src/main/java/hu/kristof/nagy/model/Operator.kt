package hu.kristof.nagy.model

import hu.kristof.nagy.parenthesizeIfNeeded

abstract class Operator : Expression()

data class Addition(
    private val left: Expression,
    private val right: Expression
) : Operator() {
    override fun toLatex(): String {
        return "${left.toLatex()}+${right.toLatex()}"
    }

    override fun simplify(): Expression {
        if (left == Value(0) && right == Value(0)) {
            return Value(0)
        } else if (left == Value(0)) {
            return right
        } else if (right == Value(0)) {
            return left
        }

        return Addition(
            simplifyUntilUnchanged(left),
            simplifyUntilUnchanged(right)
        )
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
) : Operator() {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(left).toLatex()}-${parenthesizeIfNeeded(right).toLatex()}"

    override fun simplify(): Expression {
        if (left == right) {
            return Value(0)
        } else if(right == Value(0)) {
            return left
        }

        // TODO: add negation

        return Subtraction(
            simplifyUntilUnchanged(left),
            simplifyUntilUnchanged(right)
        )
    }
}

data class Multiplication(
    private val left: Expression,
    private val right: Expression
) : Operator() {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(left).toLatex()}*${parenthesizeIfNeeded(right).toLatex()}"

    override fun simplify(): Expression {
        if (left == Value(1) && right == Value(1)) {
            return Value(1)
        } else if (left == Value(1)) {
            return right
        } else if (right == Value(1)) {
            return left
        } else if (left == Value(0) || right == Value(0)) {
            return Value(0)
        }

        return Multiplication(
            simplifyUntilUnchanged(left),
            simplifyUntilUnchanged(right)
        )
    }
}

data class Division(
    private val numerator: Expression,
    private val denominator: Expression
) : Operator() {
    override fun toLatex(): String {
        return """\\frac{${numerator.toLatex()}}{${denominator.toLatex()}}"""
    }

    override fun simplify(): Expression {
        if (numerator == denominator) {
            return Value(1)
        } else if (denominator == Value(1)) {
            return numerator
        }

        return Division(
            simplifyUntilUnchanged(numerator),
            simplifyUntilUnchanged(denominator)
        )
    }
}

data class Exponentiation(
    private val base: Expression,
    private val exponent: Expression
) : Operator() {
    override fun toLatex(): String =
        "${parenthesizeIfNeeded(base).toLatex()}^{${exponent.toLatex()}}"

    override fun simplify(): Expression {
        if (exponent == Value(1)) {
            return base
        } else if (base == Value(1)) {
            return base
        }

        return Exponentiation(
            simplifyUntilUnchanged(base),
            simplifyUntilUnchanged(exponent)
        )
    }
}

data class SquareRoot(
    private val base: Expression
) : Operator() {
    override fun toLatex(): String {
        return """\\sqrt{${base.toLatex()}}"""
    }

    override fun simplify(): Expression {
        if (base == Value(1)) {
            return base
        }

        return SquareRoot(simplifyUntilUnchanged(base))
    }
}

data class NthRoot(
    private val base: Expression,
    private val root: Expression
) : Operator() {
    override fun toLatex(): String {
        return """\\sqrt[${root.toLatex()}]{${base.toLatex()}}"""
    }

    override fun simplify(): Expression {
        if (base == Value(1)) {
            return base
        } else if (root == Value(1)) {
            return base
        }

        return NthRoot(
            simplifyUntilUnchanged(base),
            simplifyUntilUnchanged(root)
        )
    }
}

data class Logarithm(
    private val base: Expression,
    private val argument: Expression
) : Operator() {
    override fun toLatex(): String {
        return """\\log_{${base.toLatex()}} ${argument.toLatex()}"""
    }

    override fun simplify(): Expression {
        return Logarithm(
            simplifyUntilUnchanged(base),
            simplifyUntilUnchanged(argument)
        )
    }
}