package g7.frsf.utn.seguimiento.eventos;

import g7.frsf.utn.des.*;
import g7.frsf.utn.seguimiento.componentespropios.LibreriaDeRutinasSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.Producto;
import g7.frsf.utn.seguimiento.estadodelsistema.Cliente;
import g7.frsf.utn.seguimiento.estadodelsistema.SeguimientoU3;

public class EventoArribarACola extends Evento {

    public EventoArribarACola(Double tiempoDeOcurrencia){
        super(tiempoDeOcurrencia);
    }
    @Override
    public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria) {
        SeguimientoU3 modeloActual = (SeguimientoU3) modelo;
        LibreriaDeRutinasSeguimiento libreriaActual = (LibreriaDeRutinasSeguimiento) libreria;

        //Agendar el próximo arribo de solicitud.
        EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosClientes());
        eventos.agregar(nuevoEvento);

        //Procesar este arribo, para lo cual es necesario generar la solicitud que acaba de arribar.
        Producto prod = libreriaActual.tipoProductoAComprar();
        Cliente clienteParaAgregar = new Cliente(libreriaActual.tiempoEntreArribosClientes(), prod, libreriaActual.cantidadDeArticulos(prod));

        if(modeloActual.estaEmpleadaOcupada()) {
            modeloActual.encolarCliente(clienteParaAgregar);
        }
        else {
            modeloActual.atenderCliente(clienteParaAgregar);
            double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento(clienteParaAgregar.getProducto(), clienteParaAgregar.getCantidadDeProductos());
            EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);
            eventos.agregar(nuevoEventoAdicional);
        }
    }
}
