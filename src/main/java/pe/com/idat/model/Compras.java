package pe.com.idat.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Compras")
public class Compras {
	

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", length = 10)
    private String fecha;
    
    @Column(name = "nombreOC", length = 10)
    private String nombre;

    //factura o boleta
    @Column(name = "TD", length = 10)
    private String tipoDocumento;
    
    
    
    
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    
    
    
    

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getFecha() {
		return fecha;
	}


	public void setFecha(int dia, int mes, int anio) {
		this.fecha = String.format("%02d-%02-%04",dia,mes,anio);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
	
	

	

}
