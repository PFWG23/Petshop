package ui.panels;

import java.awt.*;
import java.util.function.Consumer;
import javax.swing.*;

public class SidebarPanel {
    // Cria o painel lateral com botões de navegação
    public JPanel createSidebar(Font fntBold, Color crCinza, Color darkBlue, Color azulMain, Consumer<String> actionHandler) {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(crCinza);
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        String[] botoes = {"Inicio", "Animais", "Clientes", "Vendas", "Agenda", "Relatorios"};
        for (String texto : botoes) {
            sidebar.add(createSideButton(texto, fntBold, darkBlue, azulMain, actionHandler));
            sidebar.add(Box.createVerticalStrut(10));
        }
        
        return sidebar;
    }
    // Cria um botão com estilo personalizado
    // Recebe o texto, fontes e cores como parâmetros, além de um Consumer para o // manipulador de ações
    // O Consumer permite que a ação seja definida externamente, facilitando a reutilização
    private JButton createSideButton(String text, Font fntBold, Color darkBlue, Color azulMain, Consumer<String> actionHandler) {
        JButton btn = new JButton(text);
     btn.setPreferredSize(new Dimension(160, 35));
       btn.setMaximumSize(new Dimension(160, 35));
     btn.setFont(fntBold);
       btn.setBackground(Color.WHITE);
     btn.setForeground(darkBlue);
       btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(azulMain, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        btn.addActionListener(e -> actionHandler.accept(text));
        return btn;
    }
}
