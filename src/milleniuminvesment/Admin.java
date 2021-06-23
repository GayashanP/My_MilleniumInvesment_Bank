package milleniuminvesment;

import milleniuminvesment.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Gayashan Pananwala
 */

public class Admin extends javax.swing.JFrame {

    private javax.swing.JLabel billerbalancelabel;
    private javax.swing.JLabel billertypeslabel;
    private javax.swing.JLabel brancheslabel;
    private javax.swing.JButton changetax;
    private javax.swing.JButton customerschanges;
    private javax.swing.JLabel customerslabel;
    private javax.swing.JLabel datelabel;
    private javax.swing.JCheckBox enddatecheck;
    private javax.swing.JPanel front1;
    private javax.swing.JPanel front2;
    private javax.swing.JPanel front3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel maillabel;
    private javax.swing.JButton removeBillBtn;
    private javax.swing.JButton billLog;
    private javax.swing.JButton addBillerBtn;
    private javax.swing.JLabel managerslabel;
    private javax.swing.JTextField newtax;
    private javax.swing.JComboBox<String> nextdays;
    private javax.swing.JComboBox<String> nextmonths;
    private javax.swing.JComboBox<String> nextyear;
    private javax.swing.JLabel taxlabel;
    private javax.swing.JLabel taxlabel1;
    private javax.swing.JLabel taxlabel2;
    private javax.swing.JLabel taxlabel3;
    private javax.swing.JLabel wallpaper;
    private javax.swing.JLabel worthlabel;

    public Admin() {
        initComponents();
        front1.setBackground(new Color(0, 0, 0, 200));
        front2.setBackground(new Color(0, 0, 0, 150));
        front3.setBackground(new Color(0, 0, 0, 150));
        datelabel.setText("Date - \t\t " + Common.getToday());
        this.setTitle("ADMIN");
        String[] nextYears = Common.getNextYears();

        nextyear.setModel(new javax.swing.DefaultComboBoxModel<>(nextYears));
        nextdays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-- select day --"}));
        nextmonths.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-- select month --"}));

        nextyear.setEnabled(false);
        nextmonths.setEnabled(false);
        nextdays.setEnabled(false);

        if (SQLMan.hasMail("admin")) {
            maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailyes.png")));
        } else {
            maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailno.png")));
        }

        generateSummary();
    }

    private void generateSummary() {
        String[] summary = SQLMan.getAdminSummary();

        brancheslabel.setText("Branches - \t " + summary[0]);
        billertypeslabel.setText("Bills Types - \t " + summary[1]);
        billerbalancelabel.setText("Bill Balance - $" + summary[2]);
        customerslabel.setText("Customers - \t " + summary[3]);
        managerslabel.setText("Managers - \t " + summary[4]);
        worthlabel.setText("Worth - \t $" + summary[5]);
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        front1 = new javax.swing.JPanel();
        customerslabel = new javax.swing.JLabel();
        brancheslabel = new javax.swing.JLabel();
        managerslabel = new javax.swing.JLabel();
        worthlabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        billertypeslabel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        billerbalancelabel = new javax.swing.JLabel();
        customerschanges = new javax.swing.JButton();
        removeBillBtn = new javax.swing.JButton();
        addBillerBtn = new javax.swing.JButton();
        billLog = new javax.swing.JButton();
        front2 = new javax.swing.JPanel();
        maillabel = new javax.swing.JLabel();
        front3 = new javax.swing.JPanel();
        taxlabel = new javax.swing.JLabel();
        newtax = new javax.swing.JTextField();
        changetax = new javax.swing.JButton();
        enddatecheck = new javax.swing.JCheckBox();
        nextyear = new javax.swing.JComboBox<>();
        nextmonths = new javax.swing.JComboBox<>();
        nextdays = new javax.swing.JComboBox<>();
        taxlabel1 = new javax.swing.JLabel();
        taxlabel2 = new javax.swing.JLabel();
        taxlabel3 = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1047, 799));
        setResizable(false);
        setSize(new java.awt.Dimension(1047, 799));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 10, 232, 228);

        customerslabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        customerslabel.setForeground(new java.awt.Color(255, 255, 255));
        customerslabel.setText("Customers - ");

        brancheslabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        brancheslabel.setForeground(new java.awt.Color(255, 255, 255));
        brancheslabel.setText("Branches - ");

        managerslabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        managerslabel.setForeground(new java.awt.Color(255, 255, 255));
        managerslabel.setText("Managers -");

        worthlabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        worthlabel.setForeground(new java.awt.Color(255, 255, 255));
        worthlabel.setText("Worth - ");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel5.setForeground(new java.awt.Color(153, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SUMMARY");

        billertypeslabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        billertypeslabel.setForeground(new java.awt.Color(255, 255, 255));
        billertypeslabel.setText("Biller Types - ");

        datelabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setText("Date - ");

        billerbalancelabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        billerbalancelabel.setForeground(new java.awt.Color(255, 255, 255));
        billerbalancelabel.setText("Biller Balance -");

        org.jdesktop.layout.GroupLayout front1Layout = new org.jdesktop.layout.GroupLayout(front1);
        front1.setLayout(front1Layout);
        front1Layout.setHorizontalGroup(
                front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front1Layout.createSequentialGroup()
                                .add(32, 32, 32)
                                .add(front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(brancheslabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(front1Layout.createSequentialGroup()
                                                .add(front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                        .add(billertypeslabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(billerbalancelabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                                        .add(customerslabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(managerslabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(worthlabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, front1Layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 134, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(51, 51, 51))
        );
        front1Layout.setVerticalGroup(
                front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front1Layout.createSequentialGroup()
                                .add(33, 33, 33)
                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(27, 27, 27)
                                .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(brancheslabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(billertypeslabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(billerbalancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(customerslabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(managerslabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(worthlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(front1);
        front1.setBounds(750, 20, 260, 350);

        customerschanges.setFont(new java.awt.Font("Dialog", 0, 24));
        customerschanges.setText("View / Modify Customers");
        customerschanges.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersChangesActionPerformed(evt);
            }
        });
        getContentPane().add(customerschanges);
        customerschanges.setBounds(60, 220, 310, 40);

        removeBillBtn.setFont(new java.awt.Font("Dialog", 0, 24));
        removeBillBtn.setText("Remove Biller");
        getContentPane().add(removeBillBtn);
        removeBillBtn.setBounds(60, 440, 310, 40);
        removeBillBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBillActionPerformed(e);
            }
        });

        addBillerBtn.setFont(new java.awt.Font("Dialog", 0, 24));
        addBillerBtn.setText("Add Biller");
        getContentPane().add(addBillerBtn);
        addBillerBtn.setBounds(60, 380, 310, 40);
        addBillerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBillBtnActionPerformed(e);
            }
        });

        billLog.setFont(new java.awt.Font("Dialog", 0, 24));
        billLog.setText("Bills Log");
        getContentPane().add(billLog);
        billLog.setBounds(60, 280, 310, 40);
        billLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billLogActionPerformed(e);
            }
        });

        maillabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maillabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailno.png")));
        maillabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maillabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mailLabelMouseReleased(evt);
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

        getContentPane().add(front2);
        front2.setBounds(40, 30, 110, 100);

        taxlabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        taxlabel.setForeground(new java.awt.Color(255, 255, 255));
        taxlabel.setText("Year");

        newtax.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        newtax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newtax.setToolTipText("Enter Account Number");
        newtax.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                newTaxKeyReleased(e);
            }
        });

        changetax.setFont(new java.awt.Font("Dialog", 0, 24));
        changetax.setText("Change Tax Rate");
        changetax.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTaxActionPerformed(evt);
            }
        });

        enddatecheck.setFont(new java.awt.Font("Dialog", 0, 14));
        enddatecheck.setForeground(new java.awt.Color(0, 0, 0));
        enddatecheck.setText("End Date");
        enddatecheck.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateCheckActionPerformed(evt);
            }
        });
        enddatecheck.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                endDateCheckKeyReleasedPerformed(e);
            }
        });

        nextyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        nextyear.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextYearActionPerformed(evt);
            }
        });
        nextyear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                nextYearMouseEntered(e);
            }
        });

        nextmonths.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        nextmonths.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMonthsMouseEntered(evt);
            }
        });
        nextmonths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextMonthActionPerformed();
            }
        });


        nextdays.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextDaysMouseEntered(evt);
            }
        });
        nextdays.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextDaysActionPerformed(evt);
            }
        });

        taxlabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        taxlabel1.setForeground(new java.awt.Color(255, 255, 255));
        taxlabel1.setText("Current Tax Rate - ");

        taxlabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        taxlabel2.setForeground(new java.awt.Color(255, 255, 255));
        taxlabel2.setText("Month");

        taxlabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        taxlabel3.setForeground(new java.awt.Color(255, 255, 255));
        taxlabel3.setText("Day");

        org.jdesktop.layout.GroupLayout front3Layout = new org.jdesktop.layout.GroupLayout(front3);
        front3.setLayout(front3Layout);
        front3Layout.setHorizontalGroup(
                front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front3Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(taxlabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                        .add(front3Layout.createSequentialGroup()
                                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(front3Layout.createSequentialGroup()
                                                                .add(enddatecheck)
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(newtax))
                                                .addContainerGap())))
                        .add(front3Layout.createSequentialGroup()
                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(front3Layout.createSequentialGroup()
                                                .add(33, 33, 33)
                                                .add(changetax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(front3Layout.createSequentialGroup()
                                                .add(32, 32, 32)
                                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(taxlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(nextyear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(35, 35, 35)
                                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(taxlabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(nextmonths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, taxlabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, nextdays, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(0, 0, Short.MAX_VALUE))
        );
        front3Layout.setVerticalGroup(
                front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front3Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(taxlabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(newtax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(enddatecheck)
                                .add(12, 12, 12)
                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(taxlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(taxlabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(taxlabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(3, 3, 3)
                                .add(front3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nextyear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(nextmonths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(nextdays, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(changetax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(front3);
        front3.setBounds(640, 460, 370, 280);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/adminwall.jpg")));
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 1031, 761);

        pack();
        setLocationRelativeTo(null);
    }

    private void billLogActionPerformed(ActionEvent e) {
        this.setVisible(false);
        BillsLog billsLog = new BillsLog();
        billsLog.setVisible(true);
    }

    private void newTaxKeyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
            enddatecheck.requestFocus();
        }
    }

    private void endDateCheckActionPerformed(java.awt.event.ActionEvent evt) {
        if (enddatecheck.isSelected()) {
            nextyear.setEnabled(true);
            nextmonths.setEnabled(false);
            nextdays.setEnabled(false);
            nextyear.requestFocus();
        } else {
            nextyear.setEnabled(false);
            nextmonths.setEnabled(false);
            nextdays.setEnabled(false);
            changetax.requestFocus();
        }
    }

    private void endDateCheckKeyReleasedPerformed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (enddatecheck.isSelected()) {
                nextyear.setEnabled(true);
                nextyear.requestFocus();
            } else {
                changetax.requestFocus();
            }
        }
    }

    private void nextYearMouseEntered(MouseEvent e) {
        if (!enddatecheck.isSelected()) {
            nextyear.setToolTipText("Check End Date!");
        } else {
            nextdays.setToolTipText("Select a year!");
        }
    }

    private void nextYearActionPerformed(java.awt.event.ActionEvent evt) {
        nextmonths.setToolTipText("Select a year!");
        String selectedYear = ((String) nextyear.getSelectedItem()).toLowerCase();
        String[] getNextMonths = Common.getNextMonths(selectedYear);
        nextmonths.setModel(new javax.swing.DefaultComboBoxModel<>(getNextMonths));
        nextmonths.setEnabled(true);
        nextmonths.requestFocus();
    }

    private void nextMonthActionPerformed() {
        if (nextmonths.getSelectedIndex() == 0) {
            nextdays.setEnabled(false);
        } else {
            nextdays.setEnabled(true);
            String selectedMonth = (String) nextmonths.getSelectedItem();
            int year = Integer.parseInt((String) nextyear.getSelectedItem());
            String[] getNextDays = Common.getMonthDays(selectedMonth,year);
            nextdays.setModel(new javax.swing.DefaultComboBoxModel<>(getNextDays));
            nextdays.requestFocus();
        }
    }

    private void nextDaysActionPerformed(java.awt.event.ActionEvent evt) {
        changetax.requestFocus();
    }

    private void addBillBtnActionPerformed(ActionEvent e) {
        AddAndDeleteBill addAndDeleteBill = new AddAndDeleteBill(true);
        this.setVisible(false);
        addAndDeleteBill.setVisible(true);
    }

    private void removeBillActionPerformed(ActionEvent e) {
        AddAndDeleteBill addAndDeleteBill = new AddAndDeleteBill(false);
        this.setVisible(false);
        addAndDeleteBill.setVisible(true);
    }

    private void customersChangesActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        CustomerModify customerModify = new CustomerModify();
    }

    private void mailLabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        MailBox mailBox = new MailBox(new String[]{"ADMIN"});
        mailBox.setVisible(true);
    }

    private void nextDaysMouseEntered(java.awt.event.MouseEvent evt) {
        if (nextmonths.getSelectedIndex() == 0) {
            nextdays.setToolTipText("Select a month!");
        } else {
            nextdays.setToolTipText("Select a day!");
        }
    }

    private void nextMonthsMouseEntered(java.awt.event.MouseEvent evt) {
        if (nextyear.getSelectedIndex() == 0) {
            nextmonths.setToolTipText("Select a year!");
        } else {
            nextmonths.setToolTipText("Select a month!");
        }
    }

    private void disableEvery(){
        newtax.setText("");;
        nextyear.setEnabled(false);
        nextyear = new JComboBox<>();
        nextmonths.setEnabled(false);
        nextmonths = new JComboBox<>();
        nextdays.setEnabled(false);
        nextdays = new JComboBox<>();
    }

    private void changeTaxActionPerformed(java.awt.event.ActionEvent evt) {
        if(newtax.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter new tax rate!");
            disableEvery();
            return;
        }
        double rate = 0;
        try {
            rate = Double.parseDouble(newtax.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error input + " + e);
            disableEvery();
            return;
        }
        if(enddatecheck.isSelected()){
            if(nextyear.getSelectedIndex() == 0 || nextmonths.getSelectedIndex() == 0 || nextdays.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null,"Fill end date correctly!");
                disableEvery();
                return;
            }
        }

        String date = (enddatecheck.isSelected())? nextdays.getSelectedItem() + "-" + nextmonths.getSelectedItem() + "-" + nextyear.getSelectedItem(): "no";

        if(SQLMan.addNewInterest(rate,date)){
            JOptionPane.showMessageDialog(null, "Successfully added new rate");
            disableEvery();
        }
    }


}
