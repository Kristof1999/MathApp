// Generated from C:/Users/36203/Desktop/MathApp/mobile/app/src/main/java/hu/kristof/nagy/mathapp/view/step/antlr\LatexGrammar.g4 by ANTLR 4.10.1
package hu.kristof.nagy.mathapp.view.step.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatexGrammarParser}.
 */
public interface LatexGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code DoubleIndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleIndefiniteIntegral(LatexGrammarParser.DoubleIndefiniteIntegralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleIndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleIndefiniteIntegral(LatexGrammarParser.DoubleIndefiniteIntegralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(LatexGrammarParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(LatexGrammarParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionSubtraction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionSubtraction(LatexGrammarParser.AdditionSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionSubtraction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionSubtraction(LatexGrammarParser.AdditionSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operand}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperand(LatexGrammarParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operand}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperand(LatexGrammarParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SquareParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSquareParentheses(LatexGrammarParser.SquareParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SquareParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSquareParentheses(LatexGrammarParser.SquareParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CustomFunction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCustomFunction(LatexGrammarParser.CustomFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CustomFunction}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCustomFunction(LatexGrammarParser.CustomFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquation(LatexGrammarParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquation(LatexGrammarParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBlockParentheses(LatexGrammarParser.BlockParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBlockParentheses(LatexGrammarParser.BlockParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exponentiation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExponentiation(LatexGrammarParser.ExponentiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exponentiation}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExponentiation(LatexGrammarParser.ExponentiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleDefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleDefiniteIntegral(LatexGrammarParser.DoubleDefiniteIntegralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleDefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleDefiniteIntegral(LatexGrammarParser.DoubleDefiniteIntegralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SinCos}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSinCos(LatexGrammarParser.SinCosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SinCos}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSinCos(LatexGrammarParser.SinCosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleStraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleStraightParentheses(LatexGrammarParser.DoubleStraightParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleStraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleStraightParentheses(LatexGrammarParser.DoubleStraightParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDefiniteIntegral(LatexGrammarParser.DefiniteIntegralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDefiniteIntegral(LatexGrammarParser.DefiniteIntegralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Logarithm}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogarithm(LatexGrammarParser.LogarithmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Logarithm}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogarithm(LatexGrammarParser.LogarithmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SquareRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSquareRoot(LatexGrammarParser.SquareRootContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SquareRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSquareRoot(LatexGrammarParser.SquareRootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumProduct}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSumProduct(LatexGrammarParser.SumProductContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumProduct}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSumProduct(LatexGrammarParser.SumProductContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivision(LatexGrammarParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivision(LatexGrammarParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStraightParentheses(LatexGrammarParser.StraightParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StraightParentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStraightParentheses(LatexGrammarParser.StraightParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Limit}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLimit(LatexGrammarParser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Limit}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLimit(LatexGrammarParser.LimitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndefiniteIntegral(LatexGrammarParser.IndefiniteIntegralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndefiniteIntegral}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndefiniteIntegral(LatexGrammarParser.IndefiniteIntegralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NthRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNthRoot(LatexGrammarParser.NthRootContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NthRoot}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNthRoot(LatexGrammarParser.NthRootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(LatexGrammarParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LatexGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(LatexGrammarParser.ParenthesesContext ctx);
}