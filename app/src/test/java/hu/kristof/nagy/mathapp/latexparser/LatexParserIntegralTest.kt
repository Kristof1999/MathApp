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
        // KNOW:
        // println -> expression is parsed as a DefiniteIntegral
        // DoubleIndefinite passes the test -> \ii doesn't become \i, precedence shouldn't be a problem too
        // antlr plugin test -> grammar is ok
        // build log -> newest grammar is compiled
        // for "\\iiint_{0}^{1}{x}", it doesn't recognize '\iii', and parses as Variable(name='nt')
        // debugger -> LatexParser sees the input as "\iint_{0}^{1}{x}"
        val expression = LatexParser.parse("\\iint_{0}^{1}{x}")

        println(expression)
        assertTrue(expression is DoubleDefiniteIntegral)
        assertEquals(DoubleDefiniteIntegral(Value(0), Value(1), Variable("x")), expression)
    }
}