package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLReservaServicio {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLReservaServicio(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	public long adicionarReserva(PersistenceManager pm, Integer id, String horaInicio, double duracion, String dia, String lugar, Integer idCliente, Integer idServicio)  
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlReserva() + "(id, horaInicio, duracion, dia, lugar, idCLiente, idServicio) values (?, ?, ?,?,?,?,?)");
        q.setParameters(id, horaInicio, duracion, lugar, idCliente, idServicio);
        return (long) q.executeUnique();
	}
}
