package uniandes.hotelAndes.persitencia.negocio;

class SQLProducto
{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLProducto(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
