package milleniuminvesment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class PayBills extends javax.swing.JFrame {

    private javax.swing.JTextField amountTxt;
    private javax.swing.JLabel backlabel;
    private javax.swing.JLabel balancelabel;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> bill;
    private javax.swing.JComboBox<String> billtype;
    private javax.swing.JLabel branchnamelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JButton pay;
    private javax.swing.JLabel usernamelabel;

    private String username;
    private String branch;
    private String balance;

    private ArrayList<String[]> billItems;

    public PayBills(String username, String branch, String balance) {
        this.username = username;
        this.balance = balance;
        this.branch = branch;
        setMinimumSize(new java.awt.Dimension(935, 794));
        initComponents();
        bg.setBackground(new Color(0, 0, 0, 160));
        balancelabel.setText("Balance - $" + balance);
        branchnamelabel.setText("Branch - " + branch.toUpperCase());
        usernamelabel.setText("Username - " + username);
        billItems = SQLMan.getUserBills(username);
        loadBillTypeCombo();
        bill.setEnabled(false);
        billtype.requestFocus();
        balancelabel.setVisible(false);
    }

    private void loadBillTypeCombo() {
        List<String> getOnlyBillTypes = new ArrayList<>();
        for (String[] item : billItems) {
            String temp = item[0];
            if (!getOnlyBillTypes.contains(temp)) {
                getOnlyBillTypes.add(temp);
            }
        }
        String[] billTypeArray = new String[getOnlyBillTypes.size()];
        for (int i = 0; i < getOnlyBillTypes.size(); i++) {
            billTypeArray[i] = getOnlyBillTypes.get(i);
        }
        billtype.setModel(new javax.swing.DefaultComboBoxModel<>(billTypeArray));
    }

    private void loadBillCombo() {
        bill.setEnabled(true);
        List<String> billsSet = new ArrayList<>();
        String selectedBillType = ((String) billtype.getSelectedItem()).toLowerCase();
        for (String[] item : billItems) {
            String billTypeTemp = item[0];
            String billTemp = item[1];
            if (billTypeTemp.toLowerCase().equals(selectedBillType)) {
                billsSet.add(billTemp.toUpperCase());
            }
        }
        String[] show = new String[billsSet.size()];
        for (int i = 0; i < billsSet.size(); i++) {
            show[i] = billsSet.get(i);
        }
        bill.setModel(new javax.swing.DefaultComboBoxModel<>(show));
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();
        branchnamelabel = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        billtype = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        bill = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        amountTxt = new javax.swing.JTextField();
        pay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                backlabelMouseReleased(evt);
            }
        });

        logoutlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/logout.png")));
        logoutlabel.setToolTipText("logout");
        logoutlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutlabelMouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biller Type");

        billtype.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        billtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"         -- select category --", "ELECTRICITY", "FINANCE", "GOVERNMENT", "INSURANCE", "EDUCATION", "TELEPHONE", "TELEVISION", "WATER", "OTHER"}));
        billtype.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                billtypeMouseReleased(evt);
            }
        });
        billtype.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billtypeKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Biller");

        bill.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        bill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"               -- none -- "}));
        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loadBillCombo();
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amount");

        amountTxt.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        amountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountTxt.setToolTipText("Enter Account Number");

        pay.setBackground(new java.awt.Color(0, 0, 255));
        pay.setFont(new java.awt.Font("Yu Gothic", 0, 36));
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setText("Pay Bill");
        pay.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 578, Short.MAX_VALUE)
                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(30, 30, 30))
                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(bgLayout.createSequentialGroup()
                                        .add(263, 263, 263)
                                        .add(pay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 358, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(279, 279, 279))
                                .add(bgLayout.createSequentialGroup()
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(bgLayout.createSequentialGroup()
                                                        .add(282, 282, 282)
                                                        .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(bgLayout.createSequentialGroup()
                                                        .add(179, 179, 179)
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
                                                                                .add(amountTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                .add(bill, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                                .add(bgLayout.createSequentialGroup()
                                                        .add(307, 307, 307)
                                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 266, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(bgLayout.createSequentialGroup()
                                                                        .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                        .add(83, 83, 83)))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(169, 169, 169)
                                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(468, Short.MAX_VALUE))
                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(bgLayout.createSequentialGroup()
                                        .add(92, 92, 92)
                                        .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(88, 88, 88)
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(billtype, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(39, 39, 39)
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(bill, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(29, 29, 29)
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(amountTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(57, 57, 57)
                                        .add(pay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(64, Short.MAX_VALUE)))
        );

        getContentPane().add(bg);
        bg.setBounds(10, 10, 900, 730);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wa.jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 920, 757);

        pack();
        setLocationRelativeTo(null);
    }

    private void backlabelMouseReleased(java.awt.event.MouseEvent evt) {
        CustomerMenu customerMenu = new CustomerMenu(username, branch, balance);
        this.setVisible(false);
        customerMenu.setVisible(true);
    }

    private void logoutlabelMouseReleased(java.awt.event.MouseEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }

    private void billtypeMouseReleased(java.awt.event.MouseEvent evt) {
        loadBillCombo();
    }

    private void billtypeKeyReleased(java.awt.event.KeyEvent evt) {
        loadBillCombo();
    }

    private void payActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO -> ERROR CUSTOMER BALANCE UPDATE
        if (amountTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter amount");
            return;
        }
        double amount = 0;
        try {
            amount = Double.parseDouble(amountTxt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return;
        }
        if (amount > Double.parseDouble(balance)) {
            JOptionPane.showMessageDialog(null, "Insufficient balance pay!");
            return;
        }
        String newBalance = SQLMan.payBills(username, String.valueOf(amount), (String) billtype.getSelectedItem(), (String) bill.getSelectedItem());
        if (newBalance.equals("0") && Double.parseDouble(balance) != amount) {
            JOptionPane.showMessageDialog(null, "Something error");
            this.setVisible(false);
            new CustomerMenu(username, branch, newBalance).setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null,"Successfully Transferred");
        this.setVisible(false);
        new CustomerMenu(username, branch, newBalance).setVisible(true);
    }


}
