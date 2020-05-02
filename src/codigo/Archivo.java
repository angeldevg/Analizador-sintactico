
package codigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Archivo {
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    
    public String abrirArchivo(File Archivo){
        
        String documento = "";
        
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            
            while ((ascci =  entrada.read()) != -1) {
            
                char caracter = (char)ascci;
                documento+=caracter;
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return documento;    
    }

    
    
}
