package uniandes.hotelAndes.persitencia.negocio;

public class SQLHotel {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLHotel(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
