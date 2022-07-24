package hu.kristof.nagy.mathapp.view.step.model

data class IndefiniteIntegral(
    val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\int{${variable.toLatex()}}"""
    }
}

data class DefiniteIntegral(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\int_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${variable.toLatex()}}"""
    }
}

data class DoubleIndefiniteIntegral(
    val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\iint{${variable.toLatex()}}"""
    }
}

data class DoubleDefiniteIntegral(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val variable: Expression
) : Expression {
    override fun toLatex(): String {
        return """\\iint_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${variable.toLatex()}}"""
    }
}