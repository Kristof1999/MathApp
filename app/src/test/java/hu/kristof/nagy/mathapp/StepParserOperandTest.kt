package hu.kristof.nagy.mathapp

import hu.kristof.nagy.mathapp.view.step.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StepParserOperandTest {

    @Test
    fun testValue() {
        val singleDigit = StepParser.parse("1")
        val multipleDigits = StepParser.parse("1234")
        val double = StepParser.parse("12.25")

        assertTrue(singleDigit is Value)
        assertTrue(multipleDigits is Value)
        assertTrue(double is Value)
        assertEquals(1, (singleDigit as Value).x)
        assertEquals(1234, (multipleDigits as Value).x)
        assertEquals(12.25, (double as Value).x)
    }

    @Test
    fun testSpecialValues() {
        val infinity = StepParser.parse("\\infty")
        val e = StepParser.parse("e")
        val pi = StepParser.parse("\\pi")

        assertTrue(infinity is Infinity)
        assertTrue(pi is Pi)
    }

    @Test
    fun testVariable() {
        val short = StepParser.parse("x")
        val variable = StepParser.parse("name")

        assertTrue(short is Variable)
        assertTrue(variable is Variable)
        assertEquals("x", (short as Variable).name)
        assertEquals("name", (variable as Variable).name)
    }

    @Test
    fun testSpecialVariables() {
        val alpha = StepParser.parse("\\alpha")
        val beta = StepParser.parse("\\beta")
        val gamma = StepParser.parse("\\gamma")
        val omega = StepParser.parse("\\omega")
        val epsilon = StepParser.parse("\\epsilon")
        val varEpsilon = StepParser.parse("\\varepsilon")
        val phi = StepParser.parse("\\phi")
        val varPhi = StepParser.parse("\\varphi")
        
        assertTrue(alpha is Alpha)
        assertTrue(beta is Beta)
        assertTrue(gamma is Gamma)
        assertTrue(omega is Omega)
        assertTrue(epsilon is Epsilon)
        assertTrue(varEpsilon is VarEpsilon)
        assertTrue(phi is Phi)
        assertTrue(varPhi is VarPhi)
    }
}