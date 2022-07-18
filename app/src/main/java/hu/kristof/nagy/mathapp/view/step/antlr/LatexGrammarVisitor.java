// Generated from C:/Users/36203/Desktop/MathApp/mobile/app/src/main/java/hu/kristof/nagy/mathapp/view/step/antlr\LatexGrammar.g4 by ANTLR 4.10.1
package hu.kristof.nagy.mathapp.view.step.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LatexGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LatexGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code DoubleIndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleIndefiniteIntegral(LatexGrammarParser.DoubleIndefiniteIntegralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(LatexGrammarParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionSubtraction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionSubtraction(LatexGrammarParser.AdditionSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operand}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(LatexGrammarParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SquareParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareParentheses(LatexGrammarParser.SquareParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CustomFunction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomFunction(LatexGrammarParser.CustomFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(LatexGrammarParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockParentheses(LatexGrammarParser.BlockParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exponentiation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiation(LatexGrammarParser.ExponentiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleDefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleDefiniteIntegral(LatexGrammarParser.DoubleDefiniteIntegralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SinCos}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinCos(LatexGrammarParser.SinCosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleStraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleStraightParentheses(LatexGrammarParser.DoubleStraightParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteIntegral(LatexGrammarParser.DefiniteIntegralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Logarithm}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogarithm(LatexGrammarParser.LogarithmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SquareRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareRoot(LatexGrammarParser.SquareRootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumProduct}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumProduct(LatexGrammarParser.SumProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(LatexGrammarParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStraightParentheses(LatexGrammarParser.StraightParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Limit}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(LatexGrammarParser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndefiniteIntegral(LatexGrammarParser.IndefiniteIntegralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NthRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNthRoot(LatexGrammarParser.NthRootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(LatexGrammarParser.ParenthesesContext ctx);
}