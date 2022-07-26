package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LatexParserIntegralTest {
    @Test
    fun testIndefinite() {
        val expression = LatexParser.parse("\\int{x}")

        assertTrue(expression is IndefiniteIntegral)
        assertEquals(IndefiniteIntegral(Variable("x")), expression)
    }

    @Test
    fun testDefinite() {
        val expression = LatexParser.parse("\\int_{0}^{1}{x}")

        assertTrue(expression is DefiniteIntegral)
        assertEquals(DefiniteIntegral(Value(0), Value(1), Variable("x")), expression)
    }

    @Test
    fun testDoubleIndefinite() {
        val expression = LatexParser.parse("\\iint{x}")

        assertTrue(expression is DoubleIndefiniteIntegral)
        assertEquals(DoubleIndefiniteIntegral(Variable("x")), expression)
    }

    @Test
    fun testDoubleDefinite() {
        // TODO: debug
        val expression = LatexParser.parse("\\iint_{0}^{1}{x}")

        assertTrue(expression is DoubleDefiniteIntegral)
        assertEquals(DoubleDefiniteIntegral(Value(0), Value(1), Variable("x")), expression)
    }
}