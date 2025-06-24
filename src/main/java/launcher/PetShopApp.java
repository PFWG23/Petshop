package launcher;

import javax.swing.*;
import ui.main.MainWindow;

public class PetShopApp {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}
