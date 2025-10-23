package g7.frsf.utn.seguimiento.estadodelsistema;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Empleada {
	Optional<Cliente> clienteEnAtencion; /* Solicitud que está siendo retenida en el servidor. */
	Double tiempoTotalOcupacion;
	Integer cantidadClientesAtendidos;


	public Empleada() {
		super();
		clienteEnAtencion = Optional.empty();
		tiempoTotalOcupacion = 0.0;
		cantidadClientesAtendidos = 0;
	}

	public boolean estaOcupado() {
		return clienteEnAtencion.isPresent();
	}

	public void atenderCliente(Cliente solicitud) {
		this.clienteEnAtencion = Optional.of(solicitud);
	}

	public Cliente finalizarAtencionSolicitud(){
		Cliente solicitudQueSale = clienteEnAtencion.orElseThrow(() -> new NoSuchElementException("No se estaba procesando una solicitud"));
		this.clienteEnAtencion = Optional.empty();
		return solicitudQueSale;
	}

}
