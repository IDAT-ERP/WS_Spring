package pe.com.idat.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.idat.model.Empleados;
import pe.com.idat.repository.EmpleadosRepository;

@Service
public class EmpleadosServices {
	
	@Autowired
	EmpleadosRepository empleadosRepository;
	
	public ArrayList<Empleados> ObtenerEmpleados(){
		return (ArrayList<Empleados>) empleadosRepository.findAll();
	}
	
	
	
}
