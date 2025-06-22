//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Sistema Pet Shop - Launcher Principal
package launcher;

import ui.swing.SistemaPetShopUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetShopLauncher extends JFrame {
    
    public PetShopLauncher() {
        // vou configurar a janela principal do launcher
        configurarJanelaPrincipal();
        
        // depois criar todos os componentes
        criarComponentesDaInterface();
        
        // por último, mostrar a janela
        setVisible(true);
    }
    
    private void configurarJanelaPrincipal() {
        // configurações básicas da janela
        setTitle("Pet Shop - Sistema de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null); // centraliza na tela
        setResizable(false); // não deixa redimensionar
    }
    
    private void criarComponentesDaInterface() {
        // vou usar BorderLayout que é mais simples
        setLayout(new BorderLayout());
        
        // criando as três partes: topo, centro e rodapé
        JPanel painelDoTopo = criarCabecalhoLauncher();
        JPanel painelDoCentro = criarAreaDoBotao();
        JPanel painelDoRodape = criarRodapeLauncher();
        
        // adicionando cada parte na janela
        add(painelDoTopo, BorderLayout.NORTH);
        add(painelDoCentro, BorderLayout.CENTER);
        add(painelDoRodape, BorderLayout.SOUTH);
    }
    
    private JPanel criarCabecalhoLauncher() {
        // painel do cabeçalho
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new GridLayout(2, 1, 0, 10));
        
        // cor bonita para o cabeçalho
        Color corAzul = new Color(0, 100, 200);
        cabecalho.setBackground(corAzul);
        cabecalho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // título principal
        JLabel titulo = new JLabel("Pet Shop System", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        
        // subtítulo explicativo
        JLabel subtitulo = new JLabel("Sistema de Gerenciamento Completo", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitulo.setForeground(Color.WHITE);
        
        // adicionando no cabeçalho
        cabecalho.add(titulo);
        cabecalho.add(subtitulo);
        
        return cabecalho;
    }
    
    private JPanel criarAreaDoBotao() {
        // área central onde vai ficar o botão principal
        JPanel centro = new JPanel();
        centro.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        centro.setBackground(Color.WHITE);
        
        // criando o botão principal
        JButton botaoPrincipal = new JButton("Iniciar Sistema Pet Shop");
        botaoPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botaoPrincipal.setPreferredSize(new Dimension(280, 60));
        
        // cores bonitas para o botão
        Color corVerde = new Color(50, 150, 50);
        botaoPrincipal.setBackground(corVerde);
        botaoPrincipal.setForeground(Color.WHITE);
        botaoPrincipal.setFocusPainted(false);
        botaoPrincipal.setBorder(BorderFactory.createLineBorder(corVerde, 2));
        
        // configurando o que acontece quando clica no botão
        botaoPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // fechando esta janela
                dispose();
                
                // abrindo o sistema principal
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        SistemaPetShopUI sistemaPrincipal = new SistemaPetShopUI();
                        sistemaPrincipal.setVisible(true);
                    }
                });
            }
        });
        
        centro.add(botaoPrincipal);
        
        return centro;
    }
    
    private JPanel criarRodapeLauncher() {
        // rodapé simples
        JPanel rodape = new JPanel();
        rodape.setLayout(new FlowLayout());
        
        Color corCinza = new Color(245, 245, 245);
        rodape.setBackground(corCinza);
        rodape.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        
        // texto do rodapé
        JLabel textoRodape = new JLabel("Trabalho de Programação 2 - 2025", JLabel.CENTER);
        textoRodape.setFont(new Font("Arial", Font.ITALIC, 12));
        
        Color corTexto = new Color(100, 100, 100);
        textoRodape.setForeground(corTexto);
        
        rodape.add(textoRodape);
        
        return rodape;
    }
    
    // método main para iniciar tudo
    public static void main(String[] args) {
        // configurações para melhorar a aparência do texto
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // criando e mostrando a janela principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetShopLauncher();
            }
        });
    }
}
