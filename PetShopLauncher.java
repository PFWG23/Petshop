//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Sistema Pet Shop - Launcher Principal
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetShopLauncher extends JFrame {
    
    // Construtor da janela principal
    public PetShopLauncher() {
        // Configurações básicas da janela
        setTitle("Pet Shop - Sistema de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400); // tamanho adequado
        setLocationRelativeTo(null); // centraliza na tela
        setResizable(false); // não deixa redimensionar
        
        criarComponentes(); // chama o método que cria os botões e tudo mais
        setVisible(true); // mostra a janela
    }    // Método que cria todos os componentes da tela
    private void criarComponentes() {
        setLayout(new BorderLayout()); // layout básico do Java
        
        // Criando o painel do cabeçalho (parte de cima)
        JPanel painelTopo = new JPanel();
        painelTopo.setBackground(new Color(0, 100, 200)); // cor azul bonita
        painelTopo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título principal
        JLabel tituloLabel = new JLabel("🐕 Pet Shop System 🐕", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        tituloLabel.setForeground(Color.WHITE); 
        
        // Subtítulo
        JLabel subtituloLabel = new JLabel("Escolha como usar o sistema:", JLabel.CENTER);
        subtituloLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtituloLabel.setForeground(Color.WHITE);
        
        // Organizando o painel do topo
        painelTopo.setLayout(new GridLayout(2, 1, 0, 10)); 
        painelTopo.add(tituloLabel);
        painelTopo.add(subtituloLabel);
        
        // Painel do meio onde ficam os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 1, 0, 20)); // só 2 botões agora
        painelBotoes.setBackground(Color.WHITE);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
        
        // Botão para interface console (terminal)
        JButton botaoConsole = new JButton("💻 Interface Console (Terminal)");
        botaoConsole.setFont(new Font("Arial", Font.BOLD, 16));
        botaoConsole.setBackground(new Color(100, 100, 100));
        botaoConsole.setForeground(Color.WHITE);
        botaoConsole.setFocusPainted(false);
        botaoConsole.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        botaoConsole.setPreferredSize(new Dimension(350, 60));
        
        // Botão para interface gráfica
        JButton botaoGrafico = new JButton("🖥️ Interface Gráfica (Janelas)");
        botaoGrafico.setFont(new Font("Arial", Font.BOLD, 16));
        botaoGrafico.setBackground(new Color(50, 150, 50));
        botaoGrafico.setForeground(Color.WHITE);
        botaoGrafico.setFocusPainted(false);
        botaoGrafico.setBorder(BorderFactory.createLineBorder(new Color(50, 150, 50), 2));
        botaoGrafico.setPreferredSize(new Dimension(350, 60));
        
        // Ações dos botões
        botaoConsole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // fecha esta janela
                SistemaPetShop.main(new String[]{}); // abre o sistema console
            }
        });
        
        botaoGrafico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // fecha esta janela
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new PetShopSwingGUISimples(); // abre a interface gráfica
                    }
                });
            }
        });
        
        // Adicionando os botões no painel
        painelBotoes.add(botaoConsole);
        painelBotoes.add(botaoGrafico);
        
        // Painel do rodapé (parte de baixo)
        JPanel painelRodape = new JPanel();
        painelRodape.setBackground(new Color(245, 245, 245)); 
        painelRodape.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        
        JLabel autorLabel = new JLabel("Trabalho de Programação 2 - 2025", JLabel.CENTER);
        autorLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        autorLabel.setForeground(new Color(100, 100, 100)); 
        
        painelRodape.add(autorLabel);
        
        // Montando tudo na janela principal
        add(painelTopo, BorderLayout.NORTH); 
        add(painelBotoes, BorderLayout.CENTER); 
        add(painelRodape, BorderLayout.SOUTH); 
    }    
    // Método principal - aqui começa tudo
    public static void main(String[] args) {
        // Configurações para deixar o texto mais bonito
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // Cria a janela principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetShopLauncher(); // cria nossa janela
            }
        });
    }
}
