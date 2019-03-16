package uniandes.hotelAndes.persitencia.negocio;

class SQLReservaHabitacion {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLReservaHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
