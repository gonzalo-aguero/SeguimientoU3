package g7.frsf.utn.seguimiento.eventos;

import g7.frsf.utn.des.*;

import g7.frsf.utn.seguimiento.componentespropios.ContadoresEstadisticosSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.LibreriaDeRutinasSeguimiento;
import g7.frsf.utn.seguimiento.estadodelsistema.Cliente;
import g7.frsf.utn.seguimiento.estadodelsistema.SeguimientoU3;

public class EventoTerminaProcesamiento extends Evento {

    public EventoTerminaProcesamiento(double tiempoDeOcurrencia) {
        super(tiempoDeOcurrencia);
    }

    @Override
    public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria) {

        ContadoresEstadisticosSeguimiento contadoresEjemplo = (ContadoresEstadisticosSeguimiento) contadores;
        contadoresEjemplo.actualizarClientesProcesados();

        SeguimientoU3 modeloActual = (SeguimientoU3) modelo;
        LibreriaDeRutinasSeguimiento libreriaActual = (LibreriaDeRutinasSeguimiento) libreria;

        if(modeloActual.hayClientesEnEspera()) {
            Cliente clienteAAtender = modeloActual.obtenerClienteEnEspera();
            modeloActual.atenderCliente(clienteAAtender);
            double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento(clienteAAtender.getProducto(), clienteAAtender.getCantidadDeProductos());
            EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento);
            eventos.agregar(nuevoEvento);
        }
        else {

            modeloActual.desocuparEmpleada();
        }
    }
}
