// import section
import java_cup.runtime.*;

%%

// option and declaration section
%class MPLexer

%cup

%line
%column

%eofval{
	return new Symbol( sym.EOF );
%eofval}

%{
	public int getLine()
	{
		return yyline;
	}
%}

// states
%xstate COMMENT
// macros
letter = [a-zA-Z]
digit = [0-9]

%%

// rules
"**" { yybegin( COMMENT ); }
<COMMENT>~"**" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; }
\( { return new Symbol( sym.LEFTPAR ); }
\) { return new Symbol( sym.RIGHTPAR ); }

// operators
\< { return new Symbol( sym.LESS ); }
\> { return new Symbol( sym.GREATER ); }
"<=" { return new Symbol( sym.LESS_EQ ); }
">=" { return new Symbol( sym.GREATER_EQ ); }
"==" { return new Symbol( sym.EQ ); }
"<>" { return new Symbol( sym.NOT_EQ ); }

// separators
; { return new Symbol( sym.SEMICOLON ); }
: { return new Symbol( sym.COLON ); }
, { return new Symbol( sym.COMMA ); }
\. { return new Symbol( sym.DOT ); }
:= { return new Symbol( sym.ASSIGN ); }

// key words
"program"		{ return new Symbol( sym.PROGRAM ); }
"integer" 		{ return new Symbol( sym.INTEGER ); }
"char" 		    { return new Symbol( sym.CHAR ); }
"real"			{ return new Symbol( sym.REAL ); }
"boolean"		{ return new Symbol( sym.BOOLEAN ); }
"begin" 		{ return new Symbol( sym.BEGIN ); }
"end"			{ return new Symbol( sym.END ); }
"else"			{ return new Symbol( sym.ELSE ); }
"while"			{ return new Symbol( sym.WHILE ); }
"or"			{ return new Symbol( sym.OR ); }
"and"			{ return new Symbol( sym.AND ); }

// boolean
true|false { return new Symbol( sym.BOOLCONST, new Boolean( yytext() ) ); }

// ids'
({letter}|\$)({letter}|{digit}|\$)* { return new Symbol( sym.ID, new String( yytext() ) ); }

// constants
// int
0[0-7]+|0x[0-9a-fA-F]+|{digit}+ { return new Symbol( sym.INTCONST, new Integer( yytext() )  ); }
// real
(({digit}+\.{digit}*)|(\.{digit}+))(E(\+|-)?{digit}+)? { return new Symbol( sym.REALCONST, new Double( yytext() )  ); }
// char
'[^]' { return new Symbol( sym.CHARCONST, new Character( yytext().charAt(1) ) ); }
//error processing
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
