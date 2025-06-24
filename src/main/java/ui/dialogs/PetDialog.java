package ui.dialogs;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.components.ButtonUtils;

public class PetDialog {
    private JFrame parent;
    private Font fntCustom, fntBold;
    private Color greenAccent, cinzaNeutro;
    
    public PetDialog(JFrame parent, Font fntCustom, Font fntBold, Color greenAccent, Color cinzaNeutro) {
        this.parent = parent;
        this.fntCustom = fntCustom;
        this.fntBold = fntBold;
        this.greenAccent = greenAccent;
        this.cinzaNeutro = cinzaNeutro;
    }
    
    public void showDialog(DefaultTableModel tblPets) {
        JDialog dlg = new JDialog(parent, "Novo Animal", true);
                dlg.setSize(450, 400);
                dlg.setLocationRelativeTo(parent);
        JPanel form = new JPanel(new GridBagLayout());
         form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        
          gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
         form.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField nameField = new JTextField(20);
          form.add(nameField, gbc);
          
          gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
          form.add(new JLabel("Tipo:"), gbc);
          gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] tipos = {"Cao", "Gato", "Ave", "Coelho", "Outros"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);
            form.add(tipoBox, gbc);
            
            gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
            form.add(new JLabel("Raca:"), gbc);
              gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField racaField = new JTextField(20);
           form.add(racaField, gbc);
           
           gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
            form.add(new JLabel("Idade:"), gbc);
           gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField idadeField = new JTextField(20);
           form.add(idadeField, gbc);
           
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton okBtn = ButtonUtils.makeButton("Salvar", greenAccent, fntBold);
        JButton cancelBtn = ButtonUtils.makeButton("Cancelar", cinzaNeutro, fntBold);
        
            okBtn.addActionListener(e -> {
            String nome = nameField.getText().trim();
            String tipo = (String) tipoBox.getSelectedItem();
            String raca = racaField.getText().trim();
            String idade = idadeField.getText().trim();
            
            if (nome == null || tipo == null || raca.isEmpty() || idade.isEmpty()) {
                JOptionPane.showMessageDialog(dlg, "Preencha todos os campos!");
                return;
            }
            
            String idPet = String.format("P%03d", tblPets.getRowCount() + 1);
            tblPets.addRow(new Object[]{idPet, nome, tipo, raca, idade});
            dlg.dispose();
            JOptionPane.showMessageDialog(parent, "Pet cadastrado com sucesso!");
        });
        
        cancelBtn.addActionListener(e -> dlg.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        
        dlg.add(form);
        dlg.setVisible(true);
    }
}
