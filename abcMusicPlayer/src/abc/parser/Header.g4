/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Header;
import Configuration;

//parse header
root: header EOF;
header: x t element* K;
element: c | l | m | q | v;
x: 'X:' NUMBER NEWLINE;
/*t: 'T:' (ANYCHAR | NUMBER)+ NEWLINE;*/
t: 'T:' notnewline+ NEWLINE;
c: 'C:' notnewline+ NEWLINE;
/*word: ([A-Z]|[a-z]) (','? | [a-z]+ '.'? ('\'' [a-z]+)?)*/
l: 'L:' NUMBER '/' NUMBER NEWLINE;
NUMBER: [0-9]+;
m: 'M:' ((NUMBER '/' NUMBER) | 'C' | 'C|') NEWLINE;
q: 'Q:' NUMBER '/' NUMBER '=' NUMBER NEWLINE;
K: 'K:' ('A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G') ('^'|'_')? 'm'? NEWLINE;
/*v: 'V:' (ANYCHAR | NUMBER)+ NEWLINE;*/
v: 'V:' notnewline+ NEWLINE;

/* tell Antlr to ignore spaces around tokens. */
SPACES : ([ ]+ | [\t] | COMMENT) -> skip;
NEWLINE : '\r'|'\n'|'\r\n';
ANYCHAR: .;
notnewline: ~(NEWLINE);
COMMENT: '%' ANYCHAR+ '%';