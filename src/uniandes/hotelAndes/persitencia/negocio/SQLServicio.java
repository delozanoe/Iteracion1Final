package uniandes.hotelAndes.persitencia.negocio;

class SQLServicio
{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLServicio(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
