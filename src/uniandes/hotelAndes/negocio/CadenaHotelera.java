package uniandes.hotelAndes.negocio;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.hotelAndes.persitencia.negocio.PersistenciaCadenaHotelera;


public class CadenaHotelera 
{
	private static Logger log = Logger.getLogger(CadenaHotelera.class.getName());
	
	private PersistenciaCadenaHotelera pha;
	
	public CadenaHotelera()
	{
		pha = PersistenciaCadenaHotelera.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public CadenaHotelera (JsonObject tableConfig)
	{
		pha = PersistenciaCadenaHotelera.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pha.cerrarUnidadPersistencia ();
	}
	/* ****************************************************************
	 * 			Métodos para manejar los clientes
	 *****************************************************************/
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarCadenaHotelera ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = pha.limpiarCadenaHotelera();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
	}
}


