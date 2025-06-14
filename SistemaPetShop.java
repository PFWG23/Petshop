//trabalho de João Möller, Patrick Gomes e Renato Amaral 
import java.text.SimpleDateFormat;
import java.util.*;

public class SistemaPetShop {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Pet Shop ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar  pet");
            System.out.println("3. Contratar serviço");
            System.out.println("4. Listar clientes  e pets");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção : ");
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

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        clientes.add(new Cliente(nome, telefone, email));
        System.out.println("Cliente  cadastrado com sucessso.");
    }

    private static void cadastrarPet() {
        Cliente cliente = escolherCliente();
        if (cliente == null) return;

        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Raca: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());

        cliente.adicionarPet(new Pet(nome, especie, raca, idade, peso));
        System.out.println("Pet cadastrado com sucesso.");
    }

    private static void contratarServico() {
        Cliente cliente = escolherCliente();
        if (cliente == null) return;

        if (cliente.getPets().isEmpty()) {
            System.out.println("Este cliente nao tem pets cadastrados.");
            return;
        }

        Pet pet = cliente.getPets().get(0); // Simples: assume 1 pet
        System.out.println("Selecionando serviço para o pet: " + pet.getNome());

        System.out.println("1. Banho e Tosa\n2. Consulta Veterinaria\n3. Hospedagem\n4. Adestramento");
        System.out.print("Escolha o serviço: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        System.out.print("Data do serviço (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();

        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            Servico servico = null;

            switch (escolha) {
                case 1: servico = new BanhoETosa(data); break;
                case 2: servico = new ConsultaVeterinaria(data); break;
                case 3: servico = new Hospedagem(data); break;
                case 4: servico = new Adestramento(data); break;
                default: System.out.println("Servico invalido."); return;
            }

            System.out.println("Servico contratado: " + servico.getNome() + " para " + pet.getNome() + " em " + servico.getDataFormatada());
        } catch (Exception e) {
            System.out.println("Data invalida.");
        }
    }

    private static void listarClientesEPets() {
        for (Cliente c : clientes) {
            System.out.println("Cliente: " + c.getNome() + " | Pets: ");
            for (Pet p : c.getPets()) {
                System.out.println(" - " + p.getNome() + " (" + p.getEspecie() + ", " + p.getRaca() + ")");
            }
        }
    }

    private static Cliente escolherCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return null;
        }

        System.out.println("Escolha um cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Opcao: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx >= 0 && idx < clientes.size()) {
            return clientes.get(idx);
        }
        System.out.println("Cliente invalido.");
        return null;
    }
}
