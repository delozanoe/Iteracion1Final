package uniandes.hotelAndes.persitencia.negocio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUsuario {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pha;
	
	public SQLUsuario(PersistenciaHotelAndes pha)
	{
		this.pha = pha;
	}
	
	public long adicionarUsuario(PersistenceManager pm, Integer id, String tipoDocumento, Long numeroDocumento, String nombre, String correo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pha.getSqlUsuario()+ "(id, tipoDocumento, numeroDocumento, nombre, correo) values (?, ?, ?,?,?)");
        q.setParameters(id, tipoDocumento,numeroDocumento,nombre, correo);
        return (long) q.executeUnique();
	}
}
