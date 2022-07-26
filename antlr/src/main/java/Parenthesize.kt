import model.Expression
import model.Parentheses

/**
 * Returns the given expression in simple parentheses
 * if it wasn't already in simple parentheses.
 */
fun parenthesizeIfNeeded(expr: Expression): Expression =
    if (expr is Parentheses) {
        expr
    } else {
        Parentheses(expr)
    }