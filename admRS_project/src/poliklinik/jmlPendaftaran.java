package poliklinik;

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


import AdministrasiRS.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*; 
import java.lang.*; 
import java.sql.*;
/**
 *
 * @author DZAKIRA
 */
public class jmlPendaftaran extends javax.swing.JFrame {

    /**
     * Creates new form jmlPendaftaran
     */
    public jmlPendaftaran() {
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

        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        labelTahun1 = new javax.swing.JLabel();
        labelTahun2 = new javax.swing.JLabel();
        labelHeader = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labelTahun = new javax.swing.JLabel();
        choicePoliklinik = new java.awt.Choice();
        choiceBulan = new java.awt.Choice();
        choiceTahun = new java.awt.Choice();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTahun1.setText("Bulan ke-");

        labelTahun2.setText("Tahun");

        labelHeader.setText("Jumlah Pendaftaran");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        submit.setText("submit");
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

        labelTahun.setText("Poliklinik");

        String[] polList = new String[100];
        polList = poliklinik.getPoliklinik();
        for (int j = 0; j < 100 ; j++) {
            if (polList[j] != null){
                choicePoliklinik.addItem(polList[j]);
            }
        }

        for(int i = 1; i<13 ;i++){
            choiceBulan.addItem(String.valueOf(i));
        }

        for(int i = 2015; i<2022 ;i++){
            choiceTahun.addItem(String.valueOf(i));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choicePoliklinik, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(submit)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTahun2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelTahun1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(choiceBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(choiceTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTahun)
                    .addComponent(choicePoliklinik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTahun1)
                    .addComponent(choiceBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTahun2)
                    .addComponent(choiceTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        jmlPendaftaranResult start = new jmlPendaftaranResult();
        String aNama = choicePoliklinik.getSelectedItem();
        String aBulan = choiceBulan.getSelectedItem();
        String aTahun = choiceTahun.getSelectedItem();
                this.setVisible(false);
//        System.out.println(poliklinik.textProcedure(aNama, aBulan, aTahun));
        String jml = poliklinik.textProcedure(aNama, aBulan, aTahun);
        start.run(jml, aNama, aBulan, aTahun);

    }//GEN-LAST:event_submitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        viewPoliklinik start = new viewPoliklinik();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(jmlPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jmlPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jmlPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jmlPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new jmlPendaftaran().setVisible(true);
        });
        
        
    }
    
    public void run() {
                jmlPendaftaran calcu = new jmlPendaftaran();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private java.awt.Choice choiceBulan;
    private java.awt.Choice choicePoliklinik;
    private java.awt.Choice choiceTahun;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelTahun;
    private javax.swing.JLabel labelTahun1;
    private javax.swing.JLabel labelTahun2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

class poliklinik { 
    static Connection con = DBConnection.getConnection();

    static String[] getPoliklinik(){
           
      PreparedStatement pst = null;
      String[] arrPoliklinik = new String[100];
      String sql = "select * from POLIKLINIK";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrPoliklinik[i] = st.getString(2);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrPoliklinik;
    }
    
    static String textProcedure(String aNama, String aBulan, String aTahun){
        String text;
        Scanner input = new Scanner(System.in);
        CallableStatement stmt = null;
        String result = "";
        try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call JML_RIWAYAT_PENDAFTARAN(?,?,?,?)}");
			stmt.setString(1, aNama);
			stmt.setString(2, aBulan);
			stmt.setString(3, aTahun);
	
         
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			stmt.executeUpdate();
			result = stmt.getString(4);
			//read the OUT parameter now
//			System.out.println(result);
		}catch(Exception e){
//			e.printStackTrace();
                        
		}finally{
			try {
				stmt.close();
//				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
                        return result;
                        
		}
        
    }
    
}