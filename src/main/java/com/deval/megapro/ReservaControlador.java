package com.deval.megapro;

import com.deval.megapro.aplicacion.manejador.ManejadorCrearReserva;
import com.deval.megapro.aplicacion.manejador.ManejadorObtenerReserva;
import com.deval.megapro.dominio.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "reserva")
public class ReservaControlador {
  /*  ManejadorCrearPrestamo manejadorCrearPrestamo = new ManejadorCrearPrestamo();
    ManejadorObtenerPrestamo manejadorObtenerPrestamo = new ManejadorObtenerPrestamo();*/

    private final ManejadorObtenerReserva manejadorObtenerReserva;
    private final ManejadorCrearReserva manejadorCrearReserva;

    @Autowired
    public ReservaControlador(ManejadorObtenerReserva manejadorObtenerReserva, ManejadorCrearReserva manejadorCrearReserva) {
        this.manejadorObtenerReserva = manejadorObtenerReserva;
        this.manejadorCrearReserva = manejadorCrearReserva;
    }


    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {
        return manejadorCrearReserva.crearReserva(reserva);
    }

    @GetMapping(value = "/{id-reserva}")
    public ResponseEntity<?> obtenerReserva(@PathVariable("id-reserva") Long id) {
        return manejadorObtenerReserva.obtenerReserva(id);
    }
}
