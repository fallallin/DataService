package co.com.kallsonys.services.ws.app;

import java.util.Date;

public class DateExampleDTO {
	private Date fechaDateJava = new Date();
	
	private java.sql.Date fechaDateSQL = new java.sql.Date(new Date().getTime());
	
	private String nombre;

	public Date getFechaDateJava() {
		return fechaDateJava;
	}

	public void setFechaDateJava(Date fechaDateJava) {
		this.fechaDateJava = fechaDateJava;
	}

	public java.sql.Date getFechaDateSQL() {
		return fechaDateSQL;
	}

	public void setFechaDateSQL(java.sql.Date fechaDateSQL) {
		this.fechaDateSQL = fechaDateSQL;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
