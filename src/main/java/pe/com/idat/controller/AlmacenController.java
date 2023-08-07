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

import pe.com.idat.model.Almacenes;
import pe.com.idat.services.AlmacenesServices;

@RestController
@CrossOrigin("http://localhost:3000") // Definimos puertos del cliente web REACT
@RequestMapping("/ModAlmacen")
public class AlmacenController {

    @Autowired
    AlmacenesServices almacenesServices;

    // Listamos
    @GetMapping("/verAlmacen")
    public ArrayList<Almacenes> listarAlmacenes() {
        return almacenesServices.ObtenerAlmacenes();
    }

    // Guardamos
    @PostMapping("/almacen")
    public Almacenes nuevoAlmacen(@RequestBody Almacenes newAlmacen) {
        return almacenesServices.GuardarAlmacen(newAlmacen);
    }

    // Buscar por id
    @GetMapping(path = "/verAlmacen/{id}")
    public Optional<Almacenes> obtenerAlmacenPorId(@PathVariable("id") Long id) {
        return almacenesServices.obtenerPorId(id);
    }

    // Eliminar
    @DeleteMapping(path = "/almacen/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.almacenesServices.eliminar(id);
        if (ok) {
            return "Se eliminó el almacén con id " + id;
        } else {
            return "No se pudo eliminar el almacén con id " + id;
        }
    }

    @PutMapping("/almacen/{id}")
    public ResponseEntity<Almacenes> editarAlmacen(@RequestBody Almacenes almacen, @PathVariable Long id) {
        return almacenesServices.editarAlmacen(almacen, id);
    }

}
