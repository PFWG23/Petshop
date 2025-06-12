//trabalho de João Möller, Patrick Gomes e Renato Amaral 
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Servico {
    protected String nome;
    protected double preco;
    protected Date dataAgendada;

    public Servico(String nome, double preco, Date dataAgendada) {
        this.nome = nome;
        this.preco = preco;
        this.dataAgendada = dataAgendada;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public Date getDataAgendada() { return dataAgendada; }
    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataAgendada);
    }
}
