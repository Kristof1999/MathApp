// based on: https://tomassetti.me/antlr-mega-tutorial
grammar LatexGrammar;
expression
    : LEFT_PARENTHESIS expression RIGHT_PARENTHESIS                                  # Parentheses
    | LEFT_SQUARE_PARENTHESIS expression RIGHT_SQUARE_PARENTHESIS                    # SquareParentheses
    | LEFT_BLOCK_PARENTHESIS expression RIGHT_BLOCK_PARENTHESIS                      # BlockParentheses
    | LEFT_STRAIGHT_PARENTHESIS expression RIGHT_STRAIGHT_PARENTHESIS                # StraightParentheses
    | '\\Vert{' expression '}'                                                       # DoubleStraightParentheses
    | '\\operatorname{' VARIABLE '}' LEFT_PARENTHESIS expression RIGHT_PARENTHESIS   # CustomFunction
    | (SIN | COS) LEFT_PARENTHESIS expression RIGHT_PARENTHESIS                      # SinCos
    | '\\lim_{' VARIABLE '\\to' VALUE '}{' expression '}'                            # Limit
    | (SUM | PROD) '_{' expression '}^{' expression '}{' expression '}'              # SumProduct
    | '\\iint{'  expression '}'                                                      # DoubleIndefiniteIntegral
    | '\\iint_{' expression '}^{' expression '}{' expression '}'                     # DoubleDefiniteIntegral
    | '\\int{' expression '}'                                                        # IndefiniteIntegral
    | '\\int_{' expression '}^{' expression '}{' expression '}'                      # DefiniteIntegral
    | <assoc=right> expression '^{' expression '}'                                   # Exponentiation
    | '\\log_{' expression '}{' expression '}'                                       # Logarithm
    | '\\sqrt{' expression '}'                                                       # SquareRoot
    | '\\sqrt[' expression ']{' expression '}'                                       # NthRoot
    | expression '*' expression                                                      # Multiplication
    | '\\frac{' expression '}{' expression '}'                                       # Division
    | expression (PLUS | MINUS) expression                                           # AdditionSubtraction
    | expression '=' expression                                                      # Equation
    | (VALUE | VARIABLE)                                                             # Operand
    ;

fragment DIGIT    : [0-9] ;
fragment INFINITY : '\\infty' ;
fragment PI       : '\\pi' ;
VALUE: DIGIT+ ('.' DIGIT+)?
    | INFINITY | PI
    ;

fragment ALPHA     : '\\alpha' ;
fragment BETA      : '\\beta' ;
fragment GAMMA     : '\\gamma' ;
fragment OMEGA     : '\\omega' ;
fragment EPSILON   : '\\epsilon' ;
fragment VAREPSILON: '\\varepsilon' ;
fragment PHI       : '\\phi' ;
fragment VARPHI    : '\\varphi' ;
fragment STRING    : [a-zA-Z]+ ;
VARIABLE: STRING
    | ALPHA | BETA | GAMMA | OMEGA
    | EPSILON | VAREPSILON
    | PHI | VARPHI
    ;

LEFT_PARENTHESIS          : '\\left('  | '(' ;
RIGHT_PARENTHESIS         : '\\right)' | ')' ;
LEFT_SQUARE_PARENTHESIS   : '\\left['  | '[' ;
RIGHT_SQUARE_PARENTHESIS  : '\\right]' | ']' ;
LEFT_BLOCK_PARENTHESIS    : '\\left{'  | '{' ;
RIGHT_BLOCK_PARENTHESIS   : '\\right}' | '}' ;
LEFT_STRAIGHT_PARENTHESIS : '\\left|'  | '|' ;
RIGHT_STRAIGHT_PARENTHESIS: '\\right|'       ;

PLUS : '+' ;
MINUS: '-' ;
SIN  : '\\sin' ;
COS  : '\\cos' ;
SUM  : '\\sum' ;
PROD : '\\prod';

WHITESPACE : ' ' -> skip ;