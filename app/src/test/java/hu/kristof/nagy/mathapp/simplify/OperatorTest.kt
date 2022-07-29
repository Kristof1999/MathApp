package hu.kristof.nagy.mathapp.simplify

import hu.kristof.nagy.model.*
import org.junit.Assert.assertEquals
import org.junit.Test

class OperatorTest {
    @Test
    fun testAddition() {
        val zero = Value(0)
        val expr1 = Addition(zero, zero)
        val expr2 = Addition(zero, Value(1))
        val expr3 = Addition(Value(1), zero)

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()
        val simplified3 = expr3.simplify()

        assertEquals(Value(0), simplified1)
        assertEquals(Value(1), simplified2)
        assertEquals(Value(1), simplified3)
    }

    @Test
    fun testSubtraction()  {
        val expr1 = Subtraction(Value(1), Value(1))
        val expr2 = Subtraction(Value(1), Value(0))

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()

        assertEquals(Value(0), simplified1)
        assertEquals(Value(1), simplified2)
    }

    @Test
    fun testMultiplication() {
        val expr1 = Multiplication(Value(1), Value(1))
        val expr2 = Multiplication(Value(1), Value(2))
        val expr3 = Multiplication(Value(2), Value(1))
        val expr4 = Multiplication(Value(0), Value(2))
        val expr5 = Multiplication(Value(2), Value(0))
        val expr6 = Multiplication(Value(0), Value(0))

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()
        val simplified3 = expr3.simplify()
        val simplified4 = expr4.simplify()
        val simplified5 = expr5.simplify()
        val simplified6 = expr6.simplify()

        assertEquals(Value(1), simplified1)
        assertEquals(Value(2), simplified2)
        assertEquals(Value(2), simplified3)
        assertEquals(Value(0), simplified4)
        assertEquals(Value(0), simplified5)
        assertEquals(Value(0), simplified6)
    }

    @Test
    fun testDivision() {
        val expr1 = Division(Value(2), Value(2))
        val expr2 = Division(Value(2), Value(1))

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()

        assertEquals(Value(1), simplified1)
        assertEquals(Value(2), simplified2)
    }

    @Test
    fun testExponentiation() {
        val expr1 = Exponentiation(Value(2), Value(1))
        val expr2 = Exponentiation(Value(1), Value(2))

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()

        assertEquals(Value(2), simplified1)
        assertEquals(Value(1), simplified2)
    }

    @Test
    fun testSquareRoot() {
        val expr1 = SquareRoot(Value(1))

        val simplified1 = expr1.simplify()

        assertEquals(Value(1), simplified1)
    }

    @Test
    fun testNthRoot() {
        val expr1 = NthRoot(Value(2), Value(1))
        val expr2 = NthRoot(Value(1), Value(2))

        val simplified1 = expr1.simplify()
        val simplified2 = expr2.simplify()

        assertEquals(Value(2), simplified1)
        assertEquals(Value(1), simplified2)
    }
}