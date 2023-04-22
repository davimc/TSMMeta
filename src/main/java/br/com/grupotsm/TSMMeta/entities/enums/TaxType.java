package br.com.grupotsm.TSMMeta.entities.enums;

public enum TaxType {
    SOURCE(1,"Fonte"),AMORTIZED(2, "Amortizado");

    private int cod;
    private String desc;

    TaxType(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static TaxType toEnum(Integer cod) {
        if(cod == null) return null;
        for(TaxType d: TaxType.values())
            if(cod.equals(d.getCod()))
                return d;
        throw new IllegalArgumentException("Tipo inválido");
    }
}
