package milleniuminvesment;


import javax.swing.*;
import java.awt.*;


/**
 * @author Gayashan Pananwala
 */
public class Login extends javax.swing.JFrame {

    private boolean isDarker = true;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JCheckBox darkcheck;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel wallpaper;
    private javax.swing.JLabel usernameIcon;
    private javax.swing.JLabel bankLogo;
    private javax.swing.JLabel passwordIocn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JTextField usertext;


    public Login() {
        initComponents();
        bg.setBackground(new Color(0, 0, 0, 180));
        darkcheck.setBackground(new java.awt.Color(0, 0, 0, 180));
        darkcheck.setSelected(true);
        dateLabel.setText("Date - " + Common.getToday());
        this.setTitle("LOGIN");
        usertext.requestFocus();


    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        usernameIcon = new javax.swing.JLabel();
        bankLogo = new javax.swing.JLabel();
        passwordIocn = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        passtext = new javax.swing.JPasswordField();
        loginbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        darkcheck = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        signUpLabel = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(673, 742));
        setResizable(false);
        setSize(new java.awt.Dimension(673, 742));

        jPanel1.setLayout(null);

        bg.setBackground(new java.awt.Color(0, 102, 102));

        usernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/userlogo.png")));

        bankLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        passwordIocn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/passlogo.png")));

        usertext.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24));
        usertext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usertext.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTextKeyReleased(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Calibri", 1, 14));
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("DATE");

        passtext.setFont(new java.awt.Font("Dialog", 0, 36));
        passtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passtext.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passTextKeyReleased(evt);
            }
        });

        loginbutton.setBackground(new java.awt.Color(0, 51, 51));
        loginbutton.setFont(new java.awt.Font("Yu Gothic", 1, 24));
        loginbutton.setForeground(new java.awt.Color(51, 0, 51));
        loginbutton.setText("Login");
        loginbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitbutton.setBackground(new java.awt.Color(0, 51, 51));
        exitbutton.setFont(new java.awt.Font("Yu Gothic", 1, 24));
        exitbutton.setForeground(new java.awt.Color(51, 0, 51));
        exitbutton.setText("Exit");
        exitbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        darkcheck.setBackground(new java.awt.Color(204, 255, 204));
        darkcheck.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14));
        darkcheck.setForeground(new java.awt.Color(255, 255, 255));
        darkcheck.setText("Dark Mode");
        darkcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        darkcheck.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkCheckActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/resetlogo.png")));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resetLabelClicked(evt);
            }
        });

        signUpLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14));
        signUpLabel.setForeground(new java.awt.Color(102, 255, 102));
        signUpLabel.setText("haven't an account? Sign Up!");
        signUpLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signUpLabelClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(darkcheck)
                                .addContainerGap())
                        .add(bgLayout.createSequentialGroup()
                                .add(114, 114, 114)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(dateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(0, 0, Short.MAX_VALUE))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(exitbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 87, Short.MAX_VALUE)
                                                .add(loginbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(121, 121, 121))
                                        .add(bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(usernameIcon)
                                                        .add(passwordIocn))
                                                .add(47, 47, 47)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(signUpLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                                .add(usertext)
                                                                .add(passtext, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                        .addContainerGap(216, Short.MAX_VALUE)
                                        .add(bankLogo)
                                        .add(172, 172, 172)))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, bgLayout.createSequentialGroup()
                                                .add(jLabel5)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(bgLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(darkcheck)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 211, Short.MAX_VALUE)
                                                .add(dateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                                .add(usertext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(31, 31, 31))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                                .add(usernameIcon)
                                                                .add(18, 18, 18)))))
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(passwordIocn)
                                        .add(bgLayout.createSequentialGroup()
                                                .add(14, 14, 14)
                                                .add(passtext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(signUpLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(22, 22, 22)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(loginbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(exitbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(91, 91, 91))
                        .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(bgLayout.createSequentialGroup()
                                        .add(10, 10, 10)
                                        .add(bankLogo)
                                        .addContainerGap(422, Short.MAX_VALUE)))
        );

        jPanel1.add(bg);
        bg.setBounds(20, 20, 620, 660);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wa.jpg")));
        jPanel1.add(wallpaper);
        wallpaper.setBounds(0, 0, 663, 704);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loginCheck();
    }

    private void darkCheckActionPerformed(java.awt.event.ActionEvent evt) {
        if (isDarker) {
            dateLabel.setForeground(new java.awt.Color(255, 0, 51));
            wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/light.jpg")));
            isDarker = false;
        } else {
            isDarker = true;
            dateLabel.setForeground(new java.awt.Color(255, 255, 255));
            wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wa.jpg")));
        }
    }

    private void resetLabelClicked(java.awt.event.MouseEvent evt) {
        SQLMan.dropEveryDatabases();
        this.setVisible(false);
        Loading loading = new Loading();
        loading.setVisible(true);
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SQLMan.close();
        JOptionPane.showMessageDialog(null, "Thank for Banking with us!");
        System.exit(0);
    }

    private void userTextKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            passtext.requestFocus();
        }
    }

    private void passTextKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            loginCheck();
        }
    }

    private void signUpLabelClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        NewCustomer nw = new NewCustomer();
        nw.setVisible(true);
    }

    private void loginCheck() {
        String username = usertext.getText();
        String password = passtext.getText();
        if ("".equals(username)) {
            JOptionPane.showMessageDialog(null, "Username should not be null");
            passtext.setText("");
            usertext.setText("");
            usertext.requestFocus();
            return;
        }
        if ("".equals(password)) {
            JOptionPane.showMessageDialog(null, "Password should not be null");
            passtext.setText("");
            usertext.setText("");
            usertext.requestFocus();
            return;
        }

        if ("gayashan".equals(username) && "gayashan".equals(password)) {
            this.setVisible(false);
            Admin admin = new Admin();
            admin.setVisible(true);
            passtext.setText("");
            usertext.setText("");
            usertext.requestFocus();
            return;
        }

        String[] results = SQLMan.loginCheck(username, password);

        if ("blocked".equals(results[0])) {
            JOptionPane.showMessageDialog(null, "You're blocked. Contact Admin!");
            passtext.setText("");
            usertext.setText("");
            usertext.requestFocus();
            return;
        }
        if (!"found".equals(results[0])) {
            JOptionPane.showMessageDialog(null, "Invalid username or password!");
            passtext.setText("");
            usertext.setText("");
            usertext.requestFocus();
            return;
        }

        String branch = results[1];
        String balance = results[2];
        CustomerMenu cm = new CustomerMenu(username, branch, balance);
        this.setVisible(false);
        cm.setVisible(true);
        passtext.setText("");
        usertext.setText("");
    }


}
