package dokter;

/**
 *
 * @author DZAKIRA
 */
import java.awt.*;
import javax.swing.*;
import AdministrasiRS.DBConnection;
import AdministrasiRS.viewDokter;
import dokter.*;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class dokterID extends javax.swing.JFrame {

    /**
     * Creates new form dokterID
     */
    public dokterID() {
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

        labelHeader3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        labelHeader4 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        field_idDok = new javax.swing.JTextField();
        idDok = new javax.swing.JLabel();
        labelHeader5 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();

        labelHeader3.setText("Update Dokter");

        btnBack.setText("Kembali");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader4.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader4.setForeground(new Color(119,136,153));
        labelHeader4.setBounds(114, 68, 213, 59);
        labelHeader4.setHorizontalAlignment(SwingConstants.CENTER);
        labelHeader4.setText("Update Dokter");

        submit.setText("Update Now");
        submit.setBackground(new Color(119,136,153));
        submit.setForeground(SystemColor.menu);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        idDok.setText("ID Dokter");

        labelHeader5.setText("Update Dokter by ID Dokter");
        //labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        //labelHeader.setForeground(new Color(119,136,153));

        btnBack1.setText("Kembali");
        btnBack.setBackground(new Color(119,136,153));
        btnBack.setForeground(SystemColor.menu);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBack1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelHeader5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submit)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idDok, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(field_idDok, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(124, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                .addComponent(btnBack1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(labelHeader5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idDok)
                        .addComponent(field_idDok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addComponent(submit)
                    .addContainerGap(230, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(searchID.search(field_idDok.getText())){
            JOptionPane.showMessageDialog(null, "Dokter dengan ID " + field_idDok.getText() + " tidak ditemukan");
        }else{
            updateDokter start = new updateDokter(field_idDok.getText());
            start.run(field_idDok.getText());
            this.setVisible(false);   
        }
    }//GEN-LAST:event_submitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        listDokterr start = new listDokterr();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

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
            java.util.logging.Logger.getLogger(dokterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dokterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dokterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dokterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new dokterID().setVisible(true);
        });
        
    }
    
    public void run() {
        dokterID calcu = new dokterID();
        calcu.getContentPane().setBackground(new Color(204,229,255));
        calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JTextField field_idDok;
    private javax.swing.JLabel idDok;
    private javax.swing.JLabel labelHeader3;
    private javax.swing.JLabel labelHeader4;
    private javax.swing.JLabel labelHeader5;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

class searchID { 
    static Connection con = DBConnection.getConnection();
    
    static boolean search(String idDok){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DOKTER WHERE id_dokter = '" + idDok + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][7];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][7];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<8 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            System.out.println(result.length == 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(searchID.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return (result.length == 0);
        
    }
}
