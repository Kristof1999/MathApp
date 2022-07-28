package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OperatorTest {
    @Test
    fun testAdditionSubtraction() {
        val res = LatexParser.parse("a+b")
        val spaces = LatexParser.parse("a + b")
        val subtraction = LatexParser.parse("a-b")

        assertTrue(res is Addition)
        assertTrue(spaces is Addition)
        assertTrue(subtraction is Subtraction)
        assertEquals(Addition(Variable("a"), Variable("b")), res)
        assertEquals(Addition(Variable("a"), Variable("b")), spaces)
        assertEquals(Subtraction(Variable("a"), Variable("b")), subtraction)
    }

    @Test
    fun testDivision() {
        val res = LatexParser.parse("\\frac{1}{2}")

        assertTrue(res is Division)
        assertEquals(Division(Value(1), Value(2)), res)
    }

    @Test
    fun testMultiplication() {
        val res = LatexParser.parse("1*2")

        assertTrue(res is Multiplication)
        assertEquals(Multiplication(Value(1), Value(2)), res)
    }

    @Test
    fun testExponentiation() {
        val res = LatexParser.parse("1^{2}")

        assertTrue(res is Exponentiation)
        assertEquals(Exponentiation(Value(1), Value(2)), res)
    }

    @Test
    fun testSquareRoot() {
        val res = LatexParser.parse("\\sqrt{2}")

        assertTrue(res is SquareRoot)
        assertEquals(SquareRoot(Value(2)), res)
    }

    @Test
    fun testNthRoot() {
        val res = LatexParser.parse("\\sqrt[3]{2}")

        assertTrue(res is NthRoot)
        assertEquals(NthRoot(Value(2), Value(3)), res)
    }

    @Test
    fun testLogarithm() {
        val res = LatexParser.parse("\\log_{2} 10")

        assertTrue(res is Logarithm)
        assertEquals(Logarithm(Value(2), Value(10)), res)
    }
}