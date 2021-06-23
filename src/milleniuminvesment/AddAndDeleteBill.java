package milleniuminvesment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gayashan Pananwala
 */

public class AddAndDeleteBill extends javax.swing.JFrame {

    boolean isAdd;
    private javax.swing.JLabel backlabel;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField billName;
    private javax.swing.JLabel billNameLabel;
    private javax.swing.JComboBox<String> biller;
    private javax.swing.JComboBox<String> billtype;
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel billLabel;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel wallpaper;

    public AddAndDeleteBill(boolean isAdd) {
        this.isAdd = isAdd;
        initComponents();
        bg.setBackground(new Color(0, 0, 0, 160));
        if (isAdd) {
            btn.setText("Add Bill");
            billLabel.setEnabled(false);
            biller.setEnabled(false);
        } else {
            btn.setText("Delete Bill");
            billNameLabel.setEnabled(false);
            billName.setEnabled(false);
        }
        String[] billTypes = SQLMan.getBillType();
        billtype.setModel(new javax.swing.DefaultComboBoxModel<>(billTypes));
        billtype.requestFocus();
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        billLabel = new javax.swing.JLabel();
        billtype = new javax.swing.JComboBox<>();
        biller = new javax.swing.JComboBox<>();
        btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        billNameLabel = new javax.swing.JLabel();
        billName = new javax.swing.JTextField();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(662, 633));
        setSize(new java.awt.Dimension(662, 633));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bill Type");

        billLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        billLabel.setForeground(new java.awt.Color(255, 255, 255));
        billLabel.setText("Bill");

        billtype.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        billtype.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billTypeSelected();
            }
        });


        biller.setFont(new java.awt.Font("Yu Gothic", 0, 18));

        btn.setFont(new java.awt.Font("Dialog", 0, 24));
        btn.setText("Add New Biller");
        btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

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
                logoutLabelMouseReleased();
            }
        });

        billNameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        billNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        billNameLabel.setText("Bill Name");

        billName.setFont(new java.awt.Font("Yu Gothic", 0, 18));
        billName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(btn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(144, 144, 144))
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(51, 51, 51)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(billNameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(billLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(80, 80, 80)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                        .add(biller, 0, 256, Short.MAX_VALUE)
                                                        .add(billtype, 0, 256, Short.MAX_VALUE)
                                                        .add(billName)))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(176, 176, 176)
                                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(74, 74, 74)
                                                .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)
                                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(45, 45, 45)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(34, 34, 34)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(billtype, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(biller, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(billLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(billNameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(billName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(25, 25, 25)
                                .add(btn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(94, Short.MAX_VALUE))
        );

        getContentPane().add(bg);
        bg.setBounds(20, 20, 620, 590);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/adminwall.jpg")));
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 660, 630);

        pack();
        setLocationRelativeTo(null);
    }

    private void billTypeSelected() {
        if(isAdd) {
            return;
        }
        if(billtype.getSelectedIndex() != 0){
            setupBill();
        }
    }


    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        if(isAdd){
            if(billtype.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Select bill type");
                return;
            }
            if("".equals(billName.getText())){
                JOptionPane.showMessageDialog(null, "Enter new bill name");
                return;
            }
            if(SQLMan.hasDuplicateBill(billName.getText())){
                JOptionPane.showMessageDialog(null,"Bill name is already exists!");
                billtype.setSelectedIndex(0);
                billName.setText("");
                billtype.requestFocus();
                return;
            }
            SQLMan.addNewBillByAdmin((String)billtype.getSelectedItem() , billName.getText());
            this.setVisible(false);
            new Admin().setVisible(true);
        }else{
            String deletingBillName = (String) biller.getSelectedItem();
            if(SQLMan.deleteBill(deletingBillName.toLowerCase())){
                this.setVisible(false);
                new Admin().setVisible(true);
            }else{
                billtype.setSelectedIndex(0);
                biller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
            }
        }
    }

    private void backLabelMouseReleased(java.awt.event.MouseEvent evt) {
        Admin admin = new Admin();
        this.setVisible(false);
        admin.setVisible(true);
    }

    private void logoutLabelMouseReleased() {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }

    private void setupBill() {
        if(billtype.getSelectedIndex() != 0){
            biller.setEnabled(true);
        }
        String[] billsList = SQLMan.getBillsOfBillType((String) billtype.getSelectedItem());
        biller.setModel(new javax.swing.DefaultComboBoxModel<>(billsList));
    }


}
