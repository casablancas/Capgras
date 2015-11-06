/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.ConexionBD;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ConsultaMedicaNueva extends javax.swing.JFrame
{

    //Creamos la instancia 'con' de tipo ConexionBD
    ConexionBD con = new ConexionBD();
    //Inscanciamos el date para la fecha de nacimiento del paciente.
    DateFormat date = DateFormat.getDateInstance();
    //Arreglo para selección del tipo de sangre del paciente.
    String[] arraySangre = {"Seleccione","O-", "O+", "A-", "A+", "B+", "B+", "AB-", "AB+"};
    //Instanciamos el combo box.
    //JComboBox comboSangre = new JComboBox(arraySangre);
    String nombre="", apellidos="", edad="", genero="", sangre="", estatura="", peso="", alergias="", telefono="";
    
    
    public ConsultaMedicaNueva() {
        initComponents();
        setTitle("Registro de datos del nuevo paciente.");
        this.setLocationRelativeTo(ConsultaMedicaNueva.this);
        this.setSize(700, 490); 
        //this.setSize(688, 414);
        this.setResizable(false);
        limpiarTextFields();
        txtNombre.requestFocus();
        optMasculino.setSelected(true);
        btnGuardar.setEnabled(true);
        comboSangre.setSelectedIndex(1);
//        comboSangre.addActionListener((ActionListener) this);
//        add(comboSangre);
    }


    public void limpiarTextFields()
    {
         txtNombre.setText(null);
         txtAlergias.setText(null);
         txtApellidos.setText(null);
         txtEdad.setText(null);
         txtEstatura.setText(null);
         txtPeso.setText(null);
         txtTelefono.setText(null);
    }
    
    public void guardarHuella(){
     //Obtiene los datos del template de la huella actual
     //ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
     //Integer tamañoHuella = template.serialize().length;
     
     //Creamos una nueva ventana para el formulario de los datos.
     //ventanaNueva.setVisible(true);
     
     //Pregunta los datos de la persona a la cual corresponde dicha huella.
     
//     String nombre = JOptionPane.showInputDialog("Nombre:");
//     String apellidos = JOptionPane.showInputDialog("Apellidos:");
//     String edad = JOptionPane.showInputDialog("Edad:");
//     String sexo = JOptionPane.showInputDialog("Sexo:");
//     String estatura = JOptionPane.showInputDialog("Estatura:");
//     String peso = JOptionPane.showInputDialog("Peso:");
//     String alergias = JOptionPane.showInputDialog("Alergias:");
//     String tiposangre = JOptionPane.showInputDialog("Tipo de Sangre:");
     
     //String nombre, apellidos,edad, sexo, estatura, peso, alergias, tiposangre;
     
//        String sql = "INSERT INTO somhue(huenombre, hueapellidos, "
//                + "hueedad, huesexo, hueestatura, huepeso, huealergias,"
//                + "huetiposangre) values(?,?,?,?,?,?,?,?)";
        
        
        
        
     
     try {
     //Establece los valores para la sentencia SQL
     Connection c = con.conectar(); //Establecemos la conexion con la BD
            
                Statement stm = c.createStatement();
                ResultSet rs = stm.executeQuery("SELECT MAX(hueid) AS id FROM somhue");
                String lastid="";
                
                    while(rs.next())
                    {
                        lastid = rs.getString("id");
                    }
                    
                nombre = txtNombre.getText().toString();
                apellidos = txtApellidos.getText().toString();
                edad = txtEdad.getText().toString();
                //String sexo = txtSexo.getText();
                estatura = txtEstatura.getText().toString();
                peso = txtPeso.getText().toString();
                alergias = txtAlergias.getText().toString();
                //String tiposangre = txtTelefono.getText();
                telefono = txtTelefono.getText().toString();
                String fecha = date.format(btnFecha.getDate());
                //Para seleccionar el combobox conforme al index.
                //int sangre = comboSangre.getSelectedIndex();
                //Para jalar conforme al item seleccionado del combobox.
                sangre = comboSangre.getSelectedItem().toString();
                //O-", "O+", "A-", "A+", "B+", "B+", "AB-", "AB+
                
                if(sangre.equals("O-"))
                    sangre = "O-";
                if(sangre.equals("O+"))
                    sangre = "O+";
                if(sangre.equals("A-"))
                    sangre = "A-";
                if(sangre.equals("A+"))
                    sangre = "A+";
                if(sangre.equals("B-"))
                    sangre = "B-";
                if(sangre.equals("B+"))
                    sangre = "B+";
                if(sangre.equals("AB-"))
                    sangre = "AB-";
                if(sangre.equals("AB+"))
                    sangre = "AB+";
                
                //Obtenemos la información del radio button seleccionado
                //para saber qué género sexual es el paciente.
                if(optMasculino.isSelected())
                    genero = "Masculino";
                if(optFemenino.isSelected())
                    genero = "Femenino";

                String sql = "UPDATE somhue SET huenombre = '"+nombre+"',  hueapellidos = '"+apellidos+"', hueedad = '"+edad+"', huesexo = '"+genero+"', hueestatura = '"+estatura+"', huepeso = '"+peso+"', huealergias = '"+alergias+"', huetiposangre = '"+sangre+"', huefecha = '"+fecha+"', huetelefono = '"+telefono+"' WHERE hueid='"+lastid+"'";
                
                stm.executeUpdate(sql);
         
         
     JOptionPane.showMessageDialog(null,"Se ha completado el registro de datos. \nPresione Aceptar para finalizar.");
     con.desconectar();
     //btnGuardar.setEnabled(false);
//     btnVerificar.grabFocus();
     } catch (SQLException ex) {
     //Si ocurre un error lo indica en la consola
     System.err.println("Error al guardar los datos de la huella."+ex);
     }finally{
     con.desconectar();
     }
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstatura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtAlergias = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        optMasculino = new javax.swing.JRadioButton();
        optFemenino = new javax.swing.JRadioButton();
        btnFecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboSangre = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/logotipo/capgras.png")).getImage());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/iconmonstr-save-2-icon-32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cancelar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        jLabel2.setText("Apellidos:");

        jLabel1.setText("Nombre(s):");

        jLabel3.setText("NSS:");

        jLabel4.setText("Género:");

        jLabel5.setText("Estatura:");

        jLabel6.setText("Peso:");

        jLabel7.setText("Alergias:");

        jLabel8.setText("Tel (familiar):");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtEstatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstaturaActionPerformed(evt);
            }
        });

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        txtAlergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlergiasActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Por favor, llene los siguientes campos para completar el registro de la huella dactilar en la base de datos.");

        grupoGenero.add(optMasculino);
        optMasculino.setText("Masculino");
        optMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optMasculinoActionPerformed(evt);
            }
        });

        grupoGenero.add(optFemenino);
        optFemenino.setText("Femenino");
        optFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optFemeninoActionPerformed(evt);
            }
        });

        jLabel10.setText("Nacimiento:");

        jLabel11.setText("Tipo de sangre:");

        comboSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O-", "O+", "A-", "A+", "B+", "B+", "AB-", "AB+" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(77, 77, 77)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(optMasculino)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(optFemenino)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel7))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(49, 49, 49)
                                                        .addComponent(comboSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(btnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(comboSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(optMasculino)
                    .addComponent(optFemenino)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarHuella();
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
        txtApellidos.transferFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
        txtEdad.transferFocus();
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtEstaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstaturaActionPerformed
        // TODO add your handling code here:
        txtEstatura.transferFocus();
    }//GEN-LAST:event_txtEstaturaActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
        txtPeso.transferFocus();
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtAlergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlergiasActionPerformed
        // TODO add your handling code here:
        txtAlergias.transferFocus();
    }//GEN-LAST:event_txtAlergiasActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void optMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optMasculinoActionPerformed

    private void optFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optFemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optFemeninoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private com.toedter.calendar.JDateChooser btnFecha;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox comboSangre;
    private javax.swing.ButtonGroup grupoGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton optFemenino;
    private javax.swing.JRadioButton optMasculino;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
