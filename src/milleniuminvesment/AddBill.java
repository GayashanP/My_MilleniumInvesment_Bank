package milleniuminvesment;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @author Gayashan Pananwala
 */

public class AddBill extends javax.swing.JFrame {


    private String username;
    private String branch;
    private String balance;
    private javax.swing.JTextField accnumber;
    private javax.swing.JButton add;
    private javax.swing.JLabel backlabel;
    private javax.swing.JLabel balancelabel;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> billsBox;
    private javax.swing.JComboBox<String> billtype;
    private javax.swing.JLabel branchnamelabel;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel usernamelabel;

    public AddBill(String username, String branch, String balance) {

        initComponents();
        this.balance = balance;
        this.username = username;
        this.branch = branch;
        datelabel.setText("Date - " + Common.getToday());
        bg.setBackground(new Color(0, 0, 0, 100));
        billsBox.setEnabled(false);
        balancelabel.setText("Balance - " + balance);
        branchnamelabel.setText("Branch - " + branch);
        usernamelabel.setText("Username - " + username);

    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();
        branchnamelabel = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        billtype = new javax.swing.JComboBox<>(SQLMan.getBillType());
        billsBox = new javax.swing.JComboBox<>();
        accnumber = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1066, 738));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        usernamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36));
        usernamelabel.setForeground(new java.awt.Color(255, 204, 204));
        usernamelabel.setText("Customer Username");

        balancelabel.setFont(new java.awt.Font("Simplex_IV25", 1, 24));
        balancelabel.setForeground(new java.awt.Color(255, 0, 51));
        balancelabel.setText("Balance - ");

        branchnamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18));
        branchnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        branchnamelabel.setText("Branch Name");

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/back.png")));
        backlabel.setToolTipText("go back");
        backlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backLabelMouseReleased(evt);
            }
        });

        logoutlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/logout.png")));
        logoutlabel.setToolTipText("logout");
        logoutlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutLabelMouseReleased(evt);
            }
        });

        billtype.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        billtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-- select category --", "ELECTRICITY", "FINANCE", "GOVERNMENT", "INSURANCE", "EDUCATION", "TELEPHONE", "TELEVISION", "WATER", "OTHER"}));
        billtype.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                billTypeMouseReleased(evt);
            }
        });
        billtype.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billTypeKeyReleased(evt);
            }
        });
        billsBox.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        billsBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setupBills();
            }
        });

        accnumber.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        accnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        accnumber.setToolTipText("Enter Account Number");

        add.setBackground(new java.awt.Color(0, 0, 255));
        add.setFont(new java.awt.Font("Yu Gothic", 0, 36));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add New Biller");
        add.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biller Type");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Account Number");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Biller");

        datelabel.setFont(new java.awt.Font("Calibri", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelabel.setText("DATE");

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(30, 30, 30)
                                                .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(167, 167, 167)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(63, 63, 63)
                                                                .add(billtype, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 204, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                .add(39, 39, 39)
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(accnumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(billsBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(295, 295, 295)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 266, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 161, Short.MAX_VALUE)
                                                                .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(31, 31, 31)
                                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(83, 83, 83))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .add(bgLayout.createSequentialGroup()
                                .add(251, 251, 251)
                                .add(add, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 358, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(28, 28, 28)
                                                                .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .add(datelabel)))
                                                .add(18, 18, 18)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(44, 44, 44)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(billtype, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(39, 39, 39)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(billsBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(29, 29, 29)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(accnumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(57, 57, 57)
                                .add(add, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(bg);
        bg.setBounds(10, 10, 1030, 680);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/fresh-green-grass.jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1049, 699);

        pack();
        setLocationRelativeTo(null);
    }

    private void backLabelMouseReleased(java.awt.event.MouseEvent evt) {
        CustomerMenu customerMenu = new CustomerMenu(username, branch, String.valueOf(balance));
        this.setVisible(false);
        customerMenu.setVisible(true);
    }

    private void logoutLabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }

    private void billTypeMouseReleased(java.awt.event.MouseEvent evt) {
        if(billtype.getSelectedIndex() != 0) {
            setupBills();
        }
    }

    private void billTypeKeyReleased(java.awt.event.KeyEvent evt) {
        if(billtype.getSelectedIndex() != 0) {
            setupBills();
        }
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        boolean billSelected = billsBox.getSelectedIndex() == 0;
        boolean billTypeSelected = billtype.getSelectedIndex() == 0;
        boolean accNumberSelected = accnumber.getText().length() == 0;
        if (billSelected || billTypeSelected || accNumberSelected) {
            JOptionPane.showMessageDialog(null, "Fill Everything!");
            billtype.setSelectedIndex(0);
            billsBox.setSelectedIndex(0);
            accnumber.setText("");
            billtype.requestFocus();
            return;
        }
        String billTypeString = (String) billtype.getSelectedItem();
        String billString = (String) billsBox.getSelectedItem();
        String accountNumberString = accnumber.getText();

        if(SQLMan.addNewBill(username,billString,billTypeString,accountNumberString)){
            JOptionPane.showMessageDialog(null, "Successfully Added new Bill");
            CustomerMenu customerMenu = new CustomerMenu(username, branch, String.valueOf(balance));
            this.setVisible(false);
            customerMenu.setVisible(true);
        }
        else {
            billtype.setSelectedIndex(0);
            billsBox.setSelectedIndex(0);
            accnumber.setText("");
            billtype.requestFocus();
        }
    }

    private void setupBills() {
        if (billtype.getSelectedIndex() != 0) {
            String[] results = SQLMan.getBills((String) billtype.getSelectedItem());
            billsBox.setModel(new javax.swing.DefaultComboBoxModel<>(results));
            billsBox.setEnabled(true);
        }
    }


}
