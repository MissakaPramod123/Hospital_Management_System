import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;


public class DocPatientUpdate extends javax.swing.JInternalFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public DocPatientUpdate() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        Connection con = DBConnect.connect();
    }

     
    public void search(){
    String srch = DPsearchbox1.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            
            String sql = "SELECT * FROM admin_patient WHERE pid=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1,DPsearchbox1.getText());
            rs=pst.executeQuery();
           
            if(rs.next()){
        DPid.setText(rs.getString("pid"));
        DPfname.setText(rs.getString("pfname"));
        DPlname.setText(rs.getString("plname"));
        DPaddress.setText(rs.getString("paddress"));
        
        DPvaccinetype.setSelectedItem(rs.getString("pvaccinetype"));
        if (DPvaccineyes.isSelected()){
        DPvaccineyes.setSelected(false);
        }else{
        DPvaccineno.setSelected(false);
        }
        
        DPgender.setSelectedItem(rs.getString("pgender"));
        DPage.setText(rs.getString("page"));
        DPmnum.setText(rs.getString("pmobilenumber"));
        DPadmitdate.setText(rs.getString("admitdate"));
        
       
            
            }else{
                JOptionPane.showMessageDialog(null , "SORRY RECORD NOT FOUND !");
            }
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    
    }
    public void clear(){
        DPid.setText(null);
        DPfname.setText(null);
        DPlname.setText(null);
        DPaddress.setText(null);
        
        DPvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        
        DPgender.setSelectedItem(null);
        DPage.setText(null);
        DPmnum.setText(null);
        DPadmitdate.setText(null);
    }
    public void update(){
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum,admitdate;
       
        id = DPid.getText();
        fname = DPfname.getText();
        lname = DPlname.getText();
        address = DPaddress.getText();
       
        vaccinetype = DPvaccinetype.getSelectedItem().toString();
        if (DPvaccineyes.isSelected()){
        detailvaccine = DPvaccineyes.getText();
        }else{
        detailvaccine = DPvaccineno.getText();
        }
        //System.out.println(detailvaccine);
        gender = DPgender.getSelectedItem().toString();
        age = DPage.getText();
        mnum = DPmnum.getText();
        admitdate = DPadmitdate.getText();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE admin_patient SET pid ='"+id+"',pfname ='"+fname+"',plname ='"+lname+"',paddress ='"+address+"',page  ='"+age+"',pgender  ='"+gender+"',pmobilenumber  ='"+mnum+"',pvaccinedetail  ='"+detailvaccine+"',pvaccinetype  ='"+vaccinetype+"',admitdate ='"+admitdate+"' WHERE pid ='"+id+"'" ; 
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "UPDATED !");
         
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "UNUPDATED !");

        } 
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DPid = new javax.swing.JTextField();
        DPfname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DPaddress = new javax.swing.JTextField();
        DPage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DPgender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DPvaccineyes = new javax.swing.JRadioButton();
        DPvaccineno = new javax.swing.JRadioButton();
        DPvaccinetype = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        DPmnum = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        DPlname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        DPsearchbox1 = new javax.swing.JTextField();
        DPsearch = new javax.swing.JButton();
        DPupdate = new javax.swing.JButton();
        DPadmitdate = new javax.swing.JTextField();

        setResizable(true);
        setPreferredSize(new java.awt.Dimension(972, 572));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Update");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 180, 60));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient ID         :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 30));

        DPid.setBackground(new java.awt.Color(108, 122, 137));
        DPid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 270, 30));

        DPfname.setBackground(new java.awt.Color(108, 122, 137));
        DPfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 270, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("First Name        :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address             :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 30));

        DPaddress.setBackground(new java.awt.Color(108, 122, 137));
        DPaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 770, 30));

        DPage.setBackground(new java.awt.Color(108, 122, 137));
        DPage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 140, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Age                    :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 140, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Admit Date       :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 140, 30));

        DPgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel1.add(DPgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 140, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender       :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 110, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 190, 30));

        buttonGroup1.add(DPvaccineyes);
        DPvaccineyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPvaccineyes.setForeground(new java.awt.Color(255, 255, 255));
        DPvaccineyes.setText("Yes");
        jPanel1.add(DPvaccineyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, 30));

        buttonGroup1.add(DPvaccineno);
        DPvaccineno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPvaccineno.setForeground(new java.awt.Color(255, 255, 255));
        DPvaccineno.setText("No");
        jPanel1.add(DPvaccineno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, 30));

        DPvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Phizer", "Moderna", "Astrazenica", "Sputnic V", "Sinopharm" }));
        jPanel1.add(DPvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 140, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vaccine Type :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 140, 30));

        DPmnum.setBackground(new java.awt.Color(108, 122, 137));
        DPmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 190, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mobile Number :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 140, 30));

        DPlname.setBackground(new java.awt.Color(108, 122, 137));
        DPlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 270, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name        :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 140, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search ID :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 100, 30));

        DPsearchbox1.setBackground(new java.awt.Color(108, 122, 137));
        DPsearchbox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPsearchbox1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPsearchbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 180, -1));

        DPsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DPsearch.setText("Search ");
        DPsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPsearchActionPerformed(evt);
            }
        });
        jPanel1.add(DPsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 80, 30));

        DPupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        DPupdate.setText("Update ");
        DPupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPupdateActionPerformed(evt);
            }
        });
        jPanel1.add(DPupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 190, 40));

        DPadmitdate.setBackground(new java.awt.Color(108, 122, 137));
        DPadmitdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPadmitdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPadmitdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 210, 30));

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

    private void DPsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPsearchActionPerformed
        search();
        DPsearchbox1.setText(null);
    }//GEN-LAST:event_DPsearchActionPerformed

    private void DPupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DPupdateActionPerformed
        update();
        clear();
    }//GEN-LAST:event_DPupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DPaddress;
    private javax.swing.JTextField DPadmitdate;
    private javax.swing.JTextField DPage;
    private javax.swing.JTextField DPfname;
    private javax.swing.JComboBox<String> DPgender;
    private javax.swing.JTextField DPid;
    private javax.swing.JTextField DPlname;
    private javax.swing.JTextField DPmnum;
    private javax.swing.JButton DPsearch;
    private javax.swing.JTextField DPsearchbox1;
    private javax.swing.JButton DPupdate;
    private javax.swing.JRadioButton DPvaccineno;
    private javax.swing.JComboBox<String> DPvaccinetype;
    private javax.swing.JRadioButton DPvaccineyes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
