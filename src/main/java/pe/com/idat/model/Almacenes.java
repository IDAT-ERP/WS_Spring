package pe.com.idat.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Almacenes")
public class Almacenes {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @Column(name = "fecha", length = 10)
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "idOcIngresos")
    private OCDetalle ocDetalle;
    
    @Column(name="auxNS")
    private String codSerie;
    
    
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    
    		
    
	public String getFecha() {
		return fecha;
	}


	public void setFecha(int dia, int mes, int anio) {
		this.fecha = String.format("%02d-%02-%04",dia,mes,anio);
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

	

	public OCDetalle getOcDetalle() {
		return ocDetalle;
	}


	public void setOcDetalle(OCDetalle ocDetalle) {
		this.ocDetalle = ocDetalle;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setFecha(String fecha2) {
		// TODO Auto-generated method stub
		
	}

    
}
