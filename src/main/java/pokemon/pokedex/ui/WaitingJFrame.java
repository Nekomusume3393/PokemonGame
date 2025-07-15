package pokemon.pokedex.ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class WaitingJFrame extends JFrame implements WaitingController {

    public WaitingJFrame() {
        initComponents();
        this.init();
    }

    public void initComponents() {

        btnLogin = new JButton();
        btnRegister = new JButton();
        btnAbout = new JButton();
        btnExit = new JButton();
        lblLogo = new JLabel();

        pnlBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int size = 150;
                for (int y = 0; y < getHeight(); y += size) {
                    for (int x = 0; x < getWidth(); x += size) {
                        if ((x / size + y / size) % 2 == 0) {
                            g.setColor(new Color(193, 255, 114));
                        } else {
                            g.setColor(new Color(126, 217, 87));
                        }
                        g.fillRect(x, y, size, size);
                    }
                }
            }
        };

        pnlButtons = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokémon");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/pokemon/pokedex/icons/logo.png")));

        pnlButtons.setOpaque(false);

        btnLogin.setBackground(new Color(0, 191, 99));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Segoe UI", 1, 24));
        btnLogin.setText("Login");
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 103), 5));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new Color(12, 192, 223));
        btnRegister.setForeground(new Color(255, 255, 255));
        btnRegister.setFont(new Font("Segoe UI", 1, 24));
        btnRegister.setText("Register");
        btnRegister.setBorder(BorderFactory.createLineBorder(new Color(123, 124, 103), 5));
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnAbout.setBackground(new Color(255, 222, 89));
        btnAbout.setForeground(new Color(255, 255, 255));
        btnAbout.setFont(new Font("Segoe UI", 1, 24));
        btnAbout.setText("About");
        btnAbout.setBorder(BorderFactory.createLineBorder(new Color(123, 124, 103), 5));
        btnAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnExit.setBackground(new Color(255, 49, 49));
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setFont(new Font("Segoe UI", 1, 24));
        btnExit.setText("Exit");
        btnExit.setBorder(BorderFactory.createLineBorder(new Color(123, 124, 103), 5));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        GroupLayout pnlButtonsLayout = new GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
                pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        pnlButtonsLayout.setVerticalGroup(
                pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        GroupLayout pnlBackgroundLayout = new GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackgroundLayout.setVerticalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        

    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        this.showLoginJDialog(this);
    }

    private void btnRegisterActionPerformed(ActionEvent evt) {
        this.showRegisterJDialog(this);
    }

    private void btnAboutActionPerformed(ActionEvent evt) {
        this.showAboutJDialog(this);
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        this.exit();
    }

    

    @Override
    public void init() {
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaitingJFrame().setVisible(true);
            }
        });

    }

    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnAbout;
    private JButton btnExit;
    private JLabel lblLogo;
    private JPanel pnlBackground;
    private JPanel pnlButtons;
}
