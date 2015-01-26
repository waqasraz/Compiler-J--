 import java_cup.runtime.*;
%%
%cup
%class jmmScanner
%line
%column

%{
	StringBuffer string = new StringBuffer();
	private int CountWarnings = 0;
	
	private void checkWarning()
	{
		if( CountWarnings == 30)
		{
			System.err.println("Error: Too Many Warnings, Error Code: "+ sym.error );
			System.exit(0); 
		}
	}
	
	  private Symbol symbol(int type) {
         return new Symbol(type, yyline, yycolumn);
     }
     private Symbol symbol(int type, Object value) {
         return new Symbol(type, yyline, yycolumn, value);
     }
	
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
Identifier 	   = [a-zA-Z_][a-zA-Z0-9_]*
Comments	   = [/]+.*
//maFunction       = ({Identifier}{WhiteSpace}?\(\))
Numbers	   	   = [0-9]+

%state STRING

%%

<YYINITIAL> {
							
	/* Numbers */ 
  			{Numbers}  { return symbol(sym.NUMBER,yytext()); }
  			
	/* operators */
		 	"+" 		{ return symbol(sym.PLUS); }
  			"-" 		{ return symbol(sym.MINUS); }
  			"*" 		{ return symbol(sym.MULT); }
  			"/" 		{ return symbol(sym.SLASH); }
  			"%" 		{ return symbol(sym.PER); }
  			"<" 		{ return symbol(sym.LT); }
  			">" 		{ return symbol(sym.GT); }
  			"<=" 		{ return symbol(sym.LE); }
  			">=" 		{ return symbol(sym.GE); }
  			"=" 		{ return symbol(sym.EQ); }
  			
  			"!=" 		{ return symbol(sym.NE); }
  			"!" 		{ return symbol(sym.NOT); }
  			"&&" 		{ return symbol(sym.AND); }
  			
  			/* (\(&&\))	{ return symbol(sym.LOGICAND); } 
  				"==" 		{ return symbol(sym.ASSIGN); }
  				(\(\|\|\))	{ return symbol(sym.LOGICOR); }
  				"then" 		{ return symbol(sym.THEN); }
  				
  			*/
  			
  			"||" 		{ return symbol(sym.OR); }
  			
  			
  	/* keywords */
  			"break" 	{ return symbol(sym.BREAK); }
  			"return" 	{ return symbol(sym.RETURN); }
  			"if" 		{ return symbol(sym.IF); }
  			"else" 		{ return symbol(sym.ELSE); }
  			"while" 	{ return symbol(sym.WHILE); }		
  			"int" 		{ return symbol(sym.INT); }
  			"boolean" 	{ return symbol(sym.BOOLEAN); }
  			"true" 		{ return symbol(sym.TRUE); }
  			"false" 	{ return symbol(sym.FALSE); }
  			"void" 		{ return symbol(sym.VOID); }
  			
  	/* Symbolsbols */
  			"{" 		{ return symbol(sym.OPENBRACE); }
  			"}" 		{ return symbol(sym.CLOSEBRACE); }
  			
  			/* "[" 		{ return symbol(sym.OPENSQUARE); }
  			"]" 		{ return symbol(sym.CLOSESQUARE); } */
  			
  			"(" 		{ return symbol(sym.LP); }
  			")" 		{ return symbol(sym.RP); }		
  			";" 		{ return symbol(sym.SEMI); }
  			"," 		{ return symbol(sym.COMMA); }
  	/* whitespace */
  			{WhiteSpace}                   { /* ignore */ }
  	/*Comments*/
			{Comments} 					  { yyline++; }
  			
  	/* identifiers */ 
  			{Identifier}  { return symbol(sym.ID,yytext()); }
  	/*Begin STRING*/	
  			\"                             { string.setLength(0); yybegin(STRING); }
  	
  	/* Function 
  			{Function}	{ return symbol(sym.FUNCTION); }
  			*/
	
	/* error fallback */
			.|\n|\\        { System.err.println("Warning: Illegal character at or line " +
												 yyline +" Code: "+ Symbols.WARNING); CountWarnings++; checkWarning();yybegin(YYINITIAL);}
  		}
  		
  	/* String */	
  <STRING> {
  
  			\"                             { yybegin(YYINITIAL);
  								   return symbol(sym.STRING,string.toString()); }
		  [^\n\r\"\\]+                   { string.append( yytext() ); }
		  \\t                            { string.append(yytext()); }
		  \\n                            { string.append(yytext()); }
		
		  \\r                            { string.append(yytext()); }
		  \\\"                           { string.append(yytext()); }
		  \\                             { string.append(yytext()); }
		 <<EOF>>					{ System.err.println("Syntax Error: at line " +
												 yyline +" Code: "+ Symbols.ERROR);System.exit(0); }
		  
		  .|\n						 { System.err.println("Syntax Error: at line " +
												 yyline +" Code: "+ Symbols.ERROR);System.exit(0); }
  		}
  			
  	
  	