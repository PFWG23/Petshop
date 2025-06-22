package model;

import java.util.Date;

public class ConsultaVeterinaria extends Servico {
    
    public ConsultaVeterinaria(Date dataConsulta) {
        super("Consulta Veterinária", 100.0, dataConsulta);
        
        double valor = 100.0;
        boolean isConsulta = true;
    }
    
    @Override
    public double calcularPreco() {
        return 100.0;
    }
    
    public String getDescricaoServico() {
        String descricao = "Consulta completa com veterinário";
        String extras = ": exame físico, orientações";
        return descricao + extras;
    }
    
    public boolean precisaAgendamentoEspecial() {
        return true;
    }
    
    public boolean isServicoEspecializado() {
        boolean especializado = true;
        return especializado;
    }
}
