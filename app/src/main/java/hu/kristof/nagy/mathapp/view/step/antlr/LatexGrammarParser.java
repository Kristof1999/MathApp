// Generated from C:/Users/36203/Desktop/MathApp/mobile/app/src/main/java/hu/kristof/nagy/mathapp/view/step\LatexGrammar.g4 by ANTLR 4.10.1
package hu.kristof.nagy.mathapp.view.step.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatexGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, OPERAND=21, LEFT_PARENTHESIS=22, RIGHT_PARENTHESIS=23, 
		LEFT_SQUARE_PARENTHESIS=24, RIGHT_SQUARE_PARENTHESIS=25, LEFT_BLOCK_PARENTHESIS=26, 
		RIGHT_BLOCK_PARENTHESIS=27, LEFT_STRAIGHT_PARENTHESIS=28, RIGHT_STRAIGHT_PARENTHESIS=29, 
		PLUS=30, MINUS=31, SIN=32, COS=33, SUM=34, PROD=35, WHITESPACE=36, STRING=37, 
		VARIABLE=38, VALUE=39;
	public static final int
		RULE_expression = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'\\Vert{'", "'}'", "'\\operatorname{'", "'\\lim_{'", "'\\to'", 
			"'_{'", "'}^{'", "'\\iint'", "'\\iint_{'", "'\\int'", "'\\int_{'", "'^{'", 
			"'\\log_{'", "'\\sqrt{'", "'\\sqrt['", "']{'", "'*'", "'\\frac{'", "'}{'", 
			null, null, null, null, null, null, null, null, "'\\right|'", "'+'", 
			"'-'", "'\\sin'", "'\\cos'", "'\\sum'", "'\\prod'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "OPERAND", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "LEFT_SQUARE_PARENTHESIS", "RIGHT_SQUARE_PARENTHESIS", 
			"LEFT_BLOCK_PARENTHESIS", "RIGHT_BLOCK_PARENTHESIS", "LEFT_STRAIGHT_PARENTHESIS", 
			"RIGHT_STRAIGHT_PARENTHESIS", "PLUS", "MINUS", "SIN", "COS", "SUM", "PROD", 
			"WHITESPACE", "STRING", "VARIABLE", "VALUE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LatexGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LatexGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoubleIndefiniteIntegralContext extends ExpressionContext {
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoubleIndefiniteIntegralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterDoubleIndefiniteIntegral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitDoubleIndefiniteIntegral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitDoubleIndefiniteIntegral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionSubtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(LatexGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LatexGrammarParser.MINUS, 0); }
		public AdditionSubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterAdditionSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitAdditionSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitAdditionSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperandContext extends ExpressionContext {
		public TerminalNode OPERAND() { return getToken(LatexGrammarParser.OPERAND, 0); }
		public OperandContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SquareParenthesesContext extends ExpressionContext {
		public TerminalNode LEFT_SQUARE_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_SQUARE_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_SQUARE_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_SQUARE_PARENTHESIS, 0); }
		public SquareParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterSquareParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitSquareParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitSquareParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CustomFunctionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(LatexGrammarParser.STRING, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_PARENTHESIS, 0); }
		public CustomFunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterCustomFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitCustomFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitCustomFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EquationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockParenthesesContext extends ExpressionContext {
		public TerminalNode LEFT_BLOCK_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_BLOCK_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BLOCK_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_BLOCK_PARENTHESIS, 0); }
		public BlockParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterBlockParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitBlockParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitBlockParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentiationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExponentiationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterExponentiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitExponentiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitExponentiation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleDefiniteIntegralContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public DoubleDefiniteIntegralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterDoubleDefiniteIntegral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitDoubleDefiniteIntegral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitDoubleDefiniteIntegral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SinCosContext extends ExpressionContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode SIN() { return getToken(LatexGrammarParser.SIN, 0); }
		public TerminalNode COS() { return getToken(LatexGrammarParser.COS, 0); }
		public SinCosContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterSinCos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitSinCos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitSinCos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleStraightParenthesesContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoubleStraightParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterDoubleStraightParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitDoubleStraightParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitDoubleStraightParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefiniteIntegralContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public DefiniteIntegralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterDefiniteIntegral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitDefiniteIntegral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitDefiniteIntegral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogarithmContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public LogarithmContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterLogarithm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitLogarithm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitLogarithm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SquareRootContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SquareRootContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterSquareRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitSquareRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitSquareRoot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumProductContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public TerminalNode SUM() { return getToken(LatexGrammarParser.SUM, 0); }
		public TerminalNode PROD() { return getToken(LatexGrammarParser.PROD, 0); }
		public SumProductContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterSumProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitSumProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitSumProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StraightParenthesesContext extends ExpressionContext {
		public TerminalNode LEFT_STRAIGHT_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_STRAIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_STRAIGHT_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_STRAIGHT_PARENTHESIS, 0); }
		public StraightParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterStraightParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitStraightParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitStraightParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LimitContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(LatexGrammarParser.VARIABLE, 0); }
		public TerminalNode VALUE() { return getToken(LatexGrammarParser.VALUE, 0); }
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LimitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitLimit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitLimit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndefiniteIntegralContext extends ExpressionContext {
		public TerminalNode WHITESPACE() { return getToken(LatexGrammarParser.WHITESPACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndefiniteIntegralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterIndefiniteIntegral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitIndefiniteIntegral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitIndefiniteIntegral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NthRootContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NthRootContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterNthRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitNthRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitNthRoot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesesContext extends ExpressionContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LatexGrammarParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LatexGrammarParser.RIGHT_PARENTHESIS, 0); }
		public ParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexGrammarListener ) ((LatexGrammarListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexGrammarVisitor ) return ((LatexGrammarVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PARENTHESIS:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(LEFT_PARENTHESIS);
				setState(4);
				expression(0);
				setState(5);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case LEFT_SQUARE_PARENTHESIS:
				{
				_localctx = new SquareParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(LEFT_SQUARE_PARENTHESIS);
				setState(8);
				expression(0);
				setState(9);
				match(RIGHT_SQUARE_PARENTHESIS);
				}
				break;
			case LEFT_BLOCK_PARENTHESIS:
				{
				_localctx = new BlockParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(LEFT_BLOCK_PARENTHESIS);
				setState(12);
				expression(0);
				setState(13);
				match(RIGHT_BLOCK_PARENTHESIS);
				}
				break;
			case LEFT_STRAIGHT_PARENTHESIS:
				{
				_localctx = new StraightParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(LEFT_STRAIGHT_PARENTHESIS);
				setState(16);
				expression(0);
				setState(17);
				match(RIGHT_STRAIGHT_PARENTHESIS);
				}
				break;
			case T__1:
				{
				_localctx = new DoubleStraightParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(T__1);
				setState(20);
				expression(0);
				setState(21);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new CustomFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__3);
				setState(24);
				match(STRING);
				setState(25);
				match(T__2);
				setState(26);
				match(LEFT_PARENTHESIS);
				setState(27);
				expression(0);
				setState(28);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case SIN:
			case COS:
				{
				_localctx = new SinCosContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				_la = _input.LA(1);
				if ( !(_la==SIN || _la==COS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(31);
				match(LEFT_PARENTHESIS);
				setState(32);
				expression(0);
				setState(33);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case T__4:
				{
				_localctx = new LimitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(T__4);
				setState(36);
				match(VARIABLE);
				setState(37);
				match(T__5);
				setState(38);
				match(VALUE);
				setState(39);
				match(T__2);
				setState(40);
				match(WHITESPACE);
				setState(41);
				expression(14);
				}
				break;
			case SUM:
			case PROD:
				{
				_localctx = new SumProductContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				_la = _input.LA(1);
				if ( !(_la==SUM || _la==PROD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(43);
				match(T__6);
				setState(44);
				expression(0);
				setState(45);
				match(T__7);
				setState(46);
				expression(0);
				setState(47);
				match(T__2);
				setState(48);
				match(WHITESPACE);
				setState(49);
				expression(13);
				}
				break;
			case T__8:
				{
				_localctx = new DoubleIndefiniteIntegralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(T__8);
				setState(52);
				match(WHITESPACE);
				setState(53);
				expression(12);
				}
				break;
			case T__9:
				{
				_localctx = new DoubleDefiniteIntegralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				match(T__9);
				setState(55);
				expression(0);
				setState(56);
				match(T__7);
				setState(57);
				expression(0);
				setState(58);
				match(T__2);
				setState(59);
				match(WHITESPACE);
				setState(60);
				expression(11);
				}
				break;
			case T__10:
				{
				_localctx = new IndefiniteIntegralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(T__10);
				setState(63);
				match(WHITESPACE);
				setState(64);
				expression(10);
				}
				break;
			case T__11:
				{
				_localctx = new DefiniteIntegralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__11);
				setState(66);
				expression(0);
				setState(67);
				match(T__7);
				setState(68);
				expression(0);
				setState(69);
				match(T__2);
				setState(70);
				match(WHITESPACE);
				setState(71);
				expression(9);
				}
				break;
			case T__13:
				{
				_localctx = new LogarithmContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(T__13);
				setState(74);
				expression(0);
				setState(75);
				match(T__2);
				setState(76);
				match(WHITESPACE);
				setState(77);
				expression(7);
				}
				break;
			case T__14:
				{
				_localctx = new SquareRootContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(T__14);
				setState(80);
				expression(0);
				setState(81);
				match(T__2);
				}
				break;
			case T__15:
				{
				_localctx = new NthRootContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(T__15);
				setState(84);
				expression(0);
				setState(85);
				match(T__16);
				setState(86);
				expression(0);
				setState(87);
				match(T__2);
				}
				break;
			case T__18:
				{
				_localctx = new DivisionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(T__18);
				setState(90);
				expression(0);
				setState(91);
				match(T__19);
				setState(92);
				expression(0);
				setState(93);
				match(T__2);
				}
				break;
			case OPERAND:
				{
				_localctx = new OperandContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(OPERAND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new EquationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(99);
						match(T__0);
						setState(100);
						expression(23);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102);
						match(T__17);
						setState(103);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new AdditionSubtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expression(3);
						}
						break;
					case 4:
						{
						_localctx = new ExponentiationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(108);
						match(T__12);
						setState(109);
						expression(0);
						setState(110);
						match(T__2);
						}
						break;
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 22);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'v\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000a\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000q\b\u0000\n\u0000\f\u0000t\t\u0000\u0001\u0000\u0000\u0001\u0000"+
		"\u0001\u0000\u0000\u0003\u0001\u0000 !\u0001\u0000\"#\u0001\u0000\u001e"+
		"\u001f\u0089\u0000`\u0001\u0000\u0000\u0000\u0002\u0003\u0006\u0000\uffff"+
		"\uffff\u0000\u0003\u0004\u0005\u0016\u0000\u0000\u0004\u0005\u0003\u0000"+
		"\u0000\u0000\u0005\u0006\u0005\u0017\u0000\u0000\u0006a\u0001\u0000\u0000"+
		"\u0000\u0007\b\u0005\u0018\u0000\u0000\b\t\u0003\u0000\u0000\u0000\t\n"+
		"\u0005\u0019\u0000\u0000\na\u0001\u0000\u0000\u0000\u000b\f\u0005\u001a"+
		"\u0000\u0000\f\r\u0003\u0000\u0000\u0000\r\u000e\u0005\u001b\u0000\u0000"+
		"\u000ea\u0001\u0000\u0000\u0000\u000f\u0010\u0005\u001c\u0000\u0000\u0010"+
		"\u0011\u0003\u0000\u0000\u0000\u0011\u0012\u0005\u001d\u0000\u0000\u0012"+
		"a\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0002\u0000\u0000\u0014\u0015"+
		"\u0003\u0000\u0000\u0000\u0015\u0016\u0005\u0003\u0000\u0000\u0016a\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0005\u0004\u0000\u0000\u0018\u0019\u0005"+
		"%\u0000\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a\u001b\u0005\u0016"+
		"\u0000\u0000\u001b\u001c\u0003\u0000\u0000\u0000\u001c\u001d\u0005\u0017"+
		"\u0000\u0000\u001da\u0001\u0000\u0000\u0000\u001e\u001f\u0007\u0000\u0000"+
		"\u0000\u001f \u0005\u0016\u0000\u0000 !\u0003\u0000\u0000\u0000!\"\u0005"+
		"\u0017\u0000\u0000\"a\u0001\u0000\u0000\u0000#$\u0005\u0005\u0000\u0000"+
		"$%\u0005&\u0000\u0000%&\u0005\u0006\u0000\u0000&\'\u0005\'\u0000\u0000"+
		"\'(\u0005\u0003\u0000\u0000()\u0005$\u0000\u0000)a\u0003\u0000\u0000\u000e"+
		"*+\u0007\u0001\u0000\u0000+,\u0005\u0007\u0000\u0000,-\u0003\u0000\u0000"+
		"\u0000-.\u0005\b\u0000\u0000./\u0003\u0000\u0000\u0000/0\u0005\u0003\u0000"+
		"\u000001\u0005$\u0000\u000012\u0003\u0000\u0000\r2a\u0001\u0000\u0000"+
		"\u000034\u0005\t\u0000\u000045\u0005$\u0000\u00005a\u0003\u0000\u0000"+
		"\f67\u0005\n\u0000\u000078\u0003\u0000\u0000\u000089\u0005\b\u0000\u0000"+
		"9:\u0003\u0000\u0000\u0000:;\u0005\u0003\u0000\u0000;<\u0005$\u0000\u0000"+
		"<=\u0003\u0000\u0000\u000b=a\u0001\u0000\u0000\u0000>?\u0005\u000b\u0000"+
		"\u0000?@\u0005$\u0000\u0000@a\u0003\u0000\u0000\nAB\u0005\f\u0000\u0000"+
		"BC\u0003\u0000\u0000\u0000CD\u0005\b\u0000\u0000DE\u0003\u0000\u0000\u0000"+
		"EF\u0005\u0003\u0000\u0000FG\u0005$\u0000\u0000GH\u0003\u0000\u0000\t"+
		"Ha\u0001\u0000\u0000\u0000IJ\u0005\u000e\u0000\u0000JK\u0003\u0000\u0000"+
		"\u0000KL\u0005\u0003\u0000\u0000LM\u0005$\u0000\u0000MN\u0003\u0000\u0000"+
		"\u0007Na\u0001\u0000\u0000\u0000OP\u0005\u000f\u0000\u0000PQ\u0003\u0000"+
		"\u0000\u0000QR\u0005\u0003\u0000\u0000Ra\u0001\u0000\u0000\u0000ST\u0005"+
		"\u0010\u0000\u0000TU\u0003\u0000\u0000\u0000UV\u0005\u0011\u0000\u0000"+
		"VW\u0003\u0000\u0000\u0000WX\u0005\u0003\u0000\u0000Xa\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0013\u0000\u0000Z[\u0003\u0000\u0000\u0000[\\\u0005\u0014"+
		"\u0000\u0000\\]\u0003\u0000\u0000\u0000]^\u0005\u0003\u0000\u0000^a\u0001"+
		"\u0000\u0000\u0000_a\u0005\u0015\u0000\u0000`\u0002\u0001\u0000\u0000"+
		"\u0000`\u0007\u0001\u0000\u0000\u0000`\u000b\u0001\u0000\u0000\u0000`"+
		"\u000f\u0001\u0000\u0000\u0000`\u0013\u0001\u0000\u0000\u0000`\u0017\u0001"+
		"\u0000\u0000\u0000`\u001e\u0001\u0000\u0000\u0000`#\u0001\u0000\u0000"+
		"\u0000`*\u0001\u0000\u0000\u0000`3\u0001\u0000\u0000\u0000`6\u0001\u0000"+
		"\u0000\u0000`>\u0001\u0000\u0000\u0000`A\u0001\u0000\u0000\u0000`I\u0001"+
		"\u0000\u0000\u0000`O\u0001\u0000\u0000\u0000`S\u0001\u0000\u0000\u0000"+
		"`Y\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000ar\u0001\u0000\u0000"+
		"\u0000bc\n\u0016\u0000\u0000cd\u0005\u0001\u0000\u0000dq\u0003\u0000\u0000"+
		"\u0017ef\n\u0004\u0000\u0000fg\u0005\u0012\u0000\u0000gq\u0003\u0000\u0000"+
		"\u0005hi\n\u0002\u0000\u0000ij\u0007\u0002\u0000\u0000jq\u0003\u0000\u0000"+
		"\u0003kl\n\b\u0000\u0000lm\u0005\r\u0000\u0000mn\u0003\u0000\u0000\u0000"+
		"no\u0005\u0003\u0000\u0000oq\u0001\u0000\u0000\u0000pb\u0001\u0000\u0000"+
		"\u0000pe\u0001\u0000\u0000\u0000ph\u0001\u0000\u0000\u0000pk\u0001\u0000"+
		"\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000s\u0001\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000\u0003`pr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}