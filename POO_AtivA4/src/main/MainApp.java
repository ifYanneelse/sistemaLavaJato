
package main;

import datasource.ServicoDS;
import entity.Cliente;
import entity.Cor;
import entity.ECategoria;
import entity.EStatus;
import entity.ItemOS;
import entity.Marca;
import entity.Modelo;
import entity.OrdemServico;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import entity.Servico;
import entity.Veiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import report.Relatorio;

// veiculo: carro | moto // cor: branco, azul, preto 
// marca: sukuzi, fiat, honda | suzuki, bmw, honda
// modelo: jimny, doblo, civic | burgman, motorrad, crf

public class MainApp {
        private static SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        private static SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        
    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);            
        
        System.out.print("__________ Lavação de Veículos __________\n");
        
              
//        ServicoDS.inicializarListaS();
//        System.out.println(ServicoDS.listagemServicos());  // mostra lista de serviços
        

        Marca marca1 = new Marca(); marca1.setId (24); marca1.setNome ("Suzuki");
        Marca marca2 = new Marca(); marca2.setId (25); marca2.setNome ("Fiat");
        Marca marca3 = new Marca(); marca3.setId (26); marca3.setNome ("Bmw");
        
        Cor cor1 = new Cor(); cor1.setNome("azul"); cor1.setId(567);
        Cor cor2 = new Cor(); cor2.setNome("branco"); cor2.setId(568);
        Cor cor3 = new Cor(); cor3.setNome("preto"); cor3.setId(569);     
        
        Modelo modelo = new Modelo(); modelo.setId(102); modelo.setDescricao("xxx");  

        System.out.print("\nSelecione a categoria do veículo \n");
        System.out.println("1: Pequeno  \n2: Médio\n3: Grande\n4: Moto\n0: Padrão\n>");
        int nCat = entrada.nextInt();
        switch (nCat){
            case 1: modelo.setCategoria(ECategoria.PEQUENO); break;
            case 2: modelo.setCategoria(ECategoria.MEDIO); break;
            case 3: modelo.setCategoria(ECategoria.GRANDE); break;
            case 4: modelo.setCategoria(ECategoria.MOTO); break;
            case 5: modelo.setCategoria(ECategoria.PADRAO); break;
            default: modelo.setCategoria(ECategoria.PADRAO); break;
        }
        System.out.println("__________________________________\n");  
        
        
        Cliente cliente = new PessoaFisica();       
             
        System.out.println("Cadastrar cliente");  
        System.out.print("Id:.................. "); cliente.setId(entrada.nextInt());
        System.out.print("Nome:................ "); cliente.setNome(entrada.next());
        System.out.print("Celular:............. "); cliente.setCelular(entrada.next());
        System.out.print("Email:............... "); cliente.setEmail(entrada.next());
        System.out.print("Data de Cadastro:.... "); String strTmp = entrada.next(); cliente.setDataCadastro(sdfData.parse(strTmp));
        if (cliente instanceof PessoaFisica){
            System.out.print("CPF:................. "); ((PessoaFisica)cliente).setCpf(entrada.next());
            System.out.print("Data de nascimento:.. "); strTmp = entrada.next(); ((PessoaFisica)cliente).setDataNascimento(sdfData.parse(strTmp));
        } else {
            System.out.print("CNPJ:................ "); ((PessoaJuridica)cliente).setCnpj(entrada.next());
            System.out.print("Inscrição Estadual:.. "); ((PessoaJuridica)cliente).setInscricaoEstadual(entrada.next());
        }
        System.out.println("\n");  
                  
        Veiculo veiculo1 = new Veiculo();     
        System.out.println("Cadastrar veículo");  
        System.out.print("ID:....... "); veiculo1.setId(entrada.nextInt()); 
        System.out.print("Placa:.... "); veiculo1.setPlaca(entrada.next()); 
        System.out.print("Observação (apenas 1 palavra).: "); veiculo1.setObservacoes(entrada.next()); 
        System.out.println("__________________________________\n");  
                
        veiculo1.setModelo(modelo); modelo.setMarca(marca1); veiculo1.setCor(cor2); veiculo1.setCliente(cliente); 
 //       System.out.println(cliente.getDados());
       
 
 
        //criando ordem
        OrdemServico orS = new OrdemServico(5000, new Date(), new Date(), 10, EStatus.ABERTA, veiculo1);
        
        // criando item
        ItemOS item1 = new ItemOS(); 
        item1.setServico(ServicoDS.get(4)); 
        orS.add(item1);
        ItemOS item2 = new ItemOS(); item2.setServico(ServicoDS.get(5)); orS.add(item2); 
                       
        Servico.setPontos(2); // pontos da classe Servico    
        Servico servico1 = new Servico(2, "Limpeza 4 rodas", 100.00);
        Servico servico2 = new Servico(4, "Limpeza motor", 150.00);
//        orS.calcularServico();

//        System.out.println(orS.getDadosServicos()); 
//        System.out.println(item1);
//        System.out.println(item2);


        
        PessoaJuridica pj1 = new PessoaJuridica("12032020", "123499400000012");
        pj1.setId(123); 
        pj1.setNome("Ana"); 
        pj1.setCelular("91290-2345"); 
        pj1.setEmail("ana.email.com");
        pj1.setDataCadastro(sdfData.parse(strTmp)); 
        
        Veiculo veiculo2 = new Veiculo(); 
        veiculo2.setId(12); 
        veiculo2.setPlaca("45b8PO"); 
        veiculo2.setObservacoes("novo"); 
        veiculo2.setModelo(modelo); modelo.setMarca(marca3); veiculo2.setCor(cor3); veiculo2.setCliente(pj1); 

        
        
        Relatorio relatorio1 = new Relatorio();
        System.out.println("Pessoa Física");
        System.out.println(relatorio1.imprimir(cliente));
        System.out.println(relatorio1.imprimir(orS));
        System.out.println(relatorio1.imprimir(servico1));
        System.out.println(relatorio1.imprimir(servico2));

        System.out.println("__________________________________");   
        System.out.println("\n");
        System.out.println("Pessoa Jurídica");
        System.out.println(relatorio1.imprimir(pj1));          
}
   
}
