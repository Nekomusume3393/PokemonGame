package pokemon.pokedex.ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class AboutJDialog extends JDialog {

    public AboutJDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void initComponents() {

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
            }
        };

        lblLogo = new JLabel();
        pnlScroll = new JScrollPane();
        lblAbout = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setSize(480, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/pokemon/pokedex/icons/logo_small.png")));

        lblAbout.setHorizontalAlignment(SwingConstants.LEADING);
        lblAbout.setText(
                "<html>"
                + "<h1>Pokémon</h1>"
                + "<p>Nhóm 6: Gotta Catch 'Em All!</p>"
                + "<p>Môn: Dự Án Tốt Nghiệp - PRO230</p>"
                + "<p>Lớp: SD1902</p>"
                + "<p>Giảng viên: Thầy Phạm Gia Khánh</p>"
                + "</html>"
        );
        lblAbout.setVerticalAlignment(SwingConstants.TOP);
        pnlScroll.setViewportView(lblAbout);

        GroupLayout pnlBackgroundLayout = new GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(pnlScroll, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlScroll, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 14, Short.MAX_VALUE))
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

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AboutJDialog dialog = new AboutJDialog(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private JLabel lblAbout;
    private JLabel lblLogo;
    private JPanel pnlBackground;
    private JScrollPane pnlScroll;
}
