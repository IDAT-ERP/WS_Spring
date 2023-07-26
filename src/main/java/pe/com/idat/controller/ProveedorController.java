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


import pe.com.idat.model.Proveedores;
import pe.com.idat.services.ProveedoresServices;



@RestController
@CrossOrigin("http://localhost:3000")//definimos puertos del cliente web REACT
@RequestMapping("/ModConfig")
public class ProveedorController {
	@Autowired
	ProveedoresServices proveedoresServices;
	
	//listamos
	@GetMapping("/verProveedor")
	public ArrayList<Proveedores>ListarEmpleados(){
		return proveedoresServices.ObtenerEmpleados();
	}
	//guardamos
	
	@PostMapping("/proveedor")
	public Proveedores NuevoPersonal(@RequestBody Proveedores newUser) {
		return proveedoresServices.GuardaEmpleados(newUser);
	}
	
	
	
	//Buscar por id
	@GetMapping(path = "/verProveedor/{id}")
	public Optional<Proveedores>obtenerUsuarioporId(@PathVariable("id") Long id){
		return proveedoresServices.obtenerId(id);
	}
	
	
	
	
	
	
	//Eliminar 
	@DeleteMapping(path="/proveedor/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
		boolean ok=this.proveedoresServices.eliminar(id);
		if (ok) {
			return "Se eliminó el trabajador con id "+id;
		}else {
			return "No se pudo eliminar trabajador con id "+id;
		}
	}
	
	
	
	
	  @PutMapping("/proveedor/{id}")
	  public ResponseEntity<Proveedores> editarEmpleado(@RequestBody Proveedores emp, @PathVariable Long id){
		  return proveedoresServices.editarEmpleado(emp, id);
	  }
	
	  
	
	
	
	
}
