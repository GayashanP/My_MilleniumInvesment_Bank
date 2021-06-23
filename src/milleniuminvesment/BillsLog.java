package milleniuminvesment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Gayashan Pananwala
 */
public class BillsLog extends javax.swing.JFrame {


    private javax.swing.JComboBox<String> bill;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel refreshlabel;
    private javax.swing.JTable transactions;
    private javax.swing.JLabel usernamelabel;

    DefaultTableModel table;

    public BillsLog() {
        initComponents();
        table = (DefaultTableModel) transactions.getModel();
        datelabel.setText("Date - " + Common.getToday());
        String[] billsSet = SQLMan.getBillsSets();
        bill.setModel(new javax.swing.DefaultComboBoxModel<>(billsSet));
        bill.setSelectedIndex(0);
        updateTable();
    }

    private void updateTable() {
        transactions = new JTable();
        table = (DefaultTableModel) transactions.getModel();
        String selectedIndex = (String) bill.getSelectedItem();
        SQLMan.billsLog(table, selectedIndex.toLowerCase());
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bill = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        refreshlabel = new javax.swing.JLabel();
        javax.swing.JLabel backLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactions = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(943, 807));

        jPanel1.setLayout(null);

        bill.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        bill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"               -- none -- "}));
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                billMouseReleased(evt);
            }
        });
        bill.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billKeyReleased(evt);
            }
        });
        jPanel1.add(bill);
        bill.setBounds(630, 220, 250, 38);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Biller");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(520, 220, 55, 32);

        datelabel.setFont(new java.awt.Font("Calibri", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelabel.setText("DATE");
        jPanel1.add(datelabel);
        datelabel.setBounds(800, 10, 120, 18);

        usernamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36));
        usernamelabel.setForeground(new java.awt.Color(255, 204, 204));
        usernamelabel.setText("ADMIN");
        jPanel1.add(usernamelabel);
        usernamelabel.setBounds(370, 120, 160, 60);

        logoutlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/logout.png")));
        logoutlabel.setToolTipText("logout");
        logoutlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutLabelMouseReleased(evt);
            }
        });
        jPanel1.add(logoutlabel);
        logoutlabel.setBounds(850, 120, 40, 40);

        refreshlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/refresh.png")));
        refreshlabel.setToolTipText("refresh");
        refreshlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshLabelMouseReleased(evt);
            }
        });
        jPanel1.add(refreshlabel);
        refreshlabel.setBounds(790, 120, 40, 40);

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/back.png")));
        backLabel.setToolTipText("go back");
        backLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backLabelMouseReleased(evt);
            }
        });
        jPanel1.add(backLabel);
        backLabel.setBounds(730, 120, 40, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 240, 250);

        transactions.setBackground(new java.awt.Color(0, 51, 51));
        transactions.setForeground(new java.awt.Color(102, 255, 0));
        transactions.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "From", "Amount", "Account", "Transaction Date"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        transactions.setGridColor(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(transactions);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 280, 850, 440);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/cs47iK.jpg")));
        jLabel1.setText("Customer Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 925, 769);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 928, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 774, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void logoutLabelMouseReleased(java.awt.event.MouseEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }

    private void refreshLabelMouseReleased(java.awt.event.MouseEvent evt) {
        updateTable();
    }

    private void backLabelMouseReleased(java.awt.event.MouseEvent evt) {
        Admin admin = new Admin();
        this.setVisible(false);
        admin.setVisible(true);
    }

    private void billMouseReleased(java.awt.event.MouseEvent evt) {
        updateTable();
    }

    private void billKeyReleased(java.awt.event.KeyEvent evt) {
        updateTable();
    }


}
