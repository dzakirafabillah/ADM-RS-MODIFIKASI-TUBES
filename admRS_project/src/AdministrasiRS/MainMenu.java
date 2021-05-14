package AdministrasiRS;


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
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MainMenu() {
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
        buttonPoliklinik = new javax.swing.JButton();
        buttonDokter = new javax.swing.JButton();
        buttonPendaftaran = new javax.swing.JButton();
        buttonPasien = new javax.swing.JButton();
        buttonPemasukan = new javax.swing.JButton();
        labelHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrasi RS DPR");

        buttonPoliklinik.setText("Kelola Data Poliklinik     ");
        buttonPoliklinik.setBackground(new Color(119,136,153));
        buttonPoliklinik.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonPoliklinik.setForeground(SystemColor.menu);
        buttonPoliklinik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPoliklinikActionPerformed(evt);
            }
        });

        buttonDokter.setText("Kelola Data Dokter");
        buttonDokter.setBackground(new Color(119,136,153));
        buttonDokter.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonDokter.setForeground(SystemColor.menu);
        buttonDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDokterActionPerformed(evt);
            }
        });

        buttonPendaftaran.setText("Kelola Data Pendaftaran");
        buttonPendaftaran.setBackground(new Color(119,136,153));
        buttonPendaftaran.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonPendaftaran.setForeground(SystemColor.menu);
        buttonPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPendaftaranActionPerformed(evt);
            }
        });

        buttonPasien.setText("Kelola Data Pasien");
        buttonPasien.setBackground(new Color(119,136,153));
        buttonPasien.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonPasien.setForeground(SystemColor.menu);
        buttonPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasienActionPerformed(evt);
            }
        });

        buttonPemasukan.setText("Keuangan RS");
        buttonPemasukan.setBackground(new Color(119,136,153));
        buttonPemasukan.setFont(new Font("Century Gothic", Font.BOLD, 18));
        buttonPemasukan.setForeground(SystemColor.menu);
        buttonPemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPemasukanActionPerformed(evt);
            }
        });

        labelHeader.setText("Administrasi Rumah Sakit DPR");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 35));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPoliklinik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPasien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPendaftaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(buttonPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelHeader)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPoliklinik, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPoliklinikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPoliklinikActionPerformed
        viewPoliklinik start = new viewPoliklinik();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonPoliklinikActionPerformed

    private void buttonDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDokterActionPerformed
        viewDokter start = new viewDokter();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonDokterActionPerformed

    private void buttonPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPendaftaranActionPerformed
        viewPendaftaran start = new viewPendaftaran();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonPendaftaranActionPerformed

    private void buttonPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPasienActionPerformed
        viewPasien start = new viewPasien();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonPasienActionPerformed

    private void buttonPemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPemasukanActionPerformed
        viewKeuangan start = new viewKeuangan();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_buttonPemasukanActionPerformed
    
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
            new MainMenu().setVisible(true);
        });
        
        
    }
    
    public void run() {
                MainMenu calcu = new MainMenu();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDokter;
    private javax.swing.JButton buttonPasien;
    private javax.swing.JButton buttonPemasukan;
    private javax.swing.JButton buttonPendaftaran;
    private javax.swing.JButton buttonPoliklinik;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel labelHeader;
    // End of variables declaration//GEN-END:variables
}