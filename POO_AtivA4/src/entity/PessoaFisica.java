package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YyY
 */
public class PessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;
   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


//    @Override
//    public String getDados() {  
//        StringBuilder sb = new StringBuilder();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            sb.append(super.getDados());
//            sb.append("CPF:................. "); sb.append(this.getCpf()); sb.append("\n");
//            sb.append("Data de nascimento:.. "); sb.append(sdf.format(this.getDataNascimento())); sb.append("\n");
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
