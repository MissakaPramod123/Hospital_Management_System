import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class DocPatientHistory extends javax.swing.JInternalFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public DocPatientHistory() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        Connection con = DBConnect.connect();
    }

    public void History(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT * FROM admin_patient WHERE pid = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1,DPsearchbox1.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                    DPhistory.setText("\n\n");
                    DPhistory.setText("  *******************************************************************************************************************************************\n");
DPhistory.setText(DPhistory.getText()+"                              "+rs.getString("pfname")+"  "+rs.getString("plname")+"  HISTORY"+"                                             \n");
DPhistory.setText(DPhistory.getText()+"  *******************************************************************************************************************************************\n");
     DPhistory.setText(DPhistory.getText()+"\t\tPatient Name : "+rs.getString("pfname")+" "+rs.getString("plname") +"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tPatient Age  : "+rs.getString("page")+"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tGender       : "+rs.getString("pgender")+"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tAddress      : "+rs.getString("paddress")+"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tMobile Number: "+rs.getString("pmobilenumber")+"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tAdmit date   : "+rs.getString("admitdate")+"\n");
     DPhistory.setText(DPhistory.getText()+"\t\tRoom         : "+rs.getString("proom")+"\n");
     DPhistory.setText(DPhistory.getText()+"  *******************************************************************************************************************************************\n");
            
            }else {
            JOptionPane.showMessageDialog(null,"No Specific Id Found");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DPsearchbox1 = new javax.swing.JTextField();
        DPsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DPhistory = new javax.swing.JTextArea();

        setResizable(true);
        setPreferredSize(new java.awt.Dimension(972, 572));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search ID :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 100, 30));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("History");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 180, 60));

        DPsearchbox1.setBackground(new java.awt.Color(108, 122, 137));
        DPsearchbox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DPsearchbox1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(DPsearchbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 180, -1));

        DPsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DPsearch.setText("Search ");
        DPsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DPsearchActionPerformed(evt);
            }
        });
        jPanel1.add(DPsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 80, 30));

        DPhistory.setColumns(20);
        DPhistory.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DPhistory.setRows(5);
        jScrollPane1.setViewportView(DPhistory);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 920, 360));

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
        History();
        DPsearchbox1.setText(null);
    }//GEN-LAST:event_DPsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DPhistory;
    private javax.swing.JButton DPsearch;
    private javax.swing.JTextField DPsearchbox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
