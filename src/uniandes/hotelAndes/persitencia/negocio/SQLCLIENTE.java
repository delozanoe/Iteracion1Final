package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.hotelAndes.negocio.Cliente;

class SQLCLIENTE {
private final static String SQL = PersistenciaCadenaHotelera.SQL;
	
	private PersistenciaCadenaHotelera pha;
	
	public SQLCLIENTE(PersistenciaCadenaHotelera pha)
	{
		this.pha = pha;
	}
	
	public long adicionarCliente(PersistenceManager pm, Integer idBar, char pazySalvo, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlCliente()+ "(id, pazySalvo, idHotel) values (?, ?, ?)");
        q.setParameters(idBar, pazySalvo, idHotel);
        return (long) q.executeUnique();
	}
	
	
	public Cliente darClientePorId (PersistenceManager pm, Integer idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.getSqlCliente () + " WHERE id = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(idUsuario);
		return (Cliente) q.executeUnique();
	}
	
}
