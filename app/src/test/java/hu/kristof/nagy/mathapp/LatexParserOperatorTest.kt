package hu.kristof.nagy.mathapp

import hu.kristof.nagy.mathapp.view.step.Addition
import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.Variable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LatexParserOperatorTest {
    @Test
    fun testAddition() {
        val res = LatexParser.parse("a+b")

        assertTrue(res is Addition)
        assertEquals(Addition(Variable("a"), Variable("b")), res)
    }
}