package pokemon.pokedex.ui;

import javax.swing.*;
import pokemon.pokedex.util.*;

public interface WaitingController {

    void init();

    default void exit() {
        if (XDialog.confirm("Are you sure you want to exit?", "Exit Confirmation")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showRegisterJDialog(JFrame frame) {
        this.showJDialog(new RegisterJDialog(frame, true));
    }

    default void showAboutJDialog(JFrame frame) {
        this.showJDialog(new AboutJDialog(frame, true));
    }

}
