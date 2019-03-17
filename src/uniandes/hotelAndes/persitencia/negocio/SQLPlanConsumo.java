package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLPlanConsumo {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLPlanConsumo(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarPlanConsumo(PersistenceManager pm, Integer id, Integer idHotel, String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlPlanConsumo()+ "(id, idHotel, descripcion) values (?, ?, ?)");
        q.setParameters(id, idHotel, descripcion);
        return (long) q.executeUnique();
	}
}
