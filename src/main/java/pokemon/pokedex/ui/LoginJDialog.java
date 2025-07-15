package pokemon.pokedex.ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import pokemon.pokedex.dao.UserDAO;
import pokemon.pokedex.dao.impl.UserDAOImpl;
import pokemon.pokedex.entity.User;
import pokemon.pokedex.util.XAuth;
import pokemon.pokedex.util.XDialog;

public class LoginJDialog extends JDialog implements LoginController {

    public LoginJDialog(Frame parent, boolean modal) {
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
        pnlLogin = new JPanel();
        txtUsername = new JTextField();
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        txtPassword = new JPasswordField();
        btnLogin = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setSize(480, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/pokemon/pokedex/icons/logo_small.png")));

        pnlLogin.setOpaque(false);

        txtUsername.setFont(new Font("Segoe UI", 0, 20));
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 177), 4));

        lblUsername.setFont(new Font("Segoe UI", 1, 20));
        lblUsername.setForeground(new Color(52, 104, 177));
        lblUsername.setText("Username");

        lblPassword.setFont(new Font("Segoe UI", 1, 20));
        lblPassword.setForeground(new Color(52, 104, 177));
        lblPassword.setText("Password");

        txtPassword.setFont(new Font("Segoe UI", 0, 20));
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 177), 4));

        GroupLayout pnlLoginLayout = new GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
                pnlLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pnlLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUsername)
                                        .addComponent(txtPassword)
                                        .addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
                pnlLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUsername)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPassword)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogin.setBackground(new Color(0, 191, 99));
        btnLogin.setFont(new Font("Segoe UI", 1, 24));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(new LineBorder(new Color(123, 124, 103), 4, true));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        GroupLayout pnlBackgroundLayout = new GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addComponent(pnlLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
                pnlBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(75, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlBackground, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

    }
    
    private void btnLoginActionPerformed(ActionEvent evt) {
        this.login();
    }

    @Override
    public void login() {
        String username = txtUsername.getText();
        char[] password = txtPassword.getPassword();
        String passStr = new String(password);
        
        UserDAO dao = new UserDAOImpl();
        User user = dao.findById(username);
        if (user == null) {
            XDialog.alert("Wrong username!");
        } else if (!passStr.equals(user.getPassword())) {
            XDialog.alert("Wrong password!");
        } else {
            XAuth.user = user;
            this.dispose();
            new TitleJFrame().setVisible(true);
        }
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
                LoginJDialog dialog = new LoginJDialog(new JFrame(), true);
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

    private JButton btnLogin;
    private JLabel lblLogo;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JPanel pnlBackground;
    private JPanel pnlLogin;
    private JPasswordField txtPassword;
    private JTextField txtUsername;
}
