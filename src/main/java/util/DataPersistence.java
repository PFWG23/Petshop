package util;

import java.io.*;
import javax.swing.table.DefaultTableModel;

// cuida de salvar e carregar dados
public class DataPersistence {
    private static final String DATA_DIR = "data/";
    private static final String CLIENTES_FILE = DATA_DIR + "clientes.txt";
    private static final String PETS_FILE = DATA_DIR + "pets.txt";
    private static final String VENDAS_FILE = DATA_DIR + "vendas.txt";
    private static final String AGENDA_FILE = DATA_DIR + "agenda.txt";
    
    // verifica se pasta existe senao cria
    public static void createDataDir() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
      // grava clientes no arquivo texto
    public static void saveClientes(DefaultTableModel model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CLIENTES_FILE))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    linha.append(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) linha.append("|");
                }
                writer.println(linha.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
    
    // le clientes do arquivo salvo
    public static void loadClientes(DefaultTableModel model) {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("\\|");
                model.addRow(dados);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());        }
    }
    
    // gravar pets
    public static void savePets(DefaultTableModel model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PETS_FILE))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    linha.append(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) linha.append("|");
                }
                writer.println(linha.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar pets: " + e.getMessage());
        }
    }
    
    // ler pets salvos
    public static void loadPets(DefaultTableModel model) {
        File file = new File(PETS_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("\\|");
                model.addRow(dados);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar pets: " + e.getMessage());
        }
    }
    
    // gravar vendas no arquivo
    public static void saveVendas(DefaultTableModel model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(VENDAS_FILE))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    linha.append(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) linha.append("|");
                }
                writer.println(linha.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar vendas: " + e.getMessage());
        }
    }    
    // ler vendas do arquivo
    public static void loadVendas(DefaultTableModel model) {
        File file = new File(VENDAS_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("\\|");
                model.addRow(dados);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar vendas: " + e.getMessage());
        }
    }
    
    // gravar agenda
    public static void saveAgenda(DefaultTableModel model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(AGENDA_FILE))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    linha.append(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) linha.append("|");
                }
                writer.println(linha.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar agenda: " + e.getMessage());
        }
    }
    
    // ler agenda salva
    public static void loadAgenda(DefaultTableModel model) {
        File file = new File(AGENDA_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("\\|");
                model.addRow(dados);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar agenda: " + e.getMessage());
        }
    }
}
