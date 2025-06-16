//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe para o serviço de adestramento de pets
import java.util.Date;

public class Adestramento extends Servico {
    
    // Construtor - adestramento é o serviço mais caro (ajustei para 120)
    public Adestramento(Date dataAdestramento) {
        super("Adestramento", 120.0, dataAdestramento);
    }
    
    // Descrição específica do adestramento
    public String getDescricaoServico() {
        return "Treinamento comportamental e obediência básica para pets";
    }
    
    // Adestramento definitivamente precisa de agendamento especial
    public boolean precisaAgendamentoEspecial() {
        return true;
    }
    
    // Método para verificar se o pet é adequado para adestramento
    public boolean isPetAdequado(Pet pet) {
        // Lógica simples: pets muito novos ou muito velhos podem ter dificuldade
        int idade = pet.getIdade();
        if (idade < 1) {
            return false; // muito novo
        } else if (idade > 10) {
            return false; // pode ser mais difícil
        } else {
            return true; // idade boa para adestramento
        }
    }
    
    // Método para calcular preço de pacotes de aulas
    public double calcularPrecoPacote(int numeroAulas) {
        if (numeroAulas <= 0) {
            return precoServico;
        } else if (numeroAulas >= 5) {
            // desconto para pacote de 5 ou mais aulas
            return precoServico * numeroAulas * 0.85; // 15% desconto
        } else {
            return precoServico * numeroAulas;
        }
    }
}
