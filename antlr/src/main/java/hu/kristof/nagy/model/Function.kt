package hu.kristof.nagy.model

import hu.kristof.nagy.parenthesizeIfNeeded

data class CustomFunction(
    val name: Variable,
    val argument: Expression
) : Expression() {
    override fun toLatex(): String =
        """\\operatorname{${name.toLatex()}}${parenthesizeIfNeeded(argument).toLatex()}"""

    override fun simplify(): Expression =
        CustomFunction(
            simplifyUntilUnchanged(name) as Variable,
            simplifyUntilUnchanged(argument)
        )
}

data class Sin(val argument: Expression) : Expression() {
    override fun toLatex(): String = """\\sin${parenthesizeIfNeeded(argument).toLatex()}"""

    override fun simplify(): Expression =
        Sin(simplifyUntilUnchanged(argument))
}

data class Cos(val argument: Expression) : Expression() {
    override fun toLatex(): String = """\\cos${parenthesizeIfNeeded(argument).toLatex()}"""

    override fun simplify(): Expression =
        Cos(simplifyUntilUnchanged(argument))
}

data class Limit(
    val variable: Variable,
    val argument: Expression,
    val limes: Value
) : Expression() {
    override fun toLatex(): String =
        """\\lim_{${variable.toLatex()} \\to ${limes.toLatex()}}{${argument.toLatex()}}"""

    override fun simplify(): Expression =
        Limit(
            simplifyUntilUnchanged(variable) as Variable,
            simplifyUntilUnchanged(argument),
            simplifyUntilUnchanged(limes) as Value
        )
}

data class Sum(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val argument: Expression
) : Expression() {
    override fun toLatex(): String =
        """\\sum_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""

    override fun simplify(): Expression =
        Sum(
            simplifyUntilUnchanged(lowerLimit),
            simplifyUntilUnchanged(upperLimit),
            simplifyUntilUnchanged(argument)
        )
}

data class Product(
    val lowerLimit: Expression,
    val upperLimit: Expression,
    val argument: Expression
) : Expression() {
    override fun toLatex(): String =
        """\\prod_{${lowerLimit.toLatex()}}^{${upperLimit.toLatex()}}{${argument.toLatex()}}"""

    override fun simplify(): Expression =
        Product(
            simplifyUntilUnchanged(lowerLimit),
            simplifyUntilUnchanged(upperLimit),
            simplifyUntilUnchanged(argument)
        )
}