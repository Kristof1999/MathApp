package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LatexParserOperandTest {

    @Test
    fun testValue() {
        val singleDigit = LatexParser.parse("1")
        val multipleDigits = LatexParser.parse("1234")
        val double = LatexParser.parse("12.25")

        assertTrue(singleDigit is Value)
        assertTrue(multipleDigits is Value)
        assertTrue(double is Value)
        assertEquals(1, (singleDigit as Value).x)
        assertEquals(1234, (multipleDigits as Value).x)
        assertEquals(12.25, (double as Value).x)
    }

    @Test
    fun testSpecialValues() {
        val infinity = LatexParser.parse("\\infty")
        val e = LatexParser.parse("e")
        val pi = LatexParser.parse("\\pi")

        assertTrue(infinity is Infinity)
        assertTrue(pi is Pi)
    }

    @Test
    fun testVariable() {
        val short = LatexParser.parse("x")
        val variable = LatexParser.parse("name")

        assertTrue(short is Variable)
        assertTrue(variable is Variable)
        assertEquals("x", (short as Variable).name)
        assertEquals("name", (variable as Variable).name)
    }

    @Test
    fun testSpecialVariables() {
        val alpha = LatexParser.parse("\\alpha")
        val beta = LatexParser.parse("\\beta")
        val gamma = LatexParser.parse("\\gamma")
        val omega = LatexParser.parse("\\omega")
        val epsilon = LatexParser.parse("\\epsilon")
        val varEpsilon = LatexParser.parse("\\varepsilon")
        val phi = LatexParser.parse("\\phi")
        val varPhi = LatexParser.parse("\\varphi")
        
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