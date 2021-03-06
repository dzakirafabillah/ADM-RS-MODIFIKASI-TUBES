package pendaftaran;


import AdministrasiRS.*;
import java.awt.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




import java.io.*; 
import java.lang.*; 

/**
 *
 * @author DZAKIRA
 */
public class listPendaftaran extends javax.swing.JFrame {

    /**
     * Creates new form listPendaftaran
     */
    public listPendaftaran() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        field_noRegis = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        labelHeader = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnaddTindakan = new javax.swing.JButton();
        field_search = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        labelHeader1 = new javax.swing.JLabel();
        btnAll = new javax.swing.JButton();
        btnUpdDiagnosa = new javax.swing.JButton();
        btnLihatListTdk = new javax.swing.JButton();

        submit.setText("submit");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader.setText("Daftar Riwayat Pendaftaran");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Object[][] tempp = Query.getListPendaftaran();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            tempp,
            new String [] {
                "No Registrasi", "Symptom", "Diagnosa", "Tipe Rawat", "Tgl Registrasi", "Usia", "No Rekam Medis", "ID Poliklinik"  ,"ID Dokter"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnaddTindakan.setText("Tambah Tindakan");
        btnaddTindakan.setBackground(new Color(119,136,153));
        btnaddTindakan.setForeground(SystemColor.menu);
        btnaddTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddTindakanActionPerformed(evt);
            }
        });

        btnSearch.setText("search");
        btnSearch.setBackground(new Color(119,136,153));
        btnSearch.setForeground(SystemColor.menu);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        labelHeader1.setText("Search by No Rekam Medis/Diagnosa");
        //labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        //labelHeader.setForeground(new Color(119,136,153));
        labelHeader1.setBounds(114, 68, 213, 59);
        labelHeader1.setHorizontalAlignment(SwingConstants.CENTER);

        btnAll.setText("see all");
        btnAll.setBackground(new Color(119,136,153));
        btnAll.setForeground(SystemColor.menu);
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        btnUpdDiagnosa.setText("Update Diagnosa");
        btnaddTindakan.setBackground(new Color(119,136,153));
        btnaddTindakan.setForeground(SystemColor.menu);
        btnUpdDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdDiagnosaActionPerformed(evt);
            }
        });

        btnLihatListTdk.setText("Daftar Tindakan Diterima");
        btnaddTindakan.setBackground(new Color(119,136,153));
        btnaddTindakan.setForeground(SystemColor.menu);
        btnLihatListTdk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatListTdkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHeader1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(field_search, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAll)
                                            .addComponent(btnSearch)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnaddTindakan)
                                .addGap(18, 18, 18)
                                .addComponent(btnLihatListTdk)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdDiagnosa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader)
                .addGap(55, 55, 55)
                .addComponent(labelHeader1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(field_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddTindakan)
                    .addComponent(btnLihatListTdk)
                    .addComponent(btnUpdDiagnosa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenuDokter  start = new MainMenuDokter();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnaddTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddTindakanActionPerformed
        tambahTindakanKePasien start = new tambahTindakanKePasien();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnaddTindakanActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

    }//GEN-LAST:event_submitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String noRM =field_search.getText();
        Object[][] tempp = Query.getListSearchPendaftaran(noRM);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            tempp,
            new String [] {
                "No Registrasi","Symptom", "Diagnosa", "Tipe Rawat", "Tgl Registrasi", "Usia", "No Rekam Medis", "ID Poliklinik" ,"ID Dokter"
            }
        ));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
       Object[][] tempp = Query.getListPendaftaran(); 

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            tempp,
            new String [] {
                "No Registrasi", "Symptom", "Diagnosa", "Tipe Rawat", "Tgl Registrasi", "Usia", "No Rekam Medis", "ID Poliklinik" ,"ID Dokter"
            }
        ));
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnUpdDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdDiagnosaActionPerformed
        UpdateDiagnosa start = new UpdateDiagnosa();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnUpdDiagnosaActionPerformed

    private void btnLihatListTdkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatListTdkActionPerformed
        DaftarTindakanDiterima start = new DaftarTindakanDiterima();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnLihatListTdkActionPerformed

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
            java.util.logging.Logger.getLogger(listPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new listPendaftaran().setVisible(true);
        });
        
    }
    
    public void run() {
        listPendaftaran calcu = new listPendaftaran();
        calcu.getContentPane().setBackground(new Color(204,229,255));
        calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLihatListTdk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdDiagnosa;
    private javax.swing.JButton btnaddTindakan;
    private javax.swing.JTextField field_noRegis;
    private javax.swing.JTextField field_search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelHeader1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}