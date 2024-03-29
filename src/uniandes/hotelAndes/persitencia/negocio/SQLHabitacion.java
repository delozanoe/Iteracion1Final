package uniandes.hotelAndes.persitencia.negocio;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Cliente;
import uniandes.hotelAndes.negocio.Habitacion;

class SQLHabitacion {
private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLHabitacion(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	public long adicionarHabitacion(PersistenceManager pm, Integer id, Integer capacidad, Double costoPorNoche, Double cuenta, String numero, Integer idHotel, Integer idConsumoHabitacion, Integer idTipoHabitacion, Integer idPlanConsumo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlHabitacion()+ "(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoPorHabitacion, idTipoHabitacion, idPlanConsumo) values (?, ?, ?,?,?,?,?,?)");
        q.setParameters(id, capacidad, costoPorNoche, cuenta, numero, idHotel, idConsumoHabitacion, idTipoHabitacion, idPlanConsumo);
        return (long) q.executeUnique();
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, Integer id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlHabitacion () + " WHERE id = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		return (Habitacion) q.executeUnique();
	}
	
	public ArrayList<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlHabitacion());
		q.setResultClass(Habitacion.class);
		return (ArrayList<Habitacion>) q.executeList();
	}
}
