package com.deval.megapro.dominio.modelo;

import jakarta.persistence.*;

@Entity
@Table
public class Reserva {
    private static long idContador = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cdr;
    private String identificacionUsuario;
    private int tipoUsuario;
    private String fechaMaximaReserva;

    public Reserva(String cdr, String identificacionUsuario, int tipoUsuario) {
        this.id = generarIdReserva();
        this.cdr = cdr;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Reserva() {
        this.id = generarIdReserva();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaMaximaReserva() {
        return fechaMaximaReserva;
    }

    public void setFechaMaximaReserva(String fechaMaximaReserva) {
        this.fechaMaximaReserva = fechaMaximaReserva;
    }

    private static synchronized long generarIdReserva() {
        return ++idContador;
    }
}
