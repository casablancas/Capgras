/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.ConexionBD;
import Splash.ListaPaciente;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alex
 */
public class ConsultaPaciente extends javax.swing.JFrame {

    String id;
    String lastid;
    
    DefaultTableModel model;
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    
    public ConsultaPaciente() 
    {
        this.id="";
        this.lastid="";
        initComponents();
        setTitle("Historial médico.");
        this.setLocationRelativeTo(ConsultaPaciente.this);
        //consultaDescripcion();
    }
    
    void cargar(String valor)
    {
        System.out.println("Id: "+this.id);
        //Encabezados de la tabla
        String [] titulos = {"Síntomas", "Diagnóstico", "Receta"};
        String [] registros = new String[3];
        

        String sql = "SELECT * FROM consulta WHERE hueid= '"+this.id+"' ";
        
           //String sql = "SELECT * FROM somhue";
        
        //Creamos nuestro objeto para la tabla que muestra los datos de la BD
        model = new DefaultTableModel(null, titulos);
        
        
        
        //String sql2 = "SELECT MAX(idcliente) AS id FROM somhue";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
//            ResultSet rs2 = st.executeQuery(sql2);
//                
//            while(rs2.next())
//            {
//                lastid = rs2.getString("id");
//            }
            
            while(rs.next())
            {
                registros[0] = rs.getString("sintomas");
                registros[1] = rs.getString("diagnostico");
                registros[2] = rs.getString("receta");
                
                model.addRow(registros);
            }
            tablaDatos.setModel(model);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
   
    public void limpiarJTextArea()
{
    //Limpiamos el área de impresión de los datos.
    //txtAreaDescripcion.setText("");
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage( new ImageIcon(getClass().getResource("/logotipo/capgras.png")).getImage());

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/cerrar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo/printer92.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImprimir)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnImprimir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

//        //Locale local = new Locale("es","MX");
//        SimpleDateFormat formateador = new SimpleDateFormat(
//                "dd' de 'MMMM' de 'yyyy", new Locale("es_ES"));
//        Date fechaDate = new Date();
//        String fecha = formateador.format(fechaDate);
////        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"),local);
////        calendar.add(Calendar.DATE, 7);
        
        Calendar cal = Calendar.getInstance();
        String dia = cal.get(Calendar.DATE)+"/";
        String mes = ""+cal.get(Calendar.MONTH);
        String año = "/"+cal.get(Calendar.YEAR);
        //String fecha = cal.get(Calendar.DATE)+"/"+cal.get((Calendar.MONTH))+"/"+cal.get(Calendar.YEAR);
        String hora = cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
        System.out.println("CAPGRAS - FePro: "+dia+(mes)+año+"  "+hora);
        
        
        //Youtube
        /*try {
            // TODO add your handling code here:
            JasperReport reporte = JasperCompileManager.compileReport("report1.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(ConsultaPaciente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }*/
        
        
        
//        List lista = new ArrayList();
//        for(int i=0; i<tablaDatos.getRowCount();i++)
//        {
//            ListaPaciente pacientes = new ListaPaciente(tablaDatos.getValueAt(i, 0).toString(), tablaDatos.getValueAt(i, 1).toString(), tablaDatos.getValueAt(i, 2).toString());
//            lista.add(pacientes);
//        }
//        
//        try {
//            JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("report5.jasper");
//            Map parametro = new HashMap();
//            parametro.put("hueid", this.id);
//            
//            //JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, cn);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));
//
//            JRExporter exporter = new JRPdfExporter();
//        
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("InfoBD_General.pdf"));
//            exporter.exportReport();
//        } catch (JRException ex) {
//            Logger.getLogger(ConsultaPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        
        
        
        try {
            MessageFormat headerFormat = new MessageFormat("Descripción de la consulta del paciente:\n");
            MessageFormat footerFormat = new MessageFormat("CAPGRAS - FePro: " +dia+mes+año+"  "+hora);
            //tablaDatos.print(JTable.PrintMode.NORMAL, headerFormat, footerFormat);
            //tablaDatos.print(JTable.PrintMode.valueOf(lastid));
            tablaDatos.print(JTable.PrintMode.NORMAL, headerFormat, footerFormat, rootPaneCheckingEnabled, null, rootPaneCheckingEnabled);
        } catch (PrinterException ex) {
            Logger.getLogger(ConsultaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
