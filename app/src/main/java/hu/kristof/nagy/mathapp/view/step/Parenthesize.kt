package hu.kristof.nagy.mathapp.view.step

import hu.kristof.nagy.mathapp.view.step.model.Expression
import hu.kristof.nagy.mathapp.view.step.model.Parentheses

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