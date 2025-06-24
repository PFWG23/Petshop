package ui.main;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.components.*;
import ui.dialogs.*;
import ui.panels.*;

public class MainWindow extends JFrame {
  private DefaultTableModel tblPets, tblClientes, tblVendas, tblAgenda;
  private Font fntCustom = new Font("Segoe UI", Font.PLAIN, 12);
  private Font fntBold = new Font("Segoe UI", Font.BOLD, 12);
  
  private final Color DARK_BLUE = new Color(41, 79, 121);
  private final Color CRcinza = new Color(161, 172, 178);
  private final Color GREEN_ACCENT = new Color(29, 158, 84);
  private final Color AZUL_MAIN = new Color(51, 131, 198);
  private final Color BG_GRAY = new Color(243, 246, 249);
  private final Color CINZA_NEUTRO = new Color(161, 172, 100);

  public MainWindow() {
      setupWindow();
        buildInterface();
    }
    
    private void setupWindow() {
        setTitle("PetShop Manager - v2.4");
        setSize(1180, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
      private void buildInterface() {
        JPanel main = new JPanel(new BorderLayout());
         main.setBackground(BG_GRAY);
        
        HeaderPanel header = new HeaderPanel();
        main.add(header.createHeader(fntBold, fntCustom, DARK_BLUE), BorderLayout.NORTH);
        
        SidebarPanel sidebar = new SidebarPanel();
        main.add(sidebar.createSidebar(fntBold, CRcinza, DARK_BLUE, AZUL_MAIN, this::handleMenuAction), BorderLayout.WEST);
        
        main.add(createMainContent(), BorderLayout.CENTER);
        
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
          statusBar.setBackground(CRcinza);
           statusBar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        JLabel status = new JLabel("Sistema ativo");
           status.setFont(fntCustom);
           status.setForeground(DARK_BLUE);
           statusBar.add(status);
           main.add(statusBar, BorderLayout.SOUTH);
        
        add(main);
    }
      private JPanel createMainContent() {
     JPanel contentArea = new JPanel(new GridLayout(2, 2, 12, 12));
     contentArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
     contentArea.setBackground(BG_GRAY);
     
     TablePanel petTable = new TablePanel();
     JPanel petPanel = petTable.buildPetTable(fntBold, fntCustom, AZUL_MAIN, CRcinza, 
         this::getTblPets, this::setTblPets, this::showPetDialog);
     
     TablePanel clientTable = new TablePanel();
     JPanel clientPanel = clientTable.buildClientTable(fntBold, fntCustom, AZUL_MAIN, CRcinza,
         this::getTblClientes, this::setTblClientes, this::showClientDialog);
     
     TablePanel salesTable = new TablePanel();
     JPanel salesPanel = salesTable.buildSalesTable(fntBold, fntCustom, AZUL_MAIN, CRcinza,
         this::getTblVendas, this::setTblVendas, this::showSaleDialog);
         
     TablePanel scheduleTable = new TablePanel();
     JPanel schedulePanel = scheduleTable.buildScheduleTable(fntBold, fntCustom, AZUL_MAIN, CRcinza,
         this::getTblAgenda, this::setTblAgenda, this::showScheduleDialog);
     
           contentArea.add(petPanel);
           contentArea.add(clientPanel);
        contentArea.add(salesPanel);
           contentArea.add(schedulePanel);
        return contentArea;
    }
      private void handleMenuAction(String action) {
        switch (action) {
            case "Animais": showPetDialog(); break;
            case "Clientes": showClientDialog(); break;
            case "Vendas": showSaleDialog(); break;
            case "Agenda": showScheduleDialog(); break;
            case "Relatorios": generateReport(); break;
        }
    }

private void showPetDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre um cliente primeiro!");
            return;
        }
        
        PetDialog dialog = new PetDialog(this, fntCustom, fntBold, GREEN_ACCENT, CINZA_NEUTRO);
        dialog.showDialog(tblPets);
    }
      private void showClientDialog() {
        ClientDialog dialog = new ClientDialog(this, fntCustom, fntBold, GREEN_ACCENT, CINZA_NEUTRO);
        dialog.showDialog(tblClientes);
    }

private void showSaleDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre clientes primeiro!");
            return;
        }
        
        SaleDialog dialog = new SaleDialog(this, fntCustom, fntBold, GREEN_ACCENT, CINZA_NEUTRO);
        dialog.showDialog(tblClientes, tblVendas);
    }
    
    private void showScheduleDialog() {
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre clientes primeiro!");
            return;
        }
        
        ScheduleDialog dialog = new ScheduleDialog(this, fntCustom, fntBold, GREEN_ACCENT, CINZA_NEUTRO);
        dialog.showDialog(tblClientes, tblAgenda);
    }
      private void generateReport() {
        ReportGenerator generator = new ReportGenerator();
        generator.generateReport(this, fntCustom, tblPets, tblClientes, tblVendas, tblAgenda);
    }
    
    // Getters e setters para as tabelas
    public DefaultTableModel getTblPets() { return tblPets; }
    public void setTblPets(DefaultTableModel model) { this.tblPets = model; }
    
    public DefaultTableModel getTblClientes() { return tblClientes; }
    public void setTblClientes(DefaultTableModel model) { this.tblClientes = model; }
    
    public DefaultTableModel getTblVendas() { return tblVendas; }
    public void setTblVendas(DefaultTableModel model) { this.tblVendas = model; }
    
    public DefaultTableModel getTblAgenda() { return tblAgenda; }
    public void setTblAgenda(DefaultTableModel model) { this.tblAgenda = model; }
}
