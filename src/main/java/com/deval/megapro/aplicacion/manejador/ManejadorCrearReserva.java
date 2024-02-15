package com.deval.megapro.aplicacion.manejador;

import com.deval.megapro.dominio.modelo.Reserva;
import com.deval.megapro.dominio.modelo.TipoUsuario;
import com.deval.megapro.dominio.puerto.ReservaRepositorio;
import com.deval.megapro.dominio.servicio.ReservaServicio;
import com.deval.megapro.dominio.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ManejadorCrearReserva {

    // PrestamoServicio prestamoServicio = new PrestamoServicio();
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    //Map<Long, Prestamo> prestamos = PrestamoRepositorioImp.getInstance().getPrestamos();

    HashMap<Long, Reserva> reservas;

    private final ReservaRepositorio reservaRepositorio;
    private final ReservaServicio reservaServicio;

    @Autowired
    public ManejadorCrearReserva(ReservaRepositorio reservaRepositorio, ReservaServicio reservaServicio) {

        this.reservaRepositorio = reservaRepositorio;
        this.reservaServicio = reservaServicio;
    }

    public ResponseEntity<?> crearReserva(Reserva reserva) {
        TipoUsuario tipoUsuario = UsuarioServicio.fromCodigo(reserva.getTipoUsuario());
        if (tipoUsuario == TipoUsuario.DESCONOCIDO)
            return ResponseEntity.badRequest().body("{\"mensaje\": \"Tipo de usuario no permitido para reservas\"}");
        if (tipoUsuario == TipoUsuario.CLASICO && reservaServicio.tieneReserva(reserva.getIdentificacionUsuario(),reservas)) {
            return ResponseEntity.badRequest().body("{\"mensaje\": \"El usuario con identificación " + reserva.getIdentificacionUsuario()
                    + " ya tiene una reserva hecha por lo cual no se le puede realizar otra reserva\"}");
        }

        Calendar fechaReserva = reservaServicio.calcularFechaReserva(tipoUsuario);
        reserva.setFechaMaximaReserva(dateFormat.format(fechaReserva.getTime()));
        reservas.put(reserva.getId(),reserva);
        // PrestamoRepositorioImp.getInstance().setPrestamos(prestamos);

        return ResponseEntity.ok(reserva);
    }
}
