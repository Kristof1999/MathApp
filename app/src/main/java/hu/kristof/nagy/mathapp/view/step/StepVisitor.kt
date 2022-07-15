package hu.kristof.nagy.mathapp.view.step

class StepVisitor : LatexGrammarBaseVisitor<Expression>() {
    override fun visitAdditionSubtraction(ctx: LatexGrammarParser.AdditionSubtractionContext?): Expression {
        return ctx?.let { additionContext ->
            val left = visit(additionContext.expression(0))
            val right = visit(additionContext.expression(1))

            if (additionContext.PLUS() != null) {
                return Addition(left, right)
            }
            if (additionContext.MINUS() != null) {
                return Subtraction(left, right)
            }

            throw IllegalArgumentException("Unknown addition/subtraction")
        } ?: throw IllegalStateException("Addition is null")
    }

    override fun visitOperand(ctx: LatexGrammarParser.OperandContext?): Expression {
        return ctx?.let { operandContext ->
            val leafText = operandContext.OPERAND().text

            if (leafText.matches(Regex("[0-9]+"))) {
                return Value(leafText.toInt())
            }
            if (leafText.matches(Regex("[0-9]+(.[0-9]+)+"))) {
                return Value(leafText.toDouble())
            }
            if (leafText.matches(Regex("[a-zA-Z]+"))) {
                return Variable(leafText)
            }

            return when(leafText) {
                "\\infty" -> Infinity()
                "\\pi" -> Pi()

                "\\alpha" -> Alpha()
                "\\beta" -> Beta()
                "\\gamma" -> Gamma()
                "\\omega" -> Omega()
                "\\epsilon" -> Epsilon()
                "\\varepsilon" -> VarEpsilon()
                "\\phi" -> Phi()
                "\\varphi" -> VarPhi()

                else -> throw IllegalArgumentException("Unknown operand: $leafText")
            }
        } ?: throw IllegalStateException("Operand is null")
    }
}