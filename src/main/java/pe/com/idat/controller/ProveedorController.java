package pe.com.idat.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.idat.model.Empleados;
import pe.com.idat.services.EmpleadosServices;



@RestController
@CrossOrigin("http://localhost:3000")//definimos puertos del cliente web REACT
@RequestMapping("/ModConfig")
public class ProveedorController {
	@Autowired
	EmpleadosServices empleadosServices;
	
	//listamos
	@GetMapping("/verPersonal")
	public ArrayList<Empleados>ListarEmpleados(){
		return empleadosServices.ObtenerEmpleados();
	}
	//guardamos
	
	@PostMapping("/empleado")
	public Empleados NuevoPersonal(@RequestBody Empleados newUser) {
		return empleadosServices.GuardaEmpleados(newUser);
	}
	
	
	
	//Buscar por id
	@GetMapping(path = "/verPersonal/{id}")
	public Optional<Empleados>obtenerUsuarioporId(@PathVariable("id") Long id){
		return empleadosServices.obtenerId(id);
	}
	
	
	
	
	
	
	//Eliminar 
	@DeleteMapping(path="/empleado/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
		boolean ok=this.empleadosServices.eliminar(id);
		if (ok) {
			return "Se eliminó el trabajador con id "+id;
		}else {
			return "No se pudo eliminar trabajador con id "+id;
		}
	}
	
	
	
	
	  @PutMapping("/empleado/{id}")
	  public ResponseEntity<Empleados> editarEmpleado(@RequestBody Empleados emp, @PathVariable Long id){
		  return empleadosServices.editarEmpleado(emp, id);
	  }
	
	
	
	
	
	
}
