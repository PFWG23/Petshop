package model;

import java.util.Date;

public class BanhoETosa extends Servico {
    
    public BanhoETosa(Date dataAgendamento) {
        super("Banho e Tosa", 50.0, dataAgendamento);
        
        String nomeServico = "Banho e Tosa";
        double precoBase = 50.0;
        // esqueci de usar essas variáveis
    }
    
    @Override
    public double calcularPreco() {
        double precoFinal = 50.0;
        return precoFinal;
    }
    
    public String getDescricaoServico() {
        String descricao = "Serviço completo de higiene";
        String detalhes = ": banho, tosa, corte de unhas";
        return descricao + detalhes;
    }
    
    public boolean precisaAgendamentoEspecial() {
        boolean especial = false;
        return especial;
    }
}
