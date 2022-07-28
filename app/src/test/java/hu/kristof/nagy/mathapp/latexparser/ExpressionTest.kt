package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExpressionTest {
    @Test
    fun testEquation() {
        val expression = LatexParser.parse("a = b")

        assertTrue(expression is Equation)
        assertEquals(Equation(Variable("a"), Variable("b")), expression)
    }

    @Test
    fun testParentheses() {
        val simple = LatexParser.parse("\\left(a\\right)")
        val square = LatexParser.parse("\\left[a\\right]")
        val block = LatexParser.parse("\\left{a\\right}")
        val straight = LatexParser.parse("\\left|a\\right|")
        val doubleStraight = LatexParser.parse("\\Vert{a}")

        assertTrue(simple is Parentheses)
        assertTrue(square is SquareParentheses)
        assertTrue(block is BlockParentheses)
        assertTrue(straight is StraightParentheses)
        assertTrue(doubleStraight is DoubleStraightParentheses)
        assertEquals(Parentheses(Variable("a")), simple)
        assertEquals(SquareParentheses(Variable("a")), square)
        assertEquals(BlockParentheses(Variable("a")), block)
        assertEquals(StraightParentheses(Variable("a")), straight)
        assertEquals(DoubleStraightParentheses(Variable("a")), doubleStraight)
    }
}