/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran;

import AdministrasiRS.DBConnection;
import AdministrasiRS.viewPendaftaran;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author DZAKIRA
 */
public class tambahTindakanKePasien extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public tambahTindakanKePasien () {
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
        labelTahun = new javax.swing.JLabel();
        field_noRegis = new javax.swing.JTextField();
        labelTahun1 = new javax.swing.JLabel();
        choiceIdDokter = new java.awt.Choice();
        choiceIdTindakan = new java.awt.Choice();
        labelTahun2 = new javax.swing.JLabel();
        labelTahun3 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        label_tarif = new javax.swing.JLabel();
        labelTahun4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader.setText("Tambah Tindakan");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        labelTahun.setText("Nomor Registrasi");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        labelTahun1.setText("ID Dokter");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        String[] polListDok = new String[100];
        polListDok = insertTindakanKePasien.getDokter();
        for (int j = 0; j < 100; j++) {
            if (polListDok[j] != null){
                choiceIdDokter.addItem(polListDok[j]);
            }
        }

        String[] polList = new String[100];
        polList = insertTindakanKePasien.getTindakan();
        for (int j = 0; j < 100; j++) {
            if (polList[j] != null){
                choiceIdTindakan.addItem(polList[j]);
            }
        }

        labelTahun2.setText("ID Tindakan");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        labelTahun3.setText("Jumlah");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        Jumlah.setText("1");
        Jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahActionPerformed(evt);
            }
        });

        label_tarif.setText("Rp ");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        labelTahun4.setText("Tarif");
        labelTahun.setForeground(new Color(119,136,153));
        labelTahun.setBounds(114, 68, 213, 59);

        btnBack.setText("Kembali");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        submit.setText("submit");
        submit.setBackground(new Color(119,136,153));
        submit.setForeground(SystemColor.menu);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_noRegis))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelTahun3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Jumlah))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTahun1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelTahun2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(choiceIdTindakan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(choiceIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(submit)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelTahun4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTahun)
                    .addComponent(field_noRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTahun1)
                    .addComponent(choiceIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTahun2)
                    .addComponent(choiceIdTindakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTahun3)
                    .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTahun4)
                    .addComponent(label_tarif))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumlahActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        viewPendaftaran start = new viewPendaftaran();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String idTindakan = choiceIdTindakan.getSelectedItem();
        String tarif = insertTindakanKePasien.getTarifTindakan(idTindakan);
        String jml = Jumlah.getText();
        String idDokter = choiceIdDokter.getSelectedItem();
        String noRegis = field_noRegis.getText();

        label_tarif.setText("Rp " + tarif);
        insertTindakanKePasien.addTindakan(idTindakan, idDokter, noRegis, jml, tarif);
        
        this.clear();
    }//GEN-LAST:event_submitActionPerformed

    public void clear(){
        field_noRegis.setText("");
        Jumlah.setText("");
        label_tarif.setText("");
    }
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
            java.util.logging.Logger.getLogger(tambahTindakanKePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahTindakanKePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahTindakanKePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahTindakanKePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahTindakanKePasien ().setVisible(true);
            }
        });
    }
    
    public void run() {
        tambahTindakanKePasien calcu = new tambahTindakanKePasien();
        calcu.getContentPane().setBackground(new Color(204,229,255));
        calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jumlah;
    private javax.swing.JButton btnBack;
    private java.awt.Choice choiceIdDokter;
    private java.awt.Choice choiceIdTindakan;
    private javax.swing.JTextField field_noRegis;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelTahun;
    private javax.swing.JLabel labelTahun1;
    private javax.swing.JLabel labelTahun2;
    private javax.swing.JLabel labelTahun3;
    private javax.swing.JLabel labelTahun4;
    private javax.swing.JLabel label_tarif;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

class insertTindakanKePasien {
     static Connection con = DBConnection.getConnection();
     
     static String[] getTindakan(){
           
      PreparedStatement pst = null;
      String[] arrTindakan = new String[100];
      String sql = "select * from TINDAKAN";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrTindakan[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(dokter.poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrTindakan;
    }
     
     static String getTarifTindakan(String idTindakan){
           
      PreparedStatement pst = null;
      String[] arrTindakan = new String[100];
      String sql = "select tarif from TINDAKAN WHERE ID_TINDAKAN = '" + idTindakan + "'";
      ResultSet st;
      //System.out.println(sql);
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
        //        System.out.println(st.getString(1) + "ss");
                arrTindakan[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(dokter.poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrTindakan[0];
    }
     
     static String[] getDokter(){
           
      PreparedStatement pst = null;
      String[] arrDokter = new String[100];
      String sql = "select * from DOKTER";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrDokter[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(dokter.poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrDokter;
    }
     
     public  static String addTindakan(String idT, String idD, String noR, String jml, String aTarif){
         String idTindakan = idT;
         String idDokter = idD;
         String noRegis = noR;
         String jumlah = jml;
         String tarif = aTarif;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TINDAKAN_HISTORY_INSERT(?,?,?,?,?)}");
			stmt.setString(1, idD);
                        stmt.setString(2, noR);
                        stmt.setString(3, idT);
                        stmt.setString(4, jml);
                        stmt.setString(5, getTarifTindakan(idT));
                        
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Tindakan berhasil ditambahkan !");
		}catch(Exception e){
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Tindakan gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
				//con.close();
				input.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
         
         return hasil;
     }
}
