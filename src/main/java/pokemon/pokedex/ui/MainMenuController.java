/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pokemon.pokedex.ui;

import javax.swing.*;

import pokemon.pokedex.util.XDialog;

/**
 *
 * @author May5th
 */
public interface MainMenuController {
    
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
    
}
