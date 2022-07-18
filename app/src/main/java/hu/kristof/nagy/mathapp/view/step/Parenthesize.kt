package hu.kristof.nagy.mathapp.view.step

import hu.kristof.nagy.mathapp.view.step.model.Expression
import hu.kristof.nagy.mathapp.view.step.model.Parentheses

fun parenthesize(expr: Expression): Expression =
    if (expr is Parentheses) {
        expr
    } else {
        // TODO: use different type of parentheses for readability
        Parentheses(expr)
    }