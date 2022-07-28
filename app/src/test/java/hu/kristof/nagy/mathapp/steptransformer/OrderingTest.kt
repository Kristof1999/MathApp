package hu.kristof.nagy.mathapp.steptransformer

import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.transform.LeftOrder
import hu.kristof.nagy.mathapp.view.step.transform.RightOrder
import hu.kristof.nagy.mathapp.view.step.transform.StepTransformer
import org.junit.Assert.assertEquals
import org.junit.Test

class OrderingTest {
    @Test
    fun testLeftOrder() {
        val step = "a + b = 2"

        val parsedStep = LatexParser.parse(step)
        val res = LeftOrder.transform(StepTransformer.MyBundle(parsedStep))

        assertEquals(
            hu.kristof.nagy.model.Equation(
                hu.kristof.nagy.model.Subtraction(
                    hu.kristof.nagy.model.Addition(
                        hu.kristof.nagy.model.Variable("a"),
                        hu.kristof.nagy.model.Variable("b")
                    ),
                    hu.kristof.nagy.model.Value(2)
                ), hu.kristof.nagy.model.Value(0)
            ), res)
    }

    @Test
    fun testRightOrder() {
        val step = "a + b = 2"

        val parsedStep = LatexParser.parse(step)
        val res = RightOrder.transform(StepTransformer.MyBundle(parsedStep))

        assertEquals(
            hu.kristof.nagy.model.Equation(
                hu.kristof.nagy.model.Value(0), hu.kristof.nagy.model.Subtraction(
                    hu.kristof.nagy.model.Value(2),
                    hu.kristof.nagy.model.Addition(
                        hu.kristof.nagy.model.Variable("a"),
                        hu.kristof.nagy.model.Variable("b")
                    )
                )
            ), res)
    }
}