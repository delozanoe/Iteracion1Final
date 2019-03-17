package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLHabitacion {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLHabitacion(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	public long adicionarHabitacion(PersistenceManager pm, Integer id, int capacidad, double costoPorNoche, double cuenta, String numero, Integer idHotel, Integer idConsumoHabitacion, Integer idTipoHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlHabitacion()+ "(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoPorHabitacion, idTipoHabitacion) values (?, ?, ?,?,?,?,?)");
        q.setParameters(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoHabitacion, idTipoHabitacion);
        return (long) q.executeUnique();
	}
}
