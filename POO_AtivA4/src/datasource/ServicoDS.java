package datasource;

import entity.ECategoria;
import entity.Servico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YyY
 */
public class ServicoDS {
    private static List<Servico> listaServicos = new ArrayList<>();
    
    public static void inicializarListaS (){
        listaServicos.add(new Servico (1, "Simples ", 15.00));
//        listaServicos.add(new Servico (2, "Simples ", 18.00, ECategoria.PEQUENO));
//        listaServicos.add(new Servico (3, "Simples ", 20.00, ECategoria.MEDIO));
//        listaServicos.add(new Servico (4, "Simples ", 25.00, ECategoria.GRANDE));
//        listaServicos.add(new Servico (5, "Simples ", 10.00, ECategoria.MOTO));
        listaServicos.add(new Servico (2, "Completa", 30.00));        
    }
    
    public static Servico get(int id){
        for (Servico s : listaServicos) {
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
    
    public static String listagemServicos(){
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem dos serviços").append("\n");
        for(Servico s: listaServicos){
            sb.append(s.getDadosServicos());
        }
        return sb.toString();
    }  

    public static List<Servico> getListaServicos() {
        return listaServicos;
    }

    public static void setListaServicos(List<Servico> listaServicos) {
        ServicoDS.listaServicos = listaServicos;
    }
    
    
    
}
