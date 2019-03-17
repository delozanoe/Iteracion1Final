package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLHotel {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLHotel(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarHotel(PersistenceManager pm, Integer id, String pais, String ciudad, Integer ofertaHabitacionl) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlHotel()+ "(id, pais, ciudad, ofertaHabitacional) values (?, ?, ?,?)");
        q.setParameters(id, pais, ciudad, ofertaHabitacionl);
        return (long) q.executeUnique();
	}
}
