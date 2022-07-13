package hu.kristof.nagy.mathapp.view.step

interface Operator : Expression

data class Addition(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}+${right.toLatex()}"
    }
}

data class Subtraction(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}-${right.toLatex()}"
    }
}

data class Multiplication(
    private val left: Expression,
    private val right: Expression
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}${right.toLatex()}" // should we write * between left and right?
    }
}

data class Division(
    private val numerator: Expression,
    private val denominator: Expression
) : Operator {
    override fun toLatex(): String {
        return "\\frac{${numerator.toLatex()}}{${denominator.toLatex()}}"
    }
}

open class Exponentiation(
    private val base: Expression,
    private val exponent: Expression
) : Operator {
    override fun toLatex(): String {
        return "${base.toLatex()}^{${exponent.toLatex()}}"
    }
}

data class SquareRoot(
    private val base: Expression
) : Operator {
    override fun toLatex(): String {
        return "\\sqrt{${base.toLatex()}}"
    }
}

data class NthRoot(
    private val base: Expression,
    private val root: Expression
) : Operator {
    override fun toLatex(): String {
        return "\\sqrt[${root.toLatex()}]{${base.toLatex()}}"
    }
}

data class Logarithm(
    private val base: Expression,
    private val argument: Expression
) : Operator {
    override fun toLatex(): String {
        return "\\log_{${base.toLatex()}} ${argument.toLatex()}"
    }
}