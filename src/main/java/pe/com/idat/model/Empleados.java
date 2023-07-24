package pe.com.idat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleados")
public class Empleados {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 30)
    private String nombres;

    @Column(name = "dni", length = 8)
    private String dni;

    @Column(name = "celular", length = 9)
    private String celular;

    @Column(name = "correo", length = 30)
    private String correo;

    @Lob
    @Column(name = "foto")
    private byte[] foto;
    
    @Column(name = "rol", length = 30)
    private String rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

    
    
    
    
}
