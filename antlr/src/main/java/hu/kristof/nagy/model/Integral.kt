package hu.kristof.nagy.model

data class IndefiniteIntegral(
    val variable: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\int{${variable.toLatex()}}"""
    }

    override fun simplify(): Expression =
        IndefiniteIntegral(simplifyUntilUnchanged(variable))
}

data class DefiniteIntegral(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val variable: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\int_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${variable.toLatex()}}"""
    }

    override fun simplify(): Expression =
        DefiniteIntegral(
            simplifyUntilUnchanged(lowerLimit),
            simplifyUntilUnchanged(upperLimit),
            simplifyUntilUnchanged(variable)
        )
}

data class DoubleIndefiniteIntegral(
    val variable: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\iint{${variable.toLatex()}}"""
    }

    override fun simplify(): Expression =
        DoubleIndefiniteIntegral(simplifyUntilUnchanged(variable))
}

data class DoubleDefiniteIntegral(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val variable: Expression
) : Expression() {
    override fun toLatex(): String {
        return """\\iint_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${variable.toLatex()}}"""
    }

    override fun simplify(): Expression =
        DoubleDefiniteIntegral(
            simplifyUntilUnchanged(lowerLimit),
            simplifyUntilUnchanged(upperLimit),
            simplifyUntilUnchanged(variable)
        )
}