package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YyY
 */
public class Servico {
    private int id;
    private String descricao;  
    private double valor;
    private static int pontos;  

    private ECategoria categoria;
    
    

    public Servico(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor += valor;
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Servico.pontos = pontos;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    public String getDadosServicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id ").append("\t").append("Descrição Serviço").append("\t").append("Valor ").append("\n"); 
        sb.append(this.id).append("\t").append(this.descricao).append("\t\t").append(this.valor).append("\n");  
        return sb.toString();   
    }    
    
}
