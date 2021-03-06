package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class IntegralTest {
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
        val expression = LatexParser.parse("\\iint_{0}^{1}{x}")

        println(expression)
        assertTrue(expression is DoubleDefiniteIntegral)
        assertEquals(DoubleDefiniteIntegral(Value(0), Value(1), Variable("x")), expression)
    }
}