
import javax.swing.JFrame;


public class AdminDoctor extends javax.swing.JFrame {

    /**
     * Creates new form AdminDoctor
     */
    public AdminDoctor() {
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
        ADadd = new javax.swing.JButton();
        ADdelete = new javax.swing.JButton();
        ADsearch = new javax.swing.JButton();
        ADupdate = new javax.swing.JButton();
        ADview = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ADBack = new javax.swing.JButton();
        AdminDocDesktop = new javax.swing.JDesktopPane();
        UpdateDocClose1 = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADadd.setText("Add Doctor");
        ADadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADaddMouseClicked(evt);
            }
        });
        ADadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADaddActionPerformed(evt);
            }
        });
        jPanel1.add(ADadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 190, 60));

        ADdelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADdelete.setText("Delete Doctor");
        ADdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADdeleteMouseClicked(evt);
            }
        });
        ADdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(ADdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, 60));

        ADsearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADsearch.setText("Search Doctor");
        ADsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADsearchMouseClicked(evt);
            }
        });
        ADsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADsearchActionPerformed(evt);
            }
        });
        jPanel1.add(ADsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 60));

        ADupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADupdate.setText("Update Doctor");
        ADupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADupdateActionPerformed(evt);
            }
        });
        jPanel1.add(ADupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 190, 60));

        ADview.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADview.setText("Doctor Details");
        ADview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADviewActionPerformed(evt);
            }
        });
        jPanel1.add(ADview, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 190, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hospital Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        ADBack.setBackground(new java.awt.Color(255, 255, 255));
        ADBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        ADBack.setText("Back");
        ADBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ADBack.setBorderPainted(false);
        ADBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADBackActionPerformed(evt);
            }
        });
        jPanel1.add(ADBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, 50));

        AdminDocDesktop.setPreferredSize(new java.awt.Dimension(970, 560));

        javax.swing.GroupLayout AdminDocDesktopLayout = new javax.swing.GroupLayout(AdminDocDesktop);
        AdminDocDesktop.setLayout(AdminDocDesktopLayout);
        AdminDocDesktopLayout.setHorizontalGroup(
            AdminDocDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        AdminDocDesktopLayout.setVerticalGroup(
            AdminDocDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel1.add(AdminDocDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/HSAdminDoctor.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void ADaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADaddActionPerformed
        
    }//GEN-LAST:event_ADaddActionPerformed

    private void ADsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADsearchActionPerformed
       
    }//GEN-LAST:event_ADsearchActionPerformed

    private void ADupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADupdateActionPerformed
        //new UpdateDoc().setVisible(true);
        AdminDocDesktop.removeAll();
        UpdateDoc1 Updd = new UpdateDoc1();
        AdminDocDesktop.add(Updd).setVisible(true);
    }//GEN-LAST:event_ADupdateActionPerformed

    private void ADviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADviewActionPerformed
       //new ViewDoc().setVisible(true);
       AdminDocDesktop.removeAll();
       ViewDoc1 Vd = new ViewDoc1();
       AdminDocDesktop.add(Vd).setVisible(true);
    }//GEN-LAST:event_ADviewActionPerformed

    private void ADaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADaddMouseClicked

        //new AddDoc().setVisible(true);
        AdminDocDesktop.removeAll();
        AddDoc1 ADDd = new AddDoc1();
        AdminDocDesktop.add(ADDd).setVisible(true);
        
    }//GEN-LAST:event_ADaddMouseClicked

    private void ADdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADdeleteMouseClicked
        //new DltDoc().setVisible(true);
        AdminDocDesktop.removeAll();
        DeleteDoc1 Dltd = new DeleteDoc1();
        AdminDocDesktop.add(Dltd).setVisible(true);
    
    }//GEN-LAST:event_ADdeleteMouseClicked

    private void ADsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADsearchMouseClicked
      //new SearchDoc().setVisible(true);
        AdminDocDesktop.removeAll();
        SearchDoc1 Searchd = new SearchDoc1();
        AdminDocDesktop.add(Searchd).setVisible(true);
    }//GEN-LAST:event_ADsearchMouseClicked

    private void ADdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADdeleteActionPerformed
        
    }//GEN-LAST:event_ADdeleteActionPerformed

    private void ADBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADBackActionPerformed
       AdminPanel ADp = new AdminPanel();
       ADp.setVisible(true);
       ADp.pack();
       ADp.setLocationRelativeTo(null);
       ADp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_ADBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADBack;
    private javax.swing.JButton ADadd;
    private javax.swing.JButton ADdelete;
    private javax.swing.JButton ADsearch;
    private javax.swing.JButton ADupdate;
    private javax.swing.JButton ADview;
    private javax.swing.JDesktopPane AdminDocDesktop;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}