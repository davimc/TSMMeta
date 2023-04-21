package br.com.grupotsm.TSMMeta.entities.enums;

public enum DebitStatus {
    ACTIVE(1,"Ativo"),CANCELED(2, "Cancelado");

    private int cod;
    private String desc;

    DebitStatus(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static DebitStatus toEnum(Integer cod) {
        if(cod == null) return null;
        for(DebitStatus d: DebitStatus.values())
            if(cod.equals(d.getCod()))
                return d;
        throw new IllegalArgumentException("Status inválido");
    }
}
