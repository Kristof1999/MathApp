package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FunctionTest {
    @Test
    fun testCustom() {
        val expression = LatexParser.parse("\\operatorname{f}(x)")

        assertTrue(expression is CustomFunction)
        assertEquals(CustomFunction(Variable("f"), Variable("x")), expression)
    }

    @Test
    fun testTrig() {
        val sin = LatexParser.parse("\\sin(x)")
        val cos = LatexParser.parse("\\cos(x)")

        assertTrue(sin is Sin)
        assertTrue(cos is Cos)
        assertEquals(Sin(Variable("x")), sin)
        assertEquals(Cos(Variable("x")), cos)
    }

    @Test
    fun testLim() {
        val expression = LatexParser.parse("\\lim_{x \\to \\infty}{x}")

        assertTrue(expression is Limit)
        assertEquals(Limit(Variable("x"), Variable("x"), Infinity()), expression)
    }

    @Test
    fun testSum() {
        val expression = LatexParser.parse("\\sum_{0}^{1}{x}")

        assertTrue(expression is Sum)
        assertEquals(Sum(Value(0), Value(1), Variable("x")), expression)
    }

    @Test
    fun testProd() {
        val expression = LatexParser.parse("\\prod_{0}^{1}{x}")

        assertTrue(expression is Product)
        assertEquals(Product(Value(0), Value(1), Variable("x")), expression)
    }
}