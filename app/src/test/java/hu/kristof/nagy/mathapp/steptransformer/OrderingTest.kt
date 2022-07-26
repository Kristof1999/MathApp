package hu.kristof.nagy.mathapp.steptransformer

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.transform.LeftOrder
import hu.kristof.nagy.mathapp.view.step.transform.RightOrder
import hu.kristof.nagy.mathapp.view.step.transform.StepTransformer
import model.*
import org.junit.Assert.assertEquals
import org.junit.Test

class OrderingTest {
    @Test
    fun testLeftOrder() {
        val step = "a + b = 2"

        val parsedStep = LatexParser.parse(step)
        val res = LeftOrder.transform(StepTransformer.MyBundle(parsedStep))

        assertEquals(
            Equation(
            Subtraction(
                Addition(Variable("a"), Variable("b")),
                Value(2)
            ), Value(0)
        ), res)
    }

    @Test
    fun testRightOrder() {
        val step = "a + b = 2"

        val parsedStep = LatexParser.parse(step)
        val res = RightOrder.transform(StepTransformer.MyBundle(parsedStep))

        assertEquals(Equation(
            Value(0), Subtraction(
                Value(2),
                Addition(Variable("a"), Variable("b"))
            )
        ), res)
    }
}