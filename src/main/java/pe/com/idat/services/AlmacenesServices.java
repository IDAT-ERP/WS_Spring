package pe.com.idat.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.idat.model.Almacenes;
import pe.com.idat.repository.AlmacenesRepository;

@Service
public class AlmacenesServices {

    @Autowired
    AlmacenesRepository almacenesRepository;

    // Creamos método de listar
    public ArrayList<Almacenes> ObtenerAlmacenes() {
        return (ArrayList<Almacenes>) almacenesRepository.findAll();
    }

    // Creamos método de guardar
    public Almacenes GuardarAlmacen(Almacenes almacenes) {
        return almacenesRepository.save(almacenes);
    }

    // Editamos
    public Optional<Almacenes> obtenerPorId(Long id) {
        return almacenesRepository.findById(id);
    }

    public ArrayList<Almacenes> obtenerPorProducto(String Producto) {
        return almacenesRepository.findByproducto(Producto);
    }

    public boolean eliminar(Long id) {
        try {
            almacenesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResponseEntity<Almacenes> editarAlmacen(Almacenes almacen, Long id) {
        Optional<Almacenes> optionalAlmacen = almacenesRepository.findById(id);
        if (optionalAlmacen.isPresent()) {
            Almacenes existingAlmacen = optionalAlmacen.get();
            updateAlmacenAttributes(existingAlmacen, almacen);
            almacenesRepository.save(existingAlmacen);
            return ResponseEntity.ok(existingAlmacen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void updateAlmacenAttributes(Almacenes existingAlmacen, Almacenes newAlmacen) {
        existingAlmacen.setProducto(newAlmacen.getProducto());
        existingAlmacen.setCompras(newAlmacen.getCompras());
        existingAlmacen.setCodSerie(newAlmacen.getCodSerie());
        existingAlmacen.setUsuario(newAlmacen.getUsuario());
    }


}
