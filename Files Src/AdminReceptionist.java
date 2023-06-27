
//import com.sun.jdi.connect.spi.Connection;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import hospitalsystem.DBConnect;
import javax.swing.JFrame;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;






public class AdminReceptionist extends javax.swing.JFrame {

    //Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public AdminReceptionist() {
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
            String sql = "SELECT rid,rfname,rlname,raddress,rage,rgender,rmobilenum,rvaccinedetail,rvaccinetype,runame,rpass FROM admin_receptionist";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)ADRTable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("rid"));
               v.add(rs.getString("rfname"));
               v.add(rs.getString("rlname"));
               v.add(rs.getString("raddress"));
               v.add(rs.getString("rage"));
               v.add(rs.getString("rgender"));
               v.add(rs.getString("rmobilenum"));
               v.add(rs.getString("rvaccinedetail"));
               v.add(rs.getString("rvaccinetype"));
               v.add(rs.getString("runame"));
               v.add(rs.getString("rpass"));
               
               
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    public void tabledata(){
    int r = ADRTable.getSelectedRow();
    
    String id = ADRTable.getValueAt(r,0).toString();
    String fname = ADRTable.getValueAt(r,1).toString();
    String lname = ADRTable.getValueAt(r,2).toString();
    String address = ADRTable.getValueAt(r,3).toString();
    String age = ADRTable.getValueAt(r,4).toString();
    String mnum = ADRTable.getValueAt(r,6).toString();
    String vaccinedetail = ADRTable.getValueAt(r,7).toString();
    String vaccinetype = ADRTable.getValueAt(r,8).toString();
    String uname = ADRTable.getValueAt(r,9).toString();
    String pass = ADRTable.getValueAt(r,10).toString();
    String gender = ADRTable.getValueAt(r,5).toString();
    
    
        ADRid.setText(id);
        ADRfname.setText(fname);
        ADRlname.setText(lname);
        ADRaddress.setText(address);
        ADRuname.setText(uname);
        ADRpass.setText(pass);
        ADRvaccinetype.setSelectedItem(vaccinetype);
        if (vaccinedetail.toLowerCase().equals("yes")){
            ADRvaccineyes.setSelected(true);
        }else{
            ADRvaccineno.setSelected(true);
        }

        
        ADRgender.setSelectedItem(gender);
        ADRage.setText(age);
        ADRmobilenum.setText(mnum);
    
    
    }
    public void search(){
    String srch = ADRsearch.getText();
    
    try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "SELECT * FROM admin_receptionist WHERE rid LIKE '%"+srch+"%' OR rfname LIKE '%"+srch+"%' OR rlname LIKE '%"+srch+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ADRTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    }
   public void clear(){
        ADRid.setText(null);
        ADRfname.setText(null);
        ADRlname.setText(null);
        ADRaddress.setText(null);
        ADRuname.setText(null);
        ADRpass.setText(null);
        ADRvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        ADRgender.setSelectedItem(null);
        ADRage.setText(null);
        ADRmobilenum.setText(null);
    }
   public void update(){
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum;
       
        id = ADRid.getText();
        fname = ADRfname.getText();
        lname = ADRlname.getText();
        address = ADRaddress.getText();
        uname = ADRuname.getText();
        pass = ADRpass.getText();
        vaccinetype = ADRvaccinetype.getSelectedItem().toString();
        if (ADRvaccineyes.isSelected()){
        detailvaccine = ADRvaccineyes.getText();
        }else{
        detailvaccine = ADRvaccineno.getText();
        }
        //System.out.println(detailvaccine);
        gender = ADRgender.getSelectedItem().toString();
        age = ADRage.getText();
        mnum = ADRmobilenum.getText();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE admin_receptionist SET rid ='"+id+"',rfname ='"+fname+"',rlname ='"+lname+"',raddress ='"+address+"',rage  ='"+age+"',rgender  ='"+gender+"',rmobilenum  ='"+mnum+"',rvaccinedetail  ='"+detailvaccine+"',rvaccinetype  ='"+vaccinetype+"',runame  ='"+uname+"',rpass ='"+pass+"' WHERE rid ='"+id+"'" ; 
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
       String id = ADRid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `admin_receptionist` WHERE rid LIKE '%"+id+"%';";
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
        String sql = "SELECT MAX(rid) FROM admin_receptionist";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(rid)");
        
        if(rs.getString("MAX(rid)")==null){
        ADRid.setText("R0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(rid)").substring(2,rs.getString("MAX(rid)").length()));
            id++;
            ADRid.setText("R"+ String.format("%04d", id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ADadd = new javax.swing.JButton();
        ADdelete = new javax.swing.JButton();
        ADupdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ADRlname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ADRid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADRaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ADRfname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ADRvaccinetype = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        ADRpass = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ADRage = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ADRuname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADRvaccineno = new javax.swing.JRadioButton();
        ADRvaccineyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        ADRgender = new javax.swing.JComboBox<>();
        ADRmobilenum = new javax.swing.JTextField();
        ADRecpBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ADRTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        ADRsearch = new javax.swing.JTextField();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hospital Management System");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        ADadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADadd.setText("Add ");
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
        jPanel1.add(ADadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 50));

        ADdelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADdelete.setText("Delete ");
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
        jPanel1.add(ADdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 50));

        ADupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADupdate.setText("Update");
        ADupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADupdateActionPerformed(evt);
            }
        });
        jPanel1.add(ADupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 130, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Receptionist Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 60));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name        :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 140, 30));

        ADRlname.setBackground(new java.awt.Color(108, 122, 137));
        ADRlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 270, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Receptionist ID :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 30));

        ADRid.setBackground(new java.awt.Color(108, 122, 137));
        ADRid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 270, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile Number :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 140, 30));

        ADRaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADRaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 770, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("First Name        :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vaccine Type :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 140, 30));

        ADRfname.setBackground(new java.awt.Color(108, 122, 137));
        ADRfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 270, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password          :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 140, 30));

        ADRvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Phizer", "Moderna", "Astrazenica", "Sputnic V", "Sinopharm" }));
        ADRvaccinetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADRvaccinetypeActionPerformed(evt);
            }
        });
        jPanel3.add(ADRvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 140, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender       :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 30));

        ADRpass.setBackground(new java.awt.Color(108, 122, 137));
        ADRpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 210, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Age                    :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));

        ADRage.setBackground(new java.awt.Color(108, 122, 137));
        ADRage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("User Name        :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 30));

        ADRuname.setBackground(new java.awt.Color(108, 122, 137));
        ADRuname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRuname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 210, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address             :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        buttonGroup1.add(ADRvaccineno);
        ADRvaccineno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRvaccineno.setForeground(new java.awt.Color(255, 255, 255));
        ADRvaccineno.setText("No");
        ADRvaccineno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADRvaccinenoActionPerformed(evt);
            }
        });
        jPanel3.add(ADRvaccineno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, 30));

        buttonGroup1.add(ADRvaccineyes);
        ADRvaccineyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRvaccineyes.setForeground(new java.awt.Color(255, 255, 255));
        ADRvaccineyes.setText("Yes");
        ADRvaccineyes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADRvaccineyesActionPerformed(evt);
            }
        });
        jPanel3.add(ADRvaccineyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 190, 30));

        ADRgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel3.add(ADRgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 140, 30));

        ADRmobilenum.setBackground(new java.awt.Color(108, 122, 137));
        ADRmobilenum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRmobilenum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(ADRmobilenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 190, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 1000, 280));

        ADRecpBack.setBackground(new java.awt.Color(255, 255, 255));
        ADRecpBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRecpBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        ADRecpBack.setText("Back");
        ADRecpBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ADRecpBack.setBorderPainted(false);
        ADRecpBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADRecpBackActionPerformed(evt);
            }
        });
        jPanel1.add(ADRecpBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 50));

        ADRTable.setBackground(new java.awt.Color(204, 255, 255));
        ADRTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADRTable.setModel(new javax.swing.table.DefaultTableModel(
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
                "Receptionist ID", "First Name", "Last Name", "Address", "Age", "Gender", "Mobile Number", "User Name", "Password", "Get Vaccined", "Vaccine Type"
            }
        ));
        ADRTable.setShowGrid(true);
        ADRTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADRTableMouseClicked(evt);
            }
        });
        ADRTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADRTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ADRTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1190, 190));

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Search :");

        ADRsearch.setBackground(new java.awt.Color(108, 122, 137));
        ADRsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADRsearch.setForeground(new java.awt.Color(255, 255, 255));
        ADRsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADRsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADRsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADRsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 330, 40));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/AdminRecp.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADaddMouseClicked
        
    }//GEN-LAST:event_ADaddMouseClicked

    private void ADaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADaddActionPerformed
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum;
    
        id = ADRid.getText();
        fname = ADRfname.getText();
        lname = ADRlname.getText();
        address = ADRaddress.getText();
        uname = ADRuname.getText();
        pass = ADRpass.getText();
        vaccinetype = ADRvaccinetype.getSelectedItem().toString();
        if (ADRvaccineyes.isSelected()){
        detailvaccine = ADRvaccineyes.getText();
        }else{
        detailvaccine = ADRvaccineno.getText();
        }
        System.out.println(detailvaccine);
        gender = ADRgender.getSelectedItem().toString();
        age = ADRage.getText();
        mnum = ADRmobilenum.getText();
        
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

            String sql = "INSERT INTO admin_receptionist(rid,rfname,rlname,raddress,rage,rgender,rmobilenum,rvaccinedetail,rvaccinetype,runame,rpass) VALUES ('"+id+"','"+fname+"','"+lname+"','"+address+"','"+age+"','"+gender+"','"+mnum+"','"+detailvaccine+"','"+vaccinetype+"','"+uname+"','"+pass+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");
        
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    }//GEN-LAST:event_ADaddActionPerformed

    private void ADdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADdeleteMouseClicked
        

    }//GEN-LAST:event_ADdeleteMouseClicked

    private void ADdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADdeleteActionPerformed
        delete();
        table();
        clear();
    }//GEN-LAST:event_ADdeleteActionPerformed

    private void ADupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADupdateActionPerformed
        update();
        table();
        clear();

    }//GEN-LAST:event_ADupdateActionPerformed

    private void ADRecpBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADRecpBackActionPerformed
        AdminPanel AP = new AdminPanel();
        AP.setVisible(true);
        AP.pack();
        AP.setLocationRelativeTo(null);
        AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADRecpBackActionPerformed

    private void ADRvaccineyesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADRvaccineyesActionPerformed
       
    }//GEN-LAST:event_ADRvaccineyesActionPerformed

    private void ADRvaccinenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADRvaccinenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADRvaccinenoActionPerformed

    private void ADRTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADRTableMouseClicked
        tabledata();
    }//GEN-LAST:event_ADRTableMouseClicked

    private void ADRTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADRTableKeyReleased
        tabledata();
    }//GEN-LAST:event_ADRTableKeyReleased

    private void ADRsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADRsearchActionPerformed
        search();
    }//GEN-LAST:event_ADRsearchActionPerformed

    private void ADRvaccinetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADRvaccinetypeActionPerformed
        
    }//GEN-LAST:event_ADRvaccinetypeActionPerformed

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
            java.util.logging.Logger.getLogger(AdminReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminReceptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ADRTable;
    private javax.swing.JTextField ADRaddress;
    private javax.swing.JTextField ADRage;
    private javax.swing.JButton ADRecpBack;
    private javax.swing.JTextField ADRfname;
    private javax.swing.JComboBox<String> ADRgender;
    private javax.swing.JTextField ADRid;
    private javax.swing.JTextField ADRlname;
    private javax.swing.JTextField ADRmobilenum;
    private javax.swing.JTextField ADRpass;
    private javax.swing.JTextField ADRsearch;
    private javax.swing.JTextField ADRuname;
    private javax.swing.JRadioButton ADRvaccineno;
    private javax.swing.JComboBox<String> ADRvaccinetype;
    private javax.swing.JRadioButton ADRvaccineyes;
    private javax.swing.JButton ADadd;
    private javax.swing.JButton ADdelete;
    private javax.swing.JButton ADupdate;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
