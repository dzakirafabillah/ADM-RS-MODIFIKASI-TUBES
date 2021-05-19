package ResepObat;

import poliklinik.*;
import AdministrasiRS.*;
import dokter.*;

/**
 *
 * @author HP
 */
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class updateStock extends javax.swing.JFrame {

    /**
     * Creates new form inputPoliklinik
     */
    static Connection con = DBConnection.getConnection();
    public updateStock() {
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
        labelHeader2 = new javax.swing.JLabel();
        field_idObat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_stockAvail = new javax.swing.JTextField();
        field_stockFisik = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader2.setText("Update Stock Obat");
        labelHeader2.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader2.setForeground(new Color(119,136,153));
        labelHeader2.setBounds(114, 68, 213, 59);
        labelHeader2.setHorizontalAlignment(SwingConstants.CENTER);

        field_idObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_idObatActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Obat");

        submit.setText("Submit");
        submit.setBackground(new Color(119,136,153));
        submit.setForeground(SystemColor.menu);
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

        jLabel4.setText("Stock Fisik Obat");

        jLabel5.setText("Stock Available Obat");

        field_stockAvail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_stockAvailActionPerformed(evt);
            }
        });

        field_stockFisik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_stockFisikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(field_stockAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field_stockFisik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(field_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submit))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHeader2)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(field_stockFisik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_stockAvail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_idObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_idObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_idObatActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String idObat = field_idObat.getText();
        String stockAvail = field_stockAvail.getText();
        String stockFisik = field_stockFisik.getText();

        Query.updStockObat(idObat, stockFisik, stockAvail);
        this.clear();
        
    }//GEN-LAST:event_submitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        viewObat start = new  viewObat();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void field_stockAvailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_stockAvailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_stockAvailActionPerformed

    private void field_stockFisikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_stockFisikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_stockFisikActionPerformed

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
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new updateStock().setVisible(true);
        });
        
        
    }
    
    public void run() {
                updateStock calcu = new updateStock();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    public void clear(){
        field_idObat.setText("");
        field_stockAvail.setText("");
        field_stockFisik.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField field_idObat;
    private javax.swing.JTextField field_stockAvail;
    private javax.swing.JTextField field_stockFisik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelHeader2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}