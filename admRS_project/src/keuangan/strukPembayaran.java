/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keuangan;
import AdministrasiRS.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



import java.io.*; 
import java.lang.*; 
import java.sql.CallableStatement;
import pendaftaran.listPendaftaran;
/**
 *
 * @author DZAKIRA
 */
public class strukPembayaran extends javax.swing.JFrame {

    /**
     * Creates new form strukPembayaran
     */
    public strukPembayaran() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nama_pasien = new javax.swing.JTextField();
        labelHeader = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        field_idP = new javax.swing.JTextField();

        jLabel1.setText("Nama Pasien");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader.setText("Print Struk Pembayaran");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        submit.setText("submit");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        btnBack.setText("Kembali");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Pembayaran");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(0, 397, Short.MAX_VALUE))
                    .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(field_idP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_idP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addComponent(submit)
                .addGap(46, 46, 46)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String idPembayaran = field_idP.getText();
        if(tarif.search(idPembayaran)){
            JOptionPane.showMessageDialog(null, "Pembayaran dengan ID " + field_idP.getText() + " tidak ditemukan");
        }else{
            strukResult start = new strukResult (idPembayaran, tarif.getTarif(idPembayaran));
            start.run(idPembayaran,tarif.getTarif(idPembayaran));
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        listPembayaran start = new listPembayaran ();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(strukPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(strukPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(strukPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(strukPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new strukPembayaran().setVisible(true);
        });
        
    }
    
    public void run() {
        strukPembayaran calcu = new strukPembayaran();
        calcu.getContentPane().setBackground(new Color(204,229,255));
        calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField field_idP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JTextField nama_pasien;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

class tarif { 
    static Connection con = DBConnection.getConnection();

    static String getTarif(String noRegis){
        Scanner input = new Scanner(System.in);
        CallableStatement stmt = null;
        String result = "";
        try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TOTAL_TARIF(?,?)}");
			stmt.setString(1, noRegis);
      
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			stmt.executeUpdate();
			result = stmt.getString(2);
			//read the OUT parameter now
                        
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			try {
                                stmt.close();
//				con.close();
				input.close();
			} catch (SQLException e){
//				e.printStackTrace();
			}
                        return result;                        
		}        
    }
    
    static boolean search(String idP){
      
      PreparedStatement pst = null;
      
      String sql = "select * from PEMBAYARAN WHERE id_pembayaran = '" + idP + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[1][4];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][4];
            
//            st=pst.executeQuery();
//            int i=0;
//            while(st.next()){
//                for (int k =1; k<5 ;k++){
//                    result[i][k-1] = st.getString(k);
//                }
//                i++;
//            }
            
            pst.close();
            System.out.println(size == 0);
            
        } catch (SQLException ex){
            Logger.getLogger(tarif.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return (result.length == 0);
    }
}