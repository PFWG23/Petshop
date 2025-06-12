//trabalho de João Möller, Patrick Gomes e Renato Amaral 
import java.util.*;

public class PacoteServicos {
    private List<Servico> servicos = new ArrayList<>();
    private double desconto;

    public PacoteServicos(double desconto) {
        this.desconto = desconto;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (Servico s : servicos) {
            total += s.getPreco();
        }
        return total * (1 - desconto);
    }

    public List<Servico> getServicos() { return servicos; }
}
