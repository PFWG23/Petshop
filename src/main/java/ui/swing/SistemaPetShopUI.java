package ui.swing;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import util.DataPersistence;

public class SistemaPetShopUI extends JFrame {
  // Models das tabelas
  private DefaultTableModel tblPets, tblClientes, tblVendas, tblAgenda;
  
  // Fontes customizadas
  private Font fntCustom = new Font("Segoe UI", Font.PLAIN, 12);
  private Font fntBold = new Font("Segoe UI", Font.BOLD, 12);
  
  // Cores do sistema
  private final Color DARK_BLUE = new Color(41, 79, 121);
  private final Color CRcinza = new Color(161, 172, 178);
  private final Color GREEN_ACCENT = new Color(29, 158, 84);
  private final Color AZUL_MAIN = new Color(51, 131, 198);
  private final Color BG_GRAY = new Color(243, 246, 249);
  private final Color CINZA_NEUTRO = new Color(161, 172, 100);  public SistemaPetShopUI() {
      DataPersistence.createDataDir(); // Criar pasta de dados
      initWin();
        buildUI();
        loadAllData(); // Carregar dados salvos
        
        // Salvar dados ao fechar
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveAllData();
                System.exit(0);
            }
        });
    }private void initWin() {
        setTitle("PetShop Manager - v2.4");
        setSize(1180, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void buildUI() {
        JPanel main = new JPanel(new BorderLayout());
         main.setBackground(BG_GRAY);
        
        main.add(createHeader(), BorderLayout.NORTH);
        main.add(createSidebar(), BorderLayout.WEST);
        main.add(createContentArea(), BorderLayout.CENTER);
        
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
          bottom.setBackground(CRcinza);
           bottom.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        JLabel status = new JLabel("Sistema ativo");
           status.setFont(fntCustom);
           status.setForeground(DARK_BLUE);
           bottom.add(status);
           main.add(bottom, BorderLayout.SOUTH);
        
        add(main);
    }
      private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
          header.setBackground(DARK_BLUE);
          header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        JLabel title = new JLabel("Sistema Pet Shop");
          title.setFont(fntBold.deriveFont(20f));
          title.setForeground(Color.WHITE);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM HH:mm");
        JLabel time = new JLabel(fmt.format(new Date()));
          time.setFont(fntCustom);
          time.setForeground(Color.WHITE);
          header.add(title, BorderLayout.WEST);
          header.add(time, BorderLayout.EAST);
        return header;
    }
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(CRcinza);
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));            JButton home = createSideButton("Inicio");
            JButton pets = createSideButton("Animais");
            JButton clients = createSideButton("Clientes");  
            JButton sales = createSideButton("Vendas");
            JButton schedule = createSideButton("Agenda");
            JButton reports = createSideButton("Relatorios");
         sidebar.add(home);
         sidebar.add(Box.createVerticalStrut(10));
         sidebar.add(pets);
         sidebar.add(Box.createVerticalStrut(15));
         sidebar.add(clients);
         sidebar.add(Box.createVerticalStrut(10));
         sidebar.add(sales);
         sidebar.add(Box.createVerticalStrut(12));
         sidebar.add(schedule);
         sidebar.add(Box.createVerticalStrut(10));
         sidebar.add(reports);
        
        return sidebar;
    }    private JButton createSideButton(String text) {
        JButton btn = new JButton(text);
     btn.setPreferredSize(new Dimension(160, 35));
       btn.setMaximumSize(new Dimension(160, 35));
     btn.setFont(fntBold);
       btn.setBackground(Color.WHITE);
     btn.setForeground(DARK_BLUE);
       btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(AZUL_MAIN, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        btn.addActionListener(e -> handleMenuClick(text));
        return btn;
    }

    private void handleMenuClick(String action) {
        switch (action) {
            case "Animais": showPetDialog(); break;
            case "Clientes": showClientDialog(); break;
            case "Vendas": showSaleDialog(); break;
            case "Agenda": showScheduleDialog(); break;
            case "Relatorios": generateReport(); break;
        }
    }
    private JPanel createContentArea() {
     JPanel tables = new JPanel(new GridLayout(2, 2, 12, 12));
     tables.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
     tables.setBackground(BG_GRAY);
     JPanel petPanel = buildPetTable();
     JPanel clientPanel = buildClientTable();  
     JPanel salesPanel = buildSalesTable();
     JPanel schedulePanel = buildScheduleTable();
           tables.add(petPanel);
           tables.add(clientPanel);
        tables.add(salesPanel);
           tables.add(schedulePanel);
        return tables;
    }private JPanel buildPetTable() {
        JPanel petPanel = new JPanel(new BorderLayout());
        petPanel.setBackground(Color.WHITE);
      TitledBorder petBorder = BorderFactory.createTitledBorder("Registro de Pets");
         petBorder.setTitleFont(fntBold.deriveFont(14f));
         petBorder.setTitleColor(AZUL_MAIN);
         petPanel.setBorder(petBorder);          
         String[] colunasPet = {"ID", "Nome", "Tipo", "Raca", "Proprietario"};
          tblPets = new DefaultTableModel(colunasPet, 0);        
        
        JTable tabelaAnimais = new JTable(tblPets);
        tabelaAnimais.setRowHeight(25);
        tabelaAnimais.setFont(fntCustom);
        tabelaAnimais.getTableHeader().setFont(fntBold);
        tabelaAnimais.getTableHeader().setBackground(CRcinza);
        tabelaAnimais.setSelectionBackground(AZUL_MAIN);
        tabelaAnimais.setGridColor(CRcinza);        
        JScrollPane scrollPets = new JScrollPane(tabelaAnimais);
        
        JPanel petButtons = new JPanel(new FlowLayout());
        JButton btnAdicionarPet = makeButton("Adicionar", AZUL_MAIN);
        JButton btnDeletarPet = makeButton("Deletar", new Color(220, 53, 69));
        
        btnAdicionarPet.addActionListener(e -> showPetDialog());
        btnDeletarPet.addActionListener(e -> deletarPet(tabelaAnimais));
        
        petButtons.add(btnAdicionarPet);
        petButtons.add(btnDeletarPet);
        
        petPanel.add(scrollPets, BorderLayout.CENTER);
        petPanel.add(petButtons, BorderLayout.SOUTH);
        return petPanel;
      }    private JPanel buildClientTable() {
        JPanel clientPanel = new JPanel(new BorderLayout());
        clientPanel.setBackground(Color.WHITE); 
        TitledBorder clientBorder = BorderFactory.createTitledBorder("Base de Clientes");
          clientBorder.setTitleFont(fntBold.deriveFont(14f));
          clientBorder.setTitleColor(AZUL_MAIN);
          clientPanel.setBorder(clientBorder);        
          String[] colunasCliente = {"ID", "Nome Completo", "Telefone", "Email"};
        tblClientes = new DefaultTableModel(colunasCliente, 0);        
        
        JTable tabelaClientes = new JTable(tblClientes);
        tabelaClientes.setRowHeight(25);
        tabelaClientes.setFont(fntCustom);
        tabelaClientes.getTableHeader().setFont(fntBold);
        tabelaClientes.getTableHeader().setBackground(CRcinza);
        tabelaClientes.setSelectionBackground(AZUL_MAIN);
        tabelaClientes.setGridColor(CRcinza);        
        JScrollPane scrollClientes = new JScrollPane(tabelaClientes);
        
        JPanel clientButtons = new JPanel(new FlowLayout());
        JButton btnNovoCliente = makeButton("Novo Cliente", AZUL_MAIN);
        JButton btnDeletarCliente = makeButton("Deletar", new Color(220, 53, 69));
        
          btnNovoCliente.addActionListener(e -> showClientDialog());
          btnDeletarCliente.addActionListener(e -> deletarCliente(tabelaClientes));
          
          clientButtons.add(btnNovoCliente);
          clientButtons.add(btnDeletarCliente);
          
          clientPanel.add(scrollClientes, BorderLayout.CENTER);
          clientPanel.add(clientButtons, BorderLayout.SOUTH);
        return clientPanel;
    }    private JPanel buildSalesTable() {
        JPanel salesPanel = new JPanel(new BorderLayout());
          salesPanel.setBackground(Color.WHITE);
        TitledBorder salesBorder = BorderFactory.createTitledBorder("Historico Vendas");
          salesBorder.setTitleFont(fntBold.deriveFont(14f));
          salesBorder.setTitleColor(AZUL_MAIN);
        salesPanel.setBorder(salesBorder);        
        String[] colunasVenda = {"ID", "Data", "Cliente", "Servico", "Valor"};
         tblVendas = new DefaultTableModel(colunasVenda, 0);
          
        JTable tabelaVendas = new JTable(tblVendas);
        tabelaVendas.setRowHeight(25);
        tabelaVendas.setFont(fntCustom);
        tabelaVendas.getTableHeader().setFont(fntBold);
        tabelaVendas.getTableHeader().setBackground(CRcinza);
        tabelaVendas.setSelectionBackground(AZUL_MAIN);
        tabelaVendas.setGridColor(CRcinza);
        JScrollPane scrollVendas = new JScrollPane(tabelaVendas);
        JButton btnVenda = makeButton("Nova Venda", AZUL_MAIN);
         btnVenda.addActionListener(e -> showSaleDialog());
         salesPanel.add(scrollVendas, BorderLayout.CENTER);
         salesPanel.add(btnVenda, BorderLayout.SOUTH);
        
        return salesPanel;
    }    private JPanel buildScheduleTable() {
      JPanel scheduleContainer = new JPanel(new BorderLayout());
      scheduleContainer.setBackground(Color.WHITE);
       TitledBorder scheduleBorder = BorderFactory.createTitledBorder("Proximos Agendamentos");
       scheduleBorder.setTitleFont(fntBold.deriveFont(14f));
       scheduleBorder.setTitleColor(AZUL_MAIN);
       scheduleContainer.setBorder(scheduleBorder);        
       String[] colunasAgenda = {"Data", "Hora", "Cliente", "Pet", "Servico"};
       tblAgenda = new DefaultTableModel(colunasAgenda, 0);        
        
        JTable tabelaAgenda = new JTable(tblAgenda);
        tabelaAgenda.setRowHeight(25);
        tabelaAgenda.setFont(fntCustom);
        tabelaAgenda.getTableHeader().setFont(fntBold);
        tabelaAgenda.getTableHeader().setBackground(CRcinza);
        tabelaAgenda.setSelectionBackground(AZUL_MAIN);
        tabelaAgenda.setGridColor(CRcinza);
        JScrollPane scrollAgenda = new JScrollPane(tabelaAgenda);
        JButton btnAgendar = makeButton("Agendar", AZUL_MAIN);
        btnAgendar.addActionListener(e -> showScheduleDialog());
        scheduleContainer.add(scrollAgenda, BorderLayout.CENTER);
        scheduleContainer.add(btnAgendar, BorderLayout.SOUTH);        
        return scheduleContainer;
    }
    
    private JButton makeButton(String text, Color color) {
        JButton button = new JButton(text);
      button.setFont(fntBold);
      button.setBackground(color);
      button.setForeground(Color.WHITE);
       button.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
       button.setFocusPainted(false);
        return button;
    }
    
private void showPetDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre um cliente primeiro!");
            return;
        }
        JDialog dlg = new JDialog(this, "Novo Animal", true);
                dlg.setSize(450, 450);
                dlg.setLocationRelativeTo(this);
        JPanel form = new JPanel(new GridBagLayout());
         form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
          
          // Cliente
          gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
          form.add(new JLabel("Proprietario:"), gbc);
          gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
          DefaultComboBoxModel<String> modeloCliente = new DefaultComboBoxModel<>();
          for (int i = 0; i < tblClientes.getRowCount(); i++) {
              modeloCliente.addElement(tblClientes.getValueAt(i, 1).toString());
          }
          JComboBox<String> clienteBox = new JComboBox<>(modeloCliente);
          form.add(clienteBox, gbc);
          
          // Nome do pet
          gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
         form.add(new JLabel("Nome:"), gbc);        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField nameField = new JTextField(20);
          form.add(nameField, gbc);
          gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
          form.add(new JLabel("Tipo:"), gbc);
          gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] tipos = {"Cao", "Gato", "Ave", "Coelho", "Outros"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);
            form.add(tipoBox, gbc);
            gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
            form.add(new JLabel("Raca:"), gbc);
              gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField racaField = new JTextField(20);
           form.add(racaField, gbc);
           gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
            form.add(new JLabel("Idade:"), gbc);
           gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField idadeField = new JTextField(20);
           form.add(idadeField, gbc);
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton okBtn = makeButton("Salvar", GREEN_ACCENT);
        JButton cancelBtn = makeButton("Cancelar", CINZA_NEUTRO);            okBtn.addActionListener(e -> {
            String cliente = (String) clienteBox.getSelectedItem();
            String nome = nameField.getText().trim();
            String tipo = (String) tipoBox.getSelectedItem();
            String raca = racaField.getText().trim();
            String idade = idadeField.getText().trim();
            
            if (cliente == null) {
                JOptionPane.showMessageDialog(dlg, "Selecione um proprietário!");
                return;
            }
            
            if (!isNomeValid(nome)) {
                JOptionPane.showMessageDialog(dlg, "Nome do pet deve ter pelo menos 2 caracteres!");
                return;
            }
            
            if (raca.length() < 2) {
                JOptionPane.showMessageDialog(dlg, "Raça deve ter pelo menos 2 caracteres!");
                return;
            }
            
            if (!isIdadeValid(idade)) {
                JOptionPane.showMessageDialog(dlg, "Idade deve ser um número entre 0 e 30!");
                return;
            }
              String idPet = String.format("P%03d", tblPets.getRowCount() + 1);
            tblPets.addRow(new Object[]{idPet, nome, tipo, raca, cliente});
            saveAllData(); // Salvar automaticamente
            dlg.dispose();
            JOptionPane.showMessageDialog(this, "Pet cadastrado com sucesso!");
        });cancelBtn.addActionListener(e -> dlg.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        dlg.add(form);
        dlg.setVisible(true);
    }
      private void showClientDialog() {
        JDialog clientDlg = new JDialog(this, "Cadastro Cliente", true);
        clientDlg.setSize(390, 270);
        clientDlg.setLocationRelativeTo(this);
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
        JButton salvarBtn = makeButton("Salvar", GREEN_ACCENT);
        JButton cancelarBtn = makeButton("Cancelar", CINZA_NEUTRO);        salvarBtn.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String tel = telefoneField.getText().trim();
            String email = emailField.getText().trim();
            
            if (!isNomeValid(nome)) {
                JOptionPane.showMessageDialog(clientDlg, "Nome deve ter pelo menos 2 caracteres e conter apenas letras!");
                return;
            }
            
            if (!isTelefoneValid(tel)) {
                JOptionPane.showMessageDialog(clientDlg, "Telefone deve ter 10 ou 11 dígitos! Ex: (11) 98765-4321");
                return;
            }
            
            if (!isEmailValid(email)) {
                JOptionPane.showMessageDialog(clientDlg, "Email inválido! Ex: usuario@dominio.com");
                return;
            }
              String clientId = String.format("C%03d", tblClientes.getRowCount() + 1);
            tblClientes.addRow(new Object[]{clientId, nome, tel, email});
            saveAllData(); // Salvar automaticamente
            
            clientDlg.dispose();
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
        });
        
        cancelarBtn.addActionListener(e -> clientDlg.dispose());
        
        btnPanel.add(salvarBtn);
        btnPanel.add(cancelarBtn);
        mainPanel.add(btnPanel);
        
        clientDlg.add(mainPanel);
        clientDlg.setVisible(true);
    }private void showSaleDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre clientes primeiro!");
            return;
        }
        
        JDialog saleDialog = new JDialog(this, "Registrar Venda", true);
        saleDialog.setSize(420, 350);
        saleDialog.setLocationRelativeTo(this);
        
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
        }        JComboBox<String> comboCliente = new JComboBox<>(modeloCliente);
        form.add(comboCliente, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Pet (opcional):"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        DefaultComboBoxModel<String> modeloPetVenda = new DefaultComboBoxModel<>();
        modeloPetVenda.addElement("-- Sem pet específico --");
        for (int i = 0; i < tblPets.getRowCount(); i++) {
            String nomePet = tblPets.getValueAt(i, 1).toString();
            String proprietario = tblPets.getValueAt(i, 4).toString();
            modeloPetVenda.addElement(nomePet + " (" + proprietario + ")");
        }
        JComboBox<String> comboPetVenda = new JComboBox<>(modeloPetVenda);
        form.add(comboPetVenda, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Tipo de Servico:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] servicos = {"Banho Completo", "Tosa Higienica", "Consulta Veterinaria", "Vacinacao", "Vermifugacao", "Cirurgia", "Hospedagem"};        JComboBox<String> comboServico = new JComboBox<>(servicos);
        form.add(comboServico, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        form.add(new JLabel("Valor:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField campoValor = new JTextField("0.00", 15);
        form.add(campoValor, gbc);
        
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton okBtn = makeButton("Registrar", GREEN_ACCENT);
        JButton cancelBtn = makeButton("Cancelar", CINZA_NEUTRO);
          okBtn.addActionListener(e -> {
            String cliente = (String) comboCliente.getSelectedItem();
            String petInfo = (String) comboPetVenda.getSelectedItem();
            String servico = (String) comboServico.getSelectedItem();
            String valor = campoValor.getText().trim();
            
            if (cliente == null || servico == null || valor.isEmpty()) {
                JOptionPane.showMessageDialog(saleDialog, "Preencha todos os campos obrigatórios!");
                return;
            }
            
            String servicoCompleto = servico;
            if (petInfo != null && !petInfo.equals("-- Sem pet específico --")) {
                String nomePet = petInfo.split(" \\(")[0];
                servicoCompleto = servico + " (" + nomePet + ")";
            }try {
                double valorNumerico = Double.parseDouble(valor.replace(",", "."));
                if (valorNumerico <= 0) {
                    JOptionPane.showMessageDialog(saleDialog, "Valor deve ser maior que zero!");
                    return;
                }                String idVenda = String.format("V%03d", tblVendas.getRowCount() + 1);
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                String hoje = fmt.format(new Date());
                tblVendas.addRow(new Object[]{idVenda, hoje, cliente, servicoCompleto, "R$ " + valor});
                saveAllData(); // Salvar automaticamente
                
                saleDialog.dispose();
                JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(saleDialog, "Valor invalido!");
            }
        });
        
        cancelBtn.addActionListener(e -> saleDialog.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        
        saleDialog.add(form);
        saleDialog.setVisible(true);
    }    private void showScheduleDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre clientes primeiro!");
            return;
        }
        
        JDialog agendaDialog = new JDialog(this, "Novo Agendamento", true);
        agendaDialog.setSize(420, 380);
        agendaDialog.setLocationRelativeTo(this);
        
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
        DefaultComboBoxModel<String> modeloPet = new DefaultComboBoxModel<>();
        for (int i = 0; i < tblPets.getRowCount(); i++) {
            String nomePet = tblPets.getValueAt(i, 1).toString();
            String proprietario = tblPets.getValueAt(i, 4).toString();
            modeloPet.addElement(nomePet + " (" + proprietario + ")");
        }
        JComboBox<String> comboPet = new JComboBox<>(modeloPet);
        form.add(comboPet, gbc);
        
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
        JButton okBtn = makeButton("Agendar", GREEN_ACCENT);
        JButton cancelBtn = makeButton("Cancelar", CINZA_NEUTRO);          okBtn.addActionListener(e -> {
            String cliente = (String) comboCliente.getSelectedItem();
            String petInfo = (String) comboPet.getSelectedItem();
            String data = campoData.getText().trim();
            String horario = (String) comboHorario.getSelectedItem();
            String servico = (String) comboServico.getSelectedItem();
            
            if (cliente == null || petInfo == null || data.isEmpty() || horario == null || servico == null) {
                JOptionPane.showMessageDialog(agendaDialog, "Preencha todos os campos!");
                return;
            }
            
            // Extrair nome do pet da string "NomePet (Proprietario)"
            String pet = petInfo.split(" \\(")[0];
              tblAgenda.addRow(new Object[]{data, horario, cliente, pet, servico});
            saveAllData(); // Salvar automaticamente
            agendaDialog.dispose();
            JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
        });
        
        cancelBtn.addActionListener(e -> agendaDialog.dispose());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnPanel, gbc);
        
        agendaDialog.add(form);
        agendaDialog.setVisible(true);
    }    private void generateReport() {
        int totalPets = tblPets.getRowCount();
        int totalClientes = tblClientes.getRowCount();
        int totalVendas = tblVendas.getRowCount();
        int agendamentos = tblAgenda.getRowCount();
        
        double mediaClientesPorPet = totalClientes > 0 ? (double)totalPets / totalClientes : 0;
          StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RELATORIO GERENCIAL ===\n\n");
        relatorio.append("Data: ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())).append("\n\n");
        
        relatorio.append("RESUMO GERAL:\n");
        relatorio.append("Pets cadastrados: ").append(totalPets).append("\n");
        relatorio.append("Clientes ativos: ").append(totalClientes).append("\n");
        relatorio.append("Vendas realizadas: ").append(totalVendas).append("\n");
        relatorio.append("Proximos agendamentos: ").append(agendamentos).append("\n\n");
        
        relatorio.append("ANALISES:\n");
        relatorio.append("Media pets/cliente: ").append(String.format("%.2f", mediaClientesPorPet)).append("\n");
        
        if (totalVendas > 0) {
            relatorio.append("Status: Sistema ativo com movimento\n");
        } else {
            relatorio.append("Status: Aguardando primeiras vendas\n");
        }
        
        relatorio.append("\n--- Relatorio gerado automaticamente ---");
        
        JTextArea areaTexto = new JTextArea(relatorio.toString());
        areaTexto.setEditable(false);        areaTexto.setFont(fntCustom);
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(400, 300));
          JOptionPane.showMessageDialog(this, scroll, "Relatorio do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    // Metodos de validacao
    private boolean isEmailValid(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailPattern);
    }
    
    private boolean isTelefoneValid(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) return false;
        String cleanPhone = telefone.replaceAll("[\\s()\\-]", "");
        return cleanPhone.matches("^\\d{10,11}$");
    }
    
    private boolean isNomeValid(String nome) {
        return nome != null && nome.trim().length() >= 2 && nome.matches("^[a-zA-ZÀ-ÿ\\s]+$");
    }
    
    private boolean isIdadeValid(String idade) {
        try {
            int idadeInt = Integer.parseInt(idade);
            return idadeInt >= 0 && idadeInt <= 30;
        } catch (NumberFormatException e) {
            return false;
        }
    }    private void deletarPet(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um pet para deletar!");
            return;
        }
        
        String nomePet = tblPets.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Tem certeza que deseja deletar o pet '" + nomePet + "'?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);
              if (confirm == JOptionPane.YES_OPTION) {
            tblPets.removeRow(selectedRow);
            saveAllData(); // Salvar automaticamente
            JOptionPane.showMessageDialog(this, "Pet deletado com sucesso!");
        }
    }
    
    private void deletarCliente(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para deletar!");
            return;
        }
        
        String nomeCliente = tblClientes.getValueAt(selectedRow, 1).toString();
        
        // Verificar se cliente tem pets
        boolean temPets = false;
        for (int i = 0; i < tblPets.getRowCount(); i++) {
            if (tblPets.getValueAt(i, 4).toString().equals(nomeCliente)) {
                temPets = true;
                break;
            }
        }
        
        if (temPets) {
            JOptionPane.showMessageDialog(this, "Não é possível deletar cliente que possui pets cadastrados!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Tem certeza que deseja deletar o cliente '" + nomeCliente + "'?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);
              if (confirm == JOptionPane.YES_OPTION) {
            tblClientes.removeRow(selectedRow);
            saveAllData(); // Salvar automaticamente
            JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso!");
        }
    }
    
    // Carregar todos os dados
    private void loadAllData() {
        DataPersistence.loadClientes(tblClientes);
        DataPersistence.loadPets(tblPets);
        DataPersistence.loadVendas(tblVendas);
        DataPersistence.loadAgenda(tblAgenda);
    }
    
    // Salvar todos os dados
    private void saveAllData() {
        DataPersistence.saveClientes(tblClientes);
        DataPersistence.savePets(tblPets);
        DataPersistence.saveVendas(tblVendas);
        DataPersistence.saveAgenda(tblAgenda);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaPetShopUI().setVisible(true);
        });
    }
}
