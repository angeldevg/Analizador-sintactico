package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z]+
M=[0-9]*"."[0-9]+
D=[0-9] | [1-9][0-9] | 1[0-9][0-9] | 2[0-2][0-9] | 23[0-1]
espacio=[ ,\t,\r]+
%{
   public String lexeme;
%}
%%
int | 
if  |
long |
end_if |
end |
for_each |
else |
begin |
print |
while  {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"%".* {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Salto;}
";" |
"(" |
")" |
"{" |
"}" {return Delimitador;}
">" |
"<" |
">=" |
"<=" |
"==" {return Comparador;}
":=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
{L}({L}|{D} | "_")* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
("(-"{M}+")")|{M}+ {lexeme=yytext(); return Nu_decimal;}
{D}{L}+{D}* {return ERROR;}
"_"{L}* {lexeme=yytext(); return ERROR;}
 . {return ERROR;}