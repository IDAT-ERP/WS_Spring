package pe.com.idat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.idat.model.Empleados;
import pe.com.idat.repository.EmpleadosRepository;
import pe.com.idat.services.EmpleadosServices;



@RestController
@CrossOrigin("http://localhost:3000")//definimos puertos del cliente web REACT
@RequestMapping("/ModConfig")
public class EmpleadoController {
	@Autowired
	EmpleadosServices empleadosServices;
	EmpleadosRepository emp;
	//listamos
	@GetMapping("/verPersonal")
	public ArrayList<Empleados>ListarEmpleados(){
		return empleadosServices.ObtenerEmpleados();
	}
	//guardamos
	
	@PostMapping("Guardar Personal")
	Empleados NuevoPersonal(@RequestBody Empleados newUser) {
		return emp.save(NuevoPersonal(newUser));
	}
	
}
