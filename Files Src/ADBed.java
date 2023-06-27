
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class ADBed extends javax.swing.JFrame {

    PreparedStatement pst = null;
    java.sql.ResultSet rs = null;
    public ADBed() {
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
            String sql = "SELECT bid,brooms,bcategory FROM bed_details";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
           ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)Btable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("bid"));
               v.add(rs.getString("brooms"));
               v.add(rs.getString("bcategory"));
               
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
     public void tabledata(){
    int r = Btable.getSelectedRow();
    
    String id = Btable.getValueAt(r,0).toString();
    String rooms = Btable.getValueAt(r,1).toString();
    String category = Btable.getValueAt(r,2).toString();
        Bid.setText(id);
        Bnrooms.setText(rooms);
        Bcategory.setSelectedItem(category);
}
     public void clear(){
        AutoId();
        Bnrooms.setText(null);
        Bcategory.setSelectedItem(null);
    }
     public void update(){
        String id,rooms,category;
       
        id = Bid.getText();
        rooms = Bnrooms.getText();
        category = Bcategory.getSelectedItem().toString();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE bed_details SET bid ='"+id+"',bcategory ='"+category+"',brooms ='"+rooms+"' WHERE bid ='"+id+"'" ; 
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
       String id = Bid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `bed_details` WHERE bid LIKE '%"+id+"%';";
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
        String sql = "SELECT MAX(bid) FROM bed_details";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(bid)");
        
        if(rs.getString("MAX(bid)")==null){
        Bid.setText("R0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(bid)").substring(2,rs.getString("MAX(bid)").length()));
            id++;
            Bid.setText("R"+ String.format("%04d", id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ADBremove = new javax.swing.JButton();
        ADBupdate = new javax.swing.JButton();
        ADBadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Btable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Bnrooms = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Bid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Bcategory = new javax.swing.JComboBox<>();
        ADBBack = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bed Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 50));

        ADBremove.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADBremove.setText("Remove Bed");
        ADBremove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADBremoveMouseClicked(evt);
            }
        });
        ADBremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADBremoveActionPerformed(evt);
            }
        });
        jPanel2.add(ADBremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 190, 60));

        ADBupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADBupdate.setText("Update Bed");
        ADBupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADBupdateMouseClicked(evt);
            }
        });
        ADBupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADBupdateActionPerformed(evt);
            }
        });
        jPanel2.add(ADBupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 190, 60));

        ADBadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ADBadd.setText("Add Bed");
        ADBadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADBaddMouseClicked(evt);
            }
        });
        ADBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADBaddActionPerformed(evt);
            }
        });
        jPanel2.add(ADBadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 190, 60));

        Btable.setBackground(new java.awt.Color(204, 255, 255));
        Btable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Btable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Room ID", "Category", "No. Beds"
            }
        ));
        Btable.setShowGrid(true);
        Btable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtableMouseClicked(evt);
            }
        });
        Btable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Btable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 870, 290));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Number of Beds    :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 210, -1));

        Bnrooms.setBackground(new java.awt.Color(204, 204, 204));
        Bnrooms.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Bnrooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnroomsActionPerformed(evt);
            }
        });
        jPanel2.add(Bnrooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 310, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room ID               :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 210, -1));

        Bid.setBackground(new java.awt.Color(204, 204, 204));
        Bid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(Bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 310, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category                :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 210, -1));

        Bcategory.setBackground(new java.awt.Color(204, 204, 204));
        Bcategory.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Bcategory.setForeground(new java.awt.Color(255, 255, 255));
        Bcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ICU", "Normal" }));
        jPanel2.add(Bcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 230, 30));

        ADBBack.setBackground(new java.awt.Color(255, 255, 255));
        ADBBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ADBBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        ADBBack.setText("Back");
        ADBBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ADBBack.setBorderPainted(false);
        ADBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADBBackActionPerformed(evt);
            }
        });
        jPanel2.add(ADBBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 50));

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
        jPanel2.add(UpdateDocClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 50, 25));

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
        jPanel2.add(UpdateDocClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 50, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/Bed.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADBremoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADBremoveMouseClicked
       
    }//GEN-LAST:event_ADBremoveMouseClicked

    private void ADBremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADBremoveActionPerformed
        delete();
        table();
        clear();
    }//GEN-LAST:event_ADBremoveActionPerformed

    private void ADBupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADBupdateMouseClicked
        
    }//GEN-LAST:event_ADBupdateMouseClicked

    private void ADBupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADBupdateActionPerformed
        update();
        table();
        clear();
    }//GEN-LAST:event_ADBupdateActionPerformed

    private void ADBaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADBaddMouseClicked
       
    }//GEN-LAST:event_ADBaddMouseClicked

    private void ADBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADBaddActionPerformed
        String id,room,category;
    
        id = Bid.getText();
        room = Bnrooms.getText();
        category = Bcategory.getSelectedItem().toString();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO bed_details(bid,brooms,bcategory) VALUES ('"+id+"','"+room+"','"+category+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");
        
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    }//GEN-LAST:event_ADBaddActionPerformed

    private void BnroomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnroomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BnroomsActionPerformed

    private void ADBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADBBackActionPerformed
        AdminPanel AP = new AdminPanel();
        AP.setVisible(true);
        AP.pack();
        AP.setLocationRelativeTo(null);
        AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADBBackActionPerformed

    private void BtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtableMouseClicked
       tabledata();
       
    }//GEN-LAST:event_BtableMouseClicked

    private void BtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtableKeyReleased
        tabledata();
        
    }//GEN-LAST:event_BtableKeyReleased

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
            java.util.logging.Logger.getLogger(ADBed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADBed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADBed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADBed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADBed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADBBack;
    private javax.swing.JButton ADBadd;
    private javax.swing.JButton ADBremove;
    private javax.swing.JButton ADBupdate;
    private javax.swing.JComboBox<String> Bcategory;
    private javax.swing.JTextField Bid;
    private javax.swing.JTextField Bnrooms;
    private javax.swing.JTable Btable;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
