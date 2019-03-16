package uniandes.hotelAndes.negocio.asociaciones;

public class ServicioProducto 
{
	private Integer idServicio;
	
	private Integer idProducto;

	public ServicioProducto(Integer idServicio, Integer idProducto) {
		super();
		this.idServicio = idServicio;
		this.idProducto = idProducto;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	} 
	
	
}
