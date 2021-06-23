package milleniuminvesment;


 import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
 import java.awt.Color;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

/**
 * @author Gayashan Pananwala
 */

public class CustomerModify extends javax.swing.JFrame {

    private javax.swing.JLabel backlabel;
    private javax.swing.JButton block;
    private javax.swing.JButton delete;
    private javax.swing.JPanel front1;
    private javax.swing.JTextField getid;
    private javax.swing.JButton unblock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutlabel;
    private javax.swing.JLabel refreshlabel;
    private javax.swing.JTable tab;
    private javax.swing.JLabel wallpaper;

    DefaultTableModel table = null;

    public CustomerModify() {
        initComponents();
        table = (DefaultTableModel) tab.getModel();
        front1.setBackground(new Color(0, 0, 0, 160));
        this.setTitle("Customer Modification");
        loadTable();
        this.setVisible(true);
    }

    private void loadTable(){
        int lastID = SQLMan.getCustomersLastID();
        while(lastID >= 0){
            try {
                table.removeRow(lastID--);
            }catch (ArrayIndexOutOfBoundsException e){}
        }
        SQLMan.loadCustomerTable(table);
    }

    private void initComponents() {

        front1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        getid = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        block = new javax.swing.JButton();
        unblock = new javax.swing.JButton();
        backlabel = new javax.swing.JLabel();
        refreshlabel = new javax.swing.JLabel();
        logoutlabel = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1106, 908));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        tab.setBackground(new java.awt.Color(0, 51, 51));
        tab.setForeground(new java.awt.Color(255, 255, 255));
        tab.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Username", "Password", "Branch","Balance","Acc Created","Blocked","Last Interest Update"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Number");

        getid.setBackground(new java.awt.Color(51, 0, 51));
        getid.setFont(new java.awt.Font("Dialog", 0, 24));
        getid.setForeground(new java.awt.Color(255, 255, 255));
        getid.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Yu Gothic Light", 0, 24));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        block.setBackground(new java.awt.Color(51, 0, 204));
        block.setFont(new java.awt.Font("Yu Gothic Light", 0, 24));
        block.setForeground(new java.awt.Color(255, 255, 255));
        block.setText("Block");
        block.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blockUser();
            }
        });

        unblock.setBackground(new java.awt.Color(0, 204, 0));
        unblock.setFont(new java.awt.Font("Yu Gothic Light", 0, 24));
        unblock.setForeground(new java.awt.Color(255, 255, 255));
        unblock.setText("Unblock");
        unblock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unblock();
            }
        });

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/back.png")));
        backlabel.setToolTipText("go back");
        backlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backLabelMouseReleased(evt);
            }
        });

        refreshlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/refresh.png")));
        refreshlabel.setToolTipText("refresh");
        refreshlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshLabelMouseReleased(evt);
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

        org.jdesktop.layout.GroupLayout front1Layout = new org.jdesktop.layout.GroupLayout(front1);
        front1.setLayout(front1Layout);
        front1Layout.setHorizontalGroup(
                front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front1Layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 757, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(getid)
                                        .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(block, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(unblock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(41, Short.MAX_VALUE))
                        .add(front1Layout.createSequentialGroup()
                                .add(400, 400, 400)
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(20, 20, 20)
                                .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(20, 20, 20)
                                .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(51, 51, 51))
        );
        front1Layout.setVerticalGroup(
                front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(front1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(front1Layout.createSequentialGroup()
                                                .add(138, 138, 138)
                                                .add(front1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(backlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(refreshlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(logoutlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(140, 140, 140)
                                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(getid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(52, 52, 52)
                                                .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)
                                                .add(block, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)
                                                .add(unblock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(front1Layout.createSequentialGroup()
                                                .add(jLabel2)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 504, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(30, 30, 30))))
        );

        getContentPane().add(front1);
        front1.setBounds(20, 20, 1050, 830);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/adminwall.jpg")));
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 1090, 870);

        pack();
        setLocationRelativeTo(null);
    }

    private void blockUser() {
        validateIDAndProcess("BLOCK");
    }

    private void unblock() {
        validateIDAndProcess("UNBLOCK");
    }

    private void validateIDAndProcess(String operation){
        if(getid.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter one or more IDs");
            return;
        }
        String[] ids = getid.getText().split(",");
        for(String id : ids){
            try {
                int temp = Integer.parseInt(id);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null ,"Error IDs input " + e);
                getid.setText("");
                return;
            }
        }
        if(operation.equals("DELETE")) {
            SQLMan.deleteCustomers(ids);
        }else if(operation.equals("UNBLOCK")){
            SQLMan.blockAndUnblock(ids,false);
        }else{
            SQLMan.blockAndUnblock(ids,true);
        }
        getid.setText("");
        loadTable();
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        validateIDAndProcess("DELETE");
    }

    private void backLabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Admin admin = new Admin();
        admin.setVisible(true);
    }

    private void refreshLabelMouseReleased(java.awt.event.MouseEvent evt) {
        loadTable();
    }

    private void logoutLabelMouseReleased(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }

}
