package com.app.Ejercicio52.repository;

import com.app.Ejercicio52.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    // Este repositorio proporciona operaciones CRUD automáticamente
}
