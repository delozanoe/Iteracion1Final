package uniandes.hotelAndes.negocio;

import java.util.ArrayList;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Hotel
{
	private Integer id;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String pais;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String ciudad;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int ofertaHabitacional;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ArrayList<Habitacion> habitaciones;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ArrayList<ReservaHabitacion> reservas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ArrayList<Empleado> empleado;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ArrayList<Servicio> servicios;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ArrayList<PlanConsumo> planConsumo;

	public Hotel(String pais, String ciudad, int ofertaHabitacional, ArrayList<Habitacion> habitaciones,
			ArrayList<ReservaHabitacion> reservas, ArrayList<Empleado> empleado, ArrayList<Servicio> servicios,
			ArrayList<PlanConsumo> planConsumo, Integer id) {
		super();
		this.id= id;
		this.pais = pais;
		this.ciudad = ciudad;
		this.ofertaHabitacional = ofertaHabitacional;
		this.habitaciones = habitaciones;
		this.reservas = reservas;
		this.empleado = empleado;
		this.servicios = servicios;
		this.planConsumo = planConsumo;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getOfertaHabitacional() {
		return ofertaHabitacional;
	}

	public void setOfertaHabitacional(int ofertaHabitacional) {
		this.ofertaHabitacional = ofertaHabitacional;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public ArrayList<ReservaHabitacion> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<ReservaHabitacion> reservas) {
		this.reservas = reservas;
	}

	public ArrayList<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(ArrayList<Empleado> empleado) {
		this.empleado = empleado;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	public ArrayList<PlanConsumo> getPlanConsumo() {
		return planConsumo;
	}

	public void setPlanConsumo(ArrayList<PlanConsumo> planConsumo) {
		this.planConsumo = planConsumo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	
	

}

