package ui.dialogs;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.components.ButtonUtils;

public class SaleDialog {
    private JFrame parent;
    private Font fntCustom, fntBold;
    private Color greenAccent, cinzaNeutro;
    // Construtor que recebe os parâmetros necessários para personalização
    // do diálogo de venda, como fontes e cores
    public SaleDialog(JFrame parent, Font fntCustom, Font fntBold, Color greenAccent, Color cinzaNeutro) {
        this.parent = parent;
        this.fntCustom = fntCustom;
        this.fntBold = fntBold;
        this.greenAccent = greenAccent;
        this.cinzaNeutro = cinzaNeutro;
    }
    //  Exibe o diálogo de venda
    // Recebe os modelos de tabela de clientes e vendas para manipulação
    public void showDialog(DefaultTableModel tblClientes, DefaultTableModel tblVendas) {
        JDialog saleDialog = new JDialog(parent, "Registrar Venda", true);
        saleDialog.setSize(420, 350);
        saleDialog.setLocationRelativeTo(parent);
        
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        
          gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        form.add(new JLabel("Cliente:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        
        DefaultComboBoxModel<String> modeloCliente = new DefaultComboBoxModel<>();
        for (int i = 0; i < tblClientes.getRowCount(); i++) {
            modeloCliente.addElement(tblClientes.getValueAt(i, 1).toString());
        }
        JComboBox<String> comboCliente = new JComboBox<>(modeloCliente);
        form.add(comboCliente, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Tipo de Servico:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] servicos = {"Banho Completo", "Tosa Higienica", "Consulta Veterinaria", "Vacinacao", "Vermifugacao", "Cirurgia", "Hospedagem"};
        JComboBox<String> comboServico = new JComboBox<>(servicos);
        form.add(comboServico, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Valor:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField campoValor = new JTextField("0.00", 15);
        form.add(campoValor, gbc);
        // Adiciona um campo de texto para o valor da venda
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton okBtn = ButtonUtils.makeButton("Registrar", greenAccent, fntBold);
        JButton cancelBtn = ButtonUtils.makeButton("Cancelar", cinzaNeutro, fntBold);
        
          okBtn.addActionListener(e -> {
            String cliente = (String) comboCliente.getSelectedItem();
            String servico = (String) comboServico.getSelectedItem();
            String valor = campoValor.getText().trim();
            
            if (cliente == null || servico == null || valor.isEmpty()) {
                JOptionPane.showMessageDialog(saleDialog, "Preencha todos os campos!");
                return;
            }
            
            try {
                Double.parseDouble(valor.replace(",", "."));
                String idVenda = String.format("V%03d", tblVendas.getRowCount() + 1);
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                String hoje = fmt.format(new Date());
                tblVendas.addRow(new Object[]{idVenda, hoje, cliente, servico, "R$ " + valor});
                
                saleDialog.dispose();
                JOptionPane.showMessageDialog(parent, "Venda registrada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(saleDialog, "Valor invalido!");
            }
        });
        // Ação do botão Registrar
        // Verifica se todos os campos estão preenchidos e registra a venda
        cancelBtn.addActionListener(e -> saleDialog.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        
        saleDialog.add(form);
        saleDialog.setVisible(true);
    }
}
