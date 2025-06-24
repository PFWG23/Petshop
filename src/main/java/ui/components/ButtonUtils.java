package ui.components;

import java.awt.*;
import javax.swing.*;

public class ButtonUtils {
    // Método utilitário para criar botões personalizados
    // Recebe o texto, cor de fundo e fonte como parâmetros
    public static JButton makeButton(String text, Color color, Font font) {
        JButton button = new JButton(text);
      button.setFont(font);
      button.setBackground(color);
      button.setForeground(Color.WHITE);
       button.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
       button.setFocusPainted(false);
        return button;
    }
}
