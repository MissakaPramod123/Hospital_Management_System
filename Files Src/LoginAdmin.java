
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LoginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ALpasswordBox = new javax.swing.JPasswordField();
        ALunamebox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ADLogin = new javax.swing.JButton();
        ADLcancel = new javax.swing.JButton();
        ADLClose = new javax.swing.JLabel();
        ADLMin = new javax.swing.JLabel();
        ADPatBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 280, 60));

        ALpasswordBox.setBackground(new java.awt.Color(108, 122, 137));
        ALpasswordBox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ALpasswordBox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ALpasswordBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 260, 40));

        ALunamebox.setBackground(new java.awt.Color(108, 122, 137));
        ALunamebox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ALunamebox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ALunamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 260, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("User Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, 23));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Password   :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        ADLogin.setBackground(new java.awt.Color(34, 167, 240));
        ADLogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADLogin.setForeground(new java.awt.Color(255, 255, 255));
        ADLogin.setText("LOGIN");
        ADLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADLoginActionPerformed(evt);
            }
        });
        jPanel1.add(ADLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 430, -1, 50));

        ADLcancel.setBackground(new java.awt.Color(242, 38, 19));
        ADLcancel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADLcancel.setForeground(new java.awt.Color(255, 255, 255));
        ADLcancel.setText("CANCEL");
        ADLcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADLcancelActionPerformed(evt);
            }
        });
        jPanel1.add(ADLcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 150, 50));

        ADLClose.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADLClose.setText("X");
        ADLClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ADLClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADLCloseMouseClicked(evt);
            }
        });
        jPanel1.add(ADLClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

        ADLMin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADLMin.setText("-");
        ADLMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADLMinMouseClicked(evt);
            }
        });
        jPanel1.add(ADLMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 40, -1));

        ADPatBack.setBackground(new java.awt.Color(255, 255, 255));
        ADPatBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPatBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        ADPatBack.setText("Back");
        ADPatBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ADPatBack.setBorderPainted(false);
        ADPatBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADPatBackActionPerformed(evt);
            }
        });
        jPanel1.add(ADPatBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/loginNewww.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        jLabel7.setBackground(new java.awt.Color(44, 62, 80));
        jLabel7.setForeground(new java.awt.Color(44, 62, 80));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

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

    private void ADLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADLoginActionPerformed
       String uname;
       String password;
        
       uname = ALunamebox.getText();
       password = ALpasswordBox.getText();
       
       if (uname.equals("CareAdmin") && password.equals("admin123")){
        AdminPanel AP = new AdminPanel();
        AP.setVisible(true);
        AP.pack();
        AP.setLocationRelativeTo(null);
        AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
       }else{
       JOptionPane.showMessageDialog(null,"Username or Password Incorrect !");
       }
    }//GEN-LAST:event_ADLoginActionPerformed

    private void ADLcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADLcancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ADLcancelActionPerformed

    private void ADLCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADLCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ADLCloseMouseClicked

    private void ADLMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADLMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_ADLMinMouseClicked

    private void ADPatBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPatBackActionPerformed
        LoginAs12 LA = new LoginAs12();
        LA.setVisible(true);
        LA.pack();
        LA.setLocationRelativeTo(null);
        LA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADPatBackActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADLClose;
    private javax.swing.JLabel ADLMin;
    private javax.swing.JButton ADLcancel;
    private javax.swing.JButton ADLogin;
    private javax.swing.JButton ADPatBack;
    private javax.swing.JPasswordField ALpasswordBox;
    private javax.swing.JTextField ALunamebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}