package ui.dialogs;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.components.ButtonUtils;

public class ScheduleDialog {
    private JFrame parent;
    private Font fntCustom, fntBold;
    private Color greenAccent, cinzaNeutro;
    
    public ScheduleDialog(JFrame parent, Font fntCustom, Font fntBold, Color greenAccent, Color cinzaNeutro) {
        this.parent = parent;
        this.fntCustom = fntCustom;
        this.fntBold = fntBold;
        this.greenAccent = greenAccent;
        this.cinzaNeutro = cinzaNeutro;
    }
    
    public void showDialog(DefaultTableModel tblClientes, DefaultTableModel tblAgenda) {
        JDialog agendaDialog = new JDialog(parent, "Novo Agendamento", true);
        agendaDialog.setSize(420, 380);
        agendaDialog.setLocationRelativeTo(parent);
        
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
        form.add(new JLabel("Pet:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField campoPet = new JTextField(20);
        form.add(campoPet, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Data:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField campoData = new JTextField("dd/MM/yyyy", 20);
        form.add(campoData, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Horario:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] horarios = {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"};
        JComboBox<String> comboHorario = new JComboBox<>(horarios);
        form.add(comboHorario, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Servico:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] servicos = {"Check-up", "Vacinacao", "Consulta", "Cirurgia", "Banho e Tosa", "Exame"};
        JComboBox<String> comboServico = new JComboBox<>(servicos);
        form.add(comboServico, gbc);
        
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton okBtn = ButtonUtils.makeButton("Agendar", greenAccent, fntBold);
        JButton cancelBtn = ButtonUtils.makeButton("Cancelar", cinzaNeutro, fntBold);
        
          okBtn.addActionListener(e -> {
            String cliente = (String) comboCliente.getSelectedItem();
            String pet = campoPet.getText().trim();
            String data = campoData.getText().trim();
            String horario = (String) comboHorario.getSelectedItem();
            String servico = (String) comboServico.getSelectedItem();
            
            if (cliente == null || pet.isEmpty() || data.isEmpty() || horario == null || servico == null) {
                JOptionPane.showMessageDialog(agendaDialog, "Preencha todos os campos!");
                return;
            }
            
            tblAgenda.addRow(new Object[]{data, horario, cliente, pet, servico});
            agendaDialog.dispose();
            JOptionPane.showMessageDialog(parent, "Agendamento realizado com sucesso!");
        });
        
        cancelBtn.addActionListener(e -> agendaDialog.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        
        agendaDialog.add(form);
        agendaDialog.setVisible(true);
    }
}
