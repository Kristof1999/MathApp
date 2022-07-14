// based on: https://tomassetti.me/antlr-mega-tutorial
grammar LatexGrammar;
expression
    : OPERAND
    | expression binary_operator expression
    ;
binary_operator: addition | multiplication | subtraction ;
addition: expression '+' expression ;
multiplication: expression '*' expression ;
subtraction: expression '-' expression ;

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
fragment LOWERCASE: [a-z] ;
fragment UPPERCASE: [A-Z] ;
fragment VARIABLE: (LOWERCASE | UPPERCASE)+
    | ALPHA | BETA | GAMMA | OMEGA
    | EPSILON | VAREPSILON
    | PHI | VARPHI
    ;

OPERAND: VALUE+ | VARIABLE+ ;

WHITESPACE : ' ' -> skip ;