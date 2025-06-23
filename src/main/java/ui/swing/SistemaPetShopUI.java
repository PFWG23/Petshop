package ui.swing;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
public class SistemaPetShopUI extends JFrame {
  private static final long serialVersionUID = 1L;
    private DefaultTableModel animalsData;
    private DefaultTableModel customerTbl;
    private DefaultTableModel vendas_model;
    private DefaultTableModel scheduleThing;
      Color azulEscuro = new Color(41, 79, 121);
      Color cinzento = new Color(161, 172, 178);
      Color verdeClaro = new Color(29, 158, 84);
      Color azul = new Color(51, 131, 198);
      Color bgColor = new Color(243, 246, 249);
      Color greenBtn = new Color(29, 158, 84);
      Color grayish = new Color(161, 172, 178);

    public SistemaPetShopUI() {
        setupWindow();
        createInterface();
    }
    private void setupWindow() {
        setTitle("Pet Shop Management System/ Sistema de Gerenciamento de Pets");
        setBounds(100, 60, 1180, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private void createInterface() {
        JPanel mainPanel = new JPanel(new BorderLayout());
         mainPanel.setBackground(bgColor);
        JPanel header = buildHeader();
         mainPanel.add(header, BorderLayout.NORTH);
        JPanel sidebar = buildSidebar();
         mainPanel.add(sidebar, BorderLayout.WEST);
        JPanel center = buildCenterArea();
         mainPanel.add(center, BorderLayout.CENTER);
     JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
          statusBar.setBackground(cinzento);
           statusBar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        JLabel statusLabel = new JLabel("Sistema ativo");
           statusLabel.setFont(new Font("Arial", Font.PLAIN, 11));
           statusLabel.setForeground(azulEscuro);
           statusBar.add(statusLabel);
           mainPanel.add(statusBar, BorderLayout.SOUTH);
        add(mainPanel);
    }
    private JPanel buildHeader() {
        JPanel topPanel = new JPanel(new BorderLayout());
          topPanel.setBackground(azulEscuro);
          topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titulo = new JLabel("Sistema Pet Shop");
          titulo.setFont(new Font("Arial", Font.BOLD, 20));
          titulo.setForeground(Color.WHITE);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm");
        JLabel horario = new JLabel(sdf.format(new Date()));
          horario.setFont(new Font("Arial", Font.PLAIN, 12));
          horario.setForeground(Color.WHITE);
        
          topPanel.add(titulo, BorderLayout.WEST);
          topPanel.add(horario, BorderLayout.EAST);
        
        return topPanel;
    }    
    private JPanel buildSidebar() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(cinzento);
        leftPanel.setPreferredSize(new Dimension(180, 0));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
            JButton homeBtn = createMenuButton("Início");
            JButton petsBtn = createMenuButton("Animais");
            JButton clientesBtn = createMenuButton("Clientes");  
            JButton vendasBtn = createMenuButton("Vendas");
            JButton agendaBtn = createMenuButton("Agenda");
            JButton relatorioBtn = createMenuButton("Relatórios");
         leftPanel.add(homeBtn);
         leftPanel.add(Box.createVerticalStrut(10));
         leftPanel.add(petsBtn);
         leftPanel.add(Box.createVerticalStrut(15));
         leftPanel.add(clientesBtn);
         leftPanel.add(Box.createVerticalStrut(10));
         leftPanel.add(vendasBtn);
         leftPanel.add(Box.createVerticalStrut(12));
         leftPanel.add(agendaBtn);
         leftPanel.add(Box.createVerticalStrut(10));
         leftPanel.add(relatorioBtn);
        
        return leftPanel;
    }
    private JButton createMenuButton(String texto) {
        JButton btn = new JButton(texto);
     btn.setPreferredSize(new Dimension(160, 35));
       btn.setMaximumSize(new Dimension(160, 35));
     btn.setFont(new Font("Arial", Font.BOLD, 12));
       btn.setBackground(Color.WHITE);
     btn.setForeground(azulEscuro);
       btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(azul, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        btn.addActionListener(e -> menuAction(texto));
        return btn;
    }
      private void menuAction(String acao) {
        if(acao.equals("Início")) {
            showWelcome();
        } else if(acao.equals("Animais")) {
            openPetDialog();
        } else if(acao.equals("Clientes")) {
            newClientDialog();
        } else if(acao.equals("Vendas")) {
            addSale();
        } else if(acao.equals("Agenda")) {
            newAppointment();
        } else if(acao.equals("Relatórios")) {
            generateReport();
        }
    }
    private JPanel buildCenterArea() {
     JPanel areaTabelas = new JPanel(new GridLayout(2, 2, 12, 12));
     areaTabelas.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
     areaTabelas.setBackground(bgColor);
     JPanel tabelaPets = construirTabelaAnimais();
     JPanel tabelaClientes = construirTabelaClientes();  
     JPanel tabelaVendas = construirTabelaVendas();
     JPanel tabelaAgenda = construirTabelaAgendamentos();
           areaTabelas.add(tabelaPets);
           areaTabelas.add(tabelaClientes);
        areaTabelas.add(tabelaVendas);
           areaTabelas.add(tabelaAgenda);
        return areaTabelas;
    }private JPanel construirTabelaAnimais() {
        JPanel painelPets = new JPanel(new BorderLayout());
        painelPets.setBackground(Color.WHITE);
        
      TitledBorder bordaPets = BorderFactory.createTitledBorder("Registro de Pets");
         bordaPets.setTitleFont(new Font("Arial", Font.BOLD, 14));
         bordaPets.setTitleColor(azul);
         painelPets.setBorder(bordaPets);
        String[] colunasPet = {"ID", "Nome", "Tipo", "Raça", "Idade"};
          animalsData = new DefaultTableModel(colunasPet, 0);
        String[][] dadosPets = {
            {"P001", "Rex", "Cachorro", "Pastor Alemão", "3"},
            {"P002", "Mimi", "Gato", "Persa", "2"},
            {"P003", "Buddy", "Cachorro", "Golden", "5"},
            {"P004", "Floquinho", "Coelho", "Angorá", "1"}
        };
        
        for (String[] pet : dadosPets) {
            animalsData.addRow(pet);
        }
        
        JTable tabelaPet = new JTable(animalsData);
        configTable(tabelaPet);
        JScrollPane scrollPet = new JScrollPane(tabelaPet);
        JButton btnAddPet = criarBotao("Adicionar", azul);
        btnAddPet.addActionListener(e -> openPetDialog());
        painelPets.add(scrollPet, BorderLayout.CENTER);
        painelPets.add(btnAddPet, BorderLayout.SOUTH);
        
        return painelPets;
    }
    
    private JPanel construirTabelaClientes() {
        JPanel painelClientes = new JPanel(new BorderLayout());
        painelClientes.setBackground(Color.WHITE);
        
        TitledBorder bordaClientes = BorderFactory.createTitledBorder("Base de Clientes");
          bordaClientes.setTitleFont(new Font("Arial", Font.BOLD, 14));
          bordaClientes.setTitleColor(azul);
          painelClientes.setBorder(bordaClientes);
        String[] colunasCliente = {"ID", "Nome Completo", "Telefone", "Email"};
        customerTbl = new DefaultTableModel(colunasCliente, 0);
        String[][] dadosClientes = {
            {"C001", "Ana Paula Ferreira", "(11) 94567-8901", "ana.ferreira@gmail.com"},
            {"C002", "João Carlos Mendes", "(11) 91234-5678", "joao.mendes@hotmail.com"},
            {"C003", "Maria Luiza Costa", "(11) 98765-4321", "malu.costa@outlook.com"},
            {"C004", "Pedro Henrique Silva", "(11) 95432-1098", "pedro.silva@yahoo.com"}
        };
        
        for (String[] cliente : dadosClientes) {
            customerTbl.addRow(cliente);
        }
        
        JTable tabelaCliente = new JTable(customerTbl);
        configTable(tabelaCliente);
        JScrollPane scrollCliente = new JScrollPane(tabelaCliente);
        JButton btnNovoCliente = criarBotao("Novo Cliente", azul);
          btnNovoCliente.addActionListener(e -> newClientDialog());
          painelClientes.add(scrollCliente, BorderLayout.CENTER);
          painelClientes.add(btnNovoCliente, BorderLayout.SOUTH);
        
        return painelClientes;
    }    
    
    private JPanel construirTabelaVendas() {
        JPanel painelVendas = new JPanel(new BorderLayout());
          painelVendas.setBackground(Color.WHITE);
        TitledBorder bordaVendas = BorderFactory.createTitledBorder("Histórico Vendas");
          bordaVendas.setTitleFont(new Font("Arial", Font.BOLD, 14));
          bordaVendas.setTitleColor(azul);
        painelVendas.setBorder(bordaVendas);
        String[] colunasVenda = {"ID", "Data", "Cliente", "Serviço", "Valor"};
         vendas_model = new DefaultTableModel(colunasVenda, 0);
        
        String[][] dadosVendas = {
            {"V001", "21/06/2025", "Ana Paula", "Banho e Tosa", "R$ 75,00"},
            {"V002", "22/06/2025", "João Carlos", "Consulta", "R$ 90,00"},
            {"V003", "23/06/2025", "Maria Luiza", "Vacinação", "R$ 45,00"}
        };
        
        for (String[] venda : dadosVendas) {
            vendas_model.addRow(venda);
        }
        
        JTable tblVendas = new JTable(vendas_model);
         configTableStyle(tblVendas);
        JScrollPane spVendas = new JScrollPane(tblVendas);
        JButton btnVenda = criarBotao("Nova Venda", azul);
         btnVenda.addActionListener(e -> addSale());
         painelVendas.add(spVendas, BorderLayout.CENTER);
         painelVendas.add(btnVenda, BorderLayout.SOUTH);
        
        return painelVendas;
    }
    
    private JPanel construirTabelaAgendamentos() {
        JPanel containerAgenda = new JPanel(new BorderLayout());
        containerAgenda.setBackground(Color.WHITE);
        
        TitledBorder bordaAgenda = BorderFactory.createTitledBorder("Próximos Agendamentos");
        bordaAgenda.setTitleFont(new Font("Arial", Font.BOLD, 14));
        bordaAgenda.setTitleColor(azul);
        containerAgenda.setBorder(bordaAgenda);
        String[] colunasAgenda = {"Data", "Hora", "Cliente", "Pet", "Serviço"};
        scheduleThing = new DefaultTableModel(colunasAgenda, 0);
        String[][] dadosAgenda = {
            {"26/06/2025", "09:00", "Ana Paula", "Rex", "Banho"},
            {"26/06/2025", "14:30", "João Carlos", "Mimi", "Consulta"},
            {"27/06/2025", "10:15", "Pedro Silva", "Floquinho", "Check-up"}
        };
        
        for (String[] agendamento : dadosAgenda) {
            scheduleThing.addRow(agendamento);
        }

        JTable tabelaAgenda = new JTable(scheduleThing);
        configTableStyle(tabelaAgenda);
        JScrollPane scrollAgenda = new JScrollPane(tabelaAgenda);
        JButton btnAgendar = criarBotao("Agendar", azul);
        btnAgendar.addActionListener(e -> newAppointment());
        containerAgenda.add(scrollAgenda, BorderLayout.CENTER);
        containerAgenda.add(btnAgendar, BorderLayout.SOUTH);
        
        return containerAgenda;
    }    
    private void configTable(JTable tabela) {
     tabela.setRowHeight(26);
     tabela.setFont(new Font("Arial", Font.PLAIN, 11));
     tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
     tabela.getTableHeader().setBackground(cinzento);
     tabela.setSelectionBackground(azul);
     tabela.setGridColor(cinzento);
    }
    private void configTableStyle(JTable table) {
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 10));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
        table.getTableHeader().setBackground(cinzento);
        table.setSelectionBackground(azul);
        table.setGridColor(cinzento);
    }
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
     botao.setFont(new Font("Arial", Font.BOLD, 11));
     botao.setBackground(cor);
     botao.setForeground(Color.WHITE);
     botao.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
     botao.setFocusPainted(false);
        return botao;
    }    
private void openPetDialog() {
        if (customerTbl.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Adicione clientes primeiro!");
            return;
        }
        
        JDialog dlg = new JDialog(this, "Adicionar Pet", true);
                dlg.setSize(380, 300);
                dlg.setLocationRelativeTo(this);
        
        JPanel form = new JPanel(new GridBagLayout());
         form.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
         form.add(new JLabel("Nome do pet:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField nameInput = new JTextField(14);
         form.add(nameInput, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
         form.add(new JLabel("Tipo de animal:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        String[] animalTypes = {"Cachorro", "Gato", "Passaro", "Coelho", "Peixe", "Outro"};
        JComboBox<String> typeBox = new JComboBox<>(animalTypes);
         form.add(typeBox, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
         form.add(new JLabel("Raca:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField breedInput = new JTextField(14);
         form.add(breedInput, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
         form.add(new JLabel("Idade:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField ageInput = new JTextField(14);
         form.add(ageInput, gbc);
    
        JPanel buttonArea = new JPanel(new FlowLayout());
        JButton saveButton = makeButton("Salvar", greenBtn);
        JButton cancelButton = makeButton("Cancelar", grayish);
        
        saveButton.addActionListener(e -> {
            String name = nameInput.getText().trim();
            String type = (String) typeBox.getSelectedItem();
            String breed = breedInput.getText().trim();
            String age = ageInput.getText().trim();
            
            if (name.isEmpty() || breed.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(dlg, "Preencha todos os campos!");
                return;
            }
            
            String newId = String.format("P%03d", animalsData.getRowCount() + 1);
            animalsData.addRow(new Object[]{newId, name, type, breed, age});
            
            dlg.dispose();
            JOptionPane.showMessageDialog(this, "Pet adicionado com sucesso!");
        });        
        cancelButton.addActionListener(e -> dlg.dispose());
        buttonArea.add(saveButton);
        buttonArea.add(cancelButton);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(buttonArea, gbc);
        dlg.add(form);
        dlg.setVisible(true);
    }    private void newClientDialog() {
        JDialog window = new JDialog(this, "Novo Cliente", true);
          window.setSize(360, 220);
          window.setLocationRelativeTo(this);
        JPanel panel = new JPanel(new GridBagLayout());
         panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
               gbc.insets= new Insets(5, 5, 5, 5);
              gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Nome Completo:"), gbc);
          gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField nameField = new JTextField(20);
               panel.add(nameField, gbc);
              gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
             panel.add(new JLabel("Telefone:"), gbc);
            gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField phoneField = new JTextField(20);
             panel.add(phoneField, gbc);
            gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
           panel.add(new JLabel("Email:"), gbc);
           gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
          JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);        
          JPanel buttons = new JPanel(new FlowLayout());
          JButton okBtn = makeButton("Adicionar", greenBtn);
          JButton cancelBtn = makeButton("Fechar", grayish);
    
        okBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Todos os campos sao obrigatorios!");
                return;
            }
            
            String newId = String.format("C%03d", customerTbl.getRowCount() + 1);
            customerTbl.addRow(new Object[]{newId, name, phone, email});
            
            window.dispose();
            JOptionPane.showMessageDialog(this, "Cliente adicionado!");
        });
        
        cancelBtn.addActionListener(e -> window.dispose());
        
        buttons.add(okBtn);
        buttons.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buttons, gbc);
        
        window.add(panel);
        window.setVisible(true);
    }
      private void addSale() {
        if (customerTbl.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado!");
            return;
        }
        
        String customer = JOptionPane.showInputDialog(this, "Nome do cliente:");
        if (customer != null && !customer.trim().isEmpty()) {
            String amount = JOptionPane.showInputDialog(this, "Valor da venda:");
            if (amount != null && !amount.trim().isEmpty()) {
              String saleId = "S" + String.format("%03d", vendas_model.getRowCount() + 1);
              SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
              String today = dateFormat.format(new Date());
                vendas_model.addRow(new Object[]{saleId, today, customer, "Servico", "R$ " + amount});
              JOptionPane.showMessageDialog(this, "Venda registrada!");
            }
        }
    }
      private void newAppointment() {
        if (customerTbl.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente disponivel!");
            return;
        }
        
        String customer = JOptionPane.showInputDialog(this, "Cliente:");
        if (customer != null && !customer.trim().isEmpty()) {
            String petName = JOptionPane.showInputDialog(this, "Nome do pet:");
            if (petName != null && !petName.trim().isEmpty()) {
                String appointmentDate = JOptionPane.showInputDialog(this, "Data (dd/MM/yyyy):");
                if (appointmentDate != null && !appointmentDate.trim().isEmpty()) {
                    scheduleThing.addRow(new Object[]{appointmentDate, "09:00", customer, petName, "Consulta"});
                    JOptionPane.showMessageDialog(this, "Agendamento realizado!");
                }
            }
        }
    }
      private void generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("RELATORIO DO SISTEMA\n\n");
        
        int pets = animalsData.getRowCount();
        int customers = customerTbl.getRowCount();
        int sales = vendas_model.getRowCount();
        int appointments = scheduleThing.getRowCount();
        
        report.append("Total de pets: ").append(pets).append("\n");
        report.append("Total de clientes: ").append(customers).append("\n");
        report.append("Total de vendas: ").append(sales).append("\n");
        report.append("Agendamentos: ").append(appointments).append("\n\n");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        report.append("Gerado em: ").append(dateFormat.format(new Date()));
        
        JOptionPane.showMessageDialog(this, report.toString(), "Relatorio", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showWelcome() {
      StringBuilder message = new StringBuilder();
       message.append("Sistema de Gerenciamento de Pets\n\n");
       message.append("Funcionalidades disponíveis:\n");
       message.append("• Cadastro de pets\n");
       message.append("• Gerenciamento de clientes\n");
       message.append("• Controle de vendas\n");
       message.append("• Agendamento de consultas\n");
       message.append("• Geração de relatórios\n\n");
       message.append("Use a barra lateral para navegar.");
        JOptionPane.showMessageDialog(this, message.toString(), "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
    }
      private JButton makeButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        button.setFocusPainted(false);
        return button;
    }
      public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaPetShopUI().setVisible(true);
        });
    }
}
