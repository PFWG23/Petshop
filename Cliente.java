//trabalho de João Möller, Patrick Gomes e Renato Amaral 
import java.util.*;

public class Cliente {
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
