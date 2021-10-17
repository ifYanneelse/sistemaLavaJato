package entity;

/**
 *
 * @author YyY
 */
public enum EStatus {
    ABERTA("Aberta"), FECHADA("Fechada"), CANCELADA("Cancelada");
    
    private String DescricaoStatus;
    
    EStatus(String descricaoStatus){
        this.DescricaoStatus = descricaoStatus;
    }

    public String getDescricaoStatus() {
        return DescricaoStatus;
    }
}
