package uniandes.hotelAndes.persitencia.negocio;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Cliente;
import uniandes.hotelAndes.negocio.Hotel;



public class SQLHotel {
private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLHotel(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	
	public long adicionarHotel(PersistenceManager pm, Integer id, String pais, String ciudad, Integer ofertaHabitacionl) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlHotel()+ "(id, pais, ciudad, ofertaHabitacional) values (?, ?, ?,?)");
        q.setParameters(id, pais, ciudad, ofertaHabitacionl);
        return (long) q.executeUnique();
	}
	
	public Hotel darHotelPorId (PersistenceManager pm, Integer id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlHotel () + " WHERE id = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(id);
		return (Hotel) q.executeUnique();
	}
	
	public ArrayList<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlHotel());
		q.setResultClass(Hotel.class);
		return (ArrayList<Hotel>) q.executeList();
	}
}
