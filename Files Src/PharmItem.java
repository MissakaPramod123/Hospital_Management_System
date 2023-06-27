import com.mysql.cj.jdbc.result.ResultSetMetaData;
import hospitalsystem.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;




public class PharmItem extends javax.swing.JFrame {

    PreparedStatement pst = null;
    CreateStatement cs = null;
    ResultSet rs = null;
    
    public PharmItem() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
        table();
    }

    public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(itemid) FROM pharm_item";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(itemid)");
        
        if(rs.getString("MAX(itemid)")==null){
        PIid.setText("I0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(itemid)").substring(2,rs.getString("MAX(itemid)").length()));
            id++;
            PIid.setText("I"+ String.format("%04d",id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
    public void table(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT itemid,itemname,description,sellprice,buyprice,quentity FROM pharm_item";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
           int c;
           c = rsm.getColumnCount();
           
           DefaultTableModel df = (DefaultTableModel)PItable.getModel();
           df.setRowCount(0);
           
           while(rs.next()){
               Vector v = new Vector();
               for (int i=1;i<=c;i++){
                   
               v.add(rs.getString("itemid"));
               v.add(rs.getString("itemname"));
               v.add(rs.getString("description"));
               v.add(rs.getString("sellprice"));
               v.add(rs.getString("buyprice"));
               v.add(rs.getString("quentity"));
              
               
               }
               df.addRow(v);
           
           }
            
        } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null , e);
        
        }
    }
    public void tabledata(){
    int r = PItable.getSelectedRow();
    
    String id = PItable.getValueAt(r,0).toString();
    String name = PItable.getValueAt(r,1).toString();
    String description = PItable.getValueAt(r,2).toString();
    String sellp = PItable.getValueAt(r,3).toString();
    String buyp = PItable.getValueAt(r,4).toString();
    String qty = PItable.getValueAt(r,5).toString();
    
    
        
        PIid.setText(id);
        PIname.setText(name);
        PIdescription.setText(description);
        PIsell.setText(sellp);
        PIbuy.setText(buyp);
        PIq.setText(qty);
        
    
    
    }
    public void clear(){
        AutoId();
        PIname.setText(null);
        PIdescription.setText(null);
        PIsell.setText(null);
        PIbuy.setText(null);
        PIq.setText(null);
        
    }
    public void update(){
        String id,name,description,sellp,buyp,qty;
       
        id = PIid.getText();
        name = PIname.getText();
        description = PIdescription.getText();
        sellp = PIsell.getText();
        buyp = PIbuy.getText();
        qty = PIq.getText();
        
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE pharm_item SET itemid ='"+id+"',itemname ='"+name+"',description ='"+description+"',sellprice ='"+sellp+"',buyprice  ='"+buyp+"',quentity  ='"+qty+"' WHERE itemid ='"+id+"'" ; 
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
       String id = PIid.getText();
       try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

           String sql = "DELETE FROM `pharm_item` WHERE itemid LIKE '%"+id+"%';";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "DELETED !");
           
       } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , "Error while Deleting!");
       }
   
   } 
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PIadd = new javax.swing.JButton();
        PIremove = new javax.swing.JButton();
        PIupdate = new javax.swing.JButton();
        PIid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PIq = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PItable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PIdescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PIname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PIsell = new javax.swing.JTextField();
        PIbuy = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ADPatBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PIadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PIadd.setText("Add Item");
        PIadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIaddMouseClicked(evt);
            }
        });
        PIadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIaddActionPerformed(evt);
            }
        });
        jPanel1.add(PIadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 190, 60));

        PIremove.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PIremove.setText("Remove Item");
        PIremove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIremoveMouseClicked(evt);
            }
        });
        PIremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIremoveActionPerformed(evt);
            }
        });
        jPanel1.add(PIremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 190, 60));

        PIupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PIupdate.setText("Update Item");
        PIupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIupdateMouseClicked(evt);
            }
        });
        PIupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIupdateActionPerformed(evt);
            }
        });
        jPanel1.add(PIupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 190, 60));

        PIid.setBackground(new java.awt.Color(204, 204, 204));
        PIid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(PIid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 310, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quentity                  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 220, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item Name              :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 220, -1));

        PIq.setBackground(new java.awt.Color(204, 204, 204));
        PIq.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PIq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIqActionPerformed(evt);
            }
        });
        jPanel1.add(PIq, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 180, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description             :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 210, -1));

        PItable.setBackground(new java.awt.Color(204, 255, 255));
        PItable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PItable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        PItable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Description", "Sell Price", "Buy Price", "Quentity"
            }
        ));
        PItable.setShowGrid(true);
        PItable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PItableMouseClicked(evt);
            }
        });
        PItable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PItableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(PItable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 870, 230));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Item Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 220, 60));

        PIdescription.setBackground(new java.awt.Color(204, 204, 204));
        PIdescription.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PIdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIdescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(PIdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 650, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Item ID                   :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 210, -1));

        PIname.setBackground(new java.awt.Color(204, 204, 204));
        PIname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PIname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PInameActionPerformed(evt);
            }
        });
        jPanel1.add(PIname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 310, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sell Price        (Rs.) :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 220, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buy Price        (Rs.) :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 220, -1));

        PIsell.setBackground(new java.awt.Color(204, 204, 204));
        PIsell.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PIsell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIsellActionPerformed(evt);
            }
        });
        jPanel1.add(PIsell, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 180, 30));

        PIbuy.setBackground(new java.awt.Color(204, 204, 204));
        PIbuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PIbuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIbuyActionPerformed(evt);
            }
        });
        jPanel1.add(PIbuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, 180, 30));

        jPanel3.setBackground(new java.awt.Color(0, 255, 255,100));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(ADPatBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1086, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADPatBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1240, 70));

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
        jPanel1.add(UpdateDocClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 50, 25));

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
        jPanel1.add(UpdateDocClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 50, 25));

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

    private void PIaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIaddMouseClicked

    }//GEN-LAST:event_PIaddMouseClicked

    private void PIaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIaddActionPerformed
        String id,name,description,sellp,buyp,qty;

        id = PIid.getText();
        name = PIname.getText();
        description = PIdescription.getText();
        sellp = PIsell.getText();
        buyp = PIbuy.getText();
        qty = PIq.getText();
        
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            if (name.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER ITEM NAME !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (description.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER DESCRIPTION !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (sellp.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER SELL PRICE !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (buyp.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER BUY PRICE !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if (qty.equals("")) {
                JOptionPane.showMessageDialog( this, "PLEASE ENTER QUENTITY !","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO pharm_item(itemid,itemname,description,sellprice,buyprice,quentity) VALUES ('"+id+"','"+name+"','"+description+"','"+sellp+"','"+buyp+"','"+qty+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null , "DATA INSERT SUCCESSFULL !");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        table();
        clear();
    }//GEN-LAST:event_PIaddActionPerformed

    private void PIremoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIremoveMouseClicked

    }//GEN-LAST:event_PIremoveMouseClicked

    private void PIremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIremoveActionPerformed
        delete();
        table();
        clear();
    }//GEN-LAST:event_PIremoveActionPerformed

    private void PIupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIupdateMouseClicked

    }//GEN-LAST:event_PIupdateMouseClicked

    private void PIupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIupdateActionPerformed
        update();
        table();
        clear();
    }//GEN-LAST:event_PIupdateActionPerformed

    private void PIqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIqActionPerformed

    private void PItableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PItableMouseClicked
        tabledata();

    }//GEN-LAST:event_PItableMouseClicked

    private void PItableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PItableKeyReleased
        tabledata();

    }//GEN-LAST:event_PItableKeyReleased

    private void PIdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIdescriptionActionPerformed

    private void PInameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PInameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PInameActionPerformed

    private void PIsellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIsellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIsellActionPerformed

    private void PIbuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIbuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIbuyActionPerformed

    private void ADPatBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPatBackActionPerformed
        PharmacistPanel PP = new PharmacistPanel();
        PP.setVisible(true);
        PP.pack();
        PP.setLocationRelativeTo(null);
        PP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADPatBackActionPerformed

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
            java.util.logging.Logger.getLogger(PharmItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADPatBack;
    private javax.swing.JButton PIadd;
    private javax.swing.JTextField PIbuy;
    private javax.swing.JTextField PIdescription;
    private javax.swing.JTextField PIid;
    private javax.swing.JTextField PIname;
    private javax.swing.JTextField PIq;
    private javax.swing.JButton PIremove;
    private javax.swing.JTextField PIsell;
    private javax.swing.JTable PItable;
    private javax.swing.JButton PIupdate;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
