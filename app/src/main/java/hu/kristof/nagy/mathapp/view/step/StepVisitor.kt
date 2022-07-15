package hu.kristof.nagy.mathapp.view.step

class StepVisitor : LatexGrammarBaseVisitor<Expression>() {
    // TODO: override visit methods to return the proper Step model classes
    override fun visitOperand(ctx: LatexGrammarParser.OperandContext?): Expression {
        return ctx?.let { operandContext ->
            val leafText = operandContext.OPERAND().text

            // Double?
            if (leafText.matches(Regex("[0-9]+"))) {
                return Value(leafText.toInt())
            }
            if (leafText.matches(Regex("[0-9]+([.][0-9]+)+"))) {
                return Value(leafText.toDouble())
            }
            if (leafText.matches(Regex("[a-zA-Z]+]"))) {
                return Variable(leafText)
            }

            return when(leafText) {
                "\\infty" -> Infinity()
                "e" -> EulersNumber()
                "\\pi" -> Pi()

                "\\alpha" -> Alpha()
                "\\beta" -> Beta()
                "\\gamma" -> Gamma()
                "\\omega" -> Omega()
                "\\epsilon" -> Epsilon()
                "\\varepsilon" -> VarEpsilon()
                "\\phi" -> Phi()
                "\\varphi" -> VarPhi()

                else -> throw IllegalArgumentException("Unkown operand: " + leafText)
            }
        } ?: throw IllegalStateException("Operand is null")
    }
}