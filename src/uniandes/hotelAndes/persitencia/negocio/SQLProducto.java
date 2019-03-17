package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLProducto
{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLProducto(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarProducto(PersistenceManager pm, Integer id, String nombre, Double costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlProducto()+ "(id, nombre, costo) values (?, ?, ?)");
        q.setParameters(id, nombre, costo);
        return (long) q.executeUnique();
	}
}
