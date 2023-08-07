package pe.com.idat.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.idat.model.Almacenes;

@Repository
public interface AlmacenesRepository extends JpaRepository<Almacenes, Long>{
	

	public abstract ArrayList<Almacenes> findByproducto(String prioridad);
	
	
}
