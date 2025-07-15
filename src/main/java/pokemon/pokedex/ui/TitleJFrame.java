package pokemon.pokedex.ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TitleJFrame extends JFrame {

    public TitleJFrame() {
        initComponents();
    }

    public void initComponents() {

        lblContinue = new JLabel();
        lblLogo = new JLabel();
        pnlBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int size = 100;

                for (int y = 0; y < getHeight(); y += size) {
                    for (int x = 0; x < getWidth(); x += size) {
                        if ((x / size + y / size) % 2 == 0) {
                            g.setColor(new Color(0, 191, 99));
                        } else {
                            g.setColor(new Color(126, 217, 87));
                        }
                        g.fillRect(x, y, size, size);
                    }
                }

                g.setColor(Color.BLACK);
                int bandHeight = 180;
                g.fillRect(0, 0, getWidth(), bandHeight);
                g.fillRect(0, getHeight() - bandHeight, getWidth(), bandHeight);
            }
        };

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokémon");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/pokemon/pokedex/icons/logo_firered.png")));

        lblContinue.setFont(new Font("Segoe UI", 1, 36));
        lblContinue.setForeground(new Color(255, 255, 255));
        lblContinue.setHorizontalAlignment(SwingConstants.CENTER);
        lblContinue.setText("CLICK TO CONTINUE");

        GroupLayout pnlBackgroundLayout = new GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                        .addComponent(lblContinue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(lblContinue, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
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

        Timer blinkTimer = new Timer(500, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                visible = !visible;
                lblContinue.setVisible(visible);
            }
        });
        blinkTimer.start();
        playBackgroundMusic("/pokemon/pokedex/bgm/mainmenu.wav");
    }

    private void formMouseClicked(MouseEvent evt) {
        new MainMenuJFrame().setVisible(true);
    }
    
    private void playBackgroundMusic(String filePath) {
        try {
            URL url = getClass().getResource(filePath);
            if (url == null) {
                System.out.println("Cannot find the file: " + filePath);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audio);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
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
                new TitleJFrame().setVisible(true);
            }
        });

    }

    private JLabel lblContinue;
    private JLabel lblLogo;
    private JPanel pnlBackground;
    private Clip backgroundMusic;
}
