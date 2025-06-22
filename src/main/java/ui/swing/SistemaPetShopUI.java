package ui.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPetShopUI extends JFrame {
    
    // vou precisar dessas tabelas para guardar os dados
    // declarando aqui porque vou usar em vários métodos diferentes
    private DefaultTableModel tabelaPets;
    private DefaultTableModel tabelaClientes;
    private DefaultTableModel tabelaVendas;
    private DefaultTableModel tabelaAgendamentos;
    
    public SistemaPetShopUI() {
        // primeiro vou configurar a janela básica
        configurarJanelaBasica();
        
        // depois vou montar toda a interface
        montarInterfaceCompleta();
    }
    
    private void configurarJanelaBasica() {
        // configurações básicas da janela principal
        setTitle("Sistema Pet Shop - Gestao Completa");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza na tela
        setExtendedState(JFrame.MAXIMIZED_BOTH); // abre maximizada
        
        // vou tentar usar um visual mais bonito
        // se não conseguir, não tem problema, usa o padrão mesmo
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");        } catch (Exception erro) {
            // se der erro, só mostra uma mensagem e continua
            System.out.println("Nao conseguiu carregar Nimbus, usando visual padrao");
        }
    }
    
    private void montarInterfaceCompleta() {
        // vou criar o painel principal que vai conter tudo
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        
        // definindo uma cor de fundo mais agradável
        Color corDeFundo = new Color(248, 249, 250);
        painelPrincipal.setBackground(corDeFundo);
        
        // agora vou criando cada parte da interface
        JPanel parteDeCima = criarCabecalho();
        painelPrincipal.add(parteDeCima, BorderLayout.NORTH);
        
        // menu do lado esquerdo
        JPanel menuDoLado = criarMenuLateral();
        painelPrincipal.add(menuDoLado, BorderLayout.WEST);
        
        // área das tabelas no centro
        JPanel areaDasTabelas = criarAreaTabelas();
        painelPrincipal.add(areaDasTabelas, BorderLayout.CENTER);
        
        // rodapé embaixo
        JPanel parteDeRodape = criarRodape();
        painelPrincipal.add(parteDeRodape, BorderLayout.SOUTH);
        
        // adiciona tudo na janela
        add(painelPrincipal);
    }
    
    private JPanel criarCabecalho() {
        // vou criar um cabeçalho bonito no topo
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new BorderLayout());
        
        // cor azul bonita para o cabeçalho
        Color corAzul = new Color(65, 105, 225);
        cabecalho.setBackground(corAzul);
        cabecalho.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        // título principal do sistema
        JLabel titulo = new JLabel("Sistema Pet Shop");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        
        // vou mostrar a data e hora atual
        String dataHoje = new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(new Date());
        JLabel labelData = new JLabel("Data: " + dataHoje);
        labelData.setFont(new Font("Arial", Font.PLAIN, 14));
        labelData.setForeground(Color.WHITE);
        
        // posicionando tudo no cabeçalho
        cabecalho.add(titulo, BorderLayout.WEST);
        cabecalho.add(labelData, BorderLayout.EAST);
        
        return cabecalho;
    }
    
    private JPanel criarMenuLateral() {
        // criando o menu do lado esquerdo
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
        // cor azul mais clara para o menu
        Color corAzulClara = new Color(135, 206, 250);
        menu.setBackground(corAzulClara);
        menu.setPreferredSize(new Dimension(200, 0));
        menu.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        // agora vou criar os botões do menu
        JButton botaoInicio = criarBotaoDoMenu("Inicio");
        JButton botaoPets = criarBotaoDoMenu("Pets");
        JButton botaoClientes = criarBotaoDoMenu("Clientes");
        JButton botaoVendas = criarBotaoDoMenu("Vendas");
        JButton botaoAgendamentos = criarBotaoDoMenu("Agendamentos");
        JButton botaoRelatorios = criarBotaoDoMenu("Relatorios");
        
        // adicionando os botões no menu com espaçamento
        menu.add(botaoInicio);
        menu.add(Box.createVerticalStrut(10)); // espaço entre botões
        menu.add(botaoPets);
        menu.add(Box.createVerticalStrut(10));
        menu.add(botaoClientes);
        menu.add(Box.createVerticalStrut(10));
        menu.add(botaoVendas);
        menu.add(Box.createVerticalStrut(10));
        menu.add(botaoAgendamentos);
        menu.add(Box.createVerticalStrut(10));
        menu.add(botaoRelatorios);
        
        // configurando as ações dos botões
        configurarAcoesDosMenus(botaoInicio, botaoPets, botaoClientes, botaoVendas, botaoAgendamentos, botaoRelatorios);
        
        return menu;
    }
    
    private JButton criarBotaoDoMenu(String texto) {
        // criando um botão padronizado para o menu
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(180, 45));
        botao.setMaximumSize(new Dimension(180, 45));
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(Color.WHITE);
        botao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        return botao;
    }
    
    private void configurarAcoesDosMenus(JButton inicio, JButton pets, JButton clientes, 
                                        JButton vendas, JButton agendamentos, JButton relatorios) {
        // configurando o que cada botão vai fazer quando clicado
        
        inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMensagemDeBoasVindas();
            }
        });
        
        pets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarNovoPet();
            }
        });
        
        clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarNovoCliente();
            }
        });
        
        vendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarNovaVenda();
            }
        });
        
        agendamentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarNovoAgendamento();
            }
        });
        
        relatorios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirRelatoriosDoSistema();
            }
        });
    }
    
    private JPanel criarAreaTabelas() {
        // área principal onde vão ficar as 4 tabelas
        JPanel area = new JPanel();
        area.setLayout(new GridLayout(2, 2, 20, 20)); // 2x2 com espaçamento
        area.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // cor de fundo da área
        Color corFundoArea = new Color(248, 249, 250);
        area.setBackground(corFundoArea);
        
        // criando os 4 painéis das tabelas
        JPanel painelPets = criarPainelTabelaPets();
        JPanel painelClientes = criarPainelTabelaClientes();
        JPanel painelVendas = criarPainelTabelaVendas();
        JPanel painelAgendamentos = criarPainelTabelaAgendamentos();
        
        // adicionando na área
        area.add(painelPets);
        area.add(painelClientes);
        area.add(painelVendas);
        area.add(painelAgendamentos);
        
        return area;
    }
    
    private JPanel criarPainelTabelaPets() {
        // painel para a tabela de pets
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(Color.WHITE);
        
        // título bonito para o painel
        TitledBorder borda = BorderFactory.createTitledBorder("Pets Cadastrados");
        borda.setTitleFont(new Font("Arial", Font.BOLD, 16));
        
        Color corTitulo = new Color(65, 105, 225);
        borda.setTitleColor(corTitulo);
        painel.setBorder(borda);
        
        // criando a tabela de pets
        String[] colunasPets = {"ID", "Nome", "Espécie", "Raça", "Idade"};
        tabelaPets = new DefaultTableModel(colunasPets, 0);
        
        // colocando alguns dados de exemplo
        tabelaPets.addRow(new Object[]{"1", "Buddy", "Cachorro", "Golden Retriever", "3"});
        tabelaPets.addRow(new Object[]{"2", "Luna", "Gato", "Persa", "2"});
        tabelaPets.addRow(new Object[]{"3", "Rocky", "Cachorro", "Bulldog", "5"});
        
        JTable tabela = new JTable(tabelaPets);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(tabela);
        
        // botão para adicionar novo pet
        JButton botaoAdicionar = new JButton("Adicionar Pet");
        botaoAdicionar.setFont(new Font("Arial", Font.BOLD, 12));
        
        Color corBotao = new Color(65, 105, 225);
        botaoAdicionar.setBackground(corBotao);
        botaoAdicionar.setForeground(Color.WHITE);
        
        // ação do botão
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarNovoPet();
            }
        });
        
        painel.add(scroll, BorderLayout.CENTER);
        painel.add(botaoAdicionar, BorderLayout.SOUTH);
        
        return painel;
    }
    
    private JPanel criarPainelTabelaClientes() {
        // painel para a tabela de clientes
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(Color.WHITE);
        
        // título do painel
        TitledBorder borda = BorderFactory.createTitledBorder("Clientes Cadastrados");
        borda.setTitleFont(new Font("Arial", Font.BOLD, 16));
        
        Color corTitulo = new Color(65, 105, 225);
        borda.setTitleColor(corTitulo);
        painel.setBorder(borda);
        
        // criando a tabela de clientes
        String[] colunasClientes = {"ID", "Nome", "Telefone", "Email"};
        tabelaClientes = new DefaultTableModel(colunasClientes, 0);
        
        // dados de exemplo
        tabelaClientes.addRow(new Object[]{"1", "João Silva", "(11) 99999-1111", "joao@email.com"});
        tabelaClientes.addRow(new Object[]{"2", "Maria Santos", "(11) 99999-2222", "maria@email.com"});
        tabelaClientes.addRow(new Object[]{"3", "Pedro Costa", "(11) 99999-3333", "pedro@email.com"});
        
        JTable tabela = new JTable(tabelaClientes);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(tabela);
        
        // botão para adicionar cliente
        JButton botaoAdicionar = new JButton("Adicionar Cliente");
        botaoAdicionar.setFont(new Font("Arial", Font.BOLD, 12));
        
        Color corBotao = new Color(65, 105, 225);
        botaoAdicionar.setBackground(corBotao);
        botaoAdicionar.setForeground(Color.WHITE);
        
        // ação do botão
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarNovoCliente();
            }
        });
        
        painel.add(scroll, BorderLayout.CENTER);
        painel.add(botaoAdicionar, BorderLayout.SOUTH);
        
        return painel;
    }
    
    private JPanel criarPainelTabelaVendas() {
        // painel para a tabela de vendas
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(Color.WHITE);
        
        // título do painel
        TitledBorder borda = BorderFactory.createTitledBorder("Vendas Realizadas");
        borda.setTitleFont(new Font("Arial", Font.BOLD, 16));
        
        Color corTitulo = new Color(65, 105, 225);
        borda.setTitleColor(corTitulo);
        painel.setBorder(borda);
        
        // criando a tabela de vendas
        String[] colunasVendas = {"ID", "Data", "Cliente", "Serviço", "Valor"};
        tabelaVendas = new DefaultTableModel(colunasVendas, 0);
        
        // dados de exemplo
        tabelaVendas.addRow(new Object[]{"1", "19/06/2025", "João Silva", "Banho e Tosa", "R$ 50,00"});
        tabelaVendas.addRow(new Object[]{"2", "18/06/2025", "Maria Santos", "Consulta Veterinária", "R$ 100,00"});
        tabelaVendas.addRow(new Object[]{"3", "17/06/2025", "Pedro Costa", "Hospedagem", "R$ 80,00"});
        
        JTable tabela = new JTable(tabelaVendas);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(tabela);
        
        // botão para registrar venda
        JButton botaoRegistrar = new JButton("Registrar Venda");
        botaoRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
        
        Color corBotao = new Color(65, 105, 225);
        botaoRegistrar.setBackground(corBotao);
        botaoRegistrar.setForeground(Color.WHITE);
        
        // ação do botão
        botaoRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarNovaVenda();
            }
        });
        
        painel.add(scroll, BorderLayout.CENTER);
        painel.add(botaoRegistrar, BorderLayout.SOUTH);
        
        return painel;
    }
    
    private JPanel criarPainelTabelaAgendamentos() {
        // painel para a tabela de agendamentos
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(Color.WHITE);
        
        // título do painel
        TitledBorder borda = BorderFactory.createTitledBorder("Proximos Agendamentos");
        borda.setTitleFont(new Font("Arial", Font.BOLD, 16));
        
        Color corTitulo = new Color(65, 105, 225);
        borda.setTitleColor(corTitulo);
        painel.setBorder(borda);
        
        // criando a tabela de agendamentos
        String[] colunasAgendamentos = {"Data", "Hora", "Cliente", "Pet", "Serviço"};
        tabelaAgendamentos = new DefaultTableModel(colunasAgendamentos, 0);
        
        // dados de exemplo
        tabelaAgendamentos.addRow(new Object[]{"20/06/2025", "10:00", "João Silva", "Buddy", "Banho e Tosa"});
        tabelaAgendamentos.addRow(new Object[]{"20/06/2025", "14:00", "Maria Santos", "Luna", "Consulta"});
        tabelaAgendamentos.addRow(new Object[]{"21/06/2025", "09:00", "Pedro Costa", "Rocky", "Adestramento"});
        
        JTable tabela = new JTable(tabelaAgendamentos);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(tabela);
        
        // botão para novo agendamento
        JButton botaoNovo = new JButton("Novo Agendamento");
        botaoNovo.setFont(new Font("Arial", Font.BOLD, 12));
        
        Color corBotao = new Color(65, 105, 225);
        botaoNovo.setBackground(corBotao);
        botaoNovo.setForeground(Color.WHITE);
        
        // ação do botão
        botaoNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarNovoAgendamento();
            }
        });
        
        painel.add(scroll, BorderLayout.CENTER);
        painel.add(botaoNovo, BorderLayout.SOUTH);
        
        return painel;
    }
    
    private JPanel criarRodape() {
        // criando o rodapé da janela
        JPanel rodape = new JPanel();
        rodape.setLayout(new FlowLayout());
        
        Color corRodape = new Color(135, 206, 250);
        rodape.setBackground(corRodape);
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel status = new JLabel("Sistema funcionando perfeitamente!");
        status.setFont(new Font("Arial", Font.PLAIN, 12));
        
        rodape.add(status);
        
        return rodape;
    }
    
    // agora vou criar os métodos que fazem as ações quando clica nos botões
    
    private void adicionarNovoPet() {
        // primeiro vou verificar se tem cliente cadastrado
        // porque não posso ter pet sem dono
        if (tabelaClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Você precisa cadastrar pelo menos um cliente (dono) antes de adicionar pets!\n" +
                "Use o botão 'Clientes' no menu lateral para cadastrar um cliente primeiro.", 
                "Cliente Obrigatório", JOptionPane.WARNING_MESSAGE);
            return; // para aqui e não continua
        }
        
        // criando uma janela para adicionar pet
        JDialog janelaPet = new JDialog(this, "Adicionar Novo Pet", true);
        janelaPet.setSize(400, 350);
        janelaPet.setLocationRelativeTo(this);
        
        // painel com os campos
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // criando os campos do formulário
        JLabel labelNome = new JLabel("Nome do Pet:");
        JTextField campoNome = new JTextField();
        
        JLabel labelEspecie = new JLabel("Espécie:");
        JComboBox<String> campoEspecie = new JComboBox<>();
        // adicionando as opções
        campoEspecie.addItem("Cachorro");
        campoEspecie.addItem("Gato");
        campoEspecie.addItem("Pássaro");
        campoEspecie.addItem("Peixe");
        campoEspecie.addItem("Hamster");
        
        JLabel labelRaca = new JLabel("Raça:");
        JTextField campoRaca = new JTextField();
        
        JLabel labelIdade = new JLabel("Idade (anos):");
        JTextField campoIdade = new JTextField();
        
        // botões de ação
        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCancelar = new JButton("Cancelar");
        
        // adicionando tudo no painel
        painel.add(labelNome); painel.add(campoNome);
        painel.add(labelEspecie); painel.add(campoEspecie);
        painel.add(labelRaca); painel.add(campoRaca);
        painel.add(labelIdade); painel.add(campoIdade);
        painel.add(botaoSalvar); painel.add(botaoCancelar);
        
        // configurando as ações dos botões
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // pegando os valores dos campos
                String nome = campoNome.getText();
                String especie = (String) campoEspecie.getSelectedItem();
                String raca = campoRaca.getText();
                String idade = campoIdade.getText();
                
                // verificando se preencheu tudo
                if (nome.isEmpty() || raca.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(janelaPet, "Preencha todos os campos!");
                    return;
                }
                
                // calculando o próximo ID
                int proximoId = tabelaPets.getRowCount() + 1;
                
                // adicionando na tabela
                tabelaPets.addRow(new Object[]{proximoId, nome, especie, raca, idade});
                
                // fechando a janela e mostrando mensagem
                janelaPet.dispose();
                JOptionPane.showMessageDialog(SistemaPetShopUI.this, "Pet adicionado com sucesso!");
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaPet.dispose(); // só fecha a janela
            }
        });
        
        janelaPet.add(painel);
        janelaPet.setVisible(true);
    }
    
    private void adicionarNovoCliente() {
        // criando janela para adicionar cliente
        JDialog janelaCliente = new JDialog(this, "Adicionar Novo Cliente", true);
        janelaCliente.setSize(400, 300);
        janelaCliente.setLocationRelativeTo(this);
        
        // painel do formulário
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // campos do cliente
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        
        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();
        
        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField();
        
        // botões
        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCancelar = new JButton("Cancelar");
        
        // montando o painel
        painel.add(labelNome); painel.add(campoNome);
        painel.add(labelTelefone); painel.add(campoTelefone);
        painel.add(labelEmail); painel.add(campoEmail);
        painel.add(botaoSalvar); painel.add(botaoCancelar);
        
        // ações dos botões
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String telefone = campoTelefone.getText();
                String email = campoEmail.getText();
                
                // validação simples
                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(janelaCliente, "Preencha todos os campos!");
                    return;
                }
                
                // próximo ID
                int proximoId = tabelaClientes.getRowCount() + 1;
                
                // adicionando na tabela
                tabelaClientes.addRow(new Object[]{proximoId, nome, telefone, email});
                
                janelaCliente.dispose();
                JOptionPane.showMessageDialog(SistemaPetShopUI.this, "Cliente adicionado com sucesso!");
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaCliente.dispose();
            }
        });
        
        janelaCliente.add(painel);
        janelaCliente.setVisible(true);
    }
    
    private void registrarNovaVenda() {
        // precisa ter cliente para fazer venda
        if (tabelaClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Você precisa cadastrar pelo menos um cliente antes de registrar vendas!\n" +
                "Use o botão 'Clientes' no menu lateral para cadastrar um cliente primeiro.", 
                "Cliente Obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // janela para registrar venda
        JDialog janelaVenda = new JDialog(this, "Registrar Nova Venda", true);
        janelaVenda.setSize(450, 350);
        janelaVenda.setLocationRelativeTo(this);
        
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // campos da venda
        JLabel labelCliente = new JLabel("Cliente:");
        JTextField campoCliente = new JTextField();
        
        JLabel labelServico = new JLabel("Serviço:");
        JComboBox<String> campoServico = new JComboBox<>();
        campoServico.addItem("Banho e Tosa - R$ 50,00");
        campoServico.addItem("Consulta Veterinária - R$ 100,00");
        campoServico.addItem("Hospedagem - R$ 80,00");
        campoServico.addItem("Adestramento - R$ 120,00");
        
        JLabel labelValor = new JLabel("Valor:");
        JTextField campoValor = new JTextField();
        
        JLabel labelData = new JLabel("Data:");
        String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JTextField campoData = new JTextField(dataAtual);
        
        JButton botaoRegistrar = new JButton("Registrar");
        JButton botaoCancelar = new JButton("Cancelar");
        
        // montando
        painel.add(labelCliente); painel.add(campoCliente);
        painel.add(labelServico); painel.add(campoServico);
        painel.add(labelValor); painel.add(campoValor);
        painel.add(labelData); painel.add(campoData);
        painel.add(botaoRegistrar); painel.add(botaoCancelar);
        
        // ações
        botaoRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cliente = campoCliente.getText();
                String servicoCompleto = (String) campoServico.getSelectedItem();
                String servico = servicoCompleto.split(" - ")[0]; // só o nome
                String valor = campoValor.getText();
                String data = campoData.getText();
                
                if (cliente.isEmpty() || valor.isEmpty()) {
                    JOptionPane.showMessageDialog(janelaVenda, "Preencha todos os campos!");
                    return;
                }
                
                int proximoId = tabelaVendas.getRowCount() + 1;
                tabelaVendas.addRow(new Object[]{proximoId, data, cliente, servico, "R$ " + valor});
                
                janelaVenda.dispose();
                JOptionPane.showMessageDialog(SistemaPetShopUI.this, "Venda registrada com sucesso!");
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaVenda.dispose();
            }
        });
        
        janelaVenda.add(painel);
        janelaVenda.setVisible(true);
    }
    
    private void criarNovoAgendamento() {
        // precisa ter cliente para agendar
        if (tabelaClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Você precisa cadastrar pelo menos um cliente antes de fazer agendamentos!\n" +
                "Use o botão 'Clientes' no menu lateral para cadastrar um cliente primeiro.", 
                "Cliente Obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // janela do agendamento
        JDialog janelaAgendamento = new JDialog(this, "Novo Agendamento", true);
        janelaAgendamento.setSize(450, 400);
        janelaAgendamento.setLocationRelativeTo(this);
        
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(7, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // campos do agendamento
        JLabel labelData = new JLabel("Data:");
        JTextField campoData = new JTextField();
        
        JLabel labelHora = new JLabel("Hora:");
        JComboBox<String> campoHora = new JComboBox<>();
        // preenchendo horários das 8 às 18
        for (int hora = 8; hora <= 18; hora++) {
            campoHora.addItem(String.format("%02d:00", hora));
            campoHora.addItem(String.format("%02d:30", hora));
        }
        
        JLabel labelCliente = new JLabel("Cliente:");
        JTextField campoCliente = new JTextField();
        
        JLabel labelPet = new JLabel("Pet:");
        JTextField campoPet = new JTextField();
        
        JLabel labelServico = new JLabel("Serviço:");
        JComboBox<String> campoServico = new JComboBox<>();
        campoServico.addItem("Banho e Tosa");
        campoServico.addItem("Consulta Veterinária");
        campoServico.addItem("Hospedagem");
        campoServico.addItem("Adestramento");
        
        JButton botaoAgendar = new JButton("Agendar");
        JButton botaoCancelar = new JButton("Cancelar");
        
        // montando
        painel.add(labelData); painel.add(campoData);
        painel.add(labelHora); painel.add(campoHora);
        painel.add(labelCliente); painel.add(campoCliente);
        painel.add(labelPet); painel.add(campoPet);
        painel.add(labelServico); painel.add(campoServico);
        painel.add(botaoAgendar); painel.add(botaoCancelar);
        
        // ações
        botaoAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = campoData.getText();
                String hora = (String) campoHora.getSelectedItem();
                String cliente = campoCliente.getText();
                String pet = campoPet.getText();
                String servico = (String) campoServico.getSelectedItem();
                
                if (data.isEmpty() || cliente.isEmpty() || pet.isEmpty()) {
                    JOptionPane.showMessageDialog(janelaAgendamento, "Preencha todos os campos!");
                    return;
                }
                
                tabelaAgendamentos.addRow(new Object[]{data, hora, cliente, pet, servico});
                
                janelaAgendamento.dispose();
                JOptionPane.showMessageDialog(SistemaPetShopUI.this, "Agendamento criado com sucesso!");
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaAgendamento.dispose();
            }
        });
        
        janelaAgendamento.add(painel);
        janelaAgendamento.setVisible(true);
    }
    
    private void exibirRelatoriosDoSistema() {
        // vou montar um relatório simples com as estatísticas
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("RELATORIO DO SISTEMA PET SHOP\n\n");
        relatorio.append("Pets cadastrados: ").append(tabelaPets.getRowCount()).append("\n");
        relatorio.append("Clientes cadastrados: ").append(tabelaClientes.getRowCount()).append("\n");
        relatorio.append("Vendas realizadas: ").append(tabelaVendas.getRowCount()).append("\n");
        relatorio.append("Agendamentos: ").append(tabelaAgendamentos.getRowCount()).append("\n\n");
        relatorio.append("Sistema desenvolvido por estudantes de POO\n");
        relatorio.append("Data do relatório: ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
        
        JOptionPane.showMessageDialog(this, relatorio.toString(), "Relatório do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensagemDeBoasVindas() {
        // mensagem de boas vindas
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Bem-vindo ao Sistema Pet Shop!\n\n");
        mensagem.append("Este sistema permite gerenciar:\n");
        mensagem.append("- Cadastro de pets e clientes\n");
        mensagem.append("- Registro de vendas\n");
        mensagem.append("- Agendamento de servicos\n");
        mensagem.append("- Relatorios do sistema\n\n");
        mensagem.append("Use o menu lateral para navegar!\n");
        mensagem.append("Desenvolvido por estudantes de POO");
        
        JOptionPane.showMessageDialog(this, mensagem.toString(), "Sistema Pet Shop", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // método main para executar o sistema
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaPetShopUI().setVisible(true);
            }
        });
    }
}
