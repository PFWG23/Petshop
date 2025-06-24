package ui.panels;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import ui.components.ButtonUtils;

public class TablePanel {
    // Cria o painel de tabela de pets
    // Recebe fontes, cores e funções de getter/setter para o modelo de tabela
    public JPanel buildPetTable(Font fntBold, Font fntCustom, Color azulMain, Color crCinza,
                                Supplier<DefaultTableModel> getter, Consumer<DefaultTableModel> setter, Runnable showDialog) {
        JPanel petPanel = new JPanel(new BorderLayout());
        petPanel.setBackground(Color.WHITE);
        TitledBorder petBorder = BorderFactory.createTitledBorder("Registro de Pets");
         petBorder.setTitleFont(fntBold.deriveFont(14f));
         petBorder.setTitleColor(azulMain);
         petPanel.setBorder(petBorder);
         
         String[] colunasPet = {"ID", "Nome", "Tipo", "Raca", "Idade"};
          DefaultTableModel tblPets = new DefaultTableModel(colunasPet, 0);
          setter.accept(tblPets);
          
          String[][] dadosPets= {
            {"P001", "Bartolomeu", "Cao", "SRD", "4"},
            {"P002", "Fifi", "Gato", "Persa", "2"},
            {"P003", "Thor", "Cao", "Rottweiler", "6"},
            {"P004", "Luna", "Gato", "Siames", "1"},
            {"P005", "Pipoca", "Cao", "Vira-lata", "7"},
            {"P006", "Mel", "Gato", "Munchkin", "3"}
        };
        for (String[] pet : dadosPets) {
            tblPets.addRow(pet);
        }
        
        JTable tabelaAnimais = new JTable(tblPets);
        setupTableStyle(tabelaAnimais, fntCustom, fntBold, crCinza, azulMain);
        JScrollPane scrollPets = new JScrollPane(tabelaAnimais);
        JButton btnAdicionarPet = ButtonUtils.makeButton("Adicionar", azulMain, fntBold);
        btnAdicionarPet.addActionListener(e -> showDialog.run());
        petPanel.add(scrollPets, BorderLayout.CENTER);
        petPanel.add(btnAdicionarPet, BorderLayout.SOUTH);
        return petPanel;
    }
    // Cria o painel de tabela de clientes 
    public JPanel buildClientTable(Font fntBold, Font fntCustom, Color azulMain, Color crCinza,
                                   Supplier<DefaultTableModel> getter, Consumer<DefaultTableModel> setter, Runnable showDialog) {
        JPanel clientPanel = new JPanel(new BorderLayout());
        clientPanel.setBackground(Color.WHITE);
        TitledBorder clientBorder = BorderFactory.createTitledBorder("Base de Clientes");
          clientBorder.setTitleFont(fntBold.deriveFont(14f));
          clientBorder.setTitleColor(azulMain);
          clientPanel.setBorder(clientBorder);
          
          String[] colunasCliente = {"ID", "Nome Completo", "Telefone", "Email"};
        DefaultTableModel tblClientes = new DefaultTableModel(colunasCliente, 0);
        setter.accept(tblClientes);
        // Dados de exemplo para a tabela de clientes
        // Em uma aplicação real, esses dados viriam de um banco de dados ou arquivo
        String[][] dadosClientes = {
            {"C001", "Roberta Machado", "(11) 97654-3210", "roberta.m@email.com"},
            {"C002", "Carlos Eduardo Santos", "(11) 98765-4321", "carlosE@hotmail.com"},
            {"C003", "Fernanda M. Santos", "(11) 99876-5432", "fe.santos@outlook.com"},
            {"C004", "Ricardo Silva Jr.", "(11) 91234-5678", "ricardo.s@yahoo.com"},
            {"C005", "Ana Beatriz Oliveira", "(11) 94567-8901", "ana.bia@gmail.com"},
            {"C006", "Marcos Antonio", "(11) 93456-7890", "marcosant@uol.com.br"}
        };
        
        for (String[] cliente : dadosClientes) {
            tblClientes.addRow(cliente);
        }
        //  Cria a tabela de clientes com os dados
        //  Define o modelo de tabela e configura o estilo
        JTable tabelaClientes = new JTable(tblClientes);
        setupTableStyle(tabelaClientes, fntCustom, fntBold, crCinza, azulMain);
        JScrollPane scrollClientes = new JScrollPane(tabelaClientes);
        JButton btnNovoCliente = ButtonUtils.makeButton("Novo Cliente", azulMain, fntBold);
          btnNovoCliente.addActionListener(e -> showDialog.run());
          clientPanel.add(scrollClientes, BorderLayout.CENTER);
          clientPanel.add(btnNovoCliente, BorderLayout.SOUTH);
        return clientPanel;
    }
    // Cria o painel de tabela de vendas
    // Recebe fontes, cores e funções de getter/setter para o modelo de tabela
    public JPanel buildSalesTable(Font fntBold, Font fntCustom, Color azulMain, Color crCinza,
                                  Supplier<DefaultTableModel> getter, Consumer<DefaultTableModel> setter, Runnable showDialog) {
        JPanel salesPanel = new JPanel(new BorderLayout());
          salesPanel.setBackground(Color.WHITE);
        TitledBorder salesBorder = BorderFactory.createTitledBorder("Historico Vendas");
          salesBorder.setTitleFont(fntBold.deriveFont(14f));
          salesBorder.setTitleColor(azulMain);
        salesPanel.setBorder(salesBorder);
        
        String[] colunasVenda = {"ID", "Data", "Cliente", "Servico", "Valor"};
         DefaultTableModel tblVendas = new DefaultTableModel(colunasVenda, 0);
         setter.accept(tblVendas);
          String[][] dadosVendas = {
            {"V001", "18/06/2025", "Roberta Machado", "Banho Completo", "R$ 85,00"},
            {"V002", "19/06/2025", "Carlos Eduardo Santos", "Consulta + Vacina", "R$ 120,00"},
            {"V003", "21/06/2025", "Fernanda M. Santos", "Tosa Higienica", "R$ 60,00"},
            {"V004", "22/06/2025", "Ana Beatriz Oliveira", "Vermifugacao", "R$ 35,00"}
        };
        for (String[] venda : dadosVendas) {
            tblVendas.addRow(venda);
        }
        // Cria a tabela de vendas com os dados
        // Define o modelo de tabela e configura o estilo
        JTable tabelaVendas = new JTable(tblVendas);
        setupTableStyle(tabelaVendas, fntCustom, fntBold, crCinza, azulMain);
        JScrollPane scrollVendas = new JScrollPane(tabelaVendas);
        JButton btnVenda = ButtonUtils.makeButton("Nova Venda", azulMain, fntBold);
         btnVenda.addActionListener(e -> showDialog.run());
         salesPanel.add(scrollVendas, BorderLayout.CENTER);
         salesPanel.add(btnVenda, BorderLayout.SOUTH);
        
        return salesPanel;
    }
    // Cria o painel de tabela de agendamentos
    public JPanel buildScheduleTable(Font fntBold, Font fntCustom, Color azulMain, Color crCinza,
                                     Supplier<DefaultTableModel> getter, Consumer<DefaultTableModel> setter, Runnable showDialog) {
      JPanel scheduleContainer = new JPanel(new BorderLayout());
      scheduleContainer.setBackground(Color.WHITE);
       TitledBorder scheduleBorder = BorderFactory.createTitledBorder("Proximos Agendamentos");
       scheduleBorder.setTitleFont(fntBold.deriveFont(14f));
       scheduleBorder.setTitleColor(azulMain);
       scheduleContainer.setBorder(scheduleBorder);
       // Define as colunas da tabela de agendamentos
       // Recebe fontes, cores e funções de getter/setter para o modelo de tabela
       String[] colunasAgenda = {"Data", "Hora", "Cliente", "Pet", "Servico"};
       DefaultTableModel tblAgenda = new DefaultTableModel(colunasAgenda, 0);
       setter.accept(tblAgenda);
         // Dados de exemplo para a tabela de agendamentos
        String[][] dadosAgenda = {
            {"24/06/2025", "08:30", "Roberta Machado", "Bartolomeu", "Check-up"},
            {"24/06/2025", "15:00", "Carlos Eduardo Santos", "Fifi", "Vacinacao"},
            {"25/06/2025", "09:15", "Fernanda M. Santos", "Luna", "Consulta"},
            {"26/06/2025", "14:30", "Ana Beatriz Oliveira", "Pipoca", "Banho"},
            {"27/06/2025", "10:00", "Marcos Antonio", "Thor", "Tosa"}
        };
        for (String[] agendamento : dadosAgenda) {
            tblAgenda.addRow(agendamento);
        }
        // Cria a tabela de agendamentos com os dados
        // Define o modelo de tabela e configura o estilo
        JTable tabelaAgenda = new JTable(tblAgenda);
        setupTableStyle(tabelaAgenda, fntCustom, fntBold, crCinza, azulMain);
        JScrollPane scrollAgenda = new JScrollPane(tabelaAgenda);
        JButton btnAgendar = ButtonUtils.makeButton("Agendar", azulMain, fntBold);
        btnAgendar.addActionListener(e -> showDialog.run());
        scheduleContainer.add(scrollAgenda, BorderLayout.CENTER);
        scheduleContainer.add(btnAgendar, BorderLayout.SOUTH);
        return scheduleContainer;
    }
    // Configura o estilo da tabela
    // Define altura das linhas, fontes, cores do cabeçalho e fundo de seleção
    private void setupTableStyle(JTable table, Font fntCustom, Font fntBold, Color crCinza, Color azulMain) {
        table.setRowHeight(25);
        table.setFont(fntCustom);
        table.getTableHeader().setFont(fntBold);
        table.getTableHeader().setBackground(crCinza);
        table.setSelectionBackground(azulMain);
        table.setGridColor(crCinza);
    }
}
