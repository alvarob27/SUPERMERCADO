package com.utad.dawe.model;

public class JugadorBalonMano {

	private String nombre;
	private int dorsal;
	private int anotacion;
	private int bloqueo;
	private int tiempojugado;
	
	public JugadorBalonMano(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
	}
	
	public void setAnotacion(int anotacion) {
		this.anotacion = anotacion;
	}

	public void setBloqueo(int bloqueo) {
		this.bloqueo = bloqueo;
	}

	public void setTiempojugado(int tiempojugado) {
		this.tiempojugado = tiempojugado;
	}
	
	@Override
	public String toString() {
		return "JugadorBalonMano [nombre=" + nombre + ", dorsal=" + dorsal + ", anotacion=" + anotacion + ", bloqueo="
				+ bloqueo + ", tiempojugado=" + tiempojugado + " segundos ]";
	}

	public String getNombre() {
		return nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public int getAnotacion() {
		return anotacion;
	}

	public int getBloqueo() {
		return bloqueo;
	}

	public int getTiempojugado() {
		return tiempojugado;
	}

	
}
