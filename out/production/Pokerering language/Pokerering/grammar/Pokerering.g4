grammar Pokerering;

file
: code EOF
;

code
: statement 'getyourcookiejarout' code
| statement 'getyourcookiejarout'
;

statement
: decl
| assign
| print
| loop
;

loop
:loopHead loopBody
;

loopHead
: 'river' compExpr
;

loopBody
: 'flop' code 'turn'
;
//: 'river' compExpr 'flop' code 'turn'
//;

decl
: 'card' ID
;

assign
: ID 'pocketpair' expr
;

print
: 'showdown' expr
;

expr
: atomicExpr
| addExpr
;

atomicExpr
: INT
| ID
;

compExpr
: expr compareOps expr
;

compareOps
: 'air' 'pocketpair'
| 'pocketpair'
| 'airlines' 'pocketpair'
| 'air'
| 'airlines'
;

addExpr
: atomicExpr 'nuts' expr
;

ID: ('a'..'z')+;
INT: ('0'..'9')+;
WS: [ \n\t\r]+ -> skip ;