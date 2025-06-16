//Trabalho de Programação - João Möller, Patrick Gomes e Renato Amaral 
//Classe que representa um pet (animal de estimação)

public class Pet {
    // Atributos do pet - usei private para encapsulamento
    private String nomePet;
    private String especieAnimal; // cachorro, gato, etc
    private String racaAnimal;
    private int idadeAnos;
    private double pesoKg; // peso em quilos
    
    // Construtor - método especial que cria um objeto Pet
    public Pet(String nome, String especie, String raca, int idade, double peso) {
        // this serve para referenciar os atributos da classe atual
        this.nomePet = nome;
        this.especieAnimal = especie;
        this.racaAnimal = raca;
        this.idadeAnos = idade;
        this.pesoKg = peso;
    }
    
    // Métodos getter - para acessar os dados privados
    public String getNome() { 
        return nomePet; 
    }
    
    public String getEspecie() { 
        return especieAnimal; 
    }
    
    public String getRaca() { 
        return racaAnimal; 
    }
    
    public int getIdade() { 
        return idadeAnos; 
    }
    
    public double getPeso() { 
        return pesoKg; 
    }
    
    // Método que criei para mostrar as informações do pet
    public String getInformacoes() {
        return nomePet + " - " + especieAnimal + " da raça " + racaAnimal + 
               " (" + idadeAnos + " anos, " + pesoKg + " kg)";
    }
}
