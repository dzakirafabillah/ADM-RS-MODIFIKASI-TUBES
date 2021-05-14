package AdministrasiRS;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import keuangan.*;

/**
 *
 * @author DZAKIRA
 */
public class viewKeuangan extends javax.swing.JFrame {

    /**
     * Creates new form viewKeuangan
     */
    public viewKeuangan() {
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
        listPembayaran = new javax.swing.JButton();
        pemasukanRS = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelHeader.setText("Kelola Data Dokter");
        labelHeader.setFont(new Font("Century Gothic", Font.BOLD, 28));
        labelHeader.setForeground(new Color(119,136,153));
        labelHeader.setBounds(114, 68, 213, 59);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

        listPembayaran.setText("List Pembayaran");
        listPembayaran.setBackground(new Color(119,136,153));
        listPembayaran.setFont(new Font("Century Gothic", Font.BOLD, 18));
        listPembayaran.setForeground(SystemColor.menu);
        listPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPembayaranActionPerformed(evt);
            }
        });

        pemasukanRS.setText("Pemasukan RS");
        pemasukanRS.setBackground(new Color(119,136,153));
        pemasukanRS.setFont(new Font("Century Gothic", Font.BOLD, 18));
        pemasukanRS.setForeground(SystemColor.menu);
        pemasukanRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemasukanRSActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBack)
                .addContainerGap(391, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(listPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pemasukanRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(labelHeader)
                    .addGap(140, 140, 140)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pemasukanRS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(173, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPembayaranActionPerformed
        listPembayaran start = new listPembayaran();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_listPembayaranActionPerformed

    private void pemasukanRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemasukanRSActionPerformed
        formPemasukan start = new formPemasukan();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_pemasukanRSActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenu start = new MainMenu();
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
            java.util.logging.Logger.getLogger(viewKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewKeuangan().setVisible(true);
            }
        });
    }
    
    public void run() {
                viewKeuangan calcu = new viewKeuangan();
                calcu.getContentPane().setBackground(new Color(204,229,255));
                calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JButton listPembayaran;
    private javax.swing.JButton pemasukanRS;
    // End of variables declaration//GEN-END:variables
}
