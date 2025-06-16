//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe para o serviço de hospedagem de pets
import java.util.Date;

public class Hospedagem extends Servico {
    
    // Construtor - mudei o preço para 80 reais (estava muito caro)
    public Hospedagem(Date dataHospedagem) {
        super("Hospedagem", 80.0, dataHospedagem);
    }
    
    // Descrição do serviço
    public String getDescricaoServico() {
        return "Hospedagem diária para pets: cuidados, alimentação e carinho";
    }
    
    // Hospedagem precisa de planejamento
    public boolean precisaAgendamentoEspecial() {
        return true;
    }
    
    // Método para calcular preço por dias (se o cliente quiser mais de um dia)
    public double calcularPrecoMultiplosDias(int quantidadeDias) {
        if (quantidadeDias <= 0) {
            return precoServico; // pelo menos 1 dia
        } else if (quantidadeDias > 7) {
            // desconto para mais de 7 dias
            return precoServico * quantidadeDias * 0.9; // 10% de desconto
        } else {
            return precoServico * quantidadeDias;
        }
    }
}
