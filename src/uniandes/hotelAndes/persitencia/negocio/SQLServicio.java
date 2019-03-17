package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLServicio
{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLServicio(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	public long adicionarServicio(PersistenceManager pm, Integer id, String nombre, String descripcion, String horaApertura, String horaCierre, int capacidad, double costo, char costoIncluido, Integer idHotel, Integer idTipoServicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlServicio() + "(id, nombre, descripcion, horaApertura, horaCierre, capacidad, costo, costoIncluido, idHotel, idTipoServicio) values (?, ?, ?, ?, ? , ?, ?, ?, ?, ?)");
        q.setParameters(id, nombre, descripcion, horaApertura, horaCierre, capacidad, costo, costoIncluido, idHotel, idTipoServicio);
        return (long) q.executeUnique();
	}
}
