
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonModel;


public class UpdateDoc1 extends javax.swing.JInternalFrame {

    java.sql.PreparedStatement pst = null;
    CreateStatement cst = null;
    ResultSet rs = null;
    Statement stat = null;
    
    public UpdateDoc1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
    }

    public void update(){
            
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum,blood,jdate,vdate,vtime,qualification,maritial;
       
        id = ADDUid.getText();
        fname = ADDUfname.getText();
        lname = ADDUlname.getText();
        address = ADDUaddress.getText();
        uname = ADDUuname.getText();
        pass = ADDUpass.getText();
        vaccinetype = ADDUvaccinetype.getSelectedItem().toString();
        if (ADDUvaccinedetailyes.isSelected()){
        detailvaccine = ADDUvaccinedetailyes.getText();
        }else{
        detailvaccine = ADDUvaccinedetailno.getText();
        }
        System.out.println(detailvaccine);
        gender = ADDUgender.getSelectedItem().toString();
        age = ADDUage.getText();
        mnum = ADDUmnum.getText();
        blood = ADDUblood.getSelectedItem().toString();
        jdate= ADDUjdate.getText();
        vdate = ADDUvdays.getText();
        vtime = ADDUvtime.getText();
        qualification = ADDUqualification.getText();
        maritial = ADDUmaritial.getSelectedItem().toString();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE admin_doctor SET did ='"+id+"',dfname ='"+fname+"',dlname ='"+lname+"',daddress ='"+address+"',dage  ='"+age+"',dgender  ='"+gender+"',dmnum  ='"+mnum+"',dvaccinedetail  ='"+detailvaccine+"',dvaccinetype  ='"+vaccinetype+"',duname  ='"+uname+"',dpass ='"+pass+"',dblood  ='"+blood+"',djdate  ='"+jdate+"',dvdays  ='"+vdate+"',dvtime  ='"+vtime+"',dqualification  ='"+qualification+"',dmaritial  ='"+maritial+"' WHERE did ='"+id+"'" ; 
            pst = con.prepareStatement(sql);
            pst.executeUpdate(sql);
            JOptionPane.showMessageDialog(null , "UPDATED !");
         
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "UNUPDATED !");

        }
   
   
   
   }
    public void search(){
    String srch = ADDUsearch1.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            
            String sql = "SELECT * FROM admin_doctor WHERE did=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1,ADDUsearch1.getText());
            rs=pst.executeQuery();
           
            if(rs.next()){
        ADDUid.setText(rs.getString("did"));
        ADDUfname.setText(rs.getString("dfname"));
        ADDUlname.setText(rs.getString("dlname"));
        ADDUaddress.setText(rs.getString("daddress"));
        ADDUuname.setText(rs.getString("duname"));
        ADDUpass.setText(rs.getString("dpass"));
        ADDUvaccinetype.setSelectedItem(rs.getString("dvaccinetype"));
        if (rs.getString("dvaccinedetail").equals("Yes")){
        ADDUvaccinedetailyes.setSelected(true);
        }else{
        ADDUvaccinedetailno.setSelected(true);
        }
        
        
        ADDUgender.setSelectedItem(rs.getString("dgender"));
        ADDUage.setText(rs.getString("dage"));
        ADDUmnum.setText(rs.getString("dmnum"));
        ADDUblood.setSelectedItem(rs.getString("dblood"));
        ADDUjdate.setText(rs.getString("djdate"));
        ADDUvdays.setText(rs.getString("dvdays"));
        ADDUvtime.setText(rs.getString("dvtime"));
        ADDUqualification.setText(rs.getString("dqualification"));
        ADDUmaritial.setSelectedItem(rs.getString("dmaritial"));
            
            }else{
                JOptionPane.showMessageDialog(null , "SORRY RECORD NOT FOUND !");
            }
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    
    }
    public void clear(){
        ADDUid.setText(null);
        ADDUfname.setText(null);
        ADDUlname.setText(null);
        ADDUaddress.setText(null);
        ADDUuname.setText(null);
        ADDUpass.setText(null);
        ADDUvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        
        ADDUgender.setSelectedItem(null);
        ADDUage.setText(null);
        ADDUmnum.setText(null);
        ADDUblood.setSelectedItem(null);
        ADDUjdate.setText(null);
        ADDUvdays.setText(null);
        ADDUvtime.setText(null);
        ADDUqualification.setText(null);
        ADDUmaritial.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ADDUid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ADDUfname = new javax.swing.JTextField();
        ADDUlname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ADDUaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ADDUsearch1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADDUblood = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ADDUvdays = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ADDUvaccinetype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ADDUgender = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ADDUage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ADDUjdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ADDUvtime = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADDUvaccinedetailno = new javax.swing.JRadioButton();
        ADDUvaccinedetailyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        ADDUmaritial = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        ADDupdate = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        ADDUuname = new javax.swing.JTextField();
        ADDUpass = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ADDUqualification = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        ADDUmnum = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(42, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Update Doctor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 240, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        ADDUid.setBackground(new java.awt.Color(108, 122, 137));
        ADDUid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 100, 30));

        ADDUfname.setBackground(new java.awt.Color(108, 122, 137));
        ADDUfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 290, -1));

        ADDUlname.setBackground(new java.awt.Color(108, 122, 137));
        ADDUlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 290, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 30));

        ADDUaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADDUaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 790, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vaccine Type:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 30));

        ADDUsearch1.setBackground(new java.awt.Color(108, 122, 137));
        ADDUsearch1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUsearch1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUsearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 180, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile Number :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 30));

        ADDUblood.setBackground(new java.awt.Color(108, 122, 137));
        ADDUblood.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", " " }));
        ADDUblood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUbloodActionPerformed(evt);
            }
        });
        jPanel1.add(ADDUblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 30));

        ADDUvdays.setBackground(new java.awt.Color(108, 122, 137));
        ADDUvdays.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUvdays.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUvdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Age :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        ADDUvaccinetype.setBackground(new java.awt.Color(108, 122, 137));
        ADDUvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Fizer", "Moderna", "Sinopharm", "Astrazenica", " " }));
        ADDUvaccinetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUvaccinetypeActionPerformed(evt);
            }
        });
        jPanel1.add(ADDUvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 180, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Blood Group :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        ADDUgender.setBackground(new java.awt.Color(108, 122, 137));
        ADDUgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        ADDUgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUgenderActionPerformed(evt);
            }
        });
        jPanel1.add(ADDUgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 130, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Search ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 80, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Maritial Status :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 140, 30));

        ADDUage.setBackground(new java.awt.Color(108, 122, 137));
        ADDUage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 180, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Joining Date:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        ADDUjdate.setBackground(new java.awt.Color(108, 122, 137));
        ADDUjdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUjdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUjdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Visiting Time:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        ADDUvtime.setBackground(new java.awt.Color(108, 122, 137));
        ADDUvtime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUvtime.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUvtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 180, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Qualifications:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        buttonGroup1.add(ADDUvaccinedetailno);
        ADDUvaccinedetailno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUvaccinedetailno.setForeground(new java.awt.Color(255, 255, 255));
        ADDUvaccinedetailno.setText("No");
        jPanel1.add(ADDUvaccinedetailno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        buttonGroup1.add(ADDUvaccinedetailyes);
        ADDUvaccinedetailyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUvaccinedetailyes.setForeground(new java.awt.Color(255, 255, 255));
        ADDUvaccinedetailyes.setText("Yes");
        jPanel1.add(ADDUvaccinedetailyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 200, 30));

        ADDUmaritial.setBackground(new java.awt.Color(108, 122, 137));
        ADDUmaritial.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUmaritial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single", "Married" }));
        ADDUmaritial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUmaritialActionPerformed(evt);
            }
        });
        jPanel1.add(ADDUmaritial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Visiting Days:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        ADDupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADDupdate.setText("Update Doctor");
        ADDupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDupdateActionPerformed(evt);
            }
        });
        jPanel1.add(ADDupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 190, 40));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("User Name :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 120, 30));

        ADDUuname.setBackground(new java.awt.Color(108, 122, 137));
        ADDUuname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUuname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 180, -1));

        ADDUpass.setBackground(new java.awt.Color(108, 122, 137));
        ADDUpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 180, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Password :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 130, 30));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ADDUqualification.setBackground(new java.awt.Color(108, 122, 137));
        ADDUqualification.setColumns(20);
        ADDUqualification.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUqualification.setForeground(new java.awt.Color(255, 255, 255));
        ADDUqualification.setRows(5);
        jScrollPane3.setViewportView(ADDUqualification);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, 110));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search ID :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 100, 30));

        ADDUmnum.setBackground(new java.awt.Color(108, 122, 137));
        ADDUmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDUmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDUmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 180, -1));

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

    private void ADDUbloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUbloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDUbloodActionPerformed

    private void ADDUvaccinetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUvaccinetypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDUvaccinetypeActionPerformed

    private void ADDUgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDUgenderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       search();
       ADDUsearch1.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ADDUmaritialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUmaritialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDUmaritialActionPerformed

    private void ADDupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDupdateActionPerformed
        update();
        clear();
    }//GEN-LAST:event_ADDupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADDUaddress;
    private javax.swing.JTextField ADDUage;
    private javax.swing.JComboBox<String> ADDUblood;
    private javax.swing.JTextField ADDUfname;
    private javax.swing.JComboBox<String> ADDUgender;
    private javax.swing.JTextField ADDUid;
    private javax.swing.JTextField ADDUjdate;
    private javax.swing.JTextField ADDUlname;
    private javax.swing.JComboBox<String> ADDUmaritial;
    private javax.swing.JTextField ADDUmnum;
    private javax.swing.JPasswordField ADDUpass;
    private javax.swing.JTextArea ADDUqualification;
    private javax.swing.JTextField ADDUsearch1;
    private javax.swing.JTextField ADDUuname;
    private javax.swing.JRadioButton ADDUvaccinedetailno;
    private javax.swing.JRadioButton ADDUvaccinedetailyes;
    private javax.swing.JComboBox<String> ADDUvaccinetype;
    private javax.swing.JTextField ADDUvdays;
    private javax.swing.JTextField ADDUvtime;
    private javax.swing.JButton ADDupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
