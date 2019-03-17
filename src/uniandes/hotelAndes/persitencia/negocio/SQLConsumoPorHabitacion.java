package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLConsumoPorHabitacion {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLConsumoPorHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarConsumoPorHabitacion(PersistenceManager pm, Integer id, Double valorTotal, Integer idHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlConsumoPorHabitacion() + "(id, valorTotal, idHabitacion) values (?, ?, ?)");
        q.setParameters(id, valorTotal, idHabitacion);
        return (long) q.executeUnique();
	}
}
