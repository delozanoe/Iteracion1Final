package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLServicioConsumo 
{
      private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLServicioConsumo(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarServicioConsumo (PersistenceManager pm, Integer idServicio, Integer idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlServicioConsumo() + "(idServicio,idProducto) values (?, ?)");
        q.setParameters(idServicio, idProducto);
        return (long) q.executeUnique();
	}
}
