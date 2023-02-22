package com.utad.dawe.app;

import java.util.ArrayList;

import com.utad.dawe.model.JugadorBalonMano;

public class Equipo {

	public static void main(String[] args) {

		 JugadorBalonMano jugador1 = new JugadorBalonMano ("Alvaro",2);
	     JugadorBalonMano jugador2 = new JugadorBalonMano ("Sergio",3);
	     ArrayList<JugadorBalonMano> listadejugadores = new ArrayList<>();
	     
	        
	     int anotacionestotales = 0;
	     int bloqueostotales = 0;
	     int tiempototal = 0;
	     int anotacionestotales2 = 0;
	     int bloqueostotales2 = 0;
	     int tiempototal2 = 0;

	     for (int i = 0; i < 10; i++) {
	         int anotaciones = (int) (Math.random() * (10 - 0 + 1) + 0);
	         int bloqueos = (int) (Math.random() * (20 - 0 + 1) + 0);
	         int tiempojugado = (int) (Math.random() * (3000 - 0 + 1) + 0);
	         anotacionestotales += anotaciones;
	         bloqueostotales += bloqueos;
	         tiempototal += tiempojugado;
	         jugador1.setAnotacion(anotaciones);
	         jugador1.setBloqueo(bloqueos);
	         jugador1.setTiempojugado(tiempojugado);

	         int anotaciones2 = (int) (Math.random() * (10 - 0 + 1) + 0);
	         int bloqueos2 = (int) (Math.random() * (20 - 0 + 1) + 0);
	         int tiempojugado2 = (int) (Math.random() * (3000 - 0 + 1) + 0);
	         anotacionestotales2 += anotaciones2;
	         bloqueostotales2 += bloqueos2;
	         tiempototal2 += tiempojugado2;
	         jugador2.setAnotacion(anotaciones2);
	         jugador2.setBloqueo(bloqueos2);
	         jugador2.setTiempojugado(tiempojugado2);

	         // resto del código
	     
	            System.out.println();

	            System.out.println("Jornada " + (i+1));
	            System.out.println(jugador1.toString());
	            System.out.println(jugador2.toString());
	            if (i == 4) {
	                System.out.println();
	                calcularEstadisticas(jugador1, 5, anotacionestotales, bloqueostotales
	                		,tiempototal);
	                System.out.println();
	                calcularEstadisticas(jugador2, 5, anotacionestotales2, bloqueostotales2
	                		,tiempototal2);
	                System.out.println();
	            }
	            else if (i == 9) {
	                System.out.println();
	                calcularEstadisticas(jugador1, 10, anotacionestotales, bloqueostotales
	                		,tiempototal);
	                System.out.println();
	                calcularEstadisticas(jugador2, 10, anotacionestotales2, bloqueostotales2
	                		,tiempototal2);
	                System.out.println();
	            }
	        }
	        
	        listadejugadores.add(jugador1);
		    listadejugadores.add(jugador2);
	    }

	public static void calcularEstadisticas(JugadorBalonMano jugador, int jornada, int anotacionestotales
			, int bloqueostotales, int tiempototal) {
		
		if (jornada == 5) {
			anotacionestotales = anotacionestotales/5;
			bloqueostotales = bloqueostotales/5;
			tiempototal = tiempototal/5;
		}
		if (jornada == 10) {
			anotacionestotales = anotacionestotales/10;
			bloqueostotales = bloqueostotales/10;
			tiempototal = tiempototal/10;
		}
	
		System.out.println("Estadisticas de " + jugador.getNombre() + ":");
		System.out.println("- Media de anotaciones: " + anotacionestotales);
		System.out.println("- Media de bloqueos: " + bloqueostotales);
		System.out.println("- Media de tiempo jugado: " + tiempototal);
	}
}
