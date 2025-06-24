package ui.components;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReportGenerator {
    // Método para gerar o relatório gerencial
    // Recebe o JFrame pai, fonte personalizada e modelos de tabela para pets, clientes,
    public void generateReport(JFrame parent, Font fntCustom, DefaultTableModel tblPets, 
                              DefaultTableModel tblClientes, DefaultTableModel tblVendas, DefaultTableModel tblAgenda) {
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
        areaTexto.setEditable(false);
        areaTexto.setFont(fntCustom);
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(400, 300));
          JOptionPane.showMessageDialog(parent, scroll, "Relatorio do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
