
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DeleteDoc1 extends javax.swing.JInternalFrame {

    java.sql.PreparedStatement pst = null;
    java.sql.ResultSet rs = null;
    
    public DeleteDoc1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
    }

    public void search(){
        String srch = ADDdsearchid.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            
            String sql = "SELECT * FROM admin_doctor WHERE did=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1,ADDdsearchid.getText());
            rs=pst.executeQuery();
           
            if(rs.next()){
        ADDdid.setText(rs.getString("did"));
        ADDdfname.setText(rs.getString("dfname"));
        ADDdlname.setText(rs.getString("dlname"));
        ADDdaddress.setText(rs.getString("daddress"));
        ADDduname.setText(rs.getString("duname"));
        ADDdpass.setText(rs.getString("dpass"));
        ADDdvaccinetype.setSelectedItem(rs.getString("dvaccinetype"));
        if (rs.getString("dvaccinedetail").equals("Yes")){
        ADDdvaccinedetailyes.setSelected(true);
        }else{
        ADDdvaccinedetailno.setSelected(true);
        }
        
        ADDdgender.setSelectedItem(rs.getString("dgender"));
        ADDdage.setText(rs.getString("dage"));
        ADDdmnum.setText(rs.getString("dmnum"));
        ADDdblood.setSelectedItem(rs.getString("dblood"));
        ADDdjdate.setText(rs.getString("djdate"));
        ADDdvdays.setText(rs.getString("dvdays"));
        ADDdvtime.setText(rs.getString("dvtime"));
        ADDdqualification.setText(rs.getString("dqualification"));
        ADDdmaritial.setSelectedItem(rs.getString("dmaritial"));
            
            }else{
                JOptionPane.showMessageDialog(null , "SORRY RECORD NOT FOUND !");
            }
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    
    }
    
   public void delete(){      
   int check = JOptionPane.showConfirmDialog(null,"DO YOU WANT TO DELETE DATA ?");
   if (check == 0){
       String id = ADDdid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `admin_doctor` WHERE did LIKE '%"+id+"%';";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "DELETED !");
           
       } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "Error while Deleting!");
       }
   
   } 
   }
   
   public void clear(){
        ADDdid.setText(null);
        ADDdfname.setText(null);
        ADDdlname.setText(null);
        ADDdaddress.setText(null);
        ADDduname.setText(null);
        ADDdpass.setText(null);
        ADDdvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        ADDdgender.setSelectedItem(null);
        ADDdage.setText(null);
        ADDdmnum.setText(null);
        ADDdblood.setSelectedItem(null);
        ADDdjdate.setText(null);
        ADDdvdays.setText(null);
        ADDdvtime.setText(null);
        ADDdqualification.setText(null);
        ADDdmaritial.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ADDdid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ADDdfname = new javax.swing.JTextField();
        ADDdlname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ADDdaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ADDdmnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADDdblood = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ADDdvdays = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ADDdvaccinetype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ADDdgender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        ADDdage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ADDdjdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ADDdvtime = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADDdvaccinedetailno = new javax.swing.JRadioButton();
        ADDdvaccinedetailyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        ADDdmaritial = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        ADDdelete = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        ADDduname = new javax.swing.JTextField();
        ADDdpass = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ADDdqualification = new javax.swing.JTextArea();
        ADDdsearchid = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ADDdsearch = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(42, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Delete Doctor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 240, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        ADDdid.setBackground(new java.awt.Color(108, 122, 137));
        ADDdid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 100, 30));

        ADDdfname.setBackground(new java.awt.Color(108, 122, 137));
        ADDdfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 290, -1));

        ADDdlname.setBackground(new java.awt.Color(108, 122, 137));
        ADDdlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 290, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 30));

        ADDdaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADDdaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 790, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vaccine Type:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 30));

        ADDdmnum.setBackground(new java.awt.Color(108, 122, 137));
        ADDdmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 180, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile Number :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 30));

        ADDdblood.setBackground(new java.awt.Color(108, 122, 137));
        ADDdblood.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", " " }));
        ADDdblood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdbloodActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 30));

        ADDdvdays.setBackground(new java.awt.Color(108, 122, 137));
        ADDdvdays.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdvdays.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdvdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Age :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        ADDdvaccinetype.setBackground(new java.awt.Color(108, 122, 137));
        ADDdvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Fizer", "Moderna", "Sinopharm", "Astrazenica", " " }));
        ADDdvaccinetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdvaccinetypeActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 180, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Blood Group :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        ADDdgender.setBackground(new java.awt.Color(108, 122, 137));
        ADDdgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        ADDdgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdgenderActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 130, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Maritial Status :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 140, 30));

        ADDdage.setBackground(new java.awt.Color(108, 122, 137));
        ADDdage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 180, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Joining Date:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        ADDdjdate.setBackground(new java.awt.Color(108, 122, 137));
        ADDdjdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdjdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdjdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Visiting Time:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        ADDdvtime.setBackground(new java.awt.Color(108, 122, 137));
        ADDdvtime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdvtime.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdvtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 180, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Qualifications:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        buttonGroup1.add(ADDdvaccinedetailno);
        ADDdvaccinedetailno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdvaccinedetailno.setForeground(new java.awt.Color(255, 255, 255));
        ADDdvaccinedetailno.setText("No");
        jPanel1.add(ADDdvaccinedetailno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        buttonGroup1.add(ADDdvaccinedetailyes);
        ADDdvaccinedetailyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdvaccinedetailyes.setForeground(new java.awt.Color(255, 255, 255));
        ADDdvaccinedetailyes.setText("Yes");
        jPanel1.add(ADDdvaccinedetailyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 200, 30));

        ADDdmaritial.setBackground(new java.awt.Color(108, 122, 137));
        ADDdmaritial.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdmaritial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single", "Married" }));
        ADDdmaritial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdmaritialActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdmaritial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Visiting Days:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        ADDdelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADDdelete.setText("Delete Doctor");
        ADDdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 180, 40));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("User Name :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 120, 30));

        ADDduname.setBackground(new java.awt.Color(108, 122, 137));
        ADDduname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDduname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDduname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 180, -1));

        ADDdpass.setBackground(new java.awt.Color(108, 122, 137));
        ADDdpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 180, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Password :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 130, 30));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ADDdqualification.setBackground(new java.awt.Color(108, 122, 137));
        ADDdqualification.setColumns(20);
        ADDdqualification.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdqualification.setForeground(new java.awt.Color(255, 255, 255));
        ADDdqualification.setRows(5);
        jScrollPane3.setViewportView(ADDdqualification);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, 110));

        ADDdsearchid.setBackground(new java.awt.Color(108, 122, 137));
        ADDdsearchid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDdsearchid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDdsearchid, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 180, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search ID :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 100, 30));

        ADDdsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADDdsearch.setText("Search ");
        ADDdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDdsearchActionPerformed(evt);
            }
        });
        jPanel1.add(ADDdsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 80, 30));

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

    private void ADDdbloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdbloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDdbloodActionPerformed

    private void ADDdvaccinetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdvaccinetypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDdvaccinetypeActionPerformed

    private void ADDdgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDdgenderActionPerformed

    private void ADDdmaritialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdmaritialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDdmaritialActionPerformed

    private void ADDdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdeleteActionPerformed
      delete();
      clear();
      
    }//GEN-LAST:event_ADDdeleteActionPerformed

    private void ADDdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDdsearchActionPerformed
       search();
       ADDdsearchid.setText(null);
       
    }//GEN-LAST:event_ADDdsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADDdaddress;
    private javax.swing.JTextField ADDdage;
    private javax.swing.JComboBox<String> ADDdblood;
    private javax.swing.JButton ADDdelete;
    private javax.swing.JTextField ADDdfname;
    private javax.swing.JComboBox<String> ADDdgender;
    private javax.swing.JTextField ADDdid;
    private javax.swing.JTextField ADDdjdate;
    private javax.swing.JTextField ADDdlname;
    private javax.swing.JComboBox<String> ADDdmaritial;
    private javax.swing.JTextField ADDdmnum;
    private javax.swing.JPasswordField ADDdpass;
    private javax.swing.JTextArea ADDdqualification;
    private javax.swing.JButton ADDdsearch;
    private javax.swing.JTextField ADDdsearchid;
    private javax.swing.JTextField ADDduname;
    private javax.swing.JRadioButton ADDdvaccinedetailno;
    private javax.swing.JRadioButton ADDdvaccinedetailyes;
    private javax.swing.JComboBox<String> ADDdvaccinetype;
    private javax.swing.JTextField ADDdvdays;
    private javax.swing.JTextField ADDdvtime;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
