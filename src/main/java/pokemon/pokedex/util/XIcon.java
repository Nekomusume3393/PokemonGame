package pokemon.pokedex.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import pokemon.pokedex.util.XStr;

public class XIcon {

    public static ImageIcon getIcon(String path) {
        if (!path.contains("/") && !path.contains("\\")) {
            return XIcon.getIcon("images/" + path);
        }
        if (path.startsWith("/")) {
            return new ImageIcon(XIcon.class.getResource(path));
        }
        return new ImageIcon(path);
    }

    public static ImageIcon getIcon(String path, int width, int height) {
        Image image = getIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public static void setIcon(JLabel label, String path) {
        label.setIcon(XIcon.getIcon(path, label.getWidth(), label.getHeight()));
    }

    public static void setIcon(JLabel label, File file) {
        XIcon.setIcon(label, file.getAbsolutePath());
    }

    public static File copyTo(File fromFile, String folder) {
        String fileExt = fromFile.getName().substring(fromFile.getName().lastIndexOf('.'));
        File toFile = new File(folder + "/" + XStr.getKey() + fileExt);
        try {
            Files.copy(fromFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return toFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File copyTo(File fromFile) {
        return copyTo(fromFile, "images");
    }

    // Summary of the XIcon class:
    // This class provides utility methods for handling icons in a Java Swing application.
    // - getIcon(String path): Returns an ImageIcon for a given path, handling both relative and absolute paths.
    // - getIcon(String path, int width, int height): Returns a scaled ImageIcon for a given path.
    // - setIcon(JLabel label, String path): Sets the icon of a JLabel to an ImageIcon created from the specified path.
    // - setIcon(JLabel label, File file): Sets the icon of a JLabel to an ImageIcon created from a File.
    // - copyTo(File fromFile, String folder): Copies a file to a specified folder and returns the new file.
    // - copyTo(File fromFile): Copies a file to the "images" folder and returns the new file.
}
