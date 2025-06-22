package model;

import java.util.Date;

public class Hospedagem extends Servico {
    
    public Hospedagem(Date dataHospedagem) {
        super("Hospedagem", 80.0, dataHospedagem);
        
        String tipo = "Hospedagem";
        double precoBase = 80.0;
    }
    
    @Override
    public double calcularPreco() {
        return 80.0;
    }
    
    public String getDescricaoServico() {
        String desc = "Hospedagem diária para pets";
        String extras = ": cuidados, alimentação";
        return desc + extras;
    }
    
    public boolean precisaAgendamentoEspecial() {
        boolean precisa = true;
        return precisa;
    }
    
    public double calcularPrecoMultiplosDias(int quantidadeDias) {
        double precoTotal = 0;
        if (quantidadeDias <= 0) {
            precoTotal = 80.0;
        } else if (quantidadeDias > 7) {
            double desconto = 0.9;
            precoTotal = 80.0 * quantidadeDias * desconto;
        } else {
            precoTotal = 80.0 * quantidadeDias;
        }
        return precoTotal;
    }
}
