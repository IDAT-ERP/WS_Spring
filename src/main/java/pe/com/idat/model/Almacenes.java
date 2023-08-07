package pe.com.idat.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Almacenes")
public class Almacenes {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Productos producto;
    
    
    @ManyToOne
    @JoinColumn(name = "idNumSerie")
    private Compras compras;
    
    @Column(name="auxNS")
    private String codSerie;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    
    	
    
	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	public String getCodSerie() {
		return codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
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

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
