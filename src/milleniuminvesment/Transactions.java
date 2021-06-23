package milleniuminvesment;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Transactions extends javax.swing.JFrame {

    private String username;
    private String branch;
    private String balance;
    private javax.swing.JLabel backlabel;
    private javax.swing.JLabel balancelabel;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel branchnamelabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel refreshlabel;
    private javax.swing.JTable table;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JLabel wallpaper;

    private DefaultTableModel transactionsTable ;
    public Transactions(String username, String branch, String balance) {
        this.username = username;
        this.branch = branch;
        this.balance = balance;
        initComponents();
        transactionsTable = (DefaultTableModel) table.getModel();
        bg.setBackground(new Color(0, 0, 0, 160));
        balancelabel.setText("Balance - $" + this.balance);
        branchnamelabel.setText("Branch - " + this.branch.toUpperCase());
        usernamelabel.setText("Username - " + this.username);
        updateTable();
    }

    private void updateTable(){
        int lastID = SQLMan.getLastTransactionID(username);
        while (lastID >= 0){
            try {
                transactionsTable.removeRow(lastID--);
            }catch (ArrayIndexOutOfBoundsException e){}
        }
        SQLMan.transactionsTableUpdate(username,transactionsTable);
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        backlabel = new javax.swing.JLabel();
        refreshlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        branchnamelabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1096, 900));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        table.setBackground(new java.awt.Color(0, 51, 51));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Date", "Amount", "Description"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/back.png")));
        backlabel.setToolTipText("go back");
        backlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backlabelMouseReleased(evt);
            }
        });

        refreshlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/refresh.png")));
        refreshlabel.setToolTipText("refresh");
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

        branchnamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18));
        branchnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        branchnamelabel.setText("Branch Name");

        balancelabel.setFont(new java.awt.Font("Simplex_IV25", 1, 24));
        balancelabel.setForeground(new java.awt.Color(255, 0, 51));
        balancelabel.setText("Balance - ");

        usernamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36));
        usernamelabel.setForeground(new java.awt.Color(255, 204, 204));
        usernamelabel.setText("Customer Username");

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 991, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(33, Short.MAX_VALUE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(jLabel2)
                                                .add(33, 33, 33)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(20, 20, 20)
                                                                .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(20, 20, 20)
                                                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(51, 51, 51))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(usernamelabel)
                                                                        .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(24, 24, 24)
                                                .add(jLabel2))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(37, 37, 37)
                                                .add(usernamelabel)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(76, 76, 76)
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(balancelabel)
                                                                .add(27, 27, 27)
                                                                .add(branchnamelabel)))))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 44, Short.MAX_VALUE)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 504, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(30, 30, 30))
        );

        getContentPane().add(bg);
        bg.setBounds(10, 10, 1050, 830);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/adminwall.jpg")));
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 1080, 860);

        pack();
        setLocationRelativeTo(null);
    }

    private void backlabelMouseReleased(java.awt.event.MouseEvent evt) {
        CustomerMenu customerMenu = new CustomerMenu(username, branch, balance);
        this.setVisible(false);
        customerMenu.setVisible(true);
    }

    private void refreshlabelMouseReleased(java.awt.event.MouseEvent evt) {
        updateTable();
    }

    private void logoutlabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }


}
