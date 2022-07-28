package hu.kristof.nagy

import LatexGrammarBaseVisitor
import LatexGrammarParser
import com.google.errorprone.annotations.Var
import hu.kristof.nagy.model.*

class StepVisitor : LatexGrammarBaseVisitor<Expression>() {
    override fun visitEquation(ctx: LatexGrammarParser.EquationContext?): Expression {
        return ctx?.let { equationContext ->
            val left = visit(equationContext.expression(0))
            val right = visit(equationContext.expression(1))

            return Equation(left, right)
        } ?: throw IllegalStateException("Equation is null")
    }

    override fun visitDoubleStraightParentheses(ctx: LatexGrammarParser.DoubleStraightParenthesesContext?): Expression {
        return ctx?.let { doubleStraightParenthesesContext ->
            val expr = visit(doubleStraightParenthesesContext.expression())

            return DoubleStraightParentheses(expr)
        } ?: throw IllegalStateException("DoubleStraightParentheses is null")
    }

    override fun visitStraightParentheses(ctx: LatexGrammarParser.StraightParenthesesContext?): Expression {
        return ctx?.let { straightParenthesesContext ->
            val expr = visit(straightParenthesesContext.expression())

            return StraightParentheses(expr)
        } ?: throw IllegalStateException("StraightParentheses is null")
    }

    override fun visitBlockParentheses(ctx: LatexGrammarParser.BlockParenthesesContext?): Expression {
        return ctx?.let { blockParenthesesContext ->
            val expr = visit(blockParenthesesContext.expression())

            return BlockParentheses(expr)
        } ?: throw IllegalStateException("BlockParentheses is null")
    }

    override fun visitSquareParentheses(ctx: LatexGrammarParser.SquareParenthesesContext?): Expression {
        return ctx?.let { squareParentheses ->
            val expr = visit(squareParentheses.expression())

            return SquareParentheses(expr)
        } ?: throw IllegalStateException("SquareParentheses is null")
    }

    override fun visitParentheses(ctx: LatexGrammarParser.ParenthesesContext?): Expression {
        return ctx?.let { parenthesesContext ->
            val expr = visit(parenthesesContext.expression())

            return Parentheses(expr)
        } ?: throw IllegalStateException("Parentheses is null")
    }

    override fun visitDoubleDefiniteIntegral(ctx: LatexGrammarParser.DoubleDefiniteIntegralContext?): Expression {
        return ctx?.let { doubleDefiniteIntegralContext ->
            val lowerBound = visit(doubleDefiniteIntegralContext.expression(0))
            val upperBound = visit(doubleDefiniteIntegralContext.expression(1))
            val argument = visit(doubleDefiniteIntegralContext.expression(2))

            return DoubleDefiniteIntegral(lowerBound, upperBound, argument)
        } ?: throw IllegalStateException("DoubleDefiniteIntegral is null")
    }

    override fun visitDoubleIndefiniteIntegral(ctx: LatexGrammarParser.DoubleIndefiniteIntegralContext?): Expression {
        return ctx?.let { doubleIndefiniteIntegralContext ->
            val argument = visit(doubleIndefiniteIntegralContext.expression())
            return DoubleIndefiniteIntegral(argument)
        } ?: throw IllegalStateException("DoubleIndefiniteIntegral is null")
    }

    override fun visitDefiniteIntegral(ctx: LatexGrammarParser.DefiniteIntegralContext?): Expression {
        return ctx?.let { definiteIntegralContext ->
            val lowerBound = visit(definiteIntegralContext.expression(0))
            val upperBound = visit(definiteIntegralContext.expression(1))
            val argument = visit(definiteIntegralContext.expression(2))

            return DefiniteIntegral(lowerBound, upperBound, argument)
        } ?: throw IllegalStateException("DefiniteIntegral is null")
    }

    override fun visitIndefiniteIntegral(ctx: LatexGrammarParser.IndefiniteIntegralContext?): Expression {
        return ctx?.let { indefiniteIntegralContext ->
            val argument = visit(indefiniteIntegralContext.expression())
            return IndefiniteIntegral(argument)
        } ?: throw IllegalStateException("IndefiniteIntegral is null")
    }

    override fun visitSumProduct(ctx: LatexGrammarParser.SumProductContext?): Expression {
        return ctx?.let { sumProductContext ->
            val lowerBound = visit(sumProductContext.expression(0))
            val upperBound = visit(sumProductContext.expression(1))
            val argument = visit(sumProductContext.expression(2))

            if (sumProductContext.SUM() != null) {
                return Sum(lowerBound, upperBound, argument)
            }
            if (sumProductContext.PROD() != null) {
                return Product(lowerBound, upperBound, argument)
            }

            throw IllegalArgumentException("Unknown sumProduct")
        } ?: throw IllegalStateException("SumProd is null")
    }

    override fun visitLimit(ctx: LatexGrammarParser.LimitContext?): Expression {
        return ctx?.let { limitContext ->
            val variable = parseVariableText(limitContext.VARIABLE().text)
            val limes = parseValueText(limitContext.VALUE().text)
            val argument = visit(limitContext.expression())
            return Limit(variable, argument, limes)
        } ?: throw IllegalStateException("Limit is null")
    }

    override fun visitSinCos(ctx: LatexGrammarParser.SinCosContext?): Expression {
        return ctx?.let { sinCosContext ->
            val argument = visit(sinCosContext.expression())

            if (sinCosContext.SIN() != null) {
                return Sin(argument)
            }
            if (sinCosContext.COS() != null) {
                return Cos(argument)
            }

            throw IllegalArgumentException("Unknown trig func")
        } ?: throw IllegalStateException("Trig func is null")
    }

    override fun visitCustomFunction(ctx: LatexGrammarParser.CustomFunctionContext?): Expression {
        return ctx?.let { customFunctionContext ->
            val name = visit(customFunctionContext.VARIABLE()) as Variable
            val argument = visit(customFunctionContext.expression())
            return CustomFunction(name, argument)
        } ?: throw IllegalStateException("CustomFunction is null")
    }

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
            if (operandContext.VARIABLE() != null) {
                val leafText = operandContext.VARIABLE().text

                return parseVariableText(leafText)
            } else if (operandContext.VALUE() != null) {
                val leafText = operandContext.VALUE().text

                return parseValueText(leafText)
            }

            throw IllegalArgumentException("Unknown operand")
        } ?: throw IllegalStateException("Operand is null")
    }

    private fun parseVariableText(text: String): Variable {
        if (text.matches(Regex("[a-zA-Z]+"))) {
            return Variable(text)
        }

        return when(text) {
            "\\alpha" -> Alpha()
            "\\beta" -> Beta()
            "\\gamma" -> Gamma()
            "\\omega" -> Omega()
            "\\epsilon" -> Epsilon()
            "\\varepsilon" -> VarEpsilon()
            "\\phi" -> Phi()
            "\\varphi" -> VarPhi()
            else -> throw IllegalArgumentException("Unknown variable: $text")
        }
    }

    private fun parseValueText(text: String): Value {
        if (text.matches(Regex("[0-9]+"))) {
            return Value(text.toInt())
        }
        if (text.matches(Regex("[0-9]+(\\.[0-9]+)+"))) {
            return Value(text.toDouble())
        }

        return when(text) {
            "\\infty" -> Infinity()
            "\\pi" -> Pi()
            else -> throw IllegalArgumentException("Unknown value: $text")
        }
    }
}