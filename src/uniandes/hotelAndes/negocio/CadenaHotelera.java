package uniandes.hotelAndes.negocio;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.hotelAndes.persitencia.negocio.PersistenciaHotelAndes;




public class CadenaHotelera 
{
	private static Logger log = Logger.getLogger(CadenaHotelera.class.getName());
	
	private PersistenciaHotelAndes pha;
	
	public CadenaHotelera()
	{
		pha = PersistenciaHotelAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public CadenaHotelera (JsonObject tableConfig)
	{
		pha = PersistenciaHotelAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pha.cerrarUnidadPersistencia ();
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarCadenaHotelera ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = pha.li();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
	}
}


