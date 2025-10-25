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


        // Programar el próximo arribo a la cola de clientes (antes de procesar el arribo actual).
        EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosClientes());
        eventos.agregar(nuevoEvento);

        // Procesar el arribo de cliente actual.
        Producto producto = libreriaActual.tipoProductoAComprar();
        Double tiempoDeArribo = this.getTiempoDeOcurrencia();
        Cliente clienteQueArribo = new Cliente(
            tiempoDeArribo, // tiempoDeArribo
            producto, // producto (tipo de producto)
            libreriaActual.cantidadDeArticulos(producto) // cantidadDeProductos
        );
        
        
        if(modeloActual.estaEmpleadaOcupada()) { // La empleada está ocupada, por lo que el cliente debe ir a la cola.
            modeloActual.encolarCliente(clienteQueArribo);
        } else { // La empleada está desocupada, por lo que el cliente es atendido inmediatamente.
            clienteQueArribo.setTiempoDeInicioAtencion(this.getTiempoDeOcurrencia());
            contadoresEstadisticos.setTiempoDeInicioAtencionUltimoCliente(this.getTiempoDeOcurrencia());
            modeloActual.atenderCliente(clienteQueArribo);
            Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento(clienteQueArribo.getProducto(), clienteQueArribo.getCantidadDeProductos());
            EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);
            eventos.agregar(nuevoEventoAdicional);
        }
    }
}
