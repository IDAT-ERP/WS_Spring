package pe.com.idat.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.idat.model.Proveedores;
import pe.com.idat.repository.ProveedoresRepository;

@Service
public class ProveedoresServices {
	
	@Autowired
	ProveedoresRepository proveedoresRepository;
	
	
	//creamos metodo de listar
	public ArrayList<Proveedores> ObtenerEmpleados(){
		return (ArrayList<Proveedores>) proveedoresRepository.findAll();
	}
	
	//creamos metodo de guardar
	public Proveedores GuardaEmpleados(Proveedores proveedores) {
		return proveedoresRepository.save(proveedores);
	}
	
	//editamos
	
	public Optional<Proveedores>obtenerId(Long id){
		return proveedoresRepository.findById(id);
	}
	
	public ArrayList<Proveedores> obtenerPorDni(String prioridad){
		return proveedoresRepository.findByruc(prioridad);
	}
	
	public boolean eliminar(Long id) {
		try {
			
			proveedoresRepository.deleteById(id);
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
		
	 public ResponseEntity<Proveedores> editarEmpleado(Proveedores empleados, Long id) {
	        Optional<Proveedores> optionalUser = proveedoresRepository.findById(id);
	        if (optionalUser.isPresent()) {
	        	Proveedores existingUser = optionalUser.get();
	            updateUserAttributes(existingUser, empleados);
	            proveedoresRepository.save(existingUser);
	            return ResponseEntity.ok(existingUser);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 private void updateUserAttributes(Proveedores existingUser, Proveedores newUser) {
	        existingUser.setRazonSocial(newUser.getRazonSocial());
	        existingUser.setRuc(newUser.getRuc());
	        existingUser.setCelular(newUser.getCelular());
	        existingUser.setCorreo(newUser.getCorreo());
	        existingUser.setDireccion(newUser.getDireccion());
	        
	        
	    }
	
	
	
	
	
}
