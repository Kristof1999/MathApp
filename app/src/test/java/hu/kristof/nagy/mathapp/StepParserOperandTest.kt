package hu.kristof.nagy.mathapp

import hu.kristof.nagy.mathapp.view.step.StepParser
import hu.kristof.nagy.mathapp.view.step.Value
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
}