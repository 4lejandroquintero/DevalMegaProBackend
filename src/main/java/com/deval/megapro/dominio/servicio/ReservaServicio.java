package com.deval.megapro.dominio.servicio;

import com.deval.megapro.dominio.modelo.Reserva;
import com.deval.megapro.dominio.modelo.TipoUsuario;

import java.util.Calendar;
import java.util.Map;
import java.util.Objects;

public class ReservaServicio {
    public Boolean tieneReserva(String identificacionUsuario, Map<Long, Reserva> reservas) {
        for (Reserva reserva : reservas.values()) {
            if (Objects.equals(reserva.getIdentificacionUsuario(), identificacionUsuario))
                return true;
        }
        return false;
    }

    public Calendar calcularFechaReserva(TipoUsuario tipoUsuario) {
        Calendar fechaReserva = Calendar.getInstance();
        int diasReserva = tipoUsuario.getDiasReserva();

        for (int i = 0; i < diasReserva; i++) {
            fechaReserva.add(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = fechaReserva.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                i--;
            }
        }
        return fechaReserva;
    }
}
