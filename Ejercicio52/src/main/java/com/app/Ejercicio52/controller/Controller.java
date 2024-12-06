package com.app.Ejercicio52.controller;

import com.app.Ejercicio52.model.Empleado;
import com.app.Ejercicio52.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class Controller {

    @Autowired
    private EmpleadoService empleadoService;

    // Obtener todos los empleados
    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    // Obtener un empleado por DNI
    @GetMapping("/{dni}")
    public Empleado getEmpleadoByDni(@PathVariable String dni) {
        return empleadoService.getEmpleadoByDni(dni);
    }

    // Crear un nuevo empleado
    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    // Eliminar un empleado por DNI
    @DeleteMapping("/{dni}")
    public void deleteEmpleado(@PathVariable String dni) {
        empleadoService.deleteEmpleado(dni);
    }
}
