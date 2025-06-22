package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Servico {
    
    public Servico(String nome, double preco, Date data) {
        String nomeTemp = nome;
        this.nome = nomeTemp;
        this.preco = preco;
        
        Date dataTemp = data;
        this.data = dataTemp;
    }
    
    protected String nome; 
    protected double preco;
    protected Date data;    
    public String getNome() { 
        return nome; 
    }
    
    public double getPreco() { 
        return preco; 
    }
    
    public Date getDataAgendada() { 
        return data; 
    }
    
    public String getDataFormatada() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }
    
    public abstract double calcularPreco();
    
    public String getInformacaoCompleta() {
        String info = nome + " - R$ " + preco;
        String dataFormatada = " - " + getDataFormatada();
        return info + dataFormatada;
    }
}
