package pe.com.idat.model;


import jakarta.persistence.*;

@Entity
@Table(name = "CarritoCompras")
public class CarritoCompras {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Modelos producto;

    @Column(name = "cantidad")
    private Integer cantidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Modelos getProducto() {
		return producto;
	}

	public void setProducto(Modelos producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
