
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class LodingScreen extends javax.swing.JFrame {

    
    public LodingScreen() {
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

        jLabel1 = new javax.swing.JLabel();
        LSbackgroundImage = new javax.swing.JLabel();
        LSbackground = new javax.swing.JPanel();
        LSProgressBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LSprograssBarWord = new javax.swing.JLabel();
        LSprogressBarNum = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/100-1005910_wallpaper-blue-yellow-gradient-linear-dark-blue-gold.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        LSbackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/emrecord.jpg"))); // NOI18N
        LSbackgroundImage.setText("jLabel1");
        LSbackgroundImage.setPreferredSize(new java.awt.Dimension(1958, 1080));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        LSbackground.setBackground(new java.awt.Color(102, 255, 255));
        LSbackground.setPreferredSize(new java.awt.Dimension(900, 500));
        LSbackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LSProgressBar.setForeground(new java.awt.Color(51, 51, 255));
        LSbackground.add(LSProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 490, 910, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Hospital ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Management");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("System");

        jLabel6.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel6.setText("CARE");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 102));
        jLabel7.setText("+");

        LSprograssBarWord.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LSprograssBarWord.setText("Loading........");

        LSprogressBarNum.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LSprogressBarNum.setText("0 %");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LSprograssBarWord)
                        .addGap(54, 54, 54)
                        .addComponent(LSprogressBarNum)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel6)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LSprograssBarWord)
                    .addComponent(LSprogressBarNum))
                .addGap(20, 20, 20))
        );

        LSbackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/emrecord.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(900, 500));
        jLabel2.setMinimumSize(new java.awt.Dimension(900, 500));
        LSbackground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LSbackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LSbackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LodingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LodingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LodingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LodingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       LodingScreen LS = new LodingScreen();
       LS.setVisible(true);
       
       try{
           int i;
           
           for(i=0;i<=100;i++){
               Thread.sleep(100);
               LS.LSprogressBarNum.setText(i + "%");
               if(i==10){
               LS.LSprograssBarWord.setText("Turning On Module....");
               }
               if(i==20){
               LS.LSprograssBarWord.setText("Loading Module....");
               }
               if(i==50){
               LS.LSprograssBarWord.setText("Connecting to Database....");
               }
               if(i==70){
               LS.LSprograssBarWord.setText("Connection Successful....");
               }
               if(i==80){
               LS.LSprograssBarWord.setText("Launching Application....");
               }
               LS.LSProgressBar.setValue(i);
           
           } 
               
       }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
       }
       LS.setVisible(false);
       LoginAs12 logas = new LoginAs12();
       
       logas.setVisible(true);
       LS.dispose();
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LSProgressBar;
    private javax.swing.JPanel LSbackground;
    private javax.swing.JLabel LSbackgroundImage;
    private javax.swing.JLabel LSprograssBarWord;
    private javax.swing.JLabel LSprogressBarNum;
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
