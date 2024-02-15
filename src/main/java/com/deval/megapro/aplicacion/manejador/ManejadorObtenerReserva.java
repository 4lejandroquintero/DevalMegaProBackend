package com.deval.megapro.aplicacion.manejador;

import com.deval.megapro.dominio.modelo.Reserva;
import com.deval.megapro.dominio.puerto.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ManejadorObtenerReserva {

    // Map<Long, Prestamo> prestamos = PrestamoRepositorioImp.getInstance().getPrestamos();
    private final ReservaRepositorio reservaRepositorio;

    @Autowired
    public ManejadorObtenerReserva(ReservaRepositorio reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }

    Map<Long, Reserva> setReservas() {
        return (Map<Long, Reserva>) this.reservaRepositorio.findAll();
    }

    public ResponseEntity<?> obtenerReserva(Long id) {
        Reserva reserva = setReservas().get(id);
        if (reserva == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reserva);
    }
}
