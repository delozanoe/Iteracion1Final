package uniandes.hotelAndes.persitencia.negocio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.hotelAndes.negocio.Cliente;
import uniandes.hotelAndes.negocio.ConsumoHabitacion;
import uniandes.hotelAndes.negocio.asociaciones.ConsumoHabitacionServicio;
import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.negocio.Visitan;





public class PersistenciaCadenaHotelera 
{
	private static Logger log = Logger.getLogger(PersistenciaCadenaHotelera.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaCadenaHotelera instance;
	
	private PersistenceManagerFactory pmf;

	private List <String> tablas;
	
	private SQLCLIENTE sqlCliente; 
	
	private SQLConsumoPorHabitacion sqlConsumoPorHabitacion;
	
	 private SQLEmpleado sqlEmpleado;
	
	private SQLHabitacion sqlHabitacion;
	
	private SQLHotel sqlHotel;
	
	private SQLPlanConsumo sqlPlanConsumo; 
	
	private SQLProducto sqlProducto;
		
	private SQLProductoConsumoPorHabitacion sqlProductoConsumoPorHabitacion;
	
	private SQLReservaServicio sqlReservaServicio; 
	
	private SQLReservaHabitacion sqlReservaHabitacion;
	
	private SQLServicio sqlServicio;
	
	private SQLServicioConsumo sqlServicioConsumo;
	
	private SQLServicioProducto sqlServicioProducto;
	
	private SQLUsuario sqlUsuario;
	
	private SQLUtil sqlUtil;
	
	private SQLConsumoHabitacioServicio sqlConsumoHabitacioServicio;
	
	
	private PersistenciaCadenaHotelera()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("CadenaHotelera");
		crearClasesSQL();
		
		tablas = new LinkedList<String>();
		tablas.add("CadenaHotelera_sequence");
		tablas.add("CLIENTE");
		tablas.add("CONSUMOPORHABITACION");
		tablas.add("EMPLEADO");
		tablas.add("HABITACION");
		tablas.add("HOTEL");
		tablas.add("PLANCONSUMO");
		tablas.add("PRODUCTO");
		tablas.add("PRODUCTOCONSUMOPORHABITACION");
		tablas.add("RESERVASERVICIO	");
		tablas.add("RESERVAHABITACION");
		tablas.add("SERVICIO");
		tablas.add("SERVICIOCONSUMO");
		tablas.add("SERVICIOPRODUCTO");
		tablas.add("USUARIO");
		tablas.add("CONSUMOHABITACIOSERVICIO");
		

		
	}
	
	private PersistenciaCadenaHotelera(JsonObject tableConfig)
	{
		crearClasesSQL();
		tablas = leerNombreTablas(tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);

	}
	
	public static PersistenciaCadenaHotelera getInstance()
	{
		if(instance == null)
		{
			instance = new PersistenciaCadenaHotelera();
		}
		return instance;
	}
	
	public static PersistenciaCadenaHotelera getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaCadenaHotelera (tableConfig);
		}
		return instance;
	}

	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	private List<String> leerNombreTablas(JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	private void crearClasesSQL()
	{
		
		
		sqlCliente = new SQLCLIENTE(this);
		sqlConsumoPorHabitacion = new SQLConsumoPorHabitacion(this);
		
		sqlEmpleado = new SQLEmpleado(this);
		
		
		
		sqlHabitacion = new SQLHabitacion(this);
		sqlHotel = new SQLHotel(this);
		
		sqlPlanConsumo = new SQLPlanConsumo(this);
		sqlProductoConsumoPorHabitacion = new SQLProductoConsumoPorHabitacion(this);
		
		sqlReservaHabitacion = new SQLReservaHabitacion(this); 
		sqlReservaServicio = new SQLReservaServicio(this);
		
		sqlServicio = new SQLServicio(this);
		sqlServicioConsumo = new SQLServicioConsumo(this);
		sqlServicioProducto = new SQLServicioProducto(this);
		
		sqlUsuario = new SQLUsuario(this);
		
		sqlUtil = new SQLUtil(this);
		sqlConsumoHabitacioServicio = new SQLConsumoHabitacioServicio(this);
	}


	

	public List<String> getTablas() {
		return tablas;
	}

	
	
	public PersistenceManagerFactory getPmf() {
		return pmf;
	}
	
	public String darSeqCadenaHotelera()
	{
		return tablas.get(0);
	}

	public String getSqlCliente() {
		return tablas.get(1);
	}

	public String getSqlConsumoPorHabitacion() {
		return tablas.get(2);
	}

	public String getSqlEmpleado() {
		return tablas.get(3);
	}

	public String getSqlHabitacion() {
		return tablas.get(4);
	}

	public String getSqlHotel() {
		return tablas.get(5);
	}

	public String getSqlPlanConsumo() {
		return tablas.get(6);
	}

	public String getSqlProducto() {
		return tablas.get(7);
	}

	public String getSqlProductoConsumoPorHabitacion() {
		return tablas.get(8);
	}

	public String getSqlReservaServicio() {
		return tablas.get(9);
	}

	public String getSqlReservaHabitacion() {
		return tablas.get(10);
	}

	public String getSqlServicio() {
		return tablas.get(11);
	}

	public String getSqlServicioConsumo() {
		return tablas.get(12);
	}
	
	public String getSqlServicioProducto()
	{
		return tablas.get(13);
	}

	public String getSqlUsuario() {
		return tablas.get(14);
	}

	public String getSqlUtil() {
		return tablas.get(15);
	}
	
	public String getSqlConsumoHabitacioServicio()
	{
		return tablas.get(16);
	}

	

//	private long nextval ()
//	{
//        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
//        log.trace ("Generando secuencia: " + resp);
//        return resp;
//    }
//	
//	private String darDetalleException(Exception e) 
//	{
//		String resp = "";
//		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
//		{
//			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
//			return je.getNestedExceptions() [0].getMessage();
//		}
//		return resp;
//	}
//	
//	public long [] limpiarCadenaHotelera()
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx=pm.currentTransaction();
//        try
//        {
//            tx.begin();
//            long [] resp = sqlUtil.limpiarCadenaHotelera (pm);
//            tx.commit ();
//            log.info ("Borrada la base de datos");
//            return resp;
//        }
//        catch (Exception e)
//        {
////        	e.printStackTrace();
//        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//        }
//		
//	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla TipoBebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Cliente adicionarCliente(char pazYSalvo, Integer idHabitacion, String tipoDocumento, Long numeroDocumento, String nombre, String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Integer id = nextVal();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, id, pazYSalvo, idHabitacion);
            long tuplasInsertadasUsu = sqlUsuario.adicionarUsuario(pm, id, tipoDocumento, numeroDocumento, nombre, correo);
            tx.commit();
            
            log.trace ("Inserción de cliente: " + nombre + ": " + tuplasInsertadas + tuplasInsertadasUsu +" tuplas insertadas");
            
            return new Cliente (id, pazYSalvo, idHabitacion, tipoDocumento, numeroDocumento, nombre, correo);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public ArrayList<Cliente> darClientes ()
	{
		return sqlCliente.darClientes(pmf.getPersistenceManager());
	}
	
	public Cliente darClientePorId (Integer idCliente)
	{
		return sqlCliente.darClientePorId (pmf.getPersistenceManager(), idCliente);
	}
 
	public ConsumoHabitacionServicio adicionarConsumoPorHabitacionServicio(Integer idConsumoHabitacion, Integer idServicio)
	{
			PersistenceManager pm = pmf.getPersistenceManager();
	        Transaction tx=pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            long tuplasInsertadas = sqlConsumoHabitacioServicio.adicionarConsumoPorHabitacionServicio(pm, idConsumoHabitacion, idServicio);
	            tx.commit();

	            log.trace ("Inserción de gustan: [" + idConsumoHabitacion + ", " + idServicio + "]. " + tuplasInsertadas + " tuplas insertadas");

	            return new ConsumoHabitacionServicio(idConsumoHabitacion, idServicio);
	        }
	        catch (Exception e)
	        {
//	        	e.printStackTrace();
	        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        	return null;
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
	        }
		
	}
	
	
	public ArrayList<ConsumoHabitacionServicio> darConsumoHabitacionServicio ()
	{
		return sqlConsumoHabitacioServicio.darConsumoHabitacionServicio(pmf.getPersistenceManager());
	}
	
	public ConsumoHabitacion adicionarConsumoHabitacion(Double valorTotal, Integer idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Integer id = nextval ();
            long tuplasInsertadas = sqlConsumoPorHabitacion.adicionarConsumoPorHabitacion(pmf.getPersistenceManager(), id, valorTotal, idHabitacion);
            tx.commit();

            log.trace ("Inserción de consumo: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ConsumoHabitacion(valorTotal, idHabitacion, id);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
}
