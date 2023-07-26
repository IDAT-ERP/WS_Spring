package pe.com.idat.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.idat.model.Proveedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long>{
	

	public abstract ArrayList<Proveedores> findByruc(String prioridad);
	
	
}
