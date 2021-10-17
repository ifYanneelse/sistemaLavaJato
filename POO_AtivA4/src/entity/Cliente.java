package entity;
import exceptions.ExceptionLavacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author YyY
 */
public abstract class Cliente implements ICliente{
    private int id;
    private String nome;
    private String celular;
    private String email;
    private Date dataCadastro;
        
    private Veiculo veiculo;
    private PessoaFisica pessoafisica;
    private PessoaJuridica pessoajuridica;
        
    private List <Veiculo> listaVeiculos;
    
    private Pontuacao pontuacao;
    private ExceptionLavacao exceptionLavacao;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public PessoaFisica getPessoafisica() {
        return pessoafisica;
    }

    public void setPessoafisica(PessoaFisica pessoafisica) {
        this.pessoafisica = pessoafisica;
    }

    public PessoaJuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(PessoaJuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }


    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ExceptionLavacao getExceptionLavacao() {
        return exceptionLavacao;
    }

    public void setExceptionLavacao(ExceptionLavacao exceptionLavacao) {
        this.exceptionLavacao = exceptionLavacao;
    }
    
      
    public void add(Veiculo veiculo) {
        if (this.listaVeiculos == null){ //poder ter 0 ou nenhum veículo
            this.listaVeiculos = new ArrayList<>();
        }
        this.listaVeiculos.add (veiculo);
    }
    
    public void remove(Veiculo veiculo) {
        if (this.listaVeiculos != null){ 
            this.listaVeiculos.remove(veiculo);
        }
    }


    @Override
    public String getDados(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
//        sb.append("_Dados do Veículo ");
//       // int cont = 0;
//        if (this.getListaVeiculos() != null){
//            for (Veiculo v: this.getListaVeiculos()){ //de cada veiculo do cliente os dados
//         //       sb.append(++cont); 
//                sb.append("\n");
//                sb.append("Id do veículo:.... " + v.getId()); sb.append("\n");
//                sb.append("Placa:............ " + v.getPlaca()); sb.append("\n");
//                sb.append("Observação:....... " + v.getObservacoes()); sb.append("\n");         
//             //sb.append("Id do modelo: " + veiculo1.getModelo().getId());
//                sb.append("Modelo:........... " + v.getModelo().getDescricao()); sb.append("\n");    
//             //sb.append("Id da marca: " + v.getModelo().getMarca().getId());
//                sb.append("Marca:............ " + v.getModelo().getMarca().getNome()); sb.append("\n");      
//             //sb.append("Id da cor: " + v.getCor());
//                sb.append("Cor:.............. " + v.getCor().getNome()); sb.append("\n");
//                sb.append("Categoria:........ " + v.getModelo().getCategoria()); sb.append("\n");      
//                sb.append("\n");
//            }
//        }else{
//            sb.append("Não há veículos registrados..."); sb.append("\n");
//        }      
        
        sb.append("_Dados do Cliente");
        sb.append("\n");
        sb.append("Id:.................. "); sb.append(this.getId()); sb.append("\n");
        sb.append("Nome:................ "); sb.append(this.getNome()); sb.append("\n");
        sb.append("Celular:............. "); sb.append(this.getCelular()); sb.append("\n");
        sb.append("Email:............... "); sb.append(this.getEmail()); sb.append("\n");
        sb.append("Data de Cadastro:.... "); sb.append(sdf.format(this.getDataCadastro())); sb.append("\n");     
                                     
        return sb.toString();              
    }
    
}
