package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Empleado;


class SQLEmpleado {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLEmpleado(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarEmpleado(PersistenceManager pm, Integer id,Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlEmpleado()+ "(id, idHotel) values (?, ?)");
        q.setParameters(id, idHotel);
        return (long) q.executeUnique();
	}
	
	public Empleado darEmpleadoPorId (PersistenceManager pm, Integer id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlEmpleado () + " WHERE id = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(id);
		return (Empleado) q.executeUnique();
	}
}
