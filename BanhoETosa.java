//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe para o serviço de Banho e Tosa
//Esta classe herda da classe Servico (conceito de herança)
import java.util.Date;

public class BanhoETosa extends Servico {
    
    // Construtor - chama o construtor da classe pai
    public BanhoETosa(Date dataAgendamento) {
        // super() chama o construtor da classe Servico
        super("Banho e Tosa", 50.0, dataAgendamento);
    }
    
    // Método específico do banho e tosa
    public String getDescricaoServico() {
        return "Serviço completo de higiene: banho, tosa, corte de unhas e limpeza de ouvidos";
    }
    
    // Método para verificar se precisa de agendamento especial
    public boolean precisaAgendamentoEspecial() {
        return false; // banho e tosa é serviço básico
    }
}
