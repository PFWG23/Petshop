import java.text.SimpleDateFormat;
import java.util.*;


class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private List<Pet> pets = new ArrayList<>();

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public List<Pet> getPets() { return pets; }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }
}

class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public double getPeso() { return peso; }
}

abstract class Servico {
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

class BanhoETosa extends Servico {
    public BanhoETosa(Date data) {
        super("Banho e Tosa", 50.0, data);
    }
}

class ConsultaVeterinaria extends Servico {
    public ConsultaVeterinaria(Date data) {
        super("Consulta Veterinária", 100.0, data);
    }
}

class Hospedagem extends Servico {
    public Hospedagem(Date data) {
        super("Hospedagem", 150.0, data);
    }
}

class Adestramento extends Servico {
    public Adestramento(Date data) {
        super("Adestramento", 200.0, data);
    }
}

class PacoteServicos {
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

public class SistemaPetShop {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Pet Shop ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar pet");
            System.out.println("3. Contratar serviço");
            System.out.println("4. Listar clientes e pets");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: cadastrarPet(); break;
                case 3: contratarServico(); break;
                case 4: listarClientesEPets(); break;
                case 5: System.out.println("Encerrando sistema."); return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    
