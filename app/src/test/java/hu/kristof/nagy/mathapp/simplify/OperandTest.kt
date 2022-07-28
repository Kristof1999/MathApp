package hu.kristof.nagy.mathapp.simplify

import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OperandTest {
    @Test
    fun testValue() {
        val value = Value(1)
        val infinity = Infinity()
        val pi = Pi()

        val simplifiedValue = value.simplify()
        val simplifiedInfinity = infinity.simplify()
        val simplifiedPi = pi.simplify()

        assertTrue(simplifiedValue is Value)
        assertTrue(simplifiedInfinity is Infinity)
        assertTrue(simplifiedPi is Pi)
        assertEquals(Value(1), simplifiedValue)
    }

    @Test
    fun testVariable() {
        val alpha = Alpha()
        val beta = Beta()
        val gamma = Gamma()
        val omega = Omega()
        val epsilon = Epsilon()
        val varEpsilon = VarEpsilon()
        val phi = Phi()
        val varPhi = VarPhi()

        val simplifiedAlpha = alpha.simplify()
        val simplifiedBeta = beta.simplify()
        val simplifiedGamma = gamma.simplify()
        val simplifiedOmega = omega.simplify()
        val simplifiedEpsilon = epsilon.simplify()
        val simplifiedVarEpsilon = varEpsilon.simplify()
        val simplifiedPhi = phi.simplify()
        val simplifiedVarPhi = varPhi.simplify()

        assertTrue(simplifiedAlpha is Alpha)
        assertTrue(simplifiedBeta is Beta)
        assertTrue(simplifiedGamma is Gamma)
        assertTrue(simplifiedOmega is Omega)
        assertTrue(simplifiedEpsilon is Epsilon)
        assertTrue(simplifiedVarEpsilon is VarEpsilon)
        assertTrue(simplifiedPhi is Phi)
        assertTrue(simplifiedVarPhi is VarPhi)
    }
}