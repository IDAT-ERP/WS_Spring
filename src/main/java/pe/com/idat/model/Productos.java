package pe.com.idat.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Productos {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 12)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idmarca")
    private Marcas marca;

    @ManyToOne
    @JoinColumn(name = "idmodelo")
    private Modelos modelo;

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

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public Modelos getModelo() {
		return modelo;
	}

	public void setModelo(Modelos modelo) {
		this.modelo = modelo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
