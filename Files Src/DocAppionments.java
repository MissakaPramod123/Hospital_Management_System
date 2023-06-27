
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;




public class DocAppionments extends javax.swing.JFrame {

    PreparedStatement pst = null;
    CreateStatement cs = null;
    ResultSet rs = null;
    
    
    String id;
    //String newid;
    
    public DocAppionments(String id) {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        
        this.id = id;
        //newid=id;
        table();
        
        
    }

public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT appoinment.cnum,admin_doctor.dfname,admin_patient.pfname,bed_details.bid,appoinment.cdate FROM admin_doctor INNER JOIN appoinment on appoinment.cdoc = admin_doctor.dfname INNER JOIN admin_patient on appoinment.cpatient = admin_patient.pfname INNER JOIN bed_details on appoinment.croom = bed_details.bid WHERE admin_doctor.did = ? ";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            
           ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)DAppoinmentTable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("cnum"));
               v.add(rs.getString("cdate"));
               v.add(rs.getString("dfname"));
               v.add(rs.getString("pfname"));
               v.add(rs.getString("bid"));
              
               
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DAppBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DAppoinmentTable = new javax.swing.JTable();
        DocPrescription = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Doctor Appoinments");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 350, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 390, 60));

        DAppBack.setBackground(new java.awt.Color(255, 255, 255));
        DAppBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DAppBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        DAppBack.setText("Back");
        DAppBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DAppBack.setBorderPainted(false);
        DAppBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DAppBackActionPerformed(evt);
            }
        });
        jPanel1.add(DAppBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 50));

        DAppoinmentTable.setBackground(new java.awt.Color(204, 255, 255));
        DAppoinmentTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DAppoinmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Channel No.", "Channel Date", "Date", "Patient's Name", "Room No."
            }
        ));
        DAppoinmentTable.setShowGrid(true);
        DAppoinmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DAppoinmentTableMouseClicked(evt);
            }
        });
        DAppoinmentTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DAppoinmentTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(DAppoinmentTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 1140, 450));

        DocPrescription.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DocPrescription.setText("Prescription");
        DocPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocPrescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(DocPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 630, 200, 50));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DAppBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DAppBackActionPerformed
        DoctorPanel DPP = new DoctorPanel(id);
        DPP.setVisible(true);
        DPP.pack();
        DPP.setLocationRelativeTo(null);
        DPP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_DAppBackActionPerformed

    private void DAppoinmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DAppoinmentTableMouseClicked
        
    }//GEN-LAST:event_DAppoinmentTableMouseClicked

    private void DAppoinmentTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DAppoinmentTableKeyReleased
       
    }//GEN-LAST:event_DAppoinmentTableKeyReleased

    private void DocPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocPrescriptionActionPerformed
        
        DefaultTableModel t1 = (DefaultTableModel)DAppoinmentTable.getModel();
        int selectedIndex = DAppoinmentTable.getSelectedRow();
        
        String chno = t1.getValueAt(selectedIndex, 0).toString();
        String docname = t1.getValueAt(selectedIndex, 1).toString();
        
        new DocPrescription(chno,docname,id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DocPrescriptionActionPerformed

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
            java.util.logging.Logger.getLogger(DocAppionments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocAppionments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocAppionments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocAppionments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocAppionments().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DAppBack;
    private javax.swing.JTable DAppoinmentTable;
    private javax.swing.JButton DocPrescription;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
