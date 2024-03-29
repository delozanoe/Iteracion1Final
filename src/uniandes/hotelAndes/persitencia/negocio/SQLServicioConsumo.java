package uniandes.hotelAndes.persitencia.negocio;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.asociaciones.ServicioConsumo;


class SQLServicioConsumo 
{
      private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLServicioConsumo(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	
	public long adicionarServicioConsumo (PersistenceManager pm, Integer idServicio, Integer idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlServicioConsumo() + "(idServicio,idProducto) values (?, ?)");
        q.setParameters(idServicio, idProducto);
        return (long) q.executeUnique();
	}
	
	public ArrayList<ServicioConsumo> darServicioConsumo(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlServicioConsumo ());
		q.setResultClass(ServicioConsumo.class);
		return (ArrayList<ServicioConsumo>) q.execute();
	}
}
