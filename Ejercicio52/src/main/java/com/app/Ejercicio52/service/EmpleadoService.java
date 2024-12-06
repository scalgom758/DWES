package com.app.Ejercicio52.service;

import com.app.Ejercicio52.model.Empleado;
import com.app.Ejercicio52.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoByDni(String dni) {
        return empleadoRepository.findById(dni).orElse(null);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
}
