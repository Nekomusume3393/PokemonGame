/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.pokedex.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import com.formdev.flatlaf.FlatLightLaf;
import pokemon.pokedex.util.XAuth;
import pokemon.pokedex.util.XIcon;

/**
 *
 * @author May5th
 */
public class MainMenuJFrame extends JFrame implements MainMenuController {

    public MainMenuJFrame() {
        initComponents();
        this.init();
    }

    public void initComponents() {

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

        pnlUser = new JPanel();
        lblAvatar = new JLabel();
        lblDisplayName = new JLabel();
        lblUsername = new JLabel();
        btnExit = new JButton();
        btnSettings = new JButton();
        pnlTabs = new JTabbedPane();
        pnlUserButtons = new JPanel();
        btnBattle = new JButton();
        btnTeam = new JButton();
        btnInventory = new JButton();
        btnPokemon = new JButton();
        btnExplore = new JButton();
        btnShop = new JButton();
        pnlManagerButtons = new JPanel();
        btnStatistic = new JButton();
        btnManage = new JButton();
        lblChar = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokémon");
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setResizable(false);

        pnlUser.setBackground(new java.awt.Color(255, 255, 0));

        lblAvatar.setBackground(new Color(255, 255, 255));
        lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
        lblAvatar.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0), 7));

        lblDisplayName.setFont(new Font("Segoe UI", 1, 24));
        lblDisplayName.setText("displayName");

        lblUsername.setText("username");

        btnExit.setBackground(new Color(255, 0, 0));

        btnSettings.setBackground(new Color(153, 153, 153));

        GroupLayout pnlUserLayout = new GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
                pnlUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlUserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDisplayName, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        pnlUserLayout.setVerticalGroup(
                pnlUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlUserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAvatar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlUserLayout.createSequentialGroup()
                                                .addComponent(lblDisplayName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUsername)
                                                .addGap(0, 34, Short.MAX_VALUE))
                                        .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pnlTabs.setBackground(new java.awt.Color(255, 255, 0));

        pnlUserButtons.setBackground(new java.awt.Color(255, 255, 0));

        btnBattle.setBackground(new java.awt.Color(255, 145, 77));
        btnBattle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBattle.setForeground(new java.awt.Color(255, 255, 255));
        btnBattle.setText("Battle");
        btnBattle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));
        btnBattle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBattleActionPerformed(evt);
            }
        });

        btnTeam.setBackground(new java.awt.Color(255, 145, 77));
        btnTeam.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTeam.setForeground(new java.awt.Color(255, 255, 255));
        btnTeam.setText("Team");
        btnTeam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        btnInventory.setBackground(new java.awt.Color(255, 145, 77));
        btnInventory.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnInventory.setText("Inventory");
        btnInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        btnPokemon.setBackground(new java.awt.Color(255, 145, 77));
        btnPokemon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPokemon.setForeground(new java.awt.Color(255, 255, 255));
        btnPokemon.setText("Pokémon");
        btnPokemon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        btnExplore.setBackground(new java.awt.Color(255, 145, 77));
        btnExplore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExplore.setForeground(new java.awt.Color(255, 255, 255));
        btnExplore.setText("Explore");
        btnExplore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        btnShop.setBackground(new java.awt.Color(255, 145, 77));
        btnShop.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnShop.setForeground(new java.awt.Color(255, 255, 255));
        btnShop.setText("Shop");
        btnShop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        javax.swing.GroupLayout pnlUserButtonsLayout = new javax.swing.GroupLayout(pnlUserButtons);
        pnlUserButtons.setLayout(pnlUserButtonsLayout);
        pnlUserButtonsLayout.setHorizontalGroup(
                pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlUserButtonsLayout.createSequentialGroup()
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnInventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnTeam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBattle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnShop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnExplore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlUserButtonsLayout.setVerticalGroup(
                pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlUserButtonsLayout.createSequentialGroup()
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBattle, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(btnShop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(pnlUserButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnExplore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addContainerGap(60, Short.MAX_VALUE))
        );

        pnlTabs.addTab("User", pnlUserButtons);

        pnlManagerButtons.setBackground(new java.awt.Color(255, 255, 0));

        btnStatistic.setBackground(new java.awt.Color(255, 145, 77));
        btnStatistic.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnStatistic.setForeground(new java.awt.Color(255, 255, 255));
        btnStatistic.setText("Statstic");
        btnStatistic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        btnManage.setBackground(new java.awt.Color(255, 145, 77));
        btnManage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnManage.setForeground(new java.awt.Color(255, 255, 255));
        btnManage.setText("Manage");
        btnManage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 107, 97), 10));

        javax.swing.GroupLayout pnlManagerButtonsLayout = new javax.swing.GroupLayout(pnlManagerButtons);
        pnlManagerButtons.setLayout(pnlManagerButtonsLayout);
        pnlManagerButtonsLayout.setHorizontalGroup(
                pnlManagerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlManagerButtonsLayout.createSequentialGroup()
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addComponent(btnStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlManagerButtonsLayout.setVerticalGroup(
                pnlManagerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlManagerButtonsLayout.createSequentialGroup()
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addGroup(pnlManagerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(405, Short.MAX_VALUE))
        );

        pnlTabs.addTab("Manager", pnlManagerButtons);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
                pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblChar, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
        );
        pnlBackgroundLayout.setVerticalGroup(
                pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(pnlTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 106, Short.MAX_VALUE))
                                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblChar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
    }

    private void btnBattleActionPerformed(ActionEvent evt) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());
        }
    }
    
    @Override
    public void init() {
        XIcon.setIcon(lblAvatar, "photos/" + XAuth.user.getImage());
        lblUsername.setText(XAuth.user.getUsername());
        lblDisplayName.setText(XAuth.user.getDisplayName());

        if (!XAuth.user.isManager()) {
            pnlTabs.remove(pnlManagerButtons);
        }
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuJFrame().setVisible(true);
            }
        });

    }

    private JPanel pnlBackground;
    private JPanel pnlManagerButtons;
    private JTabbedPane pnlTabs;
    private JPanel pnlUser;
    private JPanel pnlUserButtons;
    private JButton btnBattle;
    private JButton btnExit;
    private JButton btnExplore;
    private JButton btnInventory;
    private JButton btnManage;
    private JButton btnPokemon;
    private JButton btnSettings;
    private JButton btnShop;
    private JButton btnStatistic;
    private JButton btnTeam;
    private JLabel lblAvatar;
    private JLabel lblChar;
    private JLabel lblDisplayName;
    private JLabel lblUsername;
}
