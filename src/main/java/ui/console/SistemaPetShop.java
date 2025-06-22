//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Sistema principal do Pet Shop - versão console
//Esta é a versão original que fizemos primeiro, antes das interfaces gráficas
package ui.console;

import java.text.SimpleDateFormat;
import java.util.*;
import model.*;

public class SistemaPetShop {
    // Scanner global para ler entrada do usuário
    private static Scanner leitorEntrada = new Scanner(System.in);
    // Lista para armazenar todos os clientes
    private static List<Cliente> listaDeClientes = new ArrayList<>();

    // Método principal - ponto de entrada do programa
    public static void main(String[] args) {
        System.out.println("=== Bem-vindo ao Sistema Pet Shop ===");
        System.out.println("Trabalho desenvolvido por João, Patrick e Renato");
        
        // Loop infinito até o usuário escolher sair
        while (true) {
            mostrarMenu();
            int opcaoEscolhida = lerOpcaoUsuario();
            
            // Switch para chamar o método correto baseado na opção
            switch (opcaoEscolhida) {
                case 1: 
                    fazerCadastroCliente(); 
                    break;
                case 2: 
                    fazerCadastroPet(); 
                    break;
                case 3: 
                    fazerContratacaoServico(); 
                    break;
                case 4: 
                    mostrarListaClientesPets(); 
                    break;
                case 5: 
                    System.out.println("Obrigado por usar nosso sistema! Até logo!"); 
                    return; // sai do programa
                default: 
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
    
    // Método para mostrar o menu principal
    private static void mostrarMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Cadastrar pet para cliente");
        System.out.println("3. Contratar serviço");
        System.out.println("4. Listar todos os clientes e pets");
        System.out.println("5. Sair do sistema");
        System.out.println("====================================");
        System.out.print("Digite sua opção: ");
    }
    
    // Método para ler a opção do usuário com tratamento de erro
    private static int lerOpcaoUsuario() {        try {
            return Integer.parseInt(leitorEntrada.nextLine());
        } catch (NumberFormatException e) {
            return -1; // retorna valor inválido se não conseguir converter
        }
    }
    
    // Método para cadastrar um novo cliente
    private static void fazerCadastroCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = leitorEntrada.nextLine();
        
        System.out.print("Digite o telefone: ");
        String telefoneCliente = leitorEntrada.nextLine();
        
        System.out.print("Digite o email: ");
        String emailCliente = leitorEntrada.nextLine();
        
        // Cria um novo cliente e adiciona na lista
        Cliente novoCliente = new Cliente(nomeCliente, telefoneCliente, emailCliente);
        listaDeClientes.add(novoCliente);
        
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para cadastrar um pet para um cliente existente
    private static void fazerCadastroPet() {
        System.out.println("\n--- Cadastro de Pet ---");
        
        // Primeiro precisa escolher um cliente
        Cliente clienteEscolhido = escolherClienteExistente();
        if (clienteEscolhido == null) {
            return; // se não conseguiu escolher cliente, volta pro menu
        }

        System.out.print("Digite o nome do pet: ");
        String nomePet = leitorEntrada.nextLine();
        
        System.out.print("Digite a espécie (ex: Cão, Gato): ");
        String especiePet = leitorEntrada.nextLine();
        
        System.out.print("Digite a raça: ");
        String racaPet = leitorEntrada.nextLine();
        
        System.out.print("Digite a idade (em anos): ");
        int idadePet = Integer.parseInt(leitorEntrada.nextLine());
        
        System.out.print("Digite o peso (em kg): ");
        double pesoPet = Double.parseDouble(leitorEntrada.nextLine());

        // Cria o pet e adiciona ao cliente
        Pet novoPet = new Pet(nomePet, especiePet, racaPet, idadePet, pesoPet);
        clienteEscolhido.adicionarPet(novoPet);
        
        System.out.println("Pet cadastrado com sucesso para " + clienteEscolhido.getNome() + "!");
    }

    // Método para contratar um serviço
    private static void fazerContratacaoServico() {
        System.out.println("\n--- Contratação de Serviço ---");
        
        Cliente clienteEscolhido = escolherClienteExistente();
        if (clienteEscolhido == null) return;

        // Verifica se o cliente tem pets
        if (clienteEscolhido.getPets().isEmpty()) {
            System.out.println("Este cliente ainda não tem pets cadastrados!");
            return;
        }

        // Por simplicidade, pega o primeiro pet (poderia melhorar isso)
        Pet petDoServico = clienteEscolhido.getPets().get(0);
        System.out.println("Serviço será para o pet: " + petDoServico.getNome());

        // Mostra opções de serviços
        System.out.println("\nEscolha o serviço:");
        System.out.println("1. Banho e Tosa (R$ 50,00)");
        System.out.println("2. Consulta Veterinária (R$ 100,00)");
        System.out.println("3. Hospedagem (R$ 80,00)");
        System.out.println("4. Adestramento (R$ 120,00)");
        System.out.print("Digite sua escolha: ");
        
        int opcaoServico = Integer.parseInt(leitorEntrada.nextLine());

        System.out.print("Digite a data do serviço (dd/MM/yyyy): ");
        String dataTexto = leitorEntrada.nextLine();

        try {
            // Converte a data de texto para Date
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataServico = formatoData.parse(dataTexto);
            
            // Cria o serviço baseado na escolha
            Servico servicoContratado = null;
            
            if (opcaoServico == 1) {
                servicoContratado = new BanhoETosa(dataServico);
            } else if (opcaoServico == 2) {
                servicoContratado = new ConsultaVeterinaria(dataServico);
            } else if (opcaoServico == 3) {
                servicoContratado = new Hospedagem(dataServico);
            } else if (opcaoServico == 4) {
                servicoContratado = new Adestramento(dataServico);
            } else {
                System.out.println("Opção de serviço inválida!");
                return;
            }

            // Mostra confirmação
            System.out.println("\nServico contratado com sucesso!");
            System.out.println("Cliente: " + clienteEscolhido.getNome());
            System.out.println("Pet: " + petDoServico.getNome());
            System.out.println("Serviço: " + servicoContratado.getNome());
            System.out.println("Data: " + servicoContratado.getDataFormatada());
            System.out.println("Preço: R$ " + servicoContratado.getPreco());
            
        } catch (Exception e) {
            System.out.println("Data inválida! Use o formato dd/MM/yyyy");
        }
    }

    // Método para listar todos os clientes e seus pets
    private static void mostrarListaClientesPets() {
        System.out.println("\n========== RELATÓRIO DE CLIENTES ==========");
        
        if (listaDeClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado ainda.");
            return;
        }
        
        // Loop para mostrar cada cliente
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Cliente cliente = listaDeClientes.get(i);
            System.out.println("\n" + (i+1) + ". Cliente: " + cliente.getNome());
            System.out.println("   Telefone: " + cliente.getTelefone());
            System.out.println("   Email: " + cliente.getEmail());
            
            // Mostra os pets do cliente
            if (cliente.getPets().isEmpty()) {
                System.out.println("   Pets: Nenhum pet cadastrado");
            } else {
                System.out.println("   Pets:");
                for (Pet pet : cliente.getPets()) {
                    System.out.println("     - " + pet.getNome() + 
                                     " (" + pet.getEspecie() + 
                                     ", " + pet.getRaca() + 
                                     ", " + pet.getIdade() + " anos" +
                                     ", " + pet.getPeso() + " kg)");
                }
            }
        }
        System.out.println("==========================================");
    }

    // Método auxiliar para escolher um cliente da lista
    private static Cliente escolherClienteExistente() {
        if (listaDeClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado ainda. Cadastre um cliente primeiro!");
            return null;
        }

        System.out.println("\nEscolha um cliente:");
        // Mostra a lista de clientes
        for (int i = 0; i < listaDeClientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeClientes.get(i).getNome());
        }
        
        System.out.print("Digite o número do cliente: ");
        try {
            int indiceEscolhido = Integer.parseInt(leitorEntrada.nextLine()) - 1; // -1 porque array começa em 0
            
            // Verifica se o índice é válido
            if (indiceEscolhido >= 0 && indiceEscolhido < listaDeClientes.size()) {
                return listaDeClientes.get(indiceEscolhido);
            } else {
                System.out.println("Número inválido!");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite apenas números!");
            return null;
        }
    }
}
