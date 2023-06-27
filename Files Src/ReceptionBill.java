import hospitalsystem.DBConnect;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ReceptionBill extends javax.swing.JFrame {

    PreparedStatement pst = null;
    CreateStatement cs = null;
    ResultSet rs = null;
    
    public ReceptionBill() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connection con = DBConnect.connect();
        AutoId();
        Header();
        
    }

    public void search(){
    String srch = BPid.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
            
            String sql = "SELECT * FROM admin_patient WHERE pid=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1,BPid.getText());
            rs=pst.executeQuery();
           
            if(rs.next()){
        BPid.setText(rs.getString("pid"));
        BPname.setText(rs.getString("pfname"));
        BPadate.setText(rs.getString("admitdate"));
        BPrnum.setText(rs.getString("proom"));
        
       
            
            }else{
                JOptionPane.showMessageDialog(null , "SORRY RECORD NOT FOUND !");
            }
            
            
        } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null , e);
        }
    
    
    }
    public void Bill(){
        String Bdate = BPdate.getText();
        float SCharge = Float.parseFloat(BPs.getText());
        float DCharge = Float.parseFloat(BPd.getText());
        float RCharge = Float.parseFloat(BPrc.getText());
        float Rnum = Float.parseFloat(BPrdays.getText());
        float RTCharge = Rnum * RCharge;
        String roomtotalc = Float.toString(RTCharge);
        BPrtc.setText(roomtotalc);
        float RTC = Float.parseFloat(BPrtc.getText());
        float total = RTC + SCharge + DCharge;
        String totalcharge = Float.toString(total);
        BPtc.setText(totalcharge);

}
    public void Insert(){
     String id,billnum,billdate,SCharge,DCharge,RCharge,Rnum,roomtotalc,totalcharge,Paymentmethod;

        id = BPid.getText();
        billnum = BPnum.getText();
        billdate = BPdate.getText();
        SCharge = BPs.getText();
        DCharge = BPd.getText();
        RCharge = BPrc.getText();
        Paymentmethod = BPpayment.getSelectedItem().toString();
        Rnum = BPrdays.getText();
        roomtotalc = BPrtc.getText();
        totalcharge = BPtc.getText();

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO billing(billnum, billdate, scharge, dcharge, rcharge, roomdays, rtcharge, paymantmethod, tcharge, pid) VALUES ('"+billnum+"','"+billdate+"','"+SCharge+"','"+DCharge+"','"+RCharge+"','"+Rnum+"','"+roomtotalc+"','"+Paymentmethod+"','"+totalcharge+"','"+id+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
        
    
    }
    public void AutoId(){
    try {
        Class.forName("java.sql.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        String sql = "SELECT MAX(billnum) FROM billing";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        rs.getString("MAX(billnum)");
        
        if(rs.getString("MAX(billnum)")==null){
        BPnum.setText("B0001");
        
        }else{
            long id = Long.parseLong(rs.getString("MAX(billnum)").substring(2,rs.getString("MAX(billnum)").length()));
            id++;
            BPnum.setText("B"+ String.format("%04d", id));
        
        }
            
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null , e);
        
    }

}
    public void clear(){
        
        BPid.setText(null);
        BPdate.setText(null);
        BPs.setText(null);
        BPd.setText(null);
        BPrc.setText(null);
        BPpayment.setSelectedItem(null);
        BPrdays.setText(null);
        BPrtc.setText(null);
        BPtc.setText(null);
        BPname.setText(null);
        BPadate.setText(null);
        BPddate.setText(null);
        BPrnum.setText(null);
    
    
    }
    public void Display(){
        RecBillDisplay.setText(RecBillDisplay.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"************************* Patient Details ************************* \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" Bill Date  : "+BPdate.getText()+"\t\t Bill Number : "+BPnum.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" Patient ID : "+BPid.getText()+"\t Patient Name : "+BPname.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" Admit Date : "+BPadate.getText()+"\t Discharge Date : "+BPddate.getText()+"\n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"************************* Billing Details ************************* \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tRoom Charge (Per Day) : Rs. "+BPrc.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tNo. of Days                    : "+BPrdays.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tTotal Room Charge       : Rs. "+BPrtc.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tService Charge               : Rs. "+BPs.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tDoctor Charge               : Rs. "+BPd.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tTotal Charge                  : Rs. "+BPtc.getText()+"\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \tPayment Method            : "+BPpayment.getSelectedItem()+"\n\n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \t\t Thank You !!!!! \n");
        RecBillDisplay.setText(RecBillDisplay.getText()+" \t\t    Stay Safe \n\n");
        RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
    
    }
    public void Header(){
    RecBillDisplay.setText(RecBillDisplay.getText()+"\n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n\n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=============== Care + Hospital Management System ============== \n\n");
    RecBillDisplay.setText(RecBillDisplay.getText()+"=========================================================== \n");
    
    }
    public void discharge(){
        String id = BPid.getText();
        String admit = BPadate.getText();
        String discharge = BPddate.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");

            String sql = "INSERT INTO patientdischarge(pid,admitdate,dischargedate) VALUES ('"+id+"','"+admit+"','"+discharge+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null , e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecBillDisplay = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        BPrnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BPdate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BPname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BPddate = new javax.swing.JTextField();
        BPadate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        BPid = new javax.swing.JTextField();
        BPnum = new javax.swing.JTextField();
        BPrdays = new javax.swing.JTextField();
        BPs = new javax.swing.JTextField();
        BPrc = new javax.swing.JTextField();
        BPd = new javax.swing.JTextField();
        BPrtc = new javax.swing.JTextField();
        BPpayment = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        BPtc = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        history = new javax.swing.JButton();
        search = new javax.swing.JButton();
        display = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        RBBack = new javax.swing.JButton();
        UpdateDocClose = new javax.swing.JButton();
        UpdateDocClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1240, 720));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Billing Information");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 350, 60));

        RecBillDisplay.setColumns(20);
        RecBillDisplay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RecBillDisplay.setRows(5);
        jScrollPane1.setViewportView(RecBillDisplay);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 120, 500, 500));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Discharge Date      :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 170, 30));

        BPrnum.setBackground(new java.awt.Color(108, 122, 137));
        BPrnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPrnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPrnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 130, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Patient Id              :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 30));

        BPdate.setBackground(new java.awt.Color(108, 122, 137));
        BPdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 200, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Patient Name        :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 200, 30));

        BPname.setBackground(new java.awt.Color(108, 122, 137));
        BPname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPname.setForeground(new java.awt.Color(255, 255, 255));
        BPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPnameActionPerformed(evt);
            }
        });
        jPanel2.add(BPname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 270, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Doctor Charge (Rs.)                 :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 270, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Room No.  :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 110, 30));

        BPddate.setBackground(new java.awt.Color(108, 122, 137));
        BPddate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPddate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 190, 30));

        BPadate.setBackground(new java.awt.Color(108, 122, 137));
        BPadate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPadate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPadate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 190, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Admit Date            :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 180, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Bill No.     :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 255));
        jLabel14.setText("Payment Details");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 180, 40));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room Charge (One Day) (Rs.) :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 270, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Service Charge (Rs.)                :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 280, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Payment Method                       :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 270, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Billing Date             :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 180, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("No. of Days   :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 130, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total Room Charge          (Rs.) :");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 280, 30));

        BPid.setBackground(new java.awt.Color(108, 122, 137));
        BPid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 270, 30));

        BPnum.setBackground(new java.awt.Color(108, 122, 137));
        BPnum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPnum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 150, 30));

        BPrdays.setBackground(new java.awt.Color(108, 122, 137));
        BPrdays.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPrdays.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPrdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 130, 30));

        BPs.setBackground(new java.awt.Color(108, 122, 137));
        BPs.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPs.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPs, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 270, 30));

        BPrc.setBackground(new java.awt.Color(108, 122, 137));
        BPrc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPrc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPrc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 130, 30));

        BPd.setBackground(new java.awt.Color(108, 122, 137));
        BPd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPd.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 270, 30));

        BPrtc.setBackground(new java.awt.Color(108, 122, 137));
        BPrtc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPrtc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPrtc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 630, 270, 30));

        BPpayment.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPpayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cash", "Check", "Credit Card", "Debit Card" }));
        jPanel2.add(BPpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 180, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Total Charge                     (Rs.) :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 280, 30));

        BPtc.setBackground(new java.awt.Color(108, 122, 137));
        BPtc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BPtc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BPtc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 670, 270, 30));

        print.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel2.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 640, 100, 40));

        history.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        jPanel2.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 640, 100, 40));

        search.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 100, 30));

        display.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        display.setText("Calculate & Display");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });
        jPanel2.add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 210, 40));

        clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 640, 140, 40));

        RBBack.setBackground(new java.awt.Color(255, 255, 255));
        RBBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RBBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoadingscreenHM/Assets/previous (1).png"))); // NOI18N
        RBBack.setText("Back");
        RBBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RBBack.setBorderPainted(false);
        RBBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBBackMouseClicked(evt);
            }
        });
        RBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBBackActionPerformed(evt);
            }
        });
        jPanel2.add(RBBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, 50));

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
        jPanel2.add(UpdateDocClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 50, 25));

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
        jPanel2.add(UpdateDocClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 50, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BPnameActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       search();
    }//GEN-LAST:event_searchActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            RecBillDisplay.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ReceptionBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        Bill();
        Insert();
        Display();
        discharge();
        AutoId();
       
    }//GEN-LAST:event_displayActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void RBBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBBackMouseClicked

    }//GEN-LAST:event_RBBackMouseClicked

    private void RBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBBackActionPerformed
        ReceptionistPanal RP1 = new ReceptionistPanal();
        RP1.setVisible(true);
        RP1.pack();
        RP1.setLocationRelativeTo(null);
        RP1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RBBackActionPerformed

    private void UpdateDocCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_UpdateDocCloseActionPerformed

    private void UpdateDocClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDocClose1ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_UpdateDocClose1ActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        BillHistory BH = new BillHistory();
        BH.setVisible(true);
        BH.pack();
        BH.setLocationRelativeTo(null);
        BH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_historyActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BPadate;
    private javax.swing.JTextField BPd;
    private javax.swing.JTextField BPdate;
    private javax.swing.JTextField BPddate;
    private javax.swing.JTextField BPid;
    private javax.swing.JTextField BPname;
    private javax.swing.JTextField BPnum;
    private javax.swing.JComboBox<String> BPpayment;
    private javax.swing.JTextField BPrc;
    private javax.swing.JTextField BPrdays;
    private javax.swing.JTextField BPrnum;
    private javax.swing.JTextField BPrtc;
    private javax.swing.JTextField BPs;
    private javax.swing.JTextField BPtc;
    private javax.swing.JButton RBBack;
    private javax.swing.JTextArea RecBillDisplay;
    private javax.swing.JButton UpdateDocClose;
    private javax.swing.JButton UpdateDocClose1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear;
    private javax.swing.JButton display;
    private javax.swing.JButton history;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
