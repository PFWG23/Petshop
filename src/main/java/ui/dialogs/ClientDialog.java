package ui.dialogs;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.components.ButtonUtils;

public class ClientDialog {
    private JFrame parent;
    private Font fntCustom, fntBold;
    private Color greenAccent, cinzaNeutro;
    
    public ClientDialog(JFrame parent, Font fntCustom, Font fntBold, Color greenAccent, Color cinzaNeutro) {
        this.parent = parent;
        this.fntCustom = fntCustom;
        this.fntBold = fntBold;
        this.greenAccent = greenAccent;
        this.cinzaNeutro = cinzaNeutro;
    }
    
    public void showDialog(DefaultTableModel tblClientes) {
        JDialog clientDlg = new JDialog(parent, "Cadastro Cliente", true);
        clientDlg.setSize(390, 270);
        clientDlg.setLocationRelativeTo(parent);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Nome Completo:"));
        JTextField nomeField = new JTextField(25);
        namePanel.add(nomeField);
        mainPanel.add(namePanel);
        mainPanel.add(Box.createVerticalStrut(8));
        
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phonePanel.add(new JLabel("Telefone:      "));
        JTextField telefoneField = new JTextField(25);
        phonePanel.add(telefoneField);
        mainPanel.add(phonePanel);
        mainPanel.add(Box.createVerticalStrut(8));
        
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:           "));
        JTextField emailField = new JTextField(25);
        emailPanel.add(emailField);
        mainPanel.add(emailPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton salvarBtn = ButtonUtils.makeButton("Salvar", greenAccent, fntBold);
        JButton cancelarBtn = ButtonUtils.makeButton("Cancelar", cinzaNeutro, fntBold);
        
        salvarBtn.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String tel = telefoneField.getText().trim();
            String email = emailField.getText().trim();
            
            if (nome.isEmpty() || tel.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(clientDlg, "Todos os campos são obrigatórios!");
                return;
            }
            
              String clientId = String.format("C%03d", tblClientes.getRowCount() + 1);
            tblClientes.addRow(new Object[]{clientId, nome, tel, email});
            
            clientDlg.dispose();
            JOptionPane.showMessageDialog(parent, "Cliente cadastrado!");
        });
        
        cancelarBtn.addActionListener(e -> clientDlg.dispose());
        
        btnPanel.add(salvarBtn);
        btnPanel.add(cancelarBtn);
        mainPanel.add(btnPanel);
        
        clientDlg.add(mainPanel);
        clientDlg.setVisible(true);
    }
}
