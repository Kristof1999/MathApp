package hu.kristof.nagy

import hu.kristof.nagy.model.Expression
import hu.kristof.nagy.model.Parentheses

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