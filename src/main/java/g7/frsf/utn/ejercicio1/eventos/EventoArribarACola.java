package g7.frsf.utn.ejercicio1.eventos;

import g7.frsf.utn.des.ContadoresEstadisticos;
import g7.frsf.utn.des.EstadoDelSistema;
import g7.frsf.utn.des.Evento;
import g7.frsf.utn.des.LibreriaDeRutinas;
import g7.frsf.utn.des.ListaDeEventos;
import g7.frsf.utn.ejercicio1.componentespropios.LibreriaDeRutinasEjercicio1;
import g7.frsf.utn.ejercicio1.estadodelsistema.Ejercicio1;
import g7.frsf.utn.ejercicio1.estadodelsistema.Solicitud;

public class EventoArribarACola extends g7.frsf.utn.des.Evento {

	public EventoArribarACola(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinas libreria) {
				
		Ejercicio1 modeloActual = (Ejercicio1) modelo;
		LibreriaDeRutinasEjercicio1 libreriaActual = (LibreriaDeRutinasEjercicio1) libreria;
		
		//Agendar el próximo arribo de solicitud.
		EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosSolicitudes());	
		eventos.agregar(nuevoEvento);
		
		//Procesar este arribo, para lo cual es necesario generar la solicitud que acaba de arribar.
		Solicitud solicitudParaAgregar = new Solicitud();
		
		if(modeloActual.estaServidorOcupado()) {
			modeloActual.encolarSolicitud(solicitudParaAgregar);
		}
		else {
			modeloActual.atenderSolicitud(solicitudParaAgregar);
			int duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento();
			EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);	
			eventos.agregar(nuevoEventoAdicional);
		}
	}

}
