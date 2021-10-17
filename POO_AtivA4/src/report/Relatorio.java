package report;

import datasource.ServicoDS;
import entity.Cliente;
import entity.ItemOS;
import entity.OrdemServico;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import entity.Servico;
import entity.Veiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author YyY
 */
public class Relatorio {
    
    
    public String imprimir (Cliente cliente) throws ParseException{          
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm"); 
        
    
        sb.append("_Dados do Cliente");
        sb.append("\n");
        sb.append("Id:.................. ").append(cliente.getId()).append("\n");
        sb.append("Nome:................ ").append(cliente.getNome()).append("\n");
        sb.append("Celular:............. ").append(cliente.getCelular()).append("\n");
        sb.append("Email:............... ").append(cliente.getEmail()).append("\n");
        sb.append("Data de Cadastro:.... ").append(sdfData.format(cliente.getDataCadastro())).append("\n"); 
        
        if (cliente instanceof PessoaFisica){
            sb.append("CPF:................. ").append(((PessoaFisica)cliente).getCpf());
            sb.append("\n");
            sb.append("Data de nascimento:.. ").append(sdfData.format(((PessoaFisica)cliente).getDataNascimento()));
            sb.append("\n\n");
        } else {
            sb.append("CNPJ:................ ").append(((PessoaJuridica)cliente).getCnpj());
            sb.append("\n");
            sb.append("Inscrição Estadual:.. ").append(((PessoaJuridica)cliente).getInscricaoEstadual());
            sb.append("\n\n");
        }
        
        
        sb.append("_Dados do Veículo ");
       // int cont = 0;
        if (cliente.getListaVeiculos() != null){
            for (Veiculo v: cliente.getListaVeiculos()){ //de cada veiculo do cliente os dados
         //       sb.append(++cont); 
                sb.append("\n");
                sb.append("Id do veículo:.... ").append(v.getId()).append("\n");
                sb.append("Placa:............ ").append(v.getPlaca()).append("\n");
                sb.append("Observação:....... "). append(v.getObservacoes()).append("\n");         
             //sb.append("Id do modelo: " + veiculo1.getModelo().getId());
                sb.append("Modelo:........... ").append(v.getModelo().getDescricao()).append("\n");    
             //sb.append("Id da marca: " + v.getModelo().getMarca().getId());
                sb.append("Marca:............ ").append(v.getModelo().getMarca().getNome()).append("\n");      
             //sb.append("Id da cor: " + v.getCor());
                sb.append("Cor:.............. ").append(v.getCor().getNome()).append("\n");
                sb.append("Categoria:........ ").append(v.getModelo().getCategoria()).append("\n");      
            }
        }else{
            sb.append("Não há veículos registrados...").append("\n");
        }        
        
        return sb.toString();               
 }
    

    public String imprimir(OrdemServico orS) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm"); 
                             
        sb.append("_Dados do Serviço");       
        sb.append("\n");
        sb.append("Status:............. ").append(orS.getStatus()).append("\n");
        sb.append("Número:............. ").append(orS.getNumero()).append("\n"); 
        sb.append("Pontos:............. ").append(Servico.getPontos()).append("\n");
        sb.append("Data:............... ").append(sdfData.format(orS.getData())).append("\n");
        sb.append("Hora:............... ").append(sdfHora.format(orS.getHora())).append("\n\n");
//        sb.append(orS.getDadosServicos().);          
        sb.append("Desconto:............. R$ ").append(orS.getDesconto()).append("\n"); 
        sb.append("Total:................ R$ ").append(orS.calcularServico()).append("\n");        
        return sb.toString(); 
    }

    public String imprimir(Servico servico) {
        StringBuilder sb = new StringBuilder();
        sb.append(servico.getDadosServicos());
        sb.append("\n");
        return sb.toString(); 
    }

    
}
