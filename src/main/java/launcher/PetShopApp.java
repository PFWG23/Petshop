package launcher;

import javax.swing.*;
import ui.main.MainWindow;

public class PetShopApp {
    // Sistema Pet Shop - Launcher Principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}
