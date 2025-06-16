//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe que representa um cliente do pet shop
import java.util.*;

public class Cliente {
    // Dados básicos do cliente
    private String nomeCliente;
    private String telefoneContato;
    private String emailCliente;
    private List<Pet> listaPets; // lista dos pets que o cliente tem
    
    // Construtor - sempre que criar um cliente novo, precisa passar esses dados
    public Cliente(String nome, String telefone, String email) {
        this.nomeCliente = nome;
        this.telefoneContato = telefone;
        this.emailCliente = email;
        this.listaPets = new ArrayList<>(); // cria uma lista vazia de pets
    }
    
    // Métodos getter - serve pra pegar os dados (encapsulamento que o professor falou)
    public String getNome() { 
        return nomeCliente; 
    }
    
    public String getTelefone() { 
        return telefoneContato; 
    }
    
    public String getEmail() { 
        return emailCliente; 
    }
    
    public List<Pet> getPets() { 
        return listaPets; 
    }
    
    // Método para adicionar um pet na lista do cliente
    public void adicionarPet(Pet novoPet) {
        listaPets.add(novoPet);
    }
    
    // Método extra que criei - conta quantos pets o cliente tem
    public int getQuantidadePets() {
        return listaPets.size();
    }
}
