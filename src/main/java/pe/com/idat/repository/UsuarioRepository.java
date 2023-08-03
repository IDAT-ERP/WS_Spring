package pe.com.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.idat.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{

}
