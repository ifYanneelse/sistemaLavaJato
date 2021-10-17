package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author YyY
 */
public class OrdemServico {
    private long numero;
    private double total;
    private Date data;
    private Date hora;
    private double desconto;
    
    private EStatus status;
    private Veiculo veiculo;    
    private List<ItemOS> itensOS = new ArrayList<>();
    private List<Servico> listaServicos = new ArrayList<>();

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }
        
    
    public OrdemServico(long numero, Date data, Date hora, double desconto, EStatus status, Veiculo veiculo) {
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.desconto = desconto;
        this.status = status;
        this.veiculo = veiculo;
    }
    
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }


    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ItemOS> getItensOS() {
        return itensOS;
    }

    public void setItensOS(List<ItemOS> itensOS) {
        this.itensOS = itensOS;
    }
    
    
    public double calcularServico() {
        double totalValor = 0.0  ;
        for (ItemOS iOS: itensOS){
            totalValor += iOS.getValorServico();
        }
        this.total = totalValor - (totalValor * desconto/100);
        return totalValor;
    }
    
    public void add (ItemOS item){
        itensOS.add(item);
        item.setOrdemServico(this);
    }
    
    public void remove(ItemOS item) {
        itensOS.remove(item);
        item.setOrdemServico(this);
    }    
    
    public String getDadosServicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID ").append("\t");
        sb.append("DescriçãoServiço ").append("\t");
        sb.append("Valor ").append("\t");
        sb.append("\n");
        return sb.toString();   
    }

}
