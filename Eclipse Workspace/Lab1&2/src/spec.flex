// import section

%%

// option and declaration section
%class MPLexer
%function next_token
%line
%column
%debug
%type Yytoken

%eofval{
return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

%{
// additional members of generated class
KWTable kwTable = new KWTable();
Yytoken getKW()
{
	return new Yytoken( kwTable.find( yytext() ), yytext(), yyline, yycolumn );
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
\( { return new Yytoken( sym.LEFTPAR, yytext(), yyline, yycolumn ); }
\) { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }

// operators
"||" { return new Yytoken( sym.OR, yytext(), yyline, yycolumn ); }
"&&" { return new Yytoken( sym.AND, yytext(), yyline, yycolumn ); }
\< { return new Yytoken( sym.LESS, yytext(), yyline, yycolumn ); }
\> { return new Yytoken( sym.GREATER, yytext(), yyline, yycolumn ); }
"<=" { return new Yytoken( sym.LESS_EQ, yytext(), yyline, yycolumn ); }
">=" { return new Yytoken( sym.GREATER_EQ, yytext(), yyline, yycolumn ); }
"==" { return new Yytoken( sym.EQ, yytext(), yyline, yycolumn ); }
"<>" { return new Yytoken( sym.NOT_EQ, yytext(), yyline, yycolumn ); }

// separators
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn ); }
, { return new Yytoken( sym.COMMA, yytext(), yyline, yycolumn ); }
\. { return new Yytoken( sym.DOT, yytext(), yyline, yycolumn ); }
:= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn ); }

// key words
// boolean - here because of priority of recognition
true|false { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
{letter}+ { return getKW(); }

// ids'
({letter}|\$)({letter}|{digit}|\$)* { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }

// constants
// int
0[0-7]+|0x[0-9a-fA-F]+|{digit}+ { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
// real
(({digit}+\.{digit}*)|(\.{digit}+))(=E(\+|-)?{digit}+)? { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
// char
\"[^]\" { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
//error processing
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
