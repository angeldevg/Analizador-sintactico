
package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import javax.swing.JOptionPane;

public class Analizador {
String texto;


    public Analizador(String texto) {
        this.texto = texto;
    }
    
    
    public void Escribir() throws FileNotFoundException{
        
        File archivo = new File("Archivo.txt");
        
        PrintWriter escribir;
        
        escribir = new PrintWriter(archivo);
        
        escribir.print(texto);
        escribir.close();
        
    
    }
    
    
    public String Reed() throws FileNotFoundException, IOException{
        
        
        int count = 1;
        Reader lector = new BufferedReader(new FileReader("archivo.txt"));
        
        Lexer lexer = new Lexer(lector);
        String resultado = "[TOKENS]"+"     "+"[ANALISIS] \n";
        
       
        while (true) {
            
            Tokens tokens = lexer.yylex();
            
            if (tokens == null) {
                    
                    JOptionPane.showMessageDialog(null,"Anlisis completado") ;
                    
                    return resultado; 
                }
            
            
            switch (tokens) {
              
                    case Salto:
                        count++;
                    break;
                    
                    case ERROR:
                        resultado += "Simbolo no definido\n";    
                    break;
                    
                    
                    case Reservadas:
                        resultado += lexer.lexeme + "           " + tokens + "\n";    
                    break;
                    
                    case Igual:
                        resultado += lexer.yytext() + "         "+" Comparador" + "\n";    
                    break;
                    
                    case Suma:
                        resultado += "   "+lexer.yytext() + "      Operador Aritmetico" + "\n";    
                    break;
                    
                    case Resta:
                        resultado += "   "+lexer.yytext() + "      Operador Aritmetico" + "\n"; 
                    break;
                    
                    case Multiplicacion:
                        resultado += "   "+lexer.yytext() + "      Operador Aritmetico" + "\n"; 
                    break;
                    
                    case Division:
                        resultado += "   "+lexer.yytext() + "      Operador Aritmetico" + "\n"; 
                    break;
                    
                    case Nu_decimal:
                        resultado += "   "+lexer.yytext() + "      "+ tokens + "\n"; 
                    break;
                    
                    case Identificador:
                          
                        if(validarPalabra(lexer.lexeme)){
                            
                            resultado += "Linea " + count + ":" + " identificador sobrepasa la longitud permitida";                         
                        }else{
                            
                            resultado += lexer.lexeme + "       " + tokens + "\n";                        
                        }
                        
                    break;
                    case Numero:
                        
                       if(lexer.lexeme.matches("([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[12][0-9]{4}|3[01][0-9]{3}|32[0-6][0-9]{2}|327[0-5][0-9]|3276[0-8])")){
                           
                           
                        
                           resultado += lexer.lexeme + "           " + "Constante" + "\n";  
                    }else{
                           
                           resultado += "Linea " + count + ":" + " Constante entera fuera del rango permitido \n"; 
                                                 
                           
                       }
                          
                        
                          
                    break;
                    
                    case Comparador:
                        resultado += "   "+lexer.yytext() + "          " + tokens + "\n";        
                    break;
                    
                    
                    case Delimitador:
                        resultado += "   "+lexer.yytext() + "            " + tokens + "\n";        
                    break;
                    
                   
                  
                    default:
                        resultado += "Token" + tokens + "\n"; 
                        throw new AssertionError();
                }

        }
        
        
        
     
     
    }
    
    public boolean validarPalabra(String palabra){
        
    return palabra.length()>25;
    
    }

    void Escribir(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   



}
