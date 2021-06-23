package milleniuminvesment;


import javax.swing.*;
import java.awt.Color;

public class NewCustomer extends javax.swing.JFrame {


    public NewCustomer() {
        initComponents();
        bg.setBackground(new Color(0,0,0,160));
        datelabel.setText("Date - " + Common.getToday());
        this.setTitle("SIGN UP");
        usertext.requestFocus();
    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        branchBox = new javax.swing.JComboBox<>();
        passtext = new javax.swing.JPasswordField();
        passtext1 = new javax.swing.JPasswordField();
        signup = new javax.swing.JButton();
        back = new javax.swing.JButton();
        datelabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(855, 766));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        usertext.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        usertext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usertext.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usertextKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password Again");

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Branch");

        branchBox.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        branchBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       --Select Branch--", "Ampara", "Anuradhapura", "Badulla", "Batticaloa", "Colombo", "Galle", "Gampaha", "Hambantota", "Jaffna", "Kalutara", "Kandy", "Kegalle", "Kilinochchi", "Kurunegala", "Mannar", "Matale", "Matara", "Monaragala", "Mullaitivu", "Nuwara Eliya", "Polonnaruwa", "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya" }));
        branchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                branchKeyReleased(evt);
            }
        });

        passtext.setFont(new java.awt.Font("Dialog", 0, 36));
        passtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passtext.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });

        passtext1.setFont(new java.awt.Font("Dialog", 0, 36));
        passtext1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passtext1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordAgainKeyReleased(evt);
            }
        });

        signup.setBackground(new java.awt.Color(0, 51, 51));
        signup.setFont(new java.awt.Font("Yu Gothic", 1, 24));
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Sign Up");
        signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpMouseEntered(evt);
            }
        });
        signup.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 51, 51));
        back.setFont(new java.awt.Font("Yu Gothic", 1, 24));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        datelabel.setFont(new java.awt.Font("Calibri", 1, 14));
        datelabel.setForeground(new java.awt.Color(255, 255, 255));
        datelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelabel.setText("DATE");

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(151, 151, 151)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabel4)
                                                        .add(jLabel6)
                                                        .add(jLabel2)
                                                        .add(jLabel5))
                                                .add(109, 109, 109)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(bgLayout.createSequentialGroup()
                                                                .add(usertext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 296, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, passtext)
                                                        .add(passtext1)
                                                        .add(branchBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(179, 179, 179)
                                                .add(back, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(signup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(102, 102, 102)))
                                .add(94, 94, 94))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(jLabel3)
                                .add(49, 49, 49)
                                .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(114, 114, 114))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel3)
                                        .add(datelabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(54, 54, 54)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(usertext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jLabel2))
                                                .add(18, 18, 18)
                                                .add(passtext1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jLabel4))
                                .add(18, 18, 18)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(passtext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel5))
                                .add(18, 18, 18)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(branchBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel6))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 52, Short.MAX_VALUE)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(signup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(back, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(27, 27, 27))
        );

        getContentPane().add(bg);
        bg.setBounds(20, 20, 800, 680);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wa.jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 727);

        pack();
        setLocationRelativeTo(null);
    }

    private void usertextKeyReleased(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            passtext1.requestFocus();
        }
    }

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            branchBox.requestFocus();
        }
    }

    private void passwordAgainKeyReleased(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            passtext.requestFocus();
        }
    }

    private void signUpMouseEntered(java.awt.event.MouseEvent evt) {
        signUpping();
    }

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {
        signUpping();
    }

    private void signUpping(){
        String username = usertext.getText();
        String password = passtext.getText();
        String passwordAgain = passtext1.getText();
        String branch = (String) branchBox.getSelectedItem();
        if("".equals(username)){
            JOptionPane.showMessageDialog(null,"Enter username");
            usertext.setText("");
            passtext.setText("");
            passtext1.setText("");
            branchBox.setSelectedIndex(0);
            usertext.requestFocus();
            return;
        }if("".equals(password) || "".equals(passwordAgain)){
            JOptionPane.showMessageDialog(null,"Enter both passwords");
            passtext.setText("");
            passtext1.setText("");
            branchBox.setSelectedIndex(0);
            passtext1.requestFocus();
            return;
        }if(!password.equals(passwordAgain)){
            JOptionPane.showMessageDialog(null,"Passwords should be same");
            passtext.setText("");
            passtext1.setText("");
            branchBox.setSelectedIndex(0);
            passtext1.requestFocus();
            return;
        }if(branchBox.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Select a branch");
            branchBox.requestFocus();
            return;
        }
        if(SQLMan.newCustomer(username,password,branch)){
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        }else{
            usertext.setText("");
            passtext.setText("");
            passtext1.setText("");
            branchBox.setSelectedIndex(0);
            usertext.requestFocus();
        }
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Login lg = new Login();
        lg.setVisible(true);
    }

    private void branchKeyReleased(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            signup.requestFocus();
        }
    }




    private javax.swing.JButton back;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> branchBox;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JPasswordField passtext1;
    private javax.swing.JButton signup;
    private javax.swing.JTextField usertext;

}