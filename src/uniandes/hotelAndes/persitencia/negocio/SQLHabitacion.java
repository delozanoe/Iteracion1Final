package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Habitacion;

class SQLHabitacion {
private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLHabitacion(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	public long adicionarHabitacion(PersistenceManager pm, Integer id, int capacidad, double costoPorNoche, double cuenta, String numero, Integer idHotel, Integer idConsumoHabitacion, Integer idTipoHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlHabitacion()+ "(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoPorHabitacion, idTipoHabitacion) values (?, ?, ?,?,?,?,?)");
        q.setParameters(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoHabitacion, idTipoHabitacion);
        return (long) q.executeUnique();
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, Integer id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlHabitacion () + " WHERE id = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		return (Habitacion) q.executeUnique();
	}
}
