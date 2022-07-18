package hu.kristof.nagy.mathapp.view.step.model

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
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\iint ${variable.toLatex()}"
    }
}

data class DoubleDefiniteIntegral(
    private val lowerLimit: Expression,
    private val upperLimit: Expression,
    private val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return "\\iint_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}} ${variable.toLatex()}"
    }
}