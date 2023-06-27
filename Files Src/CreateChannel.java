import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class CreateChannel extends javax.swing.JFrame {

    PreparedStatement pst = null;
    CreateStatement cs = null;
    ResultSet rs = null;
    
    public CreateChannel() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
        CDoctor();
        CPatient();
        CHBed();
        table();
    }

public class Doctor{
    String id;
    String name;
    
    public Doctor(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
public class Patient{
    String id;
    String name;
    
    public Patient(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
public class Bed{
    String id;
   
    
    public Bed(String id){
        this.id = id;
        
    }
    public String toString(){
        return id;
    }
}

public void CDoctor(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT * FROM admin_doctor";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
            CDoctor.addItem(new Doctor(rs.getString(1),rs.getString(2)));
        } 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null , e);
    }
}
public void CPatient(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT * FROM admin_patient";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
            CPatient.addItem(new Patient(rs.getString(1),rs.getString(2)));
        } 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null , e);
    }
}
public void CHBed(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT * FROM bed_details";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
            
            CRoom.addItem(new Bed(rs.getString(1)));
        } 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null , e);
    }
}
public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(cnum) FROM appoinment";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(cnum)");
        
        if(rs.getString("MAX(cnum)")==null){
        CNo.setText("CH0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(cnum)").substring(2,rs.getString("MAX(cnum)").length()));
            id++;
            CNo.setText("CH"+ String.format("%04d",id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT cnum,cdate,cdoc,cpatient,croom FROM appoinment";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)CTable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("cnum"));
               v.add(rs.getString("cdate"));
               v.add(rs.getString("cdoc"));
               v.add(rs.getString("cpatient"));
               v.add(rs.getString("croom"));
              
               
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
public void clear(){
        AutoId();
        Cdate.setText(null);
        CDoctor.setSelectedItem(null);
        CPatient.setSelectedItem(null);
        CRoom.setSelectedItem(null);
        
    }
       
public void tabledata(){
    DefaultTableModel d2 = (DefaultTableModel)CTable.getModel();
    int r = CTable.getSelectedRow();
    
    String cnum = d2.getValueAt(r,0).toString();
    String cdate = d2.getValueAt(r,1).toString();
    String cdoc = d2.getValueAt(r,2).toString();
    String cpatient = d2.getValueAt(r,3).toString();
    String croom = d2.getValueAt(r,4).toString();
    
    
    
        CNo.setText(cnum);
        Cdate.setText(cdate);
        CDoctor.setSelectedItem(cdoc);
        CPatient.setSelectedItem(cpatient);
        CRoom.setSelectedItem(croom);
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Cdate = new javax.swing.JTextField();
        CNo = new javax.swing.JTextField();
        CRoom = new javax.swing.JComboBox();
        CDoctor = new javax.swing.JComboBox();
        CPatient = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        CTable = new javax.swing.JTable();
        CCreate = new javax.swing.JButton();
        CBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Appionments");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 250, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 330, 60));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Appoinment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room No.         :-");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Channel No.     :-");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 150, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Channel Date   :-");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Doctor's Name :-");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient's Name :-");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 30));

        Cdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Cdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CdateActionPerformed(evt);
            }
        });
        jPanel3.add(Cdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 160, 30));

        CNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNoActionPerformed(evt);
            }
        });
        jPanel3.add(CNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 130, 30));

        CRoom.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        CRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRoomActionPerformed(evt);
            }
        });
        jPanel3.add(CRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 110, 30));

        CDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CDoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        CDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDoctorActionPerformed(evt);
            }
        });
        jPanel3.add(CDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 200, 30));

        CPatient.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CPatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        CPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPatientActionPerformed(evt);
            }
        });
        jPanel3.add(CPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 200, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 570, 450));

        CTable.setBackground(new java.awt.Color(204, 255, 255));
        CTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Channel No.", "Channel Date", "Doctor's Name", "Patient's Name", "Room No."
            }
        ));
        CTable.setShowGrid(true);
        CTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTableMouseClicked(evt);
            }
        });
        CTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 620, 450));

        CCreate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        CCreate.setText("Create");
        CCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCreateActionPerformed(evt);
            }
        });
        jPanel1.add(CCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 140, 50));

        CBack.setBackground(new java.awt.Color(255, 255, 255));
        CBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        CBack.setText("Back");
        CBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBack.setBorderPainted(false);
        CBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBackMouseClicked(evt);
            }
        });
        CBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBackActionPerformed(evt);
            }
        });
        jPanel1.add(CBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 50));

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

    private void CdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CdateActionPerformed

    private void CNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNoActionPerformed

    private void CRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CRoomActionPerformed

    private void CDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDoctorActionPerformed

    private void CPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPatientActionPerformed

    private void CCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCreateActionPerformed
        String cnum,cdate;

        cnum = CNo.getText();
        cdate = Cdate.getText();
        Doctor cdoc = (Doctor)CDoctor.getSelectedItem();
        Patient cpatient = (Patient)CPatient.getSelectedItem();
        Bed croom = (Bed)CRoom.getSelectedItem();
        
        

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO appoinment(cnum,cdate,cdoc,cpatient,croom) VALUES ('"+cnum+"','"+cdate+"','"+cdoc+"','"+cpatient+"','"+croom+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "APPOINMENT CREATE SUCCESSFULL !");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    
    }//GEN-LAST:event_CCreateActionPerformed

    private void CBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBackMouseClicked

    }//GEN-LAST:event_CBackMouseClicked

    private void CBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBackActionPerformed
        ReceptionistPanal RP1 = new ReceptionistPanal();
        RP1.setVisible(true);
        RP1.pack();
        RP1.setLocationRelativeTo(null);
        RP1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_CBackActionPerformed

    private void CTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTableMouseClicked
        //tabledata();
    }//GEN-LAST:event_CTableMouseClicked

    private void CTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTableKeyReleased
      //tabledata();
    }//GEN-LAST:event_CTableKeyReleased

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
            java.util.logging.Logger.getLogger(CreateChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateChannel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CBack;
    private javax.swing.JButton CCreate;
    private javax.swing.JComboBox CDoctor;
    private javax.swing.JTextField CNo;
    private javax.swing.JComboBox CPatient;
    private javax.swing.JComboBox CRoom;
    private javax.swing.JTable CTable;
    private javax.swing.JTextField Cdate;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
