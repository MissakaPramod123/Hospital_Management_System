
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;


public class SearchDoc1 extends javax.swing.JInternalFrame {

    java.sql.PreparedStatement pst = null;
    ResultSet rs = null;
    
    public SearchDoc1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        
    }

    public void search(){
        String srch = ADDsearchid2.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            
            String sql = "SELECT * FROM admin_doctor WHERE did=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1,ADDsearchid2.getText());
            rs=pst.executeQuery();
           
            if(rs.next()){
        ADDSid.setText(rs.getString("did"));
        ADDSfname.setText(rs.getString("dfname"));
        ADDSlname.setText(rs.getString("dlname"));
        ADDSaddress.setText(rs.getString("daddress"));
        ADDSuname.setText(rs.getString("duname"));
        ADDSpass.setText(rs.getString("dpass"));
        ADDSvaccinetype.setSelectedItem(rs.getString("dvaccinetype"));
        if (rs.getString("dvaccinedetail").equals("Yes")){
        ADDSvaccinedetailyes.setSelected(true);
        }else{
        ADDSvaccinedetailno.setSelected(true);
        }
        
        ADDSgender.setSelectedItem(rs.getString("dgender"));
        ADDSage.setText(rs.getString("dage"));
        ADDSmnum.setText(rs.getString("dmnum"));
        ADDSblood.setSelectedItem(rs.getString("dblood"));
        ADDSjdate.setText(rs.getString("djdate"));
        ADDSvdays.setText(rs.getString("dvdays"));
        ADDSvtime.setText(rs.getString("dvtime"));
        ADDSqualification.setText(rs.getString("dqualification"));
        ADDSmaritial.setSelectedItem(rs.getString("dmaritial"));
            
            }else{
                JOptionPane.showMessageDialog(null , "SORRY RECORD NOT FOUND !");
            }
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ADDSid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ADDSfname = new javax.swing.JTextField();
        ADDSlname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ADDSaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ADDSmnum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ADDSblood = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ADDSvdays = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ADDSvaccinetype = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ADDSgender = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        ADDSage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ADDSjdate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ADDSvtime = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ADDSvaccinedetailno = new javax.swing.JRadioButton();
        ADDSvaccinedetailyes = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        ADDSmaritial = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ADDSqualification = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        ADDSuname = new javax.swing.JTextField();
        ADDSpass = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ADDsearchid2 = new javax.swing.JTextField();
        ADsearch2 = new javax.swing.JButton();
        ADSearchclear = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(42, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Search Doctor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 240, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Search Doctor");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 240, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 330, 60));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doctor Id :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        ADDSid.setBackground(new java.awt.Color(108, 122, 137));
        ADDSid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 100, 30));

        ADDSfname.setBackground(new java.awt.Color(108, 122, 137));
        ADDSfname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSfname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 290, -1));

        ADDSlname.setBackground(new java.awt.Color(108, 122, 137));
        ADDSlname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSlname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 290, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 30));

        ADDSaddress.setBackground(new java.awt.Color(108, 122, 137));
        ADDSaddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSaddress.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 790, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vaccine Type:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 30));

        ADDSmnum.setBackground(new java.awt.Color(108, 122, 137));
        ADDSmnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSmnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSmnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 180, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mobile Number :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 30));

        ADDSblood.setBackground(new java.awt.Color(108, 122, 137));
        ADDSblood.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", " " }));
        ADDSblood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDSbloodActionPerformed(evt);
            }
        });
        jPanel1.add(ADDSblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Gender :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 30));

        ADDSvdays.setBackground(new java.awt.Color(108, 122, 137));
        ADDSvdays.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSvdays.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSvdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        ADDSvaccinetype.setBackground(new java.awt.Color(108, 122, 137));
        ADDSvaccinetype.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSvaccinetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Fizer", "Moderna", "Sinopharm", "Astrazenica", " " }));
        ADDSvaccinetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDSvaccinetypeActionPerformed(evt);
            }
        });
        jPanel1.add(ADDSvaccinetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 180, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Blood Group :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        ADDSgender.setBackground(new java.awt.Color(108, 122, 137));
        ADDSgender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        ADDSgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDSgenderActionPerformed(evt);
            }
        });
        jPanel1.add(ADDSgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 130, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Maritial Status :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 140, 30));

        ADDSage.setBackground(new java.awt.Color(108, 122, 137));
        ADDSage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 180, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Joining Date:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        ADDSjdate.setBackground(new java.awt.Color(108, 122, 137));
        ADDSjdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSjdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSjdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Visiting Time:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        ADDSvtime.setBackground(new java.awt.Color(108, 122, 137));
        ADDSvtime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSvtime.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSvtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 180, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Qualifications:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        buttonGroup1.add(ADDSvaccinedetailno);
        ADDSvaccinedetailno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSvaccinedetailno.setForeground(new java.awt.Color(255, 255, 255));
        ADDSvaccinedetailno.setText("No");
        jPanel1.add(ADDSvaccinedetailno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        buttonGroup1.add(ADDSvaccinedetailyes);
        ADDSvaccinedetailyes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSvaccinedetailyes.setForeground(new java.awt.Color(255, 255, 255));
        ADDSvaccinedetailyes.setText("Yes");
        jPanel1.add(ADDSvaccinedetailyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Get Covid 19 Vaccine :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 200, 30));

        ADDSmaritial.setBackground(new java.awt.Color(108, 122, 137));
        ADDSmaritial.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSmaritial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single", "Married" }));
        ADDSmaritial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDSmaritialActionPerformed(evt);
            }
        });
        jPanel1.add(ADDSmaritial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Visiting Days:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ADDSqualification.setBackground(new java.awt.Color(108, 122, 137));
        ADDSqualification.setColumns(20);
        ADDSqualification.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSqualification.setForeground(new java.awt.Color(255, 255, 255));
        ADDSqualification.setRows(5);
        jScrollPane2.setViewportView(ADDSqualification);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, 110));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("User Name :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 120, 30));

        ADDSuname.setBackground(new java.awt.Color(108, 122, 137));
        ADDSuname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSuname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 180, -1));

        ADDSpass.setBackground(new java.awt.Color(108, 122, 137));
        ADDSpass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDSpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDSpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 180, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Password :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 130, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Search ID :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 100, 30));

        ADDsearchid2.setBackground(new java.awt.Color(108, 122, 137));
        ADDsearchid2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADDsearchid2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ADDsearchid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 180, -1));

        ADsearch2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADsearch2.setText("Search ");
        ADsearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADsearch2ActionPerformed(evt);
            }
        });
        jPanel1.add(ADsearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 80, 30));

        ADSearchclear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADSearchclear.setText("Clear Data");
        ADSearchclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADSearchclearActionPerformed(evt);
            }
        });
        jPanel1.add(ADSearchclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, 140, 50));

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

    private void ADDSbloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDSbloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDSbloodActionPerformed

    private void ADDSvaccinetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDSvaccinetypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDSvaccinetypeActionPerformed

    private void ADDSgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDSgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDSgenderActionPerformed

    private void ADDSmaritialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDSmaritialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDSmaritialActionPerformed

    private void ADsearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADsearch2ActionPerformed
        search();
        ADDsearchid2.setText(null);
    }//GEN-LAST:event_ADsearch2ActionPerformed

    private void ADSearchclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADSearchclearActionPerformed
        ADDSid.setText(null);
        ADDSfname.setText(null);
        ADDSlname.setText(null);
        ADDSaddress.setText(null);
        ADDSuname.setText(null);
        ADDSpass.setText(null);
        ADDSvaccinetype.setSelectedItem(null);
        buttonGroup1.clearSelection();
        
        ADDSgender.setSelectedItem(null);
        ADDSage.setText(null);
        ADDSmnum.setText(null);
        ADDSblood.setSelectedItem(null);
        ADDSjdate.setText(null);
        ADDSvdays.setText(null);
        ADDSvtime.setText(null);
        ADDSqualification.setText(null);
        ADDSmaritial.setSelectedItem(null);
    }//GEN-LAST:event_ADSearchclearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADDSaddress;
    private javax.swing.JTextField ADDSage;
    private javax.swing.JComboBox<String> ADDSblood;
    private javax.swing.JTextField ADDSfname;
    private javax.swing.JComboBox<String> ADDSgender;
    private javax.swing.JTextField ADDSid;
    private javax.swing.JTextField ADDSjdate;
    private javax.swing.JTextField ADDSlname;
    private javax.swing.JComboBox<String> ADDSmaritial;
    private javax.swing.JTextField ADDSmnum;
    private javax.swing.JPasswordField ADDSpass;
    private javax.swing.JTextArea ADDSqualification;
    private javax.swing.JTextField ADDSuname;
    private javax.swing.JRadioButton ADDSvaccinedetailno;
    private javax.swing.JRadioButton ADDSvaccinedetailyes;
    private javax.swing.JComboBox<String> ADDSvaccinetype;
    private javax.swing.JTextField ADDSvdays;
    private javax.swing.JTextField ADDSvtime;
    private javax.swing.JTextField ADDsearchid2;
    private javax.swing.JButton ADSearchclear;
    private javax.swing.JButton ADsearch2;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
