package uniandes.hotelAndes.persitencia.negocio;

class SQLReservaServicio {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLReservaServicio(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
