package milleniuminvesment;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MailBox extends javax.swing.JFrame {


    private javax.swing.JTextField toUsername;
    private javax.swing.JTextField id;
    private javax.swing.JLabel backlabel;
    private javax.swing.JLabel balancelabel;
    private javax.swing.JLabel banklogo;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel branchnamelabel;
    private javax.swing.JButton send;
    private javax.swing.JButton markAsRead;
    private javax.swing.JButton delete;
    private javax.swing.JButton markAsUnread;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable box;
    private javax.swing.JTextArea msg;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel refreshlabel;
    private javax.swing.JCheckBox toall;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JLabel wall;

    private DefaultTableModel table;

    private boolean isCustomer = false;
    private String username;
    private String branch;
    private String balance;

    public MailBox(String[] properties) {
        initComponents();
        table = (DefaultTableModel) box.getModel();
        if ("CUSTOMER".equals(properties[0])) {
            toall.setVisible(false);
            isCustomer = true;
            username = properties[1];
            branch = properties[2];
            balance = properties[3];
            balancelabel.setText("Balance - $" + balance);
            branchnamelabel.setText("Branch - " + branch.toUpperCase());
            usernamelabel.setText("Username - " + username);

        } else {
            username = "ADMIN";
            wall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/adminwall.jpg")));
            balancelabel.setText("");
            branchnamelabel.setText("");
            usernamelabel.setText("ADMIN");
        }
        mailBoxUpdate();

        bg.setBackground(new Color(0, 0, 0, 160));
        datelabel.setText("Date - " + Common.getToday());
    }

    private void mailBoxUpdate() {

        int lastId = SQLMan.getLastMailID(username);

        while (lastId >= 0) {
            try {
                table.removeRow(lastId--);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        SQLMan.mailBoxUpdate(table, username);
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        backlabel = new javax.swing.JLabel();
        refreshlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        banklogo = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();
        branchnamelabel = new javax.swing.JLabel();
        toall = new javax.swing.JCheckBox();
        id = new javax.swing.JTextField();
        toUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        markAsRead = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        markAsUnread = new javax.swing.JButton();
        send = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        box = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1029, 948));
        getContentPane().setLayout(null);

        bg.setBackground(new java.awt.Color(0, 51, 51));

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

        banklogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        usernamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36));
        usernamelabel.setForeground(new java.awt.Color(255, 204, 204));
        usernamelabel.setText("Customer Username");

        balancelabel.setFont(new java.awt.Font("Simplex_IV25", 1, 24));
        balancelabel.setForeground(new java.awt.Color(255, 0, 51));
        balancelabel.setText("Balance - ");

        branchnamelabel.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18));
        branchnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        branchnamelabel.setText("Branch Name");

        toall.setText("To All");

        id.setBackground(new java.awt.Color(51, 0, 51));
        id.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setToolTipText("Enter Account Number");

        toUsername.setBackground(new java.awt.Color(51, 0, 51));
        toUsername.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        toUsername.setForeground(new java.awt.Color(255, 255, 255));
        toUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toUsername.setToolTipText("Enter Account Number");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");

        markAsRead.setFont(new java.awt.Font("Dialog", 0, 24));
        markAsRead.setText("MARK AS READ");
        markAsRead.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAsReadActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Dialog", 0, 24));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        markAsUnread.setFont(new java.awt.Font("Dialog", 0, 24));
        markAsUnread.setText("MARK AS UNREAD");
        markAsUnread.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAsUnreadButtonPerformed(evt);
            }
        });

        send.setFont(new java.awt.Font("Dialog", 0, 24));
        send.setText("Send New Mail");
        send.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Message");

        datelabel.setFont(new java.awt.Font("Calibri", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelabel.setText("DATE");

        box.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Message", "Username", "Status", "Date", "Read"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(box);

        msg.setBackground(new java.awt.Color(51, 0, 51));
        msg.setColumns(20);
        msg.setFont(new java.awt.Font("Yu Gothic Light", 1, 18));
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setRows(5);
        jScrollPane2.setViewportView(msg);

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(banklogo)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(62, 62, 62)
                                                .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 315, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                .add(org.jdesktop.layout.GroupLayout.TRAILING, datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                                        .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(54, 54, 54)
                                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(20, 20, 20)
                                                                        .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(20, 20, 20)
                                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                                .add(31, 31, 31))))
                        .add(bgLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(bgLayout.createSequentialGroup()
                                                                                .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .add(id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                        .add(markAsRead, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .add(162, 162, 162)
                                                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(markAsUnread)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                                .add(toall)
                                                                                .add(send, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 323, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(toUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 262, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(25, 25, 25))
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 943, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(31, 31, 31))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(datelabel)
                                                .add(72, 72, 72)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(0, 0, Short.MAX_VALUE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(0, 0, Short.MAX_VALUE)
                                                                .add(banklogo)
                                                                .add(36, 36, 36))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .add(usernamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(balancelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(branchnamelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(52, 52, 52)))
                                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(23, 23, 23)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(0, 0, Short.MAX_VALUE)
                                                                .add(toUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(2, 2, 2))
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(bgLayout.createSequentialGroup()
                                                                                .add(11, 11, 11)
                                                                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .add(markAsRead, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))))))
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(12, 12, 12)
                                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(markAsUnread, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(toall)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(send, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(292, 292, 292))
        );

        getContentPane().add(bg);
        bg.setBounds(10, 10, 990, 890);

        wall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/mailwall.jpg")));
        getContentPane().add(wall);
        wall.setBounds(0, 0, 1013, 909);

        pack();
        setLocationRelativeTo(null);
    }

    private void backlabelMouseReleased(java.awt.event.MouseEvent evt) {
        if (isCustomer) {
            CustomerMenu customerMenu = new CustomerMenu(username, branch, balance);
            this.setVisible(false);
            customerMenu.setVisible(true);
        } else {
            Admin admin = new Admin();
            this.setVisible(false);
            admin.setVisible(true);
        }
    }

    private void refreshlabelMouseReleased(java.awt.event.MouseEvent evt) {
        mailBoxUpdate();
    }

    private void logoutlabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }

    private void sendMailActionPerformed(java.awt.event.ActionEvent evt) {
        if (toUsername.getText().equals("")) {
            if (!isCustomer && toall.isSelected()) {

            } else {
                JOptionPane.showMessageDialog(null, "Enter a receiver");
            }
            return;
        }
        if (msg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a msg");
            return;
        }
        boolean all = false;
        if (toall.getSelectedObjects() != null) {
            all = true;
        }
        if (username.toLowerCase().equals(toUsername.getText().toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Cannot send e-mails to yourself!");
            return;
        }
        SQLMan.sendMail(username, toUsername.getText(), msg.getText(), all);

    }

    private void markAsReadActionPerformed(java.awt.event.ActionEvent evt) {
        markAsReadOrUnread(true);
        mailBoxUpdate();
    }

    private void markAsReadOrUnread(boolean toMarkAsRead) {
        String idTxt = id.getText();
        String[] ids = null;
        if (idTxt.contains(",")) {
            ids = idTxt.split(",");
        } else {
            ids = new String[]{idTxt};
        }
        try {
            for (String item : ids) {
                int temp = Integer.parseInt(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error IDs");
            id.setText("");
            return;
        }
        SQLMan.setReadOrUnread(username, ids, toMarkAsRead);
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String idTxt = id.getText();
        String[] ids = null;
        if (idTxt.contains(",")) {
            ids = idTxt.split(",");
        } else {
            ids = new String[]{idTxt};
        }
        try {
            for (String item : ids) {
                int temp = Integer.parseInt(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error IDs");
            return;
        }
        SQLMan.deleteMails(username, ids);
        mailBoxUpdate();
    }

    private void markAsUnreadButtonPerformed(java.awt.event.ActionEvent evt) {
        markAsReadOrUnread(false);
    }


}
