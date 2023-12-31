
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ReceptionistPanal extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistPanal
     */
    public ReceptionistPanal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public ReceptionistPanal(String id,String username, String password) {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RecBilling = new javax.swing.JButton();
        RCAppoinment = new javax.swing.JButton();
        RdocDetails = new javax.swing.JButton();
        RecPat = new javax.swing.JButton();
        RPlogOut = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Reception Panel");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 270, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/notepad.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 140, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/budget.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 280, 160, 160));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/doctor (5).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 140, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/health-insurance.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 140, 160));

        RecBilling.setBackground(new java.awt.Color(255, 255, 255));
        RecBilling.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RecBilling.setText("Billing Information");
        RecBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecBillingActionPerformed(evt);
            }
        });
        jPanel1.add(RecBilling, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 450, 170, 50));

        RCAppoinment.setBackground(new java.awt.Color(255, 255, 255));
        RCAppoinment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RCAppoinment.setText("Create Appoinment");
        RCAppoinment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCAppoinmentActionPerformed(evt);
            }
        });
        jPanel1.add(RCAppoinment, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 170, 50));

        RdocDetails.setBackground(new java.awt.Color(255, 255, 255));
        RdocDetails.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RdocDetails.setText("Doctor Details");
        RdocDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdocDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(RdocDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 170, 50));

        RecPat.setBackground(new java.awt.Color(255, 255, 255));
        RecPat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RecPat.setText("Patient Details");
        RecPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecPatActionPerformed(evt);
            }
        });
        jPanel1.add(RecPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 170, 50));

        RPlogOut.setBackground(new java.awt.Color(242, 38, 19));
        RPlogOut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPlogOut.setForeground(new java.awt.Color(255, 255, 255));
        RPlogOut.setText("Log Out");
        RPlogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPlogOutActionPerformed(evt);
            }
        });
        jPanel1.add(RPlogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 130, 50));

        UpdateDocClose.setBackground(new java.awt.Color(255, 0, 51));
        UpdateDocClose.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UpdateDocClose.setForeground(new java.awt.Color(255, 255, 255));
        UpdateDocClose.setText("X");
        UpdateDocClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        UpdateDocClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDocCloseActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateDocClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 50, 25));

        UpdateDocClose1.setBackground(new java.awt.Color(44, 62, 80));
        UpdateDocClose1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        UpdateDocClose1.setForeground(new java.awt.Color(255, 255, 255));
        UpdateDocClose1.setText("-");
        UpdateDocClose1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        UpdateDocClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDocClose1ActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateDocClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 50, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/PatientPanel.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RPlogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPlogOutActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"DO YOU WANT TO LOG OUT ?");
        if (check == 0){
        LoginAs12 logas = new LoginAs12();
        logas.setVisible(true);
        logas.pack();
        logas.setLocationRelativeTo(null);
        logas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        }
    }//GEN-LAST:event_RPlogOutActionPerformed

    private void RecPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecPatActionPerformed
        ReceptionPatient RP = new ReceptionPatient();
        RP.setVisible(true);
        RP.pack();
        RP.setLocationRelativeTo(null);
        RP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RecPatActionPerformed

    private void RdocDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdocDetailsActionPerformed
        ReceptionDoctor RD = new ReceptionDoctor();
        RD.setVisible(true);
        RD.pack();
        RD.setLocationRelativeTo(null);
        RD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RdocDetailsActionPerformed

    private void RCAppoinmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCAppoinmentActionPerformed
        CreateChannel CC = new CreateChannel();
        CC.setVisible(true);
        CC.pack();
        CC.setLocationRelativeTo(null);
        CC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RCAppoinmentActionPerformed

    private void RecBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecBillingActionPerformed
        ReceptionBill RB = new ReceptionBill();
        RB.setVisible(true);
        RB.pack();
        RB.setLocationRelativeTo(null);
        RB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RecBillingActionPerformed

    private void UpdateDocCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_UpdateDocCloseActionPerformed

    private void UpdateDocClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocClose1ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_UpdateDocClose1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistPanal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RCAppoinment;
    private javax.swing.JButton RPlogOut;
    private javax.swing.JButton RdocDetails;
    private javax.swing.JButton RecBilling;
    private javax.swing.JButton RecPat;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
