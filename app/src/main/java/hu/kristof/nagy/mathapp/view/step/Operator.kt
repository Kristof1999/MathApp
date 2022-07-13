package hu.kristof.nagy.mathapp.view.step

interface Operator : Expression

data class Addition(
    private val left: Operand,
    private val right: Operand
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}+${right.toLatex()}"
    }
}

data class Subtraction(
    private val left: Operand,
    private val right: Operand
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}-${right.toLatex()}"
    }
}

data class Multiplication(
    private val left: Operand,
    private val right: Operand
) : Operator {
    override fun toLatex(): String {
        return "${left.toLatex()}${right.toLatex()}" // should we write * between left and right?
    }
}

data class Division(
    private val numerator: Operand,
    private val denominator: Operand
) : Operator {
    override fun toLatex(): String {
        return "\\frac{${numerator.toLatex()}}{${denominator.toLatex()}}"
    }
}

open class Exponentiation(
    private val base: Operand,
    private val exponent: Operand
) : Operator {
    override fun toLatex(): String {
        return "${base.toLatex()}^{${exponent.toLatex()}}"
    }
}

data class SquareRoot(
    private val base: Operand
) : Exponentiation(base, Value(0.5)) {
    override fun toLatex(): String {
        return "\\sqrt{${base.toLatex()}}"
    }
}

data class NthRoot(
    private val base: Operand,
    private val root: Operand
) : Operator {
    override fun toLatex(): String {
        return "\\sqrt[${root.toLatex()}]{${base.toLatex()}}"
    }
}

data class Logarithm(
    private val base: Operand,
    private val argument: Operand
) : Operator {
    override fun toLatex(): String {
        return "\\log_{${base.toLatex()}} ${argument.toLatex()}"
    }
}