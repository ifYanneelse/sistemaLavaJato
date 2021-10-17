package entity;

/**
 *
 * @author YyY
 */
public enum ECategoria {
    PEQUENO(1, "Pequeno"), MEDIO(2, "Médio"), GRANDE(3, "Grande"), MOTO(4, "Moto"), PADRAO(0, "Padrão");
    
    private int valor;
    private String DescricaoCategoria;
    
    private ECategoria(int valor, String descricao){
        this.valor = valor;
        this.DescricaoCategoria = descricao;
    }

    public int getValor (){
        return valor;
    }
    
    public String getDescricaoCategoria() {
        return DescricaoCategoria;
    }
    
}
