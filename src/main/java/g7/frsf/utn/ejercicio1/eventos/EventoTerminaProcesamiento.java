package g7.frsf.utn.ejercicio1.eventos;

import g7.frsf.utn.des.ContadoresEstadisticos;
import g7.frsf.utn.des.EstadoDelSistema;
import g7.frsf.utn.des.Evento;
import g7.frsf.utn.des.LibreriaDeRutinas;
import g7.frsf.utn.des.ListaDeEventos;
import g7.frsf.utn.ejercicio1.componentespropios.ContadoresEstadisticosEjercicio1;
import g7.frsf.utn.ejercicio1.componentespropios.LibreriaDeRutinasEjercicio1;
import g7.frsf.utn.ejercicio1.estadodelsistema.Ejercicio1;
import g7.frsf.utn.ejercicio1.estadodelsistema.Solicitud;

public class EventoTerminaProcesamiento extends Evento {

	public EventoTerminaProcesamiento(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinas libreria) {
		
		ContadoresEstadisticosEjercicio1 contadoresEjemplo = (ContadoresEstadisticosEjercicio1) contadores;
		contadoresEjemplo.actualizarCantProcesadas();
		
		Ejercicio1 modeloActual = (Ejercicio1) modelo;
		LibreriaDeRutinasEjercicio1 libreriaActual = (LibreriaDeRutinasEjercicio1) libreria;
		
		if(modeloActual.haySolicitudesEnEspera()) {
			Solicitud solicitudAProcesar = modeloActual.obtenerSolicitudPrioritaria();
			modeloActual.atenderSolicitud(solicitudAProcesar);
			int duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento();
			EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento);	
			eventos.agregar(nuevoEvento);	
		}
		else {

			modeloActual.actualizarServidorDisponible();
		}
	}

}
