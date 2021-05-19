package AdministrasiRS;


import keuangan.viewKeuanganTindakan;
import keuangan.viewKeuangan;
import keuangan.formPemasukan;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DZAKIRA
 */
public class MainMenuKeuangan extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MainMenuKeuangan() {
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

        jColorChooser1 = new javax.swing.JColorChooser();
        buttonKeuangan = new javax.swing.JButton();
        buttonTindakan = new javax.swing.JButton();
        labelHeader = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrasi RS DPR");

        buttonKeuangan.setText("Keuangan RS");
        buttonKeuangan.setBackground(new Color(119,136,153));
        buttonKeuangan.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonKeuangan.setForeground(SystemColor.menu);
        buttonKeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeuanganActionPerformed(evt);
            }
        });

        buttonTindakan.setText("Kelola Tarif Tindakan");
        buttonTindakan.setBackground(new Color(119,136,153));
        buttonTindakan.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonTindakan.setForeground(SystemColor.menu);
        buttonTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTindakanActionPerformed(evt);
            }
        });

        labelHeader.setText("Selamat Datang Manajemen Keuangan");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 35));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        btnBack.setText("Kembali");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTindakan, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(buttonKeuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelHeader)
                .addGap(75, 75, 75)
                .addComponent(buttonKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTindakan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeuanganActionPerformed
        viewKeuangan start = new viewKeuangan();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonKeuanganActionPerformed

    private void buttonTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTindakanActionPerformed
        viewKeuanganTindakan start = new viewKeuanganTindakan();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonTindakanActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginPageFrame start = new LoginPageFrame();
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenuKeuangan().setVisible(true);
        });
        
        
    }
    
    public void run() {
                MainMenuKeuangan calcu = new MainMenuKeuangan();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton buttonKeuangan;
    private javax.swing.JButton buttonTindakan;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel labelHeader;
    // End of variables declaration//GEN-END:variables
}