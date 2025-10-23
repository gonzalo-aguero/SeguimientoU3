package g7.frsf.utn.ejercicio1.estadodelsistema;

/* Servidor en la nube. */

public class Servidor {

	Boolean estaOcupado; /* false = libre / true = ocupado */
	Solicitud solicitudEnProcesamiento; /* Solicitud retenida en el servidor. */

	public Servidor(boolean estado) {
		super();
		estaOcupado = estado;
		solicitudEnProcesamiento = null;
	}

	public boolean isOcupado() {
		return estaOcupado;
	}

	public void pasarAOcupado(Solicitud solicitud) {
		estaOcupado = true;
		solicitudEnProcesamiento = solicitud;
	}

	public void pasarADisponible() {
		estaOcupado = false;
		solicitudEnProcesamiento = null;
	}
}
