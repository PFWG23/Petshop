package model;

import java.util.*;

public class Cliente {    
    public Cliente(String nome, String telefone, String email) {
        String nomeCliente = nome;
        String telefoneContato = telefone; 
        String emailCliente = email;
        
        this.nome = nomeCliente;
        this.telefone = telefoneContato;
        this.email = emailCliente;
        pets = new ArrayList<Pet>();
    }
    
    private String nome;
    private String telefone;
    private String email;
    private ArrayList<Pet> pets;    
    public String getNome() { 
        return nome; 
    }
    
    public String getTelefone() { 
        return telefone; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public List<Pet> getPets() { 
        return pets; 
    }
    
    public void adicionarPet(Pet novoPet) {
        pets.add(novoPet);
    }
    
    public int getQuantidadePets() {
        int quantidade = pets.size();
        return quantidade;
    }
}
