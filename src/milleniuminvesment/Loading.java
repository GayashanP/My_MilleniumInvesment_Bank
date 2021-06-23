package milleniuminvesment;

/**
 * @author Gayashan Pananwala
 */

import java.awt.*;

public class Loading extends javax.swing.JFrame {


    private javax.swing.JProgressBar bar;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel des;
    private javax.swing.JLabel wallpaper;
    private javax.swing.JLabel bankLogo;
    private javax.swing.JLabel description;


    public Loading() {
        initComponents();
        bg.setBackground(new Color(0, 0, 0, 100));
        this.setVisible(true);
        this.setTitle(Common.BANK_NAME + " loading...");

        Common.bar = this.bar;
        Common.label = this.des;
        Common.bar_value = 0;
        Common.loading = this;
        progress();

    }

    public static void main(String[] args) {
        Loading loading = new Loading();
    }

    private void progress() {

        SQLMan.init();


//        SQLMan.dropEveryDatabases();
//        SQLMan.close();
//        System.exit(0);

        Common.progressHandle("CHECKING DATABASES",0);
        if (SQLMan.checkDatabases()) {
            Common.progressHandle("FOUND DATABASES",55);
        } else {
            Common.progressHandle("CREATING DATABASES",0);
            SQLMan.createDatabases();
        }

        Common.progressHandle("FILLING HASH TABLES",0);
        Common.fillHashMaps();
        Common.progressHandle("FILLED HASH TABLES",10);


        Common.progressHandle("GENERATING INTERESTS",0);
        SQLMan.generateInterest();

        Common.progressHandle("GENERATED INTERESTS",100-Common.bar_value);


        Login l = new Login();
        l.setVisible(true);
        setVisible(false);

    }

    private void initComponents() {

        bg = new javax.swing.JPanel();
        bankLogo = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        des = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(905, 595));
        setResizable(false);
        getContentPane().setLayout(null);

        bg.setBackground(new java.awt.Color(0, 0, 0));

        bankLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/log2.png")));

        description.setFont(new java.awt.Font("Yu Gothic UI", 0, 36));
        description.setForeground(new java.awt.Color(255, 204, 51));
        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("FOR A SECURE BANKING FUTURE");

        des.setFont(new java.awt.Font("Yu Gothic UI", 0, 18));
        des.setForeground(new java.awt.Color(255, 0, 255));
        des.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        bar.setStringPainted(true);

        org.jdesktop.layout.GroupLayout bgLayout = new org.jdesktop.layout.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(303, 303, 303)
                                .add(bankLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                .add(bar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 775, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(34, 34, 34))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, bgLayout.createSequentialGroup()
                                                .add(bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(des, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 541, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(description, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 541, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(145, 145, 145))))
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(bgLayout.createSequentialGroup()
                                .add(22, 22, 22)
                                .add(bankLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(description, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(des, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(bar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(bg);
        bg.setBounds(20, 20, 850, 520);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milleniuminvesment/wa.jpg")));
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 889, 557);

        pack();
        setLocationRelativeTo(null);
    }


}
