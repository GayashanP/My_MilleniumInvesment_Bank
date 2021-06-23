package milleniuminvesment;

import javax.swing.*;
import java.awt.*;


/**
 * @author pgpcg
 */
public class CustomerMenu extends javax.swing.JFrame {

    private final String username;
    private final String branch;
    private String balance;
    private javax.swing.JButton addbiller;
    private javax.swing.JLabel balancelabel;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel branchnamelabel;
    private javax.swing.JButton changepass;
    private javax.swing.JLabel datelabel;
    private javax.swing.JButton deposit;
    private javax.swing.JPanel front2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel maillabel;
    private javax.swing.JButton paybills;
    private javax.swing.JLabel refreshlabel;
    private javax.swing.JButton sendmoney;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JButton viewtransactions;
    private javax.swing.JButton withdraw;

    public CustomerMenu(String username, String branch, String balance) {
        this.balance = balance;
        this.username = username;
        this.branch = branch;
        this.setTitle(username + " MENU");
        initComponents();
        bg.setBackground(new Color(0, 0, 0, 160));
        datelabel.setText("Date - " + Common.getToday());
        balancelabel.setText("Balance - $" + balance);
        branchnamelabel.setText("Branch - " + branch.toUpperCase());
        usernamelabel.setText("Username - " + username);

        if (SQLMan.hasMail(username)) {
            maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailyes.png")));
        } else {
            maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailno.png")));
        }
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        branchnamelabel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        deposit = new javax.swing.JButton();
        withdraw = new javax.swing.JButton();
        sendmoney = new javax.swing.JButton();
        changepass = new javax.swing.JButton();
        viewtransactions = new javax.swing.JButton();
        addbiller = new javax.swing.JButton();
        paybills = new javax.swing.JButton();
        refreshlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        front2 = new javax.swing.JPanel();
        maillabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1057, 809));
        setResizable(false);
        getContentPane().setLayout(null);

        bg.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        branchnamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18));
        branchnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        branchnamelabel.setText("Branch Name");

        datelabel.setFont(new java.awt.Font("Calibri", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelabel.setText("DATE");

        balancelabel.setFont(new java.awt.Font("Simplex_IV25", 1, 24));
        balancelabel.setForeground(new java.awt.Color(255, 0, 51));
        balancelabel.setText("Balance - ");

        usernamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36));
        usernamelabel.setForeground(new java.awt.Color(255, 204, 204));
        usernamelabel.setText("Customer Username");

        deposit.setBackground(new java.awt.Color(51, 0, 51));
        deposit.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setText("Deposit");
        deposit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        withdraw.setBackground(new java.awt.Color(51, 0, 51));
        withdraw.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        withdraw.setForeground(new java.awt.Color(255, 255, 255));
        withdraw.setText("Withdraw");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });

        sendmoney.setBackground(new java.awt.Color(51, 0, 51));
        sendmoney.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        sendmoney.setForeground(new java.awt.Color(255, 255, 255));
        sendmoney.setText("Send Money");
        sendmoney.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMoneyActionPerformed(evt);
            }
        });

        changepass.setBackground(new java.awt.Color(51, 0, 51));
        changepass.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        changepass.setForeground(new java.awt.Color(255, 255, 255));
        changepass.setText("Change Password");
        changepass.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassActionPerformed(evt);
            }
        });

        viewtransactions.setBackground(new java.awt.Color(51, 0, 51));
        viewtransactions.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        viewtransactions.setForeground(new java.awt.Color(255, 255, 255));
        viewtransactions.setText("View Transactions");
        viewtransactions.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTransactionsActionPerformed(evt);
            }
        });

        addbiller.setBackground(new java.awt.Color(51, 0, 51));
        addbiller.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        addbiller.setForeground(new java.awt.Color(255, 255, 255));
        addbiller.setText("Add Biller");
        addbiller.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbillerActionPerformed(evt);
            }
        });

        paybills.setBackground(new java.awt.Color(51, 0, 51));
        paybills.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        paybills.setForeground(new java.awt.Color(255, 255, 255));
        paybills.setText("Pay Bills");
        paybills.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybillsActionPerformed(evt);
            }
        });

        refreshlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/refresh.png")));
        refreshlabel.setToolTipText("refresh balance");
        refreshlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshlabelMouseReleased(evt);
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

        maillabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailno.png")));
        maillabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maillabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                maillabelMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout front2Layout = new org.jdesktop.layout.GroupLayout(front2);
        front2.setLayout(front2Layout);
        front2Layout.setHorizontalGroup(
                front2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, front2Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .add(maillabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        front2Layout.setVerticalGroup(
                front2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, front2Layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(maillabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(37, 37, 37)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 315, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                .add(0, 0, Short.MAX_VALUE)))
                                                .add(108, 108, 108)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(front2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(20, 20, 20)
                                                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                .add(23, 23, 23)))
                                .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(viewtransactions, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(deposit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(withdraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(169, 169, 169)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(paybills, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(addbiller, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(sendmoney, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(132, 132, 132))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(bgLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(datelabel)
                                                .add(18, 18, 18)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(front2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(71, 71, 71)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(deposit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(addbiller, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(162, 162, 162)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(withdraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(paybills, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 34, Short.MAX_VALUE)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(sendmoney, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(28, 28, 28)
                                .add(viewtransactions, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(73, 73, 73))
        );

        getContentPane().add(bg);
        bg.setBounds(20, 20, 1010, 730);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wall1.png")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1046, 772);

        pack();
        setLocationRelativeTo(null);
    }

    private void updateBalance(double amount, String description) {
        String newBalance = SQLMan.updateBalanceAndGetNew(username, amount, description);
        this.balance = newBalance;
        balancelabel.setText("Balance - $" + newBalance);

    }

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {
        withdrawAndDeposit(false);
    }

    private void withdrawAndDeposit(boolean isWithdraw) {
        String amountTxt = JOptionPane.showInputDialog("Enter amount - ");
        double amount = 0;
        try {
            amount = Double.parseDouble(amountTxt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error input amount!");
            return;
        }
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Enter positive amount!");
            return;
        }
        if (isWithdraw && amount > Double.parseDouble(balance)) {
            JOptionPane.showMessageDialog(null, "Insufficient amount!");
            return;
        }
        updateBalance(amount, isWithdraw ? "withdraw" : "deposit");
    }

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {
        withdrawAndDeposit(true);
    }

    private void sendMoneyActionPerformed(java.awt.event.ActionEvent evt) {
        String to = JOptionPane.showInputDialog("Enter the receiver");
        String amountTxt = JOptionPane.showInputDialog("Enter amount");
        double amount = 0;
        try {
            amount = Double.parseDouble(amountTxt);
        } catch (Exception e) {
            System.out.println("Error input amount!");
            return;
        }
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Enter positive amount!");
            return;
        }
        SQLMan.sendMoney(username, amount, to);
    }

    private void changePassActionPerformed(java.awt.event.ActionEvent evt) {
        String current = JOptionPane.showInputDialog("Enter current password");
        if ("".equals(current)) {
            JOptionPane.showMessageDialog(null, "Entered Null!");
            return;
        }
        String newPassword = JOptionPane.showInputDialog("Enter new password");
        if ("".equals(newPassword)) {
            JOptionPane.showMessageDialog(null, "Entered Null!");
            return;
        }
        String newPasswordAgain = JOptionPane.showInputDialog("Enter new password again");
        if ("".equals(newPasswordAgain)) {
            JOptionPane.showMessageDialog(null, "Entered Null!");
            return;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            JOptionPane.showMessageDialog(null, "New password aren't match!");
            return;
        }
        SQLMan.changePassword(username, newPassword, current);
    }

    private void viewTransactionsActionPerformed(java.awt.event.ActionEvent evt) {
        Transactions transactions = new Transactions(username, branch, balance);
        this.setVisible(false);
        transactions.setVisible(true);
    }

    private void addbillerActionPerformed(java.awt.event.ActionEvent evt) {
        AddBill addBill = new AddBill(username, branch, balance);
        this.setVisible(false);
        addBill.setVisible(true);
    }

    private void paybillsActionPerformed(java.awt.event.ActionEvent evt) {
        PayBills payBills = new PayBills(username, branch, balance);
        this.setVisible(false);
        payBills.setVisible(true);
    }

    private void refreshlabelMouseReleased(java.awt.event.MouseEvent evt) {
        String newBlanace = SQLMan.calculateBalanceAndUpdateCommonCustomerTable(username);
        balancelabel.setText("Balance - $" + newBlanace);
        this.balance = newBlanace;
    }

    private void logoutlabelMouseReleased(java.awt.event.MouseEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }

    private void maillabelMouseReleased(java.awt.event.MouseEvent evt) {
        MailBox mailBox = new MailBox(new String[]{"CUSTOMER", username, branch, balance});
        this.setVisible(false);
        mailBox.setVisible(true);
    }


}
