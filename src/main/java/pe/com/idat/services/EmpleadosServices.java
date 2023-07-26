package pe.com.idat.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.idat.model.Empleados;
import pe.com.idat.repository.EmpleadosRepository;

@Service
public class EmpleadosServices {
	
	@Autowired
	EmpleadosRepository empleadosRepository;
	
	
	//creamos metodo de listar
	public ArrayList<Empleados> ObtenerEmpleados(){
		return (ArrayList<Empleados>) empleadosRepository.findAll();
	}
	
	//creamos metodo de guardar
	public Empleados GuardaEmpleados(Empleados emp) {
		return empleadosRepository.save(emp);
	}
	
	//editamos
	
	public Optional<Empleados>obtenerId(Long id){
		return empleadosRepository.findById(id);
	}
	
	public ArrayList<Empleados> obtenerPorDni(String prioridad){
		return empleadosRepository.findByDni(prioridad);
	}
	
	public boolean eliminar(Long id) {
		try {
			
			empleadosRepository.deleteById(id);
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
		
	 public ResponseEntity<Empleados> editarEmpleado(Empleados empleados, Long id) {
	        Optional<Empleados> optionalUser = empleadosRepository.findById(id);
	        if (optionalUser.isPresent()) {
	        	Empleados existingUser = optionalUser.get();
	            updateUserAttributes(existingUser, empleados);
	            empleadosRepository.save(existingUser);
	            return ResponseEntity.ok(existingUser);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 private void updateUserAttributes(Empleados existingUser, Empleados newUser) {
	        existingUser.setNombres(newUser.getNombres());
	        existingUser.setDni(newUser.getDni());
	        existingUser.setCelular(newUser.getCelular());
	        existingUser.setCorreo(newUser.getCorreo());
	        existingUser.setFoto(newUser.getFoto());
	        
	    }
	
	
	
	
	
}
