//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Interface gráfica simples para o Pet Shop usando Swing
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class PetShopSwingGUISimples extends JFrame {
    // Lista para guardar todos os clientes
    private static List<Cliente> listaClientes = new ArrayList<>();
    
    // Componentes da interface
    private JTabbedPane abas;
    private DefaultTableModel tabelaClientesModel;
    private DefaultTableModel tabelaPetsModel;
    private JTable tabelaClientes;
    private JTable tabelaPets;
      // Construtor - cria a janela principal
    public PetShopSwingGUISimples() {
        setTitle("Pet Shop - Interface Gráfica Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650); // tamanho da janela
        setLocationRelativeTo(null); // centraliza
        
        criarComponentes();
        organizarLayout();
        
        setVisible(true); // mostra a janela
    }
    
    // Método que cria todos os componentes
    private void criarComponentes() {
        abas = new JTabbedPane(); // cria o painel com abas
        
        // Criando as tabelas para mostrar os dados
        // Tabela de clientes
        String[] colunasClientes = {"Nome", "Telefone", "Email", "Qtd Pets"};
        tabelaClientesModel = new DefaultTableModel(colunasClientes, 0) {
            // Não deixa editar as células da tabela
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaClientes = new JTable(tabelaClientesModel);
        
        // Tabela de pets
        String[] colunasPets = {"Nome", "Espécie", "Raça", "Idade", "Peso", "Dono"};
        tabelaPetsModel = new DefaultTableModel(colunasPets, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaPets = new JTable(tabelaPetsModel);
    }
    
    // Organiza o layout da janela
    private void organizarLayout() {
        // Aba para cadastrar clientes
        JPanel painelClientes = criarPainelClientes();
        abas.addTab("Clientes", painelClientes);
        
        // Aba para cadastrar pets
        JPanel painelPets = criarPainelPets();
        abas.addTab("Pets", painelPets);
        
        // Aba para contratar serviços
        JPanel painelServicos = criarPainelServicos();
        abas.addTab("Serviços", painelServicos);
        
        // Aba para ver relatórios
        JPanel painelRelatorios = criarPainelRelatorios();
        abas.addTab("Relatórios", painelRelatorios);
        
        add(abas); // adiciona as abas na janela
    }
    
    // Cria o painel da aba de clientes
    private JPanel criarPainelClientes() {
        JPanel painel = new JPanel(new BorderLayout());
        
        // Painel superior com o formulário
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastrar Novo Cliente"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // espaçamento
        
        // Campos do formulário
        JTextField campoNome = new JTextField(20);
        JTextField campoTelefone = new JTextField(20);
        JTextField campoEmail = new JTextField(20);
        
        // Organizando os campos no painel
        gbc.gridx = 0; gbc.gridy = 0;
        painelFormulario.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoNome, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        painelFormulario.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoTelefone, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        painelFormulario.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoEmail, gbc);
        
        // Botão para cadastrar
        JButton botaoCadastrar = new JButton("Cadastrar Cliente");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega os dados dos campos
                String nome = campoNome.getText().trim();
                String telefone = campoTelefone.getText().trim();
                String email = campoEmail.getText().trim();
                
                // Verifica se todos os campos foram preenchidos
                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Por favor, preencha todos os campos!");
                    return;
                }
                
                // Cria o cliente e adiciona na lista
                Cliente novoCliente = new Cliente(nome, telefone, email);
                listaClientes.add(novoCliente);
                
                // Adiciona na tabela
                Object[] linha = {nome, telefone, email, 0}; // 0 pets inicialmente
                tabelaClientesModel.addRow(linha);
                
                // Limpa os campos
                campoNome.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");
                
                // Mostra mensagem de sucesso
                JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                    "Cliente cadastrado com sucesso!");
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2; // ocupa 2 colunas
        painelFormulario.add(botaoCadastrar, gbc);
        
        // Painel com a tabela
        JScrollPane scrollTabela = new JScrollPane(tabelaClientes);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Clientes Cadastrados"));
        
        painel.add(painelFormulario, BorderLayout.NORTH);
        painel.add(scrollTabela, BorderLayout.CENTER);
        
        return painel;
    }
    
    // Cria o painel da aba de pets
    private JPanel criarPainelPets() {
        JPanel painel = new JPanel(new BorderLayout());
        
        // Formulário para cadastrar pets
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastrar Novo Pet"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campos do formulário
        JComboBox<String> comboClientes = new JComboBox<>();
        JTextField campoNomePet = new JTextField(20);
        JTextField campoEspecie = new JTextField(20);
        JTextField campoRaca = new JTextField(20);
        JTextField campoIdade = new JTextField(20);
        JTextField campoPeso = new JTextField(20);
        
        // Atualiza a lista de clientes no combo
        atualizarComboClientes(comboClientes);
        
        // Organizando os campos
        gbc.gridx = 0; gbc.gridy = 0;
        painelFormulario.add(new JLabel("Cliente:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(comboClientes, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        painelFormulario.add(new JLabel("Nome do Pet:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoNomePet, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        painelFormulario.add(new JLabel("Espécie:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoEspecie, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        painelFormulario.add(new JLabel("Raça:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoRaca, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        painelFormulario.add(new JLabel("Idade:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoIdade, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        painelFormulario.add(new JLabel("Peso:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoPeso, gbc);
        
        // Botão para cadastrar pet
        JButton botaoCadastrar = new JButton("Cadastrar Pet");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se selecionou um cliente
                if (comboClientes.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Selecione um cliente primeiro!");
                    return;
                }
                
                // Pega os dados dos campos
                String nomePet = campoNomePet.getText().trim();
                String especie = campoEspecie.getText().trim();
                String raca = campoRaca.getText().trim();
                String idadeStr = campoIdade.getText().trim();
                String pesoStr = campoPeso.getText().trim();
                
                // Verifica se todos os campos foram preenchidos
                if (nomePet.isEmpty() || especie.isEmpty() || raca.isEmpty() || 
                    idadeStr.isEmpty() || pesoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Preencha todos os campos!");
                    return;
                }
                
                try {
                    // Converte idade e peso para números
                    int idade = Integer.parseInt(idadeStr);
                    double peso = Double.parseDouble(pesoStr);
                    
                    // Pega o cliente selecionado
                    Cliente clienteSelecionado = listaClientes.get(comboClientes.getSelectedIndex());
                    
                    // Cria o pet e adiciona ao cliente
                    Pet novoPet = new Pet(nomePet, especie, raca, idade, peso);
                    clienteSelecionado.adicionarPet(novoPet);
                    
                    // Adiciona na tabela de pets
                    Object[] linha = {nomePet, especie, raca, idade, peso, clienteSelecionado.getNome()};
                    tabelaPetsModel.addRow(linha);
                    
                    // Atualiza a tabela de clientes (para mostrar a quantidade de pets)
                    atualizarTabelaClientes();
                    
                    // Limpa os campos
                    campoNomePet.setText("");
                    campoEspecie.setText("");
                    campoRaca.setText("");
                    campoIdade.setText("");
                    campoPeso.setText("");
                    
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Pet cadastrado com sucesso!");
                        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Idade deve ser um número inteiro e Peso um número decimal!");
                }
            }
        });
        
        // Botão para atualizar lista de clientes
        JButton botaoAtualizar = new JButton("Atualizar Lista");
        botaoAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarComboClientes(comboClientes);
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 1;
        painelFormulario.add(botaoAtualizar, gbc);
        
        gbc.gridx = 1; gbc.gridy = 6;
        painelFormulario.add(botaoCadastrar, gbc);
        
        // Tabela de pets
        JScrollPane scrollTabela = new JScrollPane(tabelaPets);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Pets Cadastrados"));
        
        painel.add(painelFormulario, BorderLayout.NORTH);
        painel.add(scrollTabela, BorderLayout.CENTER);
        
        return painel;
    }
    
    // Cria o painel da aba de serviços
    private JPanel criarPainelServicos() {
        JPanel painel = new JPanel(new BorderLayout());
        
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Contratar Serviço"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campos do formulário
        JComboBox<String> comboClientes = new JComboBox<>();
        JComboBox<String> comboPets = new JComboBox<>();
        JComboBox<String> comboServicos = new JComboBox<>();
        JTextField campoData = new JTextField(20);
        
        // Opções de serviços
        comboServicos.addItem("Banho e Tosa - R$ 50,00");
        comboServicos.addItem("Consulta Veterinária - R$ 100,00");
        comboServicos.addItem("Hospedagem - R$ 80,00");
        comboServicos.addItem("Adestramento - R$ 120,00");
        
        atualizarComboClientes(comboClientes);
        
        // Quando seleciona um cliente, atualiza a lista de pets
        comboClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboPets.removeAllItems();
                if (comboClientes.getSelectedIndex() >= 0) {
                    Cliente cliente = listaClientes.get(comboClientes.getSelectedIndex());
                    for (Pet pet : cliente.getPets()) {
                        comboPets.addItem(pet.getNome());
                    }
                }
            }
        });
        
        // Organizando os campos
        gbc.gridx = 0; gbc.gridy = 0;
        painelFormulario.add(new JLabel("Cliente:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(comboClientes, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        painelFormulario.add(new JLabel("Pet:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(comboPets, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        painelFormulario.add(new JLabel("Serviço:"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(comboServicos, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        painelFormulario.add(new JLabel("Data (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoData, gbc);
        
        // Botão para contratar serviço
        JButton botaoContratar = new JButton("Contratar Serviço");
        botaoContratar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se selecionou cliente e pet
                if (comboClientes.getSelectedIndex() == -1 || comboPets.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Selecione cliente e pet!");
                    return;
                }
                
                String dataStr = campoData.getText().trim();
                if (dataStr.isEmpty()) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Informe a data do serviço!");
                    return;
                }
                
                try {
                    // Verifica se a data está no formato correto
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.parse(dataStr);
                    
                    // Pega os dados selecionados
                    Cliente cliente = listaClientes.get(comboClientes.getSelectedIndex());
                    String nomePet = comboPets.getSelectedItem().toString();
                    String servicoInfo = comboServicos.getSelectedItem().toString();
                    
                    // Monta a mensagem de confirmação
                    String mensagem = "Serviço contratado com sucesso!\n\n" +
                                    "Cliente: " + cliente.getNome() + "\n" +
                                    "Pet: " + nomePet + "\n" +
                                    "Serviço: " + servicoInfo + "\n" +
                                    "Data: " + dataStr;
                    
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, mensagem);
                    
                    // Limpa o campo de data
                    campoData.setText("");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PetShopSwingGUISimples.this, 
                        "Data inválida! Use o formato dd/MM/yyyy");
                }
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        painelFormulario.add(botaoContratar, gbc);
        
        painel.add(painelFormulario, BorderLayout.NORTH);
        
        return painel;
    }
    
    // Cria o painel da aba de relatórios
    private JPanel criarPainelRelatorios() {
        JPanel painel = new JPanel(new BorderLayout());
        
        // Área de texto para mostrar o relatório
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Courier New", Font.PLAIN, 12)); // fonte mono-espaçada
        
        // Botão para gerar relatório
        JButton botaoGerar = new JButton("Gerar Relatório");
        botaoGerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Monta o relatório
                StringBuilder relatorio = new StringBuilder();
                relatorio.append("=== RELATÓRIO DO PET SHOP ===\n\n");
                
                relatorio.append("Total de clientes: ").append(listaClientes.size()).append("\n\n");
                
                int totalPets = 0;
                for (Cliente cliente : listaClientes) {
                    relatorio.append("Cliente: ").append(cliente.getNome()).append("\n");
                    relatorio.append("Telefone: ").append(cliente.getTelefone()).append("\n");
                    relatorio.append("Email: ").append(cliente.getEmail()).append("\n");
                    relatorio.append("Quantidade de pets: ").append(cliente.getPets().size()).append("\n");
                    
                    // Lista os pets do cliente
                    for (Pet pet : cliente.getPets()) {
                        relatorio.append("  - ").append(pet.getNome())
                                 .append(" (").append(pet.getEspecie())
                                 .append(", ").append(pet.getRaca())
                                 .append(", ").append(pet.getIdade())
                                 .append(" anos, ").append(pet.getPeso())
                                 .append(" kg)\n");
                        totalPets++;
                    }
                    relatorio.append("\n");
                }
                
                relatorio.append("TOTAL DE PETS: ").append(totalPets).append("\n");
                
                // Mostra o relatório na área de texto
                areaTexto.setText(relatorio.toString());
            }
        });
        
        painel.add(botaoGerar, BorderLayout.NORTH);
        painel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        return painel;
    }
    
    // Método para atualizar o combo de clientes
    private void atualizarComboClientes(JComboBox<String> combo) {
        combo.removeAllItems();
        for (Cliente cliente : listaClientes) {
            combo.addItem(cliente.getNome());
        }
    }
    
    // Método para atualizar a tabela de clientes
    private void atualizarTabelaClientes() {
        // Limpa a tabela
        tabelaClientesModel.setRowCount(0);
        
        // Adiciona todos os clientes novamente
        for (Cliente cliente : listaClientes) {
            Object[] linha = {
                cliente.getNome(), 
                cliente.getTelefone(), 
                cliente.getEmail(), 
                cliente.getPets().size()
            };
            tabelaClientesModel.addRow(linha);
        }
    }
    
    // Método principal
    public static void main(String[] args) {
        // Executa na thread do Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Tenta usar um look and feel mais bonito
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    // Se não conseguir, usa o padrão
                }
                new PetShopSwingGUISimples();
            }
        });
    }
}
