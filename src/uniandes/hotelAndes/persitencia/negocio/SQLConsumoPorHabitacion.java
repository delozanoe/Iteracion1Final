package uniandes.hotelAndes.persitencia.negocio;

public class SQLConsumoPorHabitacion {

private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLConsumoPorHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
