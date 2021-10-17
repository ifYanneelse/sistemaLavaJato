package entity;

import exceptions.ExceptionLavacao;

/**
 *
 * @author YyY
 */
public class Pontuacao {
    private int quantidade;
    
    private ExceptionLavacao exceptionLavacao;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ExceptionLavacao getExceptionLavacao() {
        return exceptionLavacao;
    }

    public void setExceptionLavacao(ExceptionLavacao exceptionLavacao) {
        this.exceptionLavacao = exceptionLavacao;
    }
        
    
    public int adicionar(int qtd) {
        return this.quantidade += qtd;
    }
    
    public int subtrair(int qtd) {
        return this.quantidade -= qtd;
    }
    
    //arrumar
    public int saldo() {
        return 0;
    }
        
}
