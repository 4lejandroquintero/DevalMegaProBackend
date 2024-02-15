package com.deval.megapro.dominio.servicio;

import com.deval.megapro.dominio.modelo.TipoUsuario;

public class UsuarioServicio {
    public static TipoUsuario fromCodigo(int codigo) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.getCodigo() == codigo) {
                return tipoUsuario;
            }
        }
        return TipoUsuario.DESCONOCIDO;
    }
}

