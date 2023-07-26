package pe.com.idat.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.idat.model.Empleados;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long>{
	

	public abstract ArrayList<Empleados> findByDni(String prioridad);
	
	
}
