package com.deval.megapro.dominio.puerto;

import com.deval.megapro.dominio.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    Map<Long, Reserva> getReservas();
    void setReservas(Map<Long, Reserva> prestamos);
}