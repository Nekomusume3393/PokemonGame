package pokemon.pokedex.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import pokemon.pokedex.ui.RegisterJDialog;

public class XDialog {

	public static void alert(String message) {
		XDialog.alert(message, "Alert!");
	}
	
	public static void alert(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean confirm(String message) {
		return XDialog.confirm(message, "Confirm");
	}
	
	public static boolean confirm(String message, String title) {
		int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return (result == JOptionPane.YES_OPTION);
	}
	
	public static String prompt(String message) {
		return XDialog.prompt(message, "Input");
	}
	
	public static String prompt(String message, String title) {
		return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
	}
	
	// Summary of the XDialog class:
	// This class provides static methods to display dialog boxes for alerts, confirmations, and prompts.
	// It uses JOptionPane to create and show these dialogs, allowing for easy user interaction.
	// - alert(String message): Displays an alert dialog with the given message.
	// - alert(String message, String title): Displays an alert dialog with the given message and title.
	// - confirm(String message): Displays a confirmation dialog with the given message and returns true if the user confirms.
	// - confirm(String message, String title): Displays a confirmation dialog with the given message and title, returning true if confirmed.
	// - prompt(String message): Displays a prompt dialog for user input with the given message.
	// - prompt(String message, String title): Displays a prompt dialog for user input with the given message and title.
	// This class is useful for creating user-friendly interfaces that require user feedback or input.
	
}