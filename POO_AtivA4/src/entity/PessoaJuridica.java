package entity;

import java.util.Date;

/**
 *
 * @author YyY
 */
public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica(String cnpj, String inscricaoEstadual){
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

//    @Override
//    public String getDados() {  
//        StringBuilder sb = new StringBuilder();
//            sb.append(super.getDados());
//            sb.append("CNPJ:................ "); sb.append(this.getCnpj()); sb.append("\n");
//            sb.append("Inscrição Estadual:.. "); sb.append(this.getInscricaoEstadual()); sb.append("\n");
//        return sb.toString();                 
//    }

    @Override
    public String getDados(String observacao) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getDados());
        sb.append("Observações: ");
        sb.append(observacao);        
        System.out.println("__________________________________");
        return sb.toString();            
    }
}
