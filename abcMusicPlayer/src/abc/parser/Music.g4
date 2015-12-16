/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Music;
import Configuration;

//parse music

root: voice EOF;
voice: DIVIDER? (measure DIVIDER?)+;
DIVIDER: '|' | '||' | '|]' | '[|';
measure: element+;
note: ACCIDENTAL? pitch OCTAVE? length?;
pitch: LOWERPITCH | HIGHERPITCH;
LOWERPITCH: [A-G];
HIGHERPITCH: [a-g];
OCTAVE: [,]+ | [']+;
ACCIDENTAL: ('^' | '^^' | '_' | '__' | '=');
length: NUMBER | fraction | denominator;
fraction: NUMBER '/' (NUMBER)?;
denominator: '/' (NUMBER)?;
NUMBER: [0-9]+;
rest: 'z' length?;
chord: '[' note+ ']';
duplet: '(2' (note | chord) (note | chord);
triplet: '(3' (note | chord) (note | chord) (note | chord);
quadruplet: '(4' (note | chord) (note | chord) (note | chord);
tuplet: duplet | triplet | quadruplet;
element: (note | rest | chord | tuplet);

/* tell Antlr to ignore spaces around tokens. */
SPACES : ([ ]+ | [\t] | NEWLINE) -> skip;
NEWLINE : '\r'|'\n'|'\r\n';