package codigo;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.TokenStream;


public class Frm_principal extends javax.swing.JFrame {
    
    NumeroLinea objLinea;
    NumeroLinea objLinea2;

    public Frm_principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
        
       objLinea = new NumeroLinea(txt_entrada);
       objLinea2 = new NumeroLinea(txt_resultado);
      
       
       jsc_lineas.setRowHeaderView(objLinea);
       jsc_tokens.setRowHeaderView(objLinea2);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsc_lineas = new javax.swing.JScrollPane();
        txt_entrada = new javax.swing.JTextArea();
        jsc_tokens = new javax.swing.JScrollPane();
        txt_resultado = new javax.swing.JTextArea();
        btn_abrir = new javax.swing.JButton();
        btn_analizar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(102, 255, 102));
        setName("Analizador Lexico"); // NOI18N

        txt_entrada.setColumns(20);
        txt_entrada.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txt_entrada.setRows(5);
        txt_entrada.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jsc_lineas.setViewportView(txt_entrada);

        txt_resultado.setColumns(20);
        txt_resultado.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_resultado.setRows(5);
        jsc_tokens.setViewportView(txt_resultado);

        btn_abrir.setText("Abrir Archivo");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });

        btn_analizar.setText("Analizar");
        btn_analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizarActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btn_abrir)
                        .addGap(54, 54, 54)
                        .addComponent(btn_analizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(btn_nuevo))
                    .addComponent(jsc_lineas)
                    .addComponent(jsc_tokens, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_abrir)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_analizar))
                .addGap(18, 18, 18)
                .addComponent(jsc_lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsc_tokens, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizarActionPerformed
        
        Analizador obj = new Analizador(null);
        
        obj.texto = txt_entrada.getText();
        
        try {
            obj.Escribir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            txt_resultado.setText(obj.Reed());
        } catch (IOException ex) {
            Logger.getLogger(Frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_btn_analizarActionPerformed

    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed
        
        Archivo obj2 = new Archivo();
        
        if(obj2.seleccionar.showDialog(null, "Open File") == JFileChooser.APPROVE_OPTION){
            
            obj2.archivo = obj2.seleccionar.getSelectedFile();
            
            if(obj2.archivo.canRead()){
                
                if(obj2.archivo.getName().endsWith("txt"));
                
                String documento = obj2.abrirArchivo(obj2.archivo);
                txt_entrada.setText(documento);
            }else{
            JOptionPane.showMessageDialog(null, "Arachivo no compatible");
            }
        
           
        
        }
        
        
    }//GEN-LAST:event_btn_abrirActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        txt_entrada.setText(" ");
        txt_resultado.setText(" ");
    }//GEN-LAST:event_btn_nuevoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_principal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir;
    private javax.swing.JButton btn_analizar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JScrollPane jsc_lineas;
    private javax.swing.JScrollPane jsc_tokens;
    private javax.swing.JTextArea txt_entrada;
    private javax.swing.JTextArea txt_resultado;
    // End of variables declaration//GEN-END:variables
}