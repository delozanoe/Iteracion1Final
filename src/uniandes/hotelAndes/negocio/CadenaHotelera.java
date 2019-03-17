package uniandes.hotelAndes.negocio;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.hotelAndes.negocio.asociaciones.ConsumoHabitacionServicio;
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
	
	public Cliente nuevoCliente(char pazYSalvo, Integer idHabitacion, String tipoDocumento, Long numeroDocumento, String nombre, String correo)
	{
		log.info("Agregando nuevo cliente: " + nombre );
		Cliente nuevoCliente = pha.adicionarCliente(pazYSalvo, idHabitacion, tipoDocumento, numeroDocumento, nombre, correo);
		log.info("Adicionando nuevo cliente" + numeroDocumento);
		return nuevoCliente;
	}
	
	public ArrayList<Cliente> darClientes()
	{
		return pha.darClientes();
	}
	
	public Cliente darClientePorId(Integer idCliente)
	{
		return pha.darClientePorId(idCliente);
	}
	
	//------------------------------------------------------
	//Consumo Habitacion servicio
	//-----------------------------------------------------
	
	public ConsumoHabitacionServicio nuevoConsumoPorHabitacionServicio(Integer idConsumoHabitacion, Integer idServicio)
	{
		ConsumoHabitacionServicio nuevoConsumo = pha.adicionarConsumoPorHabitacionServicio(idConsumoHabitacion, idServicio);
		return nuevoConsumo ;
	}
	
	public ArrayList<ConsumoHabitacionServicio> darCosnumosHabitacionServicio()
	{
		return pha.darConsumoHabitacionServicio();
	}
	
	
	//-------------------------------------------------
	//Consunmo Habitacion 
	//------------------------------------------------
	
	public ConsumoHabitacion nuevoConsumoPorHabitacion(Double valorTotal, Integer idHabitacion)
	{
		return pha.adicionarConsumoHabitacion(valorTotal, idHabitacion);
	}
	
	public ArrayList<ConsumoHabitacion> darConsumosHabitacion()
	{
		return pha.darConsumosHabitacion();
	}
	
	public ConsumoHabitacion darConsumoHabitacionPorId(Integer idConsumoPorHabitacion)
	{
		return pha.darConsumoHabitacionPorId(idConsumoPorHabitacion);
	}
	//--------------------------------
	//Empleado
	//--------------------------------
	
	public Empleado adicionarEmpleado(Integer idHotel, Integer idTipoEmpleado, String tipoDocumento, Long numeroDocumento, String nombre, String correo)
	{
		Empleado nuevoEmpleado = pha.adicionarEmpleado(idHotel, idTipoEmpleado, tipoDocumento, numeroDocumento, nombre, correo);
		return nuevoEmpleado;
	}
	
	public ArrayList<Empleado> darEmpleados()
	{
		return pha.darEmpleados();
	}
	
	public Empleado darEmpleadoPorId(Integer idEmpleado)
	{
		return pha.darEmpleadoPorId(idEmpleado);
	}
	
	//------------------------------------------------
	//Habitacion
	//------------------------------------------------
	public Habitacion adicionarHabitacion(Integer idHotel, Integer capacidad, Double costoPorNoche, Double cuenta, String numero, Integer idPlanConsumo, Integer idConsumoHabitacion, Integer idTipoHabitacion)
	{
		Habitacion nuevaHabitacion = pha.adicionarHabitacion(idHotel, capacidad, costoPorNoche, cuenta, numero, idPlanConsumo, idConsumoHabitacion, idTipoHabitacion);
		return nuevaHabitacion;
	}
	
	public ArrayList<Habitacion> darHabitaciones()
	{
		return pha.darHabitaciones();
	}
	
	public Habitacion darHabitacionesPorId(Integer idHabitacion)
	{
		return pha.darHabitacionPorId(idHabitacion);
	}
	
	//--------------------------------------------------
	//Hotel
	//-------------------------------------------------
	
	public Hotel adicionarHotel(String ciudad, String pais, Integer ofertaHabitacional)
	{
		Hotel nuevoHotel = pha.adicionarHotel(ciudad, pais, ofertaHabitacional);
		return nuevoHotel;
	}
	
	public ArrayList<Hotel> darHoteles()
	{
		return pha.darHoteles();
	}
	
	public Hotel darHotelPorId(Integer idHotel)
	{
		return pha.darHotelPorId(idHotel);
	}
	
	//-----------------------------------------------
	//Plan Consumo
	//-----------------------------------------------
	
	public PlanConsumo adicionarPlanConsumo(Integer idHotel, String descripcion)
	{
		PlanConsumo nuevoPlanConsumo = pha.adicionarPlanConsumo(idHotel, descripcion);
		return nuevoPlanConsumo;
	}
	
	public ArrayList<PlanConsumo> darPlanesConsumo()
	{
		return pha.darPlanesConsumo();
	}
	
	public PlanConsumo darPlanCosumoPorId(Integer idPlanConsumo)
	{
		return pha.darPlanConsumoPorId(idPlanConsumo);
	}
	
	//-----------------------------------------------------
	//Producto
	//-------------------------------------------
	
	public Producto adicionarProducto(String nombre, Double costo)
	{
		Producto nuevoProducto = pha.adicionarProducto(nombre, costo);
		return nuevoProducto;
	}
	
	public ArrayList<Producto> darProductos()
	{
		return pha.darProductos();
	}
	
	public Producto darProductoPorId (Integer idProducto)
	{
		return pha.darProductoPorId(idProducto);
	}
	
	
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


