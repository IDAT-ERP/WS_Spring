package pe.com.idat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OCDetalle")
public class OCDetalle {
	
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "idOc")
	    private Compras compras;

	    @ManyToOne
	    @JoinColumn(name = "idproducto")
	    private Productos productos;
	    
	    @ManyToOne
	    @JoinColumn(name = "idmarca")
	    private Marcas marca;
	    
	    @ManyToOne
	    @JoinColumn(name = "idmodelo")
	    private Modelos modelo;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "idProv")
	    private Proveedores proveedor;
	    
	    
	    @Column(name = "precio")
	    private Double precio;

	    @Column(name = "nSerie", length = 25) // Columna para el número de serie
	    private String nSerie;
	    
	    @Column(name = "ColAuxCant", columnDefinition = "INT DEFAULT 1")
	    private int ColAuxCant = 1;
	   
	    

		public int getColAuxCant() {
			return ColAuxCant;
		}

		public void setColAuxCant(int colAuxCant) {
			ColAuxCant = colAuxCant;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Compras getCompras() {
			return compras;
		}

		public void setCompras(Compras compras) {
			this.compras = compras;
		}

		public Productos getProductos() {
			return productos;
		}

		public void setProductos(Productos productos) {
			this.productos = productos;
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

		public Proveedores getProveedor() {
			return proveedor;
		}

		public void setProveedor(Proveedores proveedor) {
			this.proveedor = proveedor;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public String getnSerie() {
			return nSerie;
		}

		public void setnSerie(String nSerie) {
			this.nSerie = nSerie;
		}
	
	    

}
