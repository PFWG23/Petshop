package model;

public class Pet {
    
    public Pet(String nome, String especie, String raca, int idade, double peso) {
        String nomeTemp = nome;
        this.nome = nomeTemp;
        
        this.especie = especie;
        this.raca = raca;
        
        int idadePet = idade;
        double pesoPet = peso;
        this.idade = idadePet;
        this.peso = pesoPet;
    }
    
    private String nome;
    private String especie; 
    private String raca;
    private int idade;
    private double peso;    
    public String getNome() { 
        return nome; 
    }
    
    public String getEspecie() { 
        return especie; 
    }
    
    public String getRaca() { 
        return raca; 
    }
    
    public int getIdade() { 
        return idade; 
    }
    
    public double getPeso() { 
        return peso; 
    }
    
    public String getInformacoes() {
        String info = nome + " - " + especie + " da raça " + raca;
        String complemento = " (" + idade + " anos, " + peso + " kg)";
        return info + complemento;
    }
}
