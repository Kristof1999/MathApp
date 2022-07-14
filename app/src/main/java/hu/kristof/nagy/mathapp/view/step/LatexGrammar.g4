// based on: https://tomassetti.me/antlr-mega-tutorial
grammar LatexGrammar;
expression
    : OPERAND+                  # Operand
    | expression '+' expression # Addition
    | expression '*' expression # Multiplication
    | expression '-' expression # Subtraction
    | '\\frac{' expression '}{' expression '}' # Division
    | expression '^' expression # Exponentiation
    | '\\sqrt{' expression '}' # SquareRoot
    | '\\sqrt[' expression ']{' expression '}' # NthRoot
    | '\\log_{' expression '}' WHITESPACE expression # Logarithm
    | expression '=' expression # Equation
    | '\\operatorname{' STRING '}' LEFT_PARENTHESIS expression RIGHT_PARENTHESIS # CustomFunction
    | '\\sin' LEFT_PARENTHESIS expression RIGHT_PARENTHESIS # Sin
    | '\\cos' LEFT_PARENTHESIS expression RIGHT_PARENTHESIS # Cos
    | '\\lim_{' VARIABLE '\\to' VALUE '}' WHITESPACE expression # Limit
    | '\\sum_{' expression '}^{' expression '}' WHITESPACE expression # Sum
    | '\\prod_{' expression '}^{' expression '}' WHITESPACE expression # Product
    | '\\int' expression # IndefiniteIntegral
    | '\\int_{' expression '}^{' expression '}' # DefiniteIntegral
    | '\\iint' expression # DoubleIndefiniteIntegral
    | '\\iint_{' expression '}^{' expression '}' # DoubleDefiniteIntegral
    | LEFT_PARENTHESIS expression RIGHT_PARENTHESIS # Parentheses
    | LEFT_SQUARE_PARENTHESIS expression RIGHT_SQUARE_PARENTHESIS # SquareParentheses
    | LEFT_BLOCK_PARENTHESIS expression RIGHT_BLOCK_PARENTHESIS # BlockParentheses
    | LEFT_STRAIGHT_PARENTHESIS expression RIGHT_STRAIGHT_PARENTHESIS # StraightParentheses
    | '\\Vert{' expression '}' # DoubleStraightParentheses
    ;

fragment DIGIT: [0-9] ;
fragment INFINITY: '\\infty' ;
fragment EULERS_NUMBER: 'e' ;
fragment PI: '\\pi' ;
fragment VALUE: DIGIT+ ([.,] DIGIT+)?
    | INFINITY | EULERS_NUMBER | PI
    ;

fragment ALPHA: '\\alpha' ;
fragment BETA: '\\beta' ;
fragment GAMMA: '\\gamma' ;
fragment OMEGA: '\\omega' ;
fragment EPSILON: '\\epsilon' ;
fragment VAREPSILON: '\\varepsilon' ;
fragment PHI: '\\phi' ;
fragment VARPHI: '\\varphi' ;
fragment STRING: [a-zA-Z]+ ;
fragment VARIABLE: STRING
    | ALPHA | BETA | GAMMA | OMEGA
    | EPSILON | VAREPSILON
    | PHI | VARPHI
    ;

OPERAND: VALUE+ | VARIABLE+ ;

LEFT_PARENTHESIS: '\\left(' ;
RIGHT_PARENTHESIS: '\\right)' ;
LEFT_SQUARE_PARENTHESIS: '\\left[' ;
RIGHT_SQUARE_PARENTHESIS: '\\right]' ;
LEFT_BLOCK_PARENTHESIS: '\\left{' ;
RIGHT_BLOCK_PARENTHESIS: '\\right}' ;
LEFT_STRAIGHT_PARENTHESIS: '\\left|' ;
RIGHT_STRAIGHT_PARENTHESIS: '\\right|' ;

WHITESPACE : ' ' -> skip ;