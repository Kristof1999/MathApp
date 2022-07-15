// based on: https://tomassetti.me/antlr-mega-tutorial
grammar LatexGrammar;
expression
    : expression '=' expression                                                      # Equation
    | LEFT_PARENTHESIS expression RIGHT_PARENTHESIS                                  # Parentheses
    | LEFT_SQUARE_PARENTHESIS expression RIGHT_SQUARE_PARENTHESIS                    # SquareParentheses
    | LEFT_BLOCK_PARENTHESIS expression RIGHT_BLOCK_PARENTHESIS                      # BlockParentheses
    | LEFT_STRAIGHT_PARENTHESIS expression RIGHT_STRAIGHT_PARENTHESIS                # StraightParentheses
    | '\\Vert{' expression '}'                                                       # DoubleStraightParentheses
    | '\\operatorname{' STRING '}' LEFT_PARENTHESIS expression RIGHT_PARENTHESIS     # CustomFunction
    | ('\\sin' | '\\cos') LEFT_PARENTHESIS expression RIGHT_PARENTHESIS              # SinCos
    | '\\lim_{' VARIABLE '\\to' VALUE '}' WHITESPACE expression                      # Limit
    | ('\\sum_{' | '\\prod_{') expression '}^{' expression '}' WHITESPACE expression # SumProduct
    | '\\int' WHITESPACE expression                                                  # IndefiniteIntegral
    | '\\int_{' expression '}^{' expression '}' WHITESPACE expression                # DefiniteIntegral
    | '\\iint' expression WHITESPACE expression                                      # DoubleIndefiniteIntegral
    | '\\iint_{' expression '}^{' expression '}' WHITESPACE expression               # DoubleDefiniteIntegral
    | <assoc=right> expression '^{' expression '}'                                   # Exponentiation
    | '\\log_{' expression '}' WHITESPACE expression                                 # Logarithm
    | '\\sqrt{' expression '}'                                                       # SquareRoot
    | '\\sqrt[' expression ']{' expression '}'                                       # NthRoot
    | expression '*' expression                                                      # Multiplication
    | '\\frac{' expression '}{' expression '}'                                       # Division
    | expression '+' expression                                                      # Addition
    | expression '-' expression                                                      # Subtraction
    | OPERAND                                                                        # Operand
    ;

fragment DIGIT        : [0-9] ;
fragment INFINITY     : '\\infty' ;
fragment PI           : '\\pi' ;
fragment VALUE: DIGIT+ ([.] DIGIT+)?
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
fragment VARIABLE: STRING
    | ALPHA | BETA | GAMMA | OMEGA
    | EPSILON | VAREPSILON
    | PHI | VARPHI
    ;

OPERAND: VALUE | VARIABLE ;

LEFT_PARENTHESIS          : '\\left('  | '(' ;
RIGHT_PARENTHESIS         : '\\right)' | ')' ;
LEFT_SQUARE_PARENTHESIS   : '\\left['  | '[' ;
RIGHT_SQUARE_PARENTHESIS  : '\\right]' | ']' ;
LEFT_BLOCK_PARENTHESIS    : '\\left{'  | '{' ;
RIGHT_BLOCK_PARENTHESIS   : '\\right}' | '}' ;
LEFT_STRAIGHT_PARENTHESIS : '\\left|'  | '|' ;
RIGHT_STRAIGHT_PARENTHESIS: '\\right|'       ;

WHITESPACE : ' ' -> skip ;