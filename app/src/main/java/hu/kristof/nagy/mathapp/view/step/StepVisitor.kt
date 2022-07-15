package hu.kristof.nagy.mathapp.view.step

class StepVisitor : LatexGrammarBaseVisitor<Expression>() {
    override fun visitLogarithm(ctx: LatexGrammarParser.LogarithmContext?): Expression {
        return ctx?.let { logarithmContext ->
            val base = visit(logarithmContext.expression(0))
            val argument = visit(logarithmContext.expression(1))
            return Logarithm(base, argument)
        } ?: throw IllegalStateException("Logarithm is null")
    }

    override fun visitNthRoot(ctx: LatexGrammarParser.NthRootContext?): Expression {
        return ctx?.let { nthRootContext ->
            val root = visit(nthRootContext.expression(0))
            val base = visit(nthRootContext.expression(1))
            return NthRoot(base, root)
        } ?: throw IllegalStateException("NthRoot is null")
    }

    override fun visitSquareRoot(ctx: LatexGrammarParser.SquareRootContext?): Expression {
        return ctx?.let { squareRootContext ->
            val base = visit(squareRootContext.expression())
            return SquareRoot(base)
        } ?: throw IllegalStateException("SquareRoot is null")
    }

    override fun visitExponentiation(ctx: LatexGrammarParser.ExponentiationContext?): Expression {
        return ctx?.let { exponentiationContext ->
            val base = visit(exponentiationContext.expression(0))
            val exponent = visit(exponentiationContext.expression(1))
            return Exponentiation(base, exponent)
        } ?: throw IllegalStateException("Exponentiation is null")
    }

    override fun visitMultiplication(ctx: LatexGrammarParser.MultiplicationContext?): Expression {
        return ctx?.let { multiplicationContext ->
            val left = visit(multiplicationContext.expression(0))
            val right = visit(multiplicationContext.expression(1))
            return Multiplication(left, right)
        } ?: throw IllegalStateException("Multiplication is null")
    }

    override fun visitDivision(ctx: LatexGrammarParser.DivisionContext?): Expression {
        return ctx?.let { divisionContext ->
            val numerator = visit(divisionContext.expression(0))
            val denominator = visit(divisionContext.expression(1))
            return Division(numerator, denominator)
        } ?: throw IllegalStateException("Division is null")
    }

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