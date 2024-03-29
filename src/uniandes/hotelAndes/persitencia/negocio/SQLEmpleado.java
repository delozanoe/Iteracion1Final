package uniandes.hotelAndes.persitencia.negocio;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Cliente;
import uniandes.hotelAndes.negocio.Empleado;


class SQLEmpleado {
private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLEmpleado(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	
	public long adicionarEmpleado(PersistenceManager pm, Integer id,Integer idHotel, Integer idTipoEmpleado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlEmpleado()+ "(id, idHotel, idTipoEmpleado) values (?, ?,?)");
        q.setParameters(id, idHotel, idTipoEmpleado);
        return (long) q.executeUnique();
	}
	
	public Empleado darEmpleadoPorId (PersistenceManager pm, Integer id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlEmpleado () + " WHERE id = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(id);
		return (Empleado) q.executeUnique();
	}
	
	public ArrayList<Empleado> darEmpleados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlEmpleado());
		q.setResultClass(Cliente.class);
		return (ArrayList<Empleado>) q.executeList();
	}
}
