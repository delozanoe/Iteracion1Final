package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLServicioProducto 
{
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLServicioProducto(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	public long adicionarServicioProducto (PersistenceManager pm, Integer idServicio, Integer idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.delSqlServicioProdcuto() + "(idServicio, idProdcuto) values (?, ?)");
        q.setParameters(idServicio, idProducto);
        return (long) q.executeUnique();
	}
}
