package uniandes.hotelAndes.persitencia.negocio;

class SQLCLIENTE {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLCLIENTE(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
}
