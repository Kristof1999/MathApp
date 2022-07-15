// based on: https://tomassetti.me/antlr-mega-tutorial/

package hu.kristof.nagy.mathapp.view.step

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object StepParser {
    fun parse(step: String): Expression {
        // x+2 -> Addition(Variable("x"), Value(2))
        // (x+2) * (y+1) -> Mutliplication(Addition(Variable("x"), Value(2)), Addition(Variable("y"), Value(1)))
        val inputStream = CharStreams.fromString(step)
        val lexer = LatexGrammarLexer(inputStream)
        val commonTokenStream = CommonTokenStream(lexer)
        val parser = LatexGrammarParser(commonTokenStream)
        val expressionContext = parser.expression()
        val visitor = StepVisitor()
        return visitor.visit(expressionContext)
    }
}