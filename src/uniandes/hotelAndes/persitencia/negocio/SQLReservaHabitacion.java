package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLReservaHabitacion {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLReservaHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarReservaHabitacion(PersistenceManager pm, Integer id, String fechaEntrada, String fechaSalida, Integer numeroPersonas, Integer idHotel, Integer idCliente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlReservaHabitacion()+ "(id, fechaEntrada, fechaSalida, numeroPersonas, idHotel, idCliente) values (?, ?, ?,?,?,?)");
        q.setParameters(id, fechaEntrada,fechaSalida,numeroPersonas, idHotel,idCliente);
        return (long) q.executeUnique();
	}
}
