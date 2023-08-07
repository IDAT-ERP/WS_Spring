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
    
    @Column(name = "oc", length = 10)
    private String oc;

    @ManyToOne
    @JoinColumn(name = "idProv")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Productos producto;

    @Column(name = "nSerie", length = 25)
    private String nSerie;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    
    
    
    
    

	public String getFecha() {
		return fecha;
	}

	public void setFecha(int dia, int mes, int anio) {
		this.fecha = String.format("%02d-%02-%04",dia,mes,anio);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOc() {
		return oc;
	}

	public void setOc(String oc) {
		this.oc = oc;
	}

	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public String getnSerie() {
		return nSerie;
	}

	public void setnSerie(String nSerie) {
		this.nSerie = nSerie;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
}
