/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ConsultaDescripcion extends javax.swing.JFrame 
{
    //Creamos la instancia 'con' de tipo ConexionBD
    ConexionBD con = new ConexionBD();
    String id;

    /**
     * Creates new form ConsultaDescripcion
     */
    public ConsultaDescripcion()
    {
        this.id="";
        initComponents();
        setTitle("Nueva consulta médica.");
        this.setLocationRelativeTo(ConsultaDescripcion.this);
    }

    public void limpiarTextArea()
    {
        txtDiagnostico.setText(null);
        txtReceta.setText(null);
        txtSintomas.setText(null);
    }
    
    public void setId(String id)
    {
        this.id=id;
    }
    
    public void guardarConsultaMedica()
    {
        String sintomas = txtSintomas.getText().toString();
        String diagnostico = txtDiagnostico.getText().toString();
        String receta = txtReceta.getText().toString();
        
        String sql = "INSERT INTO consulta(sintomas, diagnostico, receta, hueid) values ('"+sintomas+"', '"+diagnostico+"', '"+receta+"', '"+this.id+"')"; //????: txtarea1, txtarea2, txtarea3, id_del_paciente   
        try {
            
                //Establece los valores para la sentencia SQL
                Connection c = con.conectar(); //Establecemos la conexion con la BD
            
                //Creamos variable tipo Statement para enviar comandos SQL a la base de datos
                Statement stm = c.createStatement();
                    
                limpiarTextArea();
                
                stm.executeUpdate(sql);
         
        JOptionPane.showMessageDialog(null,"Se ha completado el registro de datos. \nPresione Aceptar para finalizar.");
        con.desconectar();
        //btnGuardar.setEnabled(false);
   //     btnVerificar.grabFocus();
        } catch (SQLException ex) {
        //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.\n"+ex);
        }finally{
            con.desconectar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReceta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage( new ImageIcon(getClass().getResource("/logotipo/capgras.png")).getImage());

        txtSintomas.setColumns(20);
        txtSintomas.setRows(5);
        jScrollPane1.setViewportView(txtSintomas);

        jLabel1.setText("Síntomas presentes:");

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cancelar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/iconmonstr-save-2-icon-32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("Diagnóstico:");

        jLabel3.setText("Receta médica:");

        txtReceta.setColumns(20);
        txtReceta.setRows(5);
        jScrollPane2.setViewportView(txtReceta);

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane3.setViewportView(txtDiagnostico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarConsultaMedica();
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextArea txtReceta;
    private javax.swing.JTextArea txtSintomas;
    // End of variables declaration//GEN-END:variables
}
