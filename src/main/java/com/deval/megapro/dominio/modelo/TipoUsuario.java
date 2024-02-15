package com.deval.megapro.dominio.modelo;

public enum TipoUsuario {
    PREMIUM(1, 7),
    REGULAR(2, 4),
    CLASICO(3, 2),
    DESCONOCIDO(-1,0);

    private int codigo;
    private int diasReserva;

    TipoUsuario(int codigo, int diasReserva) {
        this.codigo = codigo;
        this.diasReserva = diasReserva;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getDiasReserva() {
        return diasReserva;
    }

}

