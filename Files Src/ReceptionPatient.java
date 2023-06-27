
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


public class ReceptionPatient extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ReceptionPatient() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        RBed();
        AutoId();
        table();
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

    public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT pid,pfname,plname,paddress,page,pgender,pmobilenumber,pvaccinedetail,pvaccinetype,admitdate,proom FROM admin_patient";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)RPtable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("pid"));
               v.add(rs.getString("pfname"));
               v.add(rs.getString("plname"));
               v.add(rs.getString("paddress"));
               v.add(rs.getString("page"));
               v.add(rs.getString("pgender"));
               v.add(rs.getString("pmobilenumber"));
               v.add(rs.getString("pvaccinedetail"));
               v.add(rs.getString("pvaccinetype"));
               
               
               v.add(rs.getString("admitdate"));
               v.add(rs.getString("proom"));
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    public void tabledata(){
    int r = RPtable.getSelectedRow();
    
    String id = RPtable.getValueAt(r,0).toString();
    String fname = RPtable.getValueAt(r,1).toString();
    String lname = RPtable.getValueAt(r,2).toString();
    String address = RPtable.getValueAt(r,3).toString();
    String age = RPtable.getValueAt(r,4).toString();
    String mnum = RPtable.getValueAt(r,6).toString();
    String vaccinedetail = RPtable.getValueAt(r,7).toString();
    String vaccinetype = RPtable.getValueAt(r,8).toString();
    
    String gender = RPtable.getValueAt(r,5).toString();
    String admitdate = RPtable.getValueAt(r,9).toString();
    String roomnum = RPtable.getValueAt(r,10).toString();
    
    
        RPid.setText(id);
        RPfname.setText(fname);
        RPlname.setText(lname);
        RPaddress.setText(address);
        
        RPvaccinetype.setSelectedItem(vaccinetype);
        if (vaccinedetail.toLowerCase().equals("yes")){
            RPvaccineyes.setSelected(true);
        }else{
            RPvaccineno.setSelected(true);
        }

        
        RPgender.setSelectedItem(gender);
        RPage.setText(age);
        RPmnum.setText(mnum);
        RPadmitdate.setText(admitdate);
        RecRoom.setSelectedItem(roomnum);
    
    
    }
    public void clear(){
        RPid.setText(null);
        RPfname.setText(null);
        RPlname.setText(null);
        RPaddress.setText(null);
        
        RPvaccinetype.setSelectedItem(null);
        if (RPvaccineyes.isSelected()){
        RPvaccineyes.setSelected(false);
        }else{
        RPvaccineno.setSelected(false);
        }
        
        RPgender.setSelectedItem(null);
        RPage.setText(null);
        RPmnum.setText(null);
        RPadmitdate.setText(null);
        RecRoom.setSelectedItem(null);
    }
    public void search(){
    String srch = RPsearch.getText();    
    
    try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "SELECT * FROM admin_patient WHERE pid LIKE '%"+srch+"%' OR pfname LIKE '%"+srch+"%' OR plname LIKE '%"+srch+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            RPtable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    }
     public void update(){
        String id,fname,lname,address,gender,detailvaccine,vaccinetype,age,mnum,admitdate,roomnum;
       
        id = RPid.getText();
        fname = RPfname.getText();
        lname = RPlname.getText();
        address = RPaddress.getText();
       
        vaccinetype = RPvaccinetype.getSelectedItem().toString();
        if (RPvaccineyes.isSelected()){
        detailvaccine = RPvaccineyes.getText();
        }else{
        detailvaccine = RPvaccineno.getText();
        }
        //System.out.println(detailvaccine);
        gender = RPgender.getSelectedItem().toString();
        age = RPage.getText();
        mnum = RPmnum.getText();
        admitdate = RPadmitdate.getText();
        roomnum = RecRoom.getSelectedItem().toString();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE admin_patient SET pid ='"+id+"',pfname ='"+fname+"',plname ='"+lname+"',paddress ='"+address+"',page  ='"+age+"',pgender  ='"+gender+"',pmobilenumber  ='"+mnum+"',pvaccinedetail  ='"+detailvaccine+"',pvaccinetype  ='"+vaccinetype+"',admitdate ='"+admitdate+"',proom ='"+roomnum+"' WHERE pid ='"+id+"'" ; 
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
       String id = RPid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `admin_patient` WHERE pid LIKE '%"+id+"%';";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "DELETED !");
           
       } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "Error while Deleting!");
       }
   
   } 
   }

public void RBed(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT * FROM bed_details";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
            
            RecRoom.addItem(new ReceptionPatient.Bed(rs.getString(1)));
        } 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null , e);
    }
}
public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(pid) FROM admin_patient";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(pid)");
        
        if(rs.getString("MAX(pid)")==null){
        RPid.setText("P0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(pid)").substring(2,rs.getString("MAX(pid)").length()));
            id++;
            RPid.setText("P"+ String.format("%04d", id));
        
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        RPadd = new javax.swing.JButton();
        RPdelete = new javax.swing.JButton();
        RPupdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RPtable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RPlname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        RPid = new javax.swing.JTextField();
        RPaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RPfname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        RPvaccinetype = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        RPage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        RPvaccineno = new javax.swing.JRadioButton();
        RPvaccineyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        RPgender = new javax.swing.JComboBox<>();
        RPmnum = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        RPadmitdate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        RecRoom = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        RPsearch = new javax.swing.JTextField();
        RPBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Patient Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 270, 60));

        RPadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RPadd.setText("Add ");
        RPadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RPaddMouseClicked(evt);
            }
        });
        RPadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPaddActionPerformed(evt);
            }
        });
        jPanel1.add(RPadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 50));

        RPdelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RPdelete.setText("Delete ");
        RPdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RPdeleteMouseClicked(evt);
            }
        });
        RPdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(RPdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 50));

        RPupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        RPupdate.setText("Update");
        RPupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPupdateActionPerformed(evt);
            }
        });
        jPanel1.add(RPupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 130, 50));

        RPtable.setBackground(new java.awt.Color(204, 255, 255));
        RPtable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RPtable.setModel(new javax.swing.table.DefaultTableModel(
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
                "Patient ID", "First Name", "Last Name", "Address", "Age", "Gender", "Mobile Number", "Get Vaccined", "Vaccine Type", "Admit Date", "Room No."
            }
        ));
        RPtable.setShowGrid(true);
        RPtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RPtableMouseClicked(evt);
            }
        });
        RPtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RPtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(RPtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1190, 190));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name        :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 140, 30));

        RPlname.setBackground(new java.awt.Color(108, 122, 137));
        RPlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 270, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient ID         :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 30));

        RPid.setBackground(new java.awt.Color(108, 122, 137));
        RPid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 270, 30));

        RPaddress.setBackground(new java.awt.Color(108, 122, 137));
        RPaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 770, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("First Name        :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vaccine Type :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 140, 30));

        RPfname.setBackground(new java.awt.Color(108, 122, 137));
        RPfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 270, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Room No.         :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, 30));

        RPvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Phizer", "Moderna", "Astrazenica", "Sputnic V", "Sinopharm" }));
        jPanel3.add(RPvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 140, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender       :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 110, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Age                    :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 140, 30));

        RPage.setBackground(new java.awt.Color(108, 122, 137));
        RPage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 140, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address             :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, 30));

        buttonGroup1.add(RPvaccineno);
        RPvaccineno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPvaccineno.setForeground(new java.awt.Color(255, 255, 255));
        RPvaccineno.setText("No");
        jPanel3.add(RPvaccineno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, -1, 30));

        buttonGroup1.add(RPvaccineyes);
        RPvaccineyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPvaccineyes.setForeground(new java.awt.Color(255, 255, 255));
        RPvaccineyes.setText("Yes");
        jPanel3.add(RPvaccineyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 190, 30));

        RPgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel3.add(RPgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 140, 30));

        RPmnum.setBackground(new java.awt.Color(108, 122, 137));
        RPmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 190, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mobile Number :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 140, 30));

        RPadmitdate.setBackground(new java.awt.Color(108, 122, 137));
        RPadmitdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPadmitdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(RPadmitdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 210, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Admit Date       :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 30));

        RecRoom.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RecRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jPanel3.add(RecRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 140, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 1000, 280));

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search :");

        RPsearch.setBackground(new java.awt.Color(108, 122, 137));
        RPsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPsearch.setForeground(new java.awt.Color(255, 255, 255));
        RPsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPsearchActionPerformed(evt);
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
                .addComponent(RPsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RPsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 330, 40));

        RPBack.setBackground(new java.awt.Color(255, 255, 255));
        RPBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RPBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        RPBack.setText("Back");
        RPBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RPBack.setBorderPainted(false);
        RPBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RPBackMouseClicked(evt);
            }
        });
        RPBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPBackActionPerformed(evt);
            }
        });
        jPanel1.add(RPBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 50));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/AdminPateint.png"))); // NOI18N
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
/**/
    private void RPaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RPaddMouseClicked

    }//GEN-LAST:event_RPaddMouseClicked

    private void RPaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPaddActionPerformed
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum,admitdate,roomnum;

        id = RPid.getText();
        fname = RPfname.getText();
        lname = RPlname.getText();
        address = RPaddress.getText();
        
        vaccinetype = RPvaccinetype.getSelectedItem().toString();
        if (RPvaccineyes.isSelected()){
            detailvaccine = RPvaccineyes.getText();
        }else{
            detailvaccine = RPvaccineno.getText();
        }
        System.out.println(detailvaccine);
        gender = RPgender.getSelectedItem().toString();
        age = RPage.getText();
        mnum = RPmnum.getText();
        admitdate = RPadmitdate.getText();
        roomnum = RecRoom.getSelectedItem().toString();

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
            }if (admitdate.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER ADMIT DATE!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO admin_patient(pid,pfname,plname,paddress,page,pgender,pmobilenumber,pvaccinedetail,pvaccinetype,admitdate,proom) VALUES ('"+id+"','"+fname+"','"+lname+"','"+address+"','"+age+"','"+gender+"','"+mnum+"','"+detailvaccine+"','"+vaccinetype+"','"+admitdate+"','"+roomnum+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    }//GEN-LAST:event_RPaddActionPerformed

    private void RPdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RPdeleteMouseClicked

    }//GEN-LAST:event_RPdeleteMouseClicked

    private void RPdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPdeleteActionPerformed
        delete();
        table();
        clear();
    }//GEN-LAST:event_RPdeleteActionPerformed

    private void RPupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPupdateActionPerformed
        update();
        table();
        clear();
    }//GEN-LAST:event_RPupdateActionPerformed

    private void RPtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RPtableMouseClicked
        tabledata();
    }//GEN-LAST:event_RPtableMouseClicked

    private void RPtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPtableKeyReleased
        tabledata();
    }//GEN-LAST:event_RPtableKeyReleased

    private void RPsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPsearchActionPerformed
        search();
    }//GEN-LAST:event_RPsearchActionPerformed

    private void RPBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPBackActionPerformed
        ReceptionistPanal RP1 = new ReceptionistPanal();
        RP1.setVisible(true);
        RP1.pack();
        RP1.setLocationRelativeTo(null);
        RP1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RPBackActionPerformed

    private void RPBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RPBackMouseClicked
       
    }//GEN-LAST:event_RPBackMouseClicked

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
            java.util.logging.Logger.getLogger(ReceptionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RPBack;
    private javax.swing.JButton RPadd;
    private javax.swing.JTextField RPaddress;
    private javax.swing.JTextField RPadmitdate;
    private javax.swing.JTextField RPage;
    private javax.swing.JButton RPdelete;
    private javax.swing.JTextField RPfname;
    private javax.swing.JComboBox<String> RPgender;
    private javax.swing.JTextField RPid;
    private javax.swing.JTextField RPlname;
    private javax.swing.JTextField RPmnum;
    private javax.swing.JTextField RPsearch;
    private javax.swing.JTable RPtable;
    private javax.swing.JButton RPupdate;
    private javax.swing.JRadioButton RPvaccineno;
    private javax.swing.JComboBox<String> RPvaccinetype;
    private javax.swing.JRadioButton RPvaccineyes;
    private javax.swing.JComboBox RecRoom;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
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
