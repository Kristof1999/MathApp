package hu.kristof.nagy.mathapp.latexparser

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.model.CustomFunction
import hu.kristof.nagy.mathapp.view.step.model.Variable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FunctionTest {
    @Test
    fun testCustom() {
        val expression = LatexParser.parse("\\operatorname{f}(x)")

        assertTrue(expression is CustomFunction)
        assertEquals(CustomFunction("f", Variable("x")), expression)
    }
}