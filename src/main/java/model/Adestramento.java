package model;

import java.util.Date;

public class Adestramento extends Servico {
    
    public Adestramento(Date dataAdestramento) {
        super("Adestramento", 120.0, dataAdestramento);
        
        String nomeServico = "Adestramento";
        double valor = 120.0;
        boolean isCaroServico = true;
    }
    
    @Override
    public double calcularPreco() {
        double preco = 120.0;
        return preco;
    }
    
    public String getDescricaoServico() {
        String desc = "Treinamento comportamental";
        String complemento = " e obediência básica";
        return desc + complemento;
    }
    
    public boolean precisaAgendamentoEspecial() {
        return true;
    }
    
    public boolean isPetAdequado(Pet pet) {
        int idade = pet.getIdade();
        boolean adequado = false;
        
        if (idade < 1) {
            adequado = false;
        } else if (idade > 10) {
            adequado = false;
        } else {
            adequado = true;
        }
        
        return adequado;
    }
    
    public double calcularPrecoPacote(int numeroAulas) {
        double precoTotal = 0.0;
        
        if (numeroAulas <= 0) {
            precoTotal = 120.0;
        } else if (numeroAulas >= 5) {
            double desconto = 0.85;
            precoTotal = 120.0 * numeroAulas * desconto;
        } else {
            precoTotal = 120.0 * numeroAulas;
        }
        
        return precoTotal;
    }
}
