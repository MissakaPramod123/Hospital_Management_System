
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class ViewDoc1 extends javax.swing.JInternalFrame {

    java.sql.PreparedStatement pst = null;
    java.sql.ResultSet rs = null;
    Statement stat = null;
    
    public ViewDoc1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        table();
    }

    public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT did,dfname,dlname,daddress,dage,dgender,dmnum,dblood,dmaritial,djdate,dvdays,dvtime,dqualification,dvaccinedetail,dvaccinetype,duname,dpass FROM admin_doctor";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)ADDtable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("did"));
               v.add(rs.getString("dfname"));
               v.add(rs.getString("dlname"));
               v.add(rs.getString("daddress"));
               v.add(rs.getString("dage"));
               v.add(rs.getString("dgender"));
               v.add(rs.getString("dmnum"));
               v.add(rs.getString("dblood"));
               v.add(rs.getString("dmaritial"));
               v.add(rs.getString("dvaccinedetail"));
               v.add(rs.getString("dvaccinetype"));
               v.add(rs.getString("dvdays"));
               v.add(rs.getString("dvtime"));
               v.add(rs.getString("duname"));
               v.add(rs.getString("dpass"));
               
               v.add(rs.getString("djdate"));
               v.add(rs.getString("dqualification"));
              
               
               }
               df.addRow(v);
           
           }
            
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    public void tabledata(){
    int r = ADDtable.getSelectedRow();
    
    String id = ADDtable.getValueAt(r,0).toString();
    String fname = ADDtable.getValueAt(r,1).toString();
    String lname = ADDtable.getValueAt(r,2).toString();
    String address = ADDtable.getValueAt(r,3).toString();
    String age = ADDtable.getValueAt(r,4).toString();
    String gender = ADDtable.getValueAt(r,5).toString();
    String mnum = ADDtable.getValueAt(r,6).toString();
    String blood = ADDtable.getValueAt(r,7).toString();
    String vaccinedetail = ADDtable.getValueAt(r,7).toString();
    String vaccinetype = ADDtable.getValueAt(r,8).toString();
    String uname = ADDtable.getValueAt(r,9).toString();
    String pass = ADDtable.getValueAt(r,10).toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ADDtable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(42, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADDtable.setAutoCreateRowSorter(true);
        ADDtable.setBackground(new java.awt.Color(153, 204, 255));
        ADDtable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ADDtable.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ADDtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "D-ID", "First Name", "Last Name", "Address", "Age", "Gender", "Mobile Number", "Blood Group", "Maritial Status", "Covid Vaccine", "Vaccine Type", "Visiting Date", "Visiting Time", "User Name", "Password", "Joining Date", "Qualification"
            }
        ));
        ADDtable.setShowGrid(true);
        ADDtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDtableMouseClicked(evt);
            }
        });
        ADDtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADDtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ADDtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 940, 430));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Doctor Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 240, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

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

    private void ADDtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDtableMouseClicked
        tabledata();
    }//GEN-LAST:event_ADDtableMouseClicked

    private void ADDtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDtableKeyReleased
        tabledata();
    }//GEN-LAST:event_ADDtableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable ADDtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
