import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DocPrescription extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /*public DocPrescription() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
    }*/
    
   String id;
   String Docname;
   String Docid;
   String newdocname;
   
    public DocPrescription(String chno, String Dname,String Docid) {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
        
        this.id = chno;
        this.Docname = Dname;
        
        this.Docid = Docid;
        newdocname = Docname;
        
        Dpreschno.setText(id);
        Dpreschno.setEditable(false);
        
    }

    public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(prsid) FROM prescription";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(prsid)");
        
        if(rs.getString("MAX(prsid)")==null){
        Dpresnum.setText("PR0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(prsid)").substring(2,rs.getString("MAX(prsid)").length()));
            id++;
            Dpresnum.setText("PR"+ String.format("%04d",id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }
    }
    public void clear(){
        AutoId();
        Dpreschno.setText(null);
        Dpresdesease.setText(null);
        Dpresdescription.setText(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Dpresnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Dpreschno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dpresdescription = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Dpresdesease = new javax.swing.JTextArea();
        Docpres = new javax.swing.JButton();
        ADPatBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Prescription");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 250, 60));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Prescription No.   :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 30));

        Dpresnum.setBackground(new java.awt.Color(108, 122, 137));
        Dpresnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Dpresnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Dpresnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 270, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Channel No.         :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 30));

        Dpreschno.setBackground(new java.awt.Color(108, 122, 137));
        Dpreschno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Dpreschno.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Dpreschno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 270, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desease Type       :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 160, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description          :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 170, 30));

        Dpresdescription.setBackground(new java.awt.Color(108, 122, 137));
        Dpresdescription.setColumns(20);
        Dpresdescription.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Dpresdescription.setForeground(new java.awt.Color(255, 255, 255));
        Dpresdescription.setRows(5);
        jScrollPane1.setViewportView(Dpresdescription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 580, 110));

        Dpresdesease.setBackground(new java.awt.Color(108, 122, 137));
        Dpresdesease.setColumns(20);
        Dpresdesease.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Dpresdesease.setForeground(new java.awt.Color(255, 255, 255));
        Dpresdesease.setRows(5);
        jScrollPane2.setViewportView(Dpresdesease);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 580, 110));

        Docpres.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Docpres.setText("Create");
        Docpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocpresActionPerformed(evt);
            }
        });
        jPanel1.add(Docpres, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 130, 40));

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
        jPanel1.add(ADPatBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 50));

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
        jPanel1.add(UpdateDocClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 25));

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
        jPanel1.add(UpdateDocClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 50, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DocpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocpresActionPerformed
        String prsid,chnlno,description,detype;

        prsid = Dpresnum.getText();
        chnlno = Dpreschno.getText();
        description = Dpresdescription.getText();
        detype = Dpresdesease.getText();
        
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            if (description.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER DESCRIPTION !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (detype.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER DESEASE TYPE !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            

            String sql = "INSERT INTO prescription(prsid,chnlid,description,detype,docname) VALUES ('"+prsid+"','"+chnlno+"','"+description+"','"+detype+"','"+newdocname+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "PRESCRIPTION INSERT SUCCESSFULL !");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        clear();
    }//GEN-LAST:event_DocpresActionPerformed

    private void ADPatBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPatBackActionPerformed
        DocAppionments DA = new DocAppionments(Docid);
        DA.setVisible(true);
        DA.pack();
        DA.setLocationRelativeTo(null);
        DA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADPatBackActionPerformed

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
            java.util.logging.Logger.getLogger(DocPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocPrescription().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADPatBack;
    private javax.swing.JButton Docpres;
    private javax.swing.JTextField Dpreschno;
    private javax.swing.JTextArea Dpresdescription;
    private javax.swing.JTextArea Dpresdesease;
    private javax.swing.JTextField Dpresnum;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
