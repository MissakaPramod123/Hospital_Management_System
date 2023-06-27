
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class AddDoc1 extends javax.swing.JInternalFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public AddDoc1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
    }

    public void clear(){
        ADDid.setText(null);
        ADDfname.setText(null);
        ADDlname.setText(null);
        ADDaddress.setText(null);
        ADDuname.setText(null);
        ADDpass.setText(null);
        ADDvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        
        ADDgender.setSelectedItem(null);
        ADDage.setText(null);
        ADDmnum.setText(null);
        ADDblood.setSelectedItem(null);
        ADDjdate.setText(null);
        ADDvdays.setText(null);
        ADDvtime.setText(null);
        ADDqulification.setText(null);
        ADDmaritial.setSelectedItem(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ADDid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ADDfname = new javax.swing.JTextField();
        ADDlname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ADDaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ADDmnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADDblood = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ADDvdays = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ADDvaccinetype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ADDgender = new javax.swing.JComboBox<>();
        AddDoc = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ADDuname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ADDjdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ADDvtime = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADDvaccinedetailsno = new javax.swing.JRadioButton();
        ADDvaccinedetailsyes = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        ADDmaritial = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ADDage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ADDpass = new javax.swing.JPasswordField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ADDqulification = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Add Doctor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 210, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        ADDid.setBackground(new java.awt.Color(108, 122, 137));
        ADDid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 100, 30));

        ADDfname.setBackground(new java.awt.Color(108, 122, 137));
        ADDfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 290, -1));

        ADDlname.setBackground(new java.awt.Color(108, 122, 137));
        ADDlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 290, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 30));

        ADDaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADDaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 790, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 130, 30));

        ADDmnum.setBackground(new java.awt.Color(108, 122, 137));
        ADDmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 180, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile Number :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 30));

        ADDblood.setBackground(new java.awt.Color(108, 122, 137));
        ADDblood.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", " " }));
        ADDblood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDbloodActionPerformed(evt);
            }
        });
        jPanel1.add(ADDblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 30));

        ADDvdays.setBackground(new java.awt.Color(108, 122, 137));
        ADDvdays.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDvdays.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDvdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Age :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        ADDvaccinetype.setBackground(new java.awt.Color(108, 122, 137));
        ADDvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Fizer", "Moderna", "Sinopharm", "Astrazenica", " " }));
        ADDvaccinetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDvaccinetypeActionPerformed(evt);
            }
        });
        jPanel1.add(ADDvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 180, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Blood Group :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        ADDgender.setBackground(new java.awt.Color(108, 122, 137));
        ADDgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        ADDgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDgenderActionPerformed(evt);
            }
        });
        jPanel1.add(ADDgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 130, -1));

        AddDoc.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        AddDoc.setText("Add Doctor");
        AddDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDocActionPerformed(evt);
            }
        });
        jPanel1.add(AddDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 170, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Maritial Status :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 140, 30));

        ADDuname.setBackground(new java.awt.Color(108, 122, 137));
        ADDuname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDuname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 180, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Joining Date:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        ADDjdate.setBackground(new java.awt.Color(108, 122, 137));
        ADDjdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDjdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDjdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Visiting Time:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        ADDvtime.setBackground(new java.awt.Color(108, 122, 137));
        ADDvtime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDvtime.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDvtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 180, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Qualifications:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        buttonGroup1.add(ADDvaccinedetailsno);
        ADDvaccinedetailsno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDvaccinedetailsno.setForeground(new java.awt.Color(255, 255, 255));
        ADDvaccinedetailsno.setText("No");
        jPanel1.add(ADDvaccinedetailsno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        buttonGroup1.add(ADDvaccinedetailsyes);
        ADDvaccinedetailsyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDvaccinedetailsyes.setForeground(new java.awt.Color(255, 255, 255));
        ADDvaccinedetailsyes.setText("Yes");
        jPanel1.add(ADDvaccinedetailsyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Get Covid 19 Vaccine :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 200, 30));

        ADDmaritial.setBackground(new java.awt.Color(108, 122, 137));
        ADDmaritial.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDmaritial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single", "Married" }));
        ADDmaritial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDmaritialActionPerformed(evt);
            }
        });
        jPanel1.add(ADDmaritial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Visiting Days:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Vaccine Type:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 30));

        ADDage.setBackground(new java.awt.Color(108, 122, 137));
        ADDage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 180, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("User Name :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 120, 30));

        ADDpass.setBackground(new java.awt.Color(108, 122, 137));
        ADDpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 180, 30));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ADDqulification.setBackground(new java.awt.Color(108, 122, 137));
        ADDqulification.setColumns(20);
        ADDqulification.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDqulification.setForeground(new java.awt.Color(255, 255, 255));
        ADDqulification.setRows(5);
        jScrollPane4.setViewportView(ADDqulification);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, 110));

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

    private void ADDbloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDbloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDbloodActionPerformed

    private void ADDvaccinetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDvaccinetypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDvaccinetypeActionPerformed

    private void ADDgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDgenderActionPerformed

    private void AddDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDocActionPerformed
        String id,fname,lname,address,gender,uname,pass,detailvaccine,vaccinetype,age,mnum,blood,jdate,vdate,vtime,qulification,maritial;
    
        id = ADDid.getText();
        fname = ADDfname.getText();
        lname = ADDlname.getText();
        address = ADDaddress.getText();
        uname = ADDuname.getText();
        pass = ADDpass.getText();
        vaccinetype = ADDvaccinetype.getSelectedItem().toString();
        if (ADDvaccinedetailsyes.isSelected()){
        detailvaccine = ADDvaccinedetailsyes.getText();
        }else{
        detailvaccine = ADDvaccinedetailsno.getText();
        }
        System.out.println(detailvaccine);
        gender = ADDgender.getSelectedItem().toString();
        age = ADDage.getText();
        mnum = ADDmnum.getText();
        blood = ADDblood.getSelectedItem().toString();
        jdate= ADDjdate.getText();
        vdate = ADDvdays.getText();
        vtime = ADDvtime.getText();
        qulification = ADDqulification.getText();
        maritial = ADDmaritial.getSelectedItem().toString();
                
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
            }if (jdate.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER JOINING DATE!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (vdate.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER VISITING DATES!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (vtime.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER VISITING TIMES!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO admin_doctor(did,dfname,dlname,daddress,dage,dgender,dmnum,dblood,dmaritial,djdate,dvdays,dvtime,dqualification,dvaccinedetail,dvaccinetype,duname,dpass) VALUES ('"+id+"','"+fname+"','"+lname+"','"+address+"','"+age+"','"+gender+"','"+mnum+"','"+blood+"','"+maritial+"','"+jdate+"','"+vdate+"','"+vtime+"','"+qulification+"','"+detailvaccine+"','"+vaccinetype+"','"+uname+"','"+pass+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");
        
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
        clear();
    }//GEN-LAST:event_AddDocActionPerformed

    private void ADDmaritialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDmaritialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDmaritialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADDaddress;
    private javax.swing.JTextField ADDage;
    private javax.swing.JComboBox<String> ADDblood;
    private javax.swing.JTextField ADDfname;
    private javax.swing.JComboBox<String> ADDgender;
    private javax.swing.JTextField ADDid;
    private javax.swing.JTextField ADDjdate;
    private javax.swing.JTextField ADDlname;
    private javax.swing.JComboBox<String> ADDmaritial;
    private javax.swing.JTextField ADDmnum;
    private javax.swing.JPasswordField ADDpass;
    private javax.swing.JTextArea ADDqulification;
    private javax.swing.JTextField ADDuname;
    private javax.swing.JRadioButton ADDvaccinedetailsno;
    private javax.swing.JRadioButton ADDvaccinedetailsyes;
    private javax.swing.JComboBox<String> ADDvaccinetype;
    private javax.swing.JTextField ADDvdays;
    private javax.swing.JTextField ADDvtime;
    private javax.swing.JButton AddDoc;
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
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
