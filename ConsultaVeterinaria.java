//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe para consulta veterinária - herda de Servico
import java.util.Date;

public class ConsultaVeterinaria extends Servico {
    
    // Construtor
    public ConsultaVeterinaria(Date dataConsulta) {
        super("Consulta Veterinária", 100.0, dataConsulta);
    }
    
    // Método que descreve o que inclui na consulta
    public String getDescricaoServico() {
        return "Consulta completa com veterinário: exame físico, orientações e prescrições";
    }
    
    // Consulta veterinária sempre precisa de agendamento
    public boolean precisaAgendamentoEspecial() {
        return true;
    }
    
    // Método extra - consulta é mais cara que outros serviços
    public boolean isServicoEspecializado() {
        return true;
    }
}
