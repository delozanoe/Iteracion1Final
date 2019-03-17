package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLConsumoHabitacioServicio
{
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLConsumoHabitacioServicio(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarConsumoPorHabitacionServicio(PersistenceManager pm, Integer idConsumoHabitacion, Integer idServicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlConsumoPorHabitacion() + "(idConsumoHabitacion, idServicio) values (?, ?)");
        q.setParameters(idConsumoHabitacion, idServicio);
        return (long) q.executeUnique();
	}
}
