package g7.frsf.utn.seguimiento.eventos;

import g7.frsf.utn.Main;
import g7.frsf.utn.des.*;
import g7.frsf.utn.seguimiento.componentespropios.ContadoresEstadisticosSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.LibreriaDeRutinasSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.Producto;
import g7.frsf.utn.seguimiento.estadodelsistema.Cliente;
import g7.frsf.utn.seguimiento.estadodelsistema.SeguimientoU3;

public class EventoArribarACola extends Evento {

    public EventoArribarACola(Double saltoDeTiempo){
        super(saltoDeTiempo);
    }
    @Override
    public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria) {
        SeguimientoU3 modeloActual = (SeguimientoU3) modelo;
        LibreriaDeRutinasSeguimiento libreriaActual = (LibreriaDeRutinasSeguimiento) libreria;

        // Actualizar contadores estadisticos
		ContadoresEstadisticosSeguimiento contadoresEstadisticos = (ContadoresEstadisticosSeguimiento) contadores;
		contadoresEstadisticos.actualizarLongitudColaAcumulada(modeloActual.obtenerLongitudColaActual());


        //Agendar el próximo arribo de solicitud.
        EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosClientes());
        eventos.agregar(nuevoEvento);

        //Procesar este arribo, para lo cual es necesario generar la solicitud que acaba de arribar.
        Producto producto = libreriaActual.tipoProductoAComprar();
        Double tiempoDeArribo = libreriaActual.tiempoEntreArribosClientes();
        Cliente clienteQueArribo = new Cliente(
            tiempoDeArribo, // tiempoDeArribo
            producto, // producto (tipo de producto)
            libreriaActual.cantidadDeArticulos(producto) // cantidadDeProductos
        );
        contadoresEstadisticos.setTiempoDeInicioAtencionUltimoCliente(Main.getTiempoActual() + tiempoDeArribo);

        if(modeloActual.estaEmpleadaOcupada()) {
            modeloActual.encolarCliente(clienteQueArribo);
        }
        else {
            clienteQueArribo.setTiempoDeInicioAtencion(this.getTiempoDeOcurrencia());
            modeloActual.atenderCliente(clienteQueArribo);
            Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento(clienteQueArribo.getProducto(), clienteQueArribo.getCantidadDeProductos());
            EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);
            eventos.agregar(nuevoEventoAdicional);
        }
    }
}
