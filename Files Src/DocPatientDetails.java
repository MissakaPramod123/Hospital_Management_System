
import javax.swing.JFrame;


public class DocPatientDetails extends javax.swing.JFrame {

    String id;
    public DocPatientDetails(String id) {
        this.id = id;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DPDUpdateDetails = new javax.swing.JButton();
        DPDHistory = new javax.swing.JButton();
        DPatientBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Dpdetails = new javax.swing.JDesktopPane();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hospital Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patient Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 240, 70));

        DPDUpdateDetails.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        DPDUpdateDetails.setText("Update Details");
        DPDUpdateDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DPDUpdateDetailsMouseClicked(evt);
            }
        });
        DPDUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPDUpdateDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(DPDUpdateDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, 60));

        DPDHistory.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        DPDHistory.setText("History");
        DPDHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DPDHistoryMouseClicked(evt);
            }
        });
        DPDHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPDHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(DPDHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 190, 60));

        DPatientBack.setBackground(new java.awt.Color(255, 255, 255));
        DPatientBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPatientBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        DPatientBack.setText("Back");
        DPatientBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DPatientBack.setBorderPainted(false);
        DPatientBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPatientBackActionPerformed(evt);
            }
        });
        jPanel1.add(DPatientBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 50));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 50));

        javax.swing.GroupLayout DpdetailsLayout = new javax.swing.GroupLayout(Dpdetails);
        Dpdetails.setLayout(DpdetailsLayout);
        DpdetailsLayout.setHorizontalGroup(
            DpdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        DpdetailsLayout.setVerticalGroup(
            DpdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel1.add(Dpdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 962, 562));

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/DPDetails.png"))); // NOI18N
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

    private void DPDUpdateDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DPDUpdateDetailsMouseClicked
       
    }//GEN-LAST:event_DPDUpdateDetailsMouseClicked

    private void DPDUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPDUpdateDetailsActionPerformed
            Dpdetails.removeAll();
            DocPatientUpdate DPD = new DocPatientUpdate();
            Dpdetails.add(DPD).setVisible(true);
    }//GEN-LAST:event_DPDUpdateDetailsActionPerformed

    private void DPDHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DPDHistoryMouseClicked
       
    }//GEN-LAST:event_DPDHistoryMouseClicked

    private void DPDHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPDHistoryActionPerformed
           Dpdetails.removeAll();
           DocPatientHistory DPH = new DocPatientHistory();
           Dpdetails.add(DPH).setVisible(true);
    }//GEN-LAST:event_DPDHistoryActionPerformed

    private void DPatientBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPatientBackActionPerformed
        DoctorPanel DPP = new DoctorPanel(id);
        DPP.setVisible(true);
        DPP.pack();
        DPP.setLocationRelativeTo(null);
        DPP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_DPatientBackActionPerformed

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
            java.util.logging.Logger.getLogger(DocPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocPatientDetails().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DPDHistory;
    private javax.swing.JButton DPDUpdateDetails;
    private javax.swing.JButton DPatientBack;
    private javax.swing.JDesktopPane Dpdetails;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
