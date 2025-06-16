//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe abstrata para os serviços do pet shop
//O professor explicou que classe abstrata é como um "molde" para outras classes
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Servico {
    // Atributos que todos os serviços vão ter
    protected String nomeServico; // protected permite que as classes filhas acessem
    protected double precoServico;
    protected Date dataAgendamento;
    
    // Construtor da classe pai
    public Servico(String nome, double preco, Date data) {
        this.nomeServico = nome;
        this.precoServico = preco;
        this.dataAgendamento = data;
    }
    
    // Métodos getter básicos
    public String getNome() { 
        return nomeServico; 
    }
    
    public double getPreco() { 
        return precoServico; 
    }
    
    public Date getDataAgendada() { 
        return dataAgendamento; 
    }
    
    // Método para formatar a data de um jeito mais bonito
    public String getDataFormatada() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(dataAgendamento);
    }
    
    // Método para mostrar informações do serviço
    public String getInformacaoCompleta() {
        return nomeServico + " - R$ " + precoServico + " - " + getDataFormatada();
    }
}
