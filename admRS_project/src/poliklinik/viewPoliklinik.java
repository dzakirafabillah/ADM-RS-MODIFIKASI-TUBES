package poliklinik;

/**
 *
 * @author DZAKIRA
 */

import AdministrasiRS.*;
import poliklinik.*;
import java.awt.*;
import javax.swing.*;

public class viewPoliklinik extends javax.swing.JFrame {

    /**
     * Creates new form viewPoliklinik
     */
    public viewPoliklinik() {
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

        labelHeader = new javax.swing.JLabel();
        btnCekJmlPendaftaran = new javax.swing.JButton();
        btnListPoli = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAddPoli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrasi RS DPR");

        labelHeader.setText("Kelola Data Poliklinik");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        btnCekJmlPendaftaran.setText("Jumlah Pendaftaran");
        btnCekJmlPendaftaran.setBackground(new Color(119,136,153));
        btnCekJmlPendaftaran.setFont(new Font("Century Gothic", Font.BOLD, 18));
        btnCekJmlPendaftaran.setForeground(SystemColor.menu);
        btnCekJmlPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekJmlPendaftaranActionPerformed(evt);
            }
        });

        btnListPoli.setText("List Poliklinik");
        btnListPoli.setBackground(new Color(119,136,153));
        btnListPoli.setFont(new Font("Century Gothic", Font.BOLD, 18));
        btnListPoli.setForeground(SystemColor.menu);
        btnListPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListPoliActionPerformed(evt);
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

        btnAddPoli.setText("Tambah Poliklinik");
        btnAddPoli.setBackground(new Color(119,136,153));
        btnAddPoli.setFont(new Font("Century Gothic", Font.BOLD, 18));
        btnAddPoli.setForeground(SystemColor.menu);
        btnAddPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPoliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAddPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListPoli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBack)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCekJmlPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelHeader)
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCekJmlPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekJmlPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekJmlPendaftaranActionPerformed
        jmlPendaftaran start = new jmlPendaftaran();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnCekJmlPendaftaranActionPerformed

    private void btnListPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListPoliActionPerformed
        // TODO add your handling code here:
        ListPoliklinik start = new ListPoliklinik();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnListPoliActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenuAdmin start = new MainMenuAdmin();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPoliActionPerformed
        // TODO add your handling code here:
        inputPoliklinik start = new inputPoliklinik();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnAddPoliActionPerformed

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
            java.util.logging.Logger.getLogger(viewPoliklinik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewPoliklinik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewPoliklinik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewPoliklinik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new viewPoliklinik().setVisible(true);
        });
        
        
    }
    
    public void run() {
                viewPoliklinik calcu = new viewPoliklinik();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPoli;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCekJmlPendaftaran;
    private javax.swing.JButton btnListPoli;
    private javax.swing.JLabel labelHeader;
    // End of variables declaration//GEN-END:variables
}