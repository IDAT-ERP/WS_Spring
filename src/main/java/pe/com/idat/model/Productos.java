package pe.com.idat.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Productos {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 12)//lectora
    private String nombre;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
