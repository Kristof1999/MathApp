// based on: https://tomassetti.me/antlr-mega-tutorial/

package hu.kristof.nagy.mathapp.view.step

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object StepParser {
    /**
     * Parses a latex string, and gives back an expression.
     * Example:
     *   Input: x + 2
     *   Output: Addition(Variable(x), Value(2))
     */
    fun parse(step: String): Expression {
        val inputStream = CharStreams.fromString(step)
        val lexer = LatexGrammarLexer(inputStream)
        val commonTokenStream = CommonTokenStream(lexer)
        val parser = LatexGrammarParser(commonTokenStream)
        val expressionContext = parser.expression()
        val visitor = StepVisitor()
        return visitor.visit(expressionContext)
    }
}