package uniandes.hotelAndes.persitencia.negocio;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.TipoHabitacion;



public class SQLTipoHabitacion 
{
	private final static String SQL = PersistenciaCadenaHotelera.SQL;

	private PersistenciaCadenaHotelera pha;

	public SQLTipoHabitacion(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}

	public long adicionarTipoHabitacion(PersistenceManager pm, Integer id, String nombre) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlTipoHabitacion()+ "(id, nombre) values (?, ?)");
		q.setParameters(id, nombre);
		return (long) q.executeUnique();
	}


	public TipoHabitacion darTipoHabitacionPorId (PersistenceManager pm, Integer idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlTipoHabitacion () + " WHERE id = ?");
		q.setResultClass(TipoHabitacion.class);
		q.setParameters(idUsuario);
		return (TipoHabitacion) q.executeUnique();
	}

	public ArrayList<TipoHabitacion> darTipoHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlTipoHabitacion());
		q.setResultClass(TipoHabitacion.class);
		return (ArrayList<TipoHabitacion>) q.executeList();
	}
}
