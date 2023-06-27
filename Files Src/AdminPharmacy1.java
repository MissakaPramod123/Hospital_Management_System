import com.mysql.cj.jdbc.result.ResultSetMetaData;
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class AdminPharmacy1 extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public AdminPharmacy1() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
        table();
    }

    public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT hpid,hpfname,hplname,hpaddress,hpage,hpgender,hpmnum,hpvaccinedetails,hpvaccintype,hpuname,hppass FROM admin_pharmacy";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)ADPtable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("hpid"));
               v.add(rs.getString("hpfname"));
               v.add(rs.getString("hplname"));
               v.add(rs.getString("hpaddress"));
               v.add(rs.getString("hpage"));
               v.add(rs.getString("hpgender"));
               v.add(rs.getString("hpmnum"));
               v.add(rs.getString("hpuname"));
               v.add(rs.getString("hppass"));
               v.add(rs.getString("hpvaccinedetails"));
               v.add(rs.getString("hpvaccintype"));
               
               
               
               }
               df.addRow(v);
           
           }
          
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    public void tabledata(){
    int r = ADPtable.getSelectedRow();
    
    String id = ADPtable.getValueAt(r,0).toString();
    String fname = ADPtable.getValueAt(r,1).toString();
    String lname = ADPtable.getValueAt(r,2).toString();
    String address = ADPtable.getValueAt(r,3).toString();
    String age = ADPtable.getValueAt(r,4).toString();
    String mnum = ADPtable.getValueAt(r,6).toString();
    String vaccinedetail = ADPtable.getValueAt(r,9).toString();
    String vaccinetype = ADPtable.getValueAt(r,10).toString();
    String uname = ADPtable.getValueAt(r,7).toString();
    String pass = ADPtable.getValueAt(r,8).toString();
    String gender = ADPtable.getValueAt(r,5).toString();
    
    
        ADPid.setText(id);
        ADPfname.setText(fname);
        ADPlname.setText(lname);
        ADPaddress.setText(address);
        ADPuname.setText(uname);
        ADPpass.setText(pass);
        ADPvaccinetype.setSelectedItem(vaccinetype);
        if (vaccinedetail.toLowerCase().equals("yes")){
            ADPvaccineyes.setSelected(true);
        }else{
            ADPvaccineno.setSelected(true);
        }

        
        ADPgender.setSelectedItem(gender);
        ADPage.setText(age);
        ADPmnum.setText(mnum);
    
    
    }
    public void clear(){
        AutoId();
        ADPfname.setText(null);
        ADPlname.setText(null);
        ADPaddress.setText(null);
        ADPuname.setText(null);
        ADPpass.setText(null);
        ADPvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        
        ADPgender.setSelectedItem(null);
        ADPage.setText(null);
        ADPmnum.setText(null);
    }
    public void search(){
    String srch = ADPsearch.getText();
    
    try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "SELECT * FROM admin_pharmacy WHERE hpid LIKE '%"+srch+"%' OR hpfname LIKE '%"+srch+"%' OR hplname LIKE '%"+srch+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ADPtable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    }
     public void update(){
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum;
       
        id = ADPid.getText();
        fname = ADPfname.getText();
        lname = ADPlname.getText();
        address = ADPaddress.getText();
        uname = ADPuname.getText();
        pass = ADPpass.getText();
        vaccinetype = ADPvaccinetype.getSelectedItem().toString();
        if (ADPvaccineyes.isSelected()){
        detailvaccine = ADPvaccineyes.getText();
        }else{
        detailvaccine = ADPvaccineno.getText();
        }
        //System.out.println(detailvaccine);
        gender = ADPgender.getSelectedItem().toString();
        age = ADPage.getText();
        mnum = ADPmnum.getText();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE admin_pharmacy SET hpid ='"+id+"',hpfname ='"+fname+"',hplname ='"+lname+"',hpaddress ='"+address+"',hpage  ='"+age+"',hpgender  ='"+gender+"',hpmnum  ='"+mnum+"',hpvaccinedetails  ='"+detailvaccine+"',hpvaccintype  ='"+vaccinetype+"',hpuname  ='"+uname+"',hppass ='"+pass+"' WHERE hpid ='"+id+"'" ; 
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "UPDATED !");
         
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "UNUPDATED !");

        } 
   }
     public void delete(){      
   int check = JOptionPane.showConfirmDialog(null,"DO YOU WANT TO DELETE DATA ?");
   if (check == 0){
       String id = ADPid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `admin_pharmacy` WHERE hpid LIKE '%"+id+"%';";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "DELETED !");
           
       } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "Error while Deleting!");
       }
   
   } 
   }
     public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(hpid) FROM admin_pharmacy";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(hpid)");
        
        if(rs.getString("MAX(hpid)")==null){
        ADPid.setText("PH0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(hpid)").substring(2,rs.getString("MAX(hpid)").length()));
            id++;
            ADPid.setText("PH"+ String.format("%04d", id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ADPlname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ADPid = new javax.swing.JTextField();
        ADPaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ADPfname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ADPvaccinetype = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        ADPpass = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ADPage = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ADPuname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADPvaccineno = new javax.swing.JRadioButton();
        ADPvaccineyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        ADPgender = new javax.swing.JComboBox<>();
        ADPmnum = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ADPadd = new javax.swing.JButton();
        ADPdelete = new javax.swing.JButton();
        ADPupdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        ADPsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ADPatBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ADPtable = new javax.swing.JTable();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name        :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 140, 30));

        ADPlname.setBackground(new java.awt.Color(108, 122, 137));
        ADPlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 270, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pharmacist ID   :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 30));

        ADPid.setBackground(new java.awt.Color(108, 122, 137));
        ADPid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 270, 30));

        ADPaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADPaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 770, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("First Name        :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vaccine Type :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 140, 30));

        ADPfname.setBackground(new java.awt.Color(108, 122, 137));
        ADPfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 270, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password          :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 140, 30));

        ADPvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Phizer", "Moderna", "Astrazenica", "Sputnic V", "Sinopharm" }));
        jPanel3.add(ADPvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 140, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender       :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 30));

        ADPpass.setBackground(new java.awt.Color(108, 122, 137));
        ADPpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 210, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Age                    :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));

        ADPage.setBackground(new java.awt.Color(108, 122, 137));
        ADPage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("User Name        :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 30));

        ADPuname.setBackground(new java.awt.Color(108, 122, 137));
        ADPuname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPuname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 210, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address             :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        buttonGroup1.add(ADPvaccineno);
        ADPvaccineno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPvaccineno.setForeground(new java.awt.Color(255, 255, 255));
        ADPvaccineno.setText("No");
        jPanel3.add(ADPvaccineno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, 30));

        buttonGroup1.add(ADPvaccineyes);
        ADPvaccineyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPvaccineyes.setForeground(new java.awt.Color(255, 255, 255));
        ADPvaccineyes.setText("Yes");
        jPanel3.add(ADPvaccineyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 190, 30));

        ADPgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel3.add(ADPgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 140, 30));

        ADPmnum.setBackground(new java.awt.Color(108, 122, 137));
        ADPmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADPmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 190, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mobile Number :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 140, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 1000, 280));

        ADPadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADPadd.setText("Add ");
        ADPadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADPaddMouseClicked(evt);
            }
        });
        ADPadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADPaddActionPerformed(evt);
            }
        });
        jPanel1.add(ADPadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 50));

        ADPdelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADPdelete.setText("Delete ");
        ADPdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADPdeleteMouseClicked(evt);
            }
        });
        ADPdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADPdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(ADPdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 50));

        ADPupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADPupdate.setText("Update");
        ADPupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADPupdateActionPerformed(evt);
            }
        });
        jPanel1.add(ADPupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 130, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pharmacist Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 60));

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search :");

        ADPsearch.setBackground(new java.awt.Color(108, 122, 137));
        ADPsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADPsearch.setForeground(new java.awt.Color(255, 255, 255));
        ADPsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADPsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADPsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADPsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 330, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

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
        jPanel1.add(ADPatBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 50));

        ADPtable.setBackground(new java.awt.Color(204, 255, 255));
        ADPtable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADPtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Pharmacist ID", "First Name", "Last Name", "Address", "Age", "Gender", "Mobile Number", "User Name", "Password", "Get Vaccined", "Vaccine Type"
            }
        ));
        ADPtable.setShowGrid(true);
        ADPtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADPtableMouseClicked(evt);
            }
        });
        ADPtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADPtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ADPtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1190, 190));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/pharm 2.png"))); // NOI18N
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

    private void ADPaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADPaddMouseClicked

    }//GEN-LAST:event_ADPaddMouseClicked

    private void ADPaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPaddActionPerformed
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum;

        id = ADPid.getText();
        fname = ADPfname.getText();
        lname = ADPlname.getText();
        address = ADPaddress.getText();
        uname = ADPuname.getText();
        pass = ADPpass.getText();
        vaccinetype = ADPvaccinetype.getSelectedItem().toString();
        if (ADPvaccineyes.isSelected()){
            detailvaccine = ADPvaccineyes.getText();
        }else{
            detailvaccine = ADPvaccineno.getText();
        }
        System.out.println(detailvaccine);
        gender = ADPgender.getSelectedItem().toString();
        age = ADPage.getText();
        mnum = ADPmnum.getText();

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            if (fname.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER FIRST NAME !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (lname.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER LAST NAME !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (address.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER ADDRESS !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (age.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER AGE !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (mnum.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER MOBILE NUMBER !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO admin_pharmacy(hpid,hpfname,hplname,hpaddress,hpage,hpgender,hpmnum,hpvaccinedetails,hpvaccintype,hpuname,hppass) VALUES ('"+id+"','"+fname+"','"+lname+"','"+address+"','"+age+"','"+gender+"','"+mnum+"','"+detailvaccine+"','"+vaccinetype+"','"+uname+"','"+pass+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    }//GEN-LAST:event_ADPaddActionPerformed

    private void ADPdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADPdeleteMouseClicked

    }//GEN-LAST:event_ADPdeleteMouseClicked

    private void ADPdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPdeleteActionPerformed
        delete();
        table();
        clear();
    }//GEN-LAST:event_ADPdeleteActionPerformed

    private void ADPupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPupdateActionPerformed
        update();
        table();
        clear();
    }//GEN-LAST:event_ADPupdateActionPerformed

    private void ADPsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPsearchActionPerformed
        search();
    }//GEN-LAST:event_ADPsearchActionPerformed

    private void ADPatBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPatBackActionPerformed
        AdminPanel AP = new AdminPanel();
        AP.setVisible(true);
        AP.pack();
        AP.setLocationRelativeTo(null);
        AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADPatBackActionPerformed

    private void ADPtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADPtableMouseClicked
        tabledata();
    }//GEN-LAST:event_ADPtableMouseClicked

    private void ADPtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADPtableKeyReleased
        tabledata();
    }//GEN-LAST:event_ADPtableKeyReleased

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
            java.util.logging.Logger.getLogger(AdminPharmacy1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPharmacy1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPharmacy1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPharmacy1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPharmacy1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADPadd;
    private javax.swing.JTextField ADPaddress;
    private javax.swing.JTextField ADPage;
    private javax.swing.JButton ADPatBack;
    private javax.swing.JButton ADPdelete;
    private javax.swing.JTextField ADPfname;
    private javax.swing.JComboBox<String> ADPgender;
    private javax.swing.JTextField ADPid;
    private javax.swing.JTextField ADPlname;
    private javax.swing.JTextField ADPmnum;
    private javax.swing.JTextField ADPpass;
    private javax.swing.JTextField ADPsearch;
    private javax.swing.JTable ADPtable;
    private javax.swing.JTextField ADPuname;
    private javax.swing.JButton ADPupdate;
    private javax.swing.JRadioButton ADPvaccineno;
    private javax.swing.JComboBox<String> ADPvaccinetype;
    private javax.swing.JRadioButton ADPvaccineyes;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
