package miPack;

import java.time.format.DateTimeFormatter;

//import java.util.Date;

public class Persona {
	private String nombre;
	private int id;
	private String fecha_nac;
	private int id_mod;
	
	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	
//	java.sql.Date sqlFecha = java.sql.Date.valueOf( fecha_nac );

	
	public Persona() {
		
	}

	public Persona(String nombre, int id, String fecha_nac, int id_mod) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.fecha_nac = fecha_nac;
		this.id_mod = id_mod;
//		this.sqlFecha = (java.sql.Date) sqlFecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getId_mod() {
		return id_mod;
	}

	public void setId_mod(int id_mod) {
		this.id_mod = id_mod;
	}

	
}