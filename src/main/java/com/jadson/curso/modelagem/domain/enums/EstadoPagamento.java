package com.jadson.curso.modelagem.domain.enums;

public enum EstadoPagamento {
    PENDENTE (1, "Pendente"),
    QUITADO (1, "Quitado"),
    CANCELADO (1, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        if(cod == null)
            return null;
        for(EstadoPagamento x : EstadoPagamento.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("ID invalido");
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
