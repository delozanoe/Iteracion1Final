package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLProductoConsumoPorHabitacion {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLProductoConsumoPorHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	
	public long adicionarProductoConsumoPorHabitacion(PersistenceManager pm, Integer idProducto, Integer idConsumoHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlProductoConsumoPorHabitacion() + "(idProducto, idConsumoHabitacion) values (?, ?)");
        q.setParameters(idProducto, idConsumoHabitacion);
        return (long) q.executeUnique();
	}
}
