package ResepObat;

/**
 *
 * @author DZAKIRA
 */
import dokter.*;
import java.awt.*;
import javax.swing.*;
import AdministrasiRS.*;
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
public class obatID extends javax.swing.JFrame {

    /**
     * Creates new form dokterID
     */
    public obatID() {
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
        field_idObat = new javax.swing.JTextField();
        idDok = new javax.swing.JLabel();
        labelHeader5 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        idDok1 = new javax.swing.JLabel();
        field_idBahan = new javax.swing.JTextField();
        btnaddIngredient = new javax.swing.JButton();
        idDok2 = new javax.swing.JLabel();

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
        labelHeader4.setText("Komposisi Obat");

        submit.setText("Lihat Komposisi");
        submit.setBackground(new Color(119,136,153));
        submit.setForeground(SystemColor.menu);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        idDok.setText("ID Obat");

        labelHeader5.setText("Masukan ID Obat");
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

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String idObat = field_idObat.getText();
            String[] strings = Query.getIngredients(idObat);
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        idDok1.setText("ID Bahan");

        btnaddIngredient.setText("Tambahkan");
        submit.setBackground(new Color(119,136,153));
        submit.setForeground(SystemColor.menu);
        btnaddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddIngredientActionPerformed(evt);
            }
        });

        idDok2.setText("Menambahkan Data Komposisi Obat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(field_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBack1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idDok2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnaddIngredient)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idDok1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_idBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
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
                                .addGap(140, 140, 140))))
                    .addContainerGap(124, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader4)
                .addGap(97, 97, 97)
                .addComponent(field_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(idDok2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idDok1)
                    .addComponent(field_idBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnaddIngredient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnBack1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(labelHeader5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(idDok)
                    .addGap(31, 31, 31)
                    .addComponent(submit)
                    .addContainerGap(404, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(Query.searchIdObat(field_idObat.getText())){
            JOptionPane.showMessageDialog(null, "Obat dengan ID " + field_idObat.getText() + " tidak ditemukan");
        }else{
           jList1.setModel(new javax.swing.AbstractListModel<String>() {
                String idObat = field_idObat.getText();
                String[] strings = Query.getIngredients(idObat);
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
           });   
        }
    }//GEN-LAST:event_submitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        listObat start = new listObat();
        start.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnaddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddIngredientActionPerformed
        String idObat = field_idObat.getText();
        String idBahan = field_idBahan.getText();
        if(Query.searchIdObat(idObat) && Query.searchIdBahan(idBahan) ){
            JOptionPane.showMessageDialog(null, "salah satu ID tidak valid");
        }else{
            Query.addDataKandunganObat(idObat,idBahan);
            jList1.setModel(new javax.swing.AbstractListModel<String>() {
                String idObat = field_idObat.getText();
                String[] strings = Query.getIngredients(idObat);
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
           }); 
        }
    }//GEN-LAST:event_btnaddIngredientActionPerformed

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
            java.util.logging.Logger.getLogger(obatID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(obatID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(obatID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(obatID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new obatID().setVisible(true);
        });
        
    }
    
    public void run() {
        obatID calcu = new obatID();
        calcu.getContentPane().setBackground(new Color(204,229,255));
        calcu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnaddIngredient;
    private javax.swing.JTextField field_idBahan;
    private javax.swing.JTextField field_idObat;
    private javax.swing.JLabel idDok;
    private javax.swing.JLabel idDok1;
    private javax.swing.JLabel idDok2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHeader3;
    private javax.swing.JLabel labelHeader4;
    private javax.swing.JLabel labelHeader5;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
