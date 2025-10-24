package g7.frsf.utn.seguimiento.estadodelsistema;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Empleada {
	Double tiempoTotalOcupacion;
	Integer cantidadClientesAtendidos;
	Optional<Cliente> clienteEnAtencion; /* Solicitud que está siendo retenida en el servidor. */


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

	public Cliente finalizarAtencionCliente(Double tiempoActual) {
		Cliente solicitudQueSale = clienteEnAtencion.orElseThrow(() -> new NoSuchElementException("No se estaba atendiendo a un cliente"));
		this.clienteEnAtencion = Optional.empty();
		cantidadClientesAtendidos++;
		// TODO: Si al finalizar simulacion aún no termina de atender al cliente, se deberia considerar el tiempo restante en el reporte.
		tiempoTotalOcupacion += tiempoActual - solicitudQueSale.getTiempoDeArribo();
		return solicitudQueSale;
	}
	public void pasarADesocupada(){
		this.clienteEnAtencion = Optional.empty();
	}
	
	public Cliente getClienteEnAtencion() {
		return clienteEnAtencion.orElseThrow(() -> new NoSuchElementException("No se estaba atendiendo a un cliente"));
	}
}
