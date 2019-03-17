package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLCLIENTE {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLCLIENTE(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarCliente(PersistenceManager pm, Integer idBar, char pazySalvo, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlCliente()+ "(id, pazySalvo, idHotel) values (?, ?, ?)");
        q.setParameters(idBar, pazySalvo, idHotel);
        return (long) q.executeUnique();
	}
	
	
}
