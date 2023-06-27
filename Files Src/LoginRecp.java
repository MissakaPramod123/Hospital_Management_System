
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class LoginRecp extends javax.swing.JFrame {

    PreparedStatement pst = null;
    CreateStatement cs = null;
    ResultSet rs = null;
    
    public LoginRecp() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
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
        RELogin = new javax.swing.JButton();
        RELcancel = new javax.swing.JButton();
        RLpasswordBox = new javax.swing.JPasswordField();
        RLunamebox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RLMin = new javax.swing.JLabel();
        RLClose = new javax.swing.JLabel();
        ADPatBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RELogin.setBackground(new java.awt.Color(34, 167, 240));
        RELogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RELogin.setForeground(new java.awt.Color(255, 255, 255));
        RELogin.setText("LOGIN");
        RELogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RELoginActionPerformed(evt);
            }
        });
        jPanel1.add(RELogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 430, -1, 50));

        RELcancel.setBackground(new java.awt.Color(242, 38, 19));
        RELcancel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RELcancel.setForeground(new java.awt.Color(255, 255, 255));
        RELcancel.setText("CANCEL");
        RELcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RELcancelActionPerformed(evt);
            }
        });
        jPanel1.add(RELcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 150, 50));

        RLpasswordBox.setBackground(new java.awt.Color(108, 122, 137));
        RLpasswordBox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RLpasswordBox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(RLpasswordBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 260, 40));

        RLunamebox.setBackground(new java.awt.Color(108, 122, 137));
        RLunamebox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RLunamebox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(RLunamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 260, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("User Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, 23));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Password   :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Receptionist Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 60));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hospital Management System");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        RLMin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RLMin.setText("-");
        RLMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RLMinMouseClicked(evt);
            }
        });
        jPanel1.add(RLMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        RLClose.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RLClose.setText("X");
        RLClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RLClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RLCloseMouseClicked(evt);
            }
        });
        jPanel1.add(RLClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(978, -3, 20, 30));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginNewww.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

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

    private void RELoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RELoginActionPerformed
        /*ReceptionistPanal RP = new ReceptionistPanal();
        RP.setVisible(true);
        RP.pack();
        RP.setLocationRelativeTo(null);
        RP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();*/
        String username = RLunamebox.getText();
        String password = RLpasswordBox.getText();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT * FROM admin_receptionist WHERE runame= ? and rpass= ?";
            pst = con.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            
            rs = pst.executeQuery();
            if (rs.next()){
                String userid = rs.getString("rid");
                this.setVisible(false);
                new ReceptionistPanal(userid,username,password).setVisible(true);
            }else{
             JOptionPane.showMessageDialog(this, "User Name or Password is Incorrect");
             RLunamebox.setText("");
             RLpasswordBox.setText("");
            
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , e);
        }
    }//GEN-LAST:event_RELoginActionPerformed

    private void RELcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RELcancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_RELcancelActionPerformed

    private void RLMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RLMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_RLMinMouseClicked

    private void RLCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RLCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_RLCloseMouseClicked

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
            java.util.logging.Logger.getLogger(LoginRecp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRecp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRecp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRecp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRecp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADPatBack;
    private javax.swing.JButton RELcancel;
    private javax.swing.JButton RELogin;
    private javax.swing.JLabel RLClose;
    private javax.swing.JLabel RLMin;
    private javax.swing.JPasswordField RLpasswordBox;
    private javax.swing.JTextField RLunamebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
