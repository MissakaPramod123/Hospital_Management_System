
import com.mysql.cj.xdevapi.Statement;
import hospitalsystem.DBConnect;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class PharmInventory extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public PharmInventory() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
    }
    String pnoo;
    String npno;
    
    public PharmInventory(String pno) {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        Header();
        
        this.pnoo = pno;
        npno = pnoo;
        
        Dpresnum.setText(npno);
    }
    
    
    public void sales1(){
        String id,Did,Dname,qty;

        id = Dpresnum.getText();
        Did = INdc.getText();
        Dname = INdn.getText();
        qty = INqty.getValue().toString();
        

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO sale_product(spresid,itemid,itemname,qty) VALUES ('"+id+"','"+Did+"','"+Dname+"','"+qty+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        
    
    }
    public void Saleproduct(){
        String id,total,pay,bal;

        id = Dpresnum.getText();
        total = INtotal.getText();
        pay = INpay.getText();
        bal = INbal.getText();
        

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO sales(sapresid,stotal,spay,sbalance) VALUES ('"+id+"','"+total+"','"+pay+"','"+bal+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
    
    
    
    
    }
 
    
   public void Display(){
        RecBillDisplay.setText(RecBillDisplay.getText()+"\n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" Prescription Number  : "+Dpresnum.getText()+"\n/n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== "+"\n\n");
        DefaultTableModel t7 = (DefaultTableModel)INtable.getModel();
        RecBillDisplay.setText(RecBillDisplay.getText()+"DRUG ID"+"\t"+"DRUG NAME"+"\t"+"Quentity"+"\t"+"PRICE"+"\t"+"TOTAL"+"\n\n");
        for (int i = 0; i < INtable.getRowCount();i++ ){
            String id = INtable.getValueAt(i, 0).toString();
            String name = INtable.getValueAt(i, 1).toString();
            String qty = INtable.getValueAt(i, 2).toString();
            String pr = INtable.getValueAt(i, 3).toString();
            String tot = INtable.getValueAt(i, 4).toString();
            RecBillDisplay.setText(RecBillDisplay.getText()+id+"\t"+name+"\t"+qty+"\t"+pr+"\t"+tot+"\n\n");
        }
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tTotal Charge        : Rs. "+INtotal.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tPayment              : Rs. "+INpay.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tBalance               : Rs. "+INbal.getText()+"\n");
        
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \t\t Thank You !!!!! \n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \t\t    Stay Safe \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
    
    }
    public void Header(){
    RecBillDisplay.setText(RecBillDisplay.getText()+"\n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=============== Care + Hospital Management System ============== \n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n");
    
    }
    public void update(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "UPDATE pharm_item set quentity = ? WHERE itemid = ?";
            pst = con.prepareStatement(sql);
            for (int j = 0; j < INtable.getRowCount();j++){
                String itemid = INtable.getValueAt(j, 0).toString();
                String qty = INtable.getValueAt(j, 3).toString();
                
                pst.setString(1, qty);
                pst.setString(2, itemid);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , e);
        }
    
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Dpresnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        INdc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        INdn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        INbal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        INtotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        INpay = new javax.swing.JTextField();
        INqty = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        INsales = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        INtable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecBillDisplay = new javax.swing.JTextArea();
        INadd = new javax.swing.JButton();
        ADPatBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("View Prescription");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 330, 60));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Prescription No.   :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 30));

        Dpresnum.setBackground(new java.awt.Color(108, 122, 137));
        Dpresnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Dpresnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Dpresnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 270, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Drug ID                :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 160, 30));

        INdc.setBackground(new java.awt.Color(108, 122, 137));
        INdc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INdc.setForeground(new java.awt.Color(255, 255, 255));
        INdc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INdcKeyPressed(evt);
            }
        });
        jPanel1.add(INdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 270, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Drug Name          : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 160, 30));

        INdn.setBackground(new java.awt.Color(108, 122, 137));
        INdn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INdn.setForeground(new java.awt.Color(255, 255, 255));
        INdn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INdnKeyPressed(evt);
            }
        });
        jPanel1.add(INdn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 270, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quentity               :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 160, 30));

        INbal.setBackground(new java.awt.Color(108, 122, 137));
        INbal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INbal.setForeground(new java.awt.Color(255, 255, 255));
        INbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INbalActionPerformed(evt);
            }
        });
        jPanel1.add(INbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 190, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total       (Rs) :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 130, 30));

        INtotal.setBackground(new java.awt.Color(108, 122, 137));
        INtotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INtotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(INtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 190, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Balance  (Rs) :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 120, 30));

        INpay.setBackground(new java.awt.Color(108, 122, 137));
        INpay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INpay.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(INpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 190, 30));

        INqty.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(INqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 70, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Payment (Rs):");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 130, 30));

        INsales.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INsales.setText("Sales Update");
        INsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INsalesActionPerformed(evt);
            }
        });
        jPanel1.add(INsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 140, 50));

        print.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 140, 50));

        INtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug ID", "Drug Name", "Quentity", "Price", "Total"
            }
        ));
        jScrollPane1.setViewportView(INtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 350));

        RecBillDisplay.setColumns(20);
        RecBillDisplay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RecBillDisplay.setRows(5);
        jScrollPane2.setViewportView(RecBillDisplay);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 510, 350));

        INadd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        INadd.setText("ADD");
        INadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INaddActionPerformed(evt);
            }
        });
        jPanel1.add(INadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 140, 50));

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
        jPanel1.add(ADPatBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 50));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INaddActionPerformed
        String dcode = INdn.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            String sql = "SELECT * FROM pharm_item WHERE itemname = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, dcode);
            rs = pst.executeQuery();
            
            while(rs.next()){
                int cqty;
                int sprice;
                int qty;
                
                cqty = rs.getInt("quentity");
                sprice = rs.getInt("sellprice");
                
                qty = Integer.parseInt(INqty.getValue().toString());
                
                int total = sprice * qty;
                
                if (qty >= cqty){
                JOptionPane.showMessageDialog(this, "Avaliable Item " +cqty);
                JOptionPane.showMessageDialog(this, "Quentity not Enough");
                
                }else {
                DefaultTableModel t3 = (DefaultTableModel)INtable.getModel();
                t3.addRow(new Object[]{
                    //Dpresnum.getText(),
                    INdc.getText(),
                    INdn.getText(),
                    INqty.getValue().toString(),
                    sprice,
                    total,
                
                });
                int sum = 0;
                for (int i = 0; i<INtable.getRowCount();i++){
                
                sum = sum + Integer.parseInt(INtable.getValueAt(i,4).toString());
                }
                INtotal.setText(Integer.toString(sum));
                INdc.setText("");
                INdn.setText("");
                INqty.setValue(0);
                }
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , e);
        }
        sales1();
        update();
    }//GEN-LAST:event_INaddActionPerformed

    private void INsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INsalesActionPerformed
        int pay = (Integer.parseInt(INpay.getText()));
        int total = (Integer.parseInt(INtotal.getText()));
        
        int bal = pay - total;
        INbal.setText(String.valueOf(bal));
        Display();
        Saleproduct();
    }//GEN-LAST:event_INsalesActionPerformed

    private void ADPatBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADPatBackActionPerformed
        PharmacyviewPres PV = new PharmacyviewPres();
        PV.setVisible(true);
        PV.pack();
        PV.setLocationRelativeTo(null);
        PV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ADPatBackActionPerformed

    private void INbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INbalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INbalActionPerformed

    private void UpdateDocCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_UpdateDocCloseActionPerformed

    private void UpdateDocClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocClose1ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_UpdateDocClose1ActionPerformed

    private void INdcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INdcKeyPressed
       
    }//GEN-LAST:event_INdcKeyPressed

    private void INdnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INdnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String dcode = INdn.getText();
            try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
                String sql = "SELECT * FROM pharm_item WHERE itemname = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, dcode);
                rs = pst.executeQuery();
                if (rs.next() == false){
                    JOptionPane.showMessageDialog(this, " DRUG NOT FOUND ! ");
                }else {
                    String dname = rs.getString("itemid");
                    INdc.setText(dname.trim());
                    INqty.requestFocus();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null , e);
            }

        }
    }//GEN-LAST:event_INdnKeyPressed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            RecBillDisplay.print();
        } catch (PrinterException ex) {
            Logger.getLogger(PharmInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(PharmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADPatBack;
    private javax.swing.JTextField Dpresnum;
    private javax.swing.JButton INadd;
    private javax.swing.JTextField INbal;
    private javax.swing.JTextField INdc;
    private javax.swing.JTextField INdn;
    private javax.swing.JTextField INpay;
    private javax.swing.JSpinner INqty;
    private javax.swing.JButton INsales;
    private javax.swing.JTable INtable;
    private javax.swing.JTextField INtotal;
    private javax.swing.JTextArea RecBillDisplay;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
