package g7.frsf.utn.seguimiento.eventos;

import g7.frsf.utn.Main;
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

        ContadoresEstadisticosSeguimiento contadoresEstadisticos = (ContadoresEstadisticosSeguimiento) contadores;
        SeguimientoU3 modeloActual = (SeguimientoU3) modelo;
        LibreriaDeRutinasSeguimiento libreriaActual = (LibreriaDeRutinasSeguimiento) libreria;

        // Finalizar la atención del cliente que estaba siendo procesado.
        Double tiempoActualDeSimulacion = Main.getTiempoActual();
        Cliente clienteFinalizado = modeloActual.obtenerClienteEnAtencion();
        clienteFinalizado.setTiempoDeFinAtencion(tiempoActualDeSimulacion);
        modeloActual.finalizarAtencionCliente(tiempoActualDeSimulacion);

        // Actualizar contadores estadisticos
        contadoresEstadisticos.actualizarClientesProcesados();
        Double beneficioObtenido = clienteFinalizado.getProducto().getBeneficioUnitario() * clienteFinalizado.getCantidadDeProductos();
        contadoresEstadisticos.actualizarBeneficioTotalAcumulado(beneficioObtenido);

        Double tiempoDeInicioAtencion = clienteFinalizado.getTiempoDeInicioAtencion();
        Double tiempoDeFinAtencion = clienteFinalizado.getTiempoDeFinAtencion();
        contadoresEstadisticos.actualizarTiempoClientesEnKioscoAcumulado(tiempoDeFinAtencion - tiempoDeInicioAtencion);

        contadoresEstadisticos.actualizarTiempoTotalOcupacion(tiempoActualDeSimulacion - tiempoDeInicioAtencion);


        // Verificar si hay clientes en espera para ser atendidos.
        if(modeloActual.hayClientesEnEspera()) {
            Cliente clienteAAtender = modeloActual.obtenerClienteEnEspera();
            clienteAAtender.setTiempoDeInicioAtencion(this.getTiempoDeOcurrencia());
            modeloActual.atenderCliente(clienteAAtender);
            
            Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento(clienteAAtender.getProducto(), clienteAAtender.getCantidadDeProductos());
            EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento);
            eventos.agregar(nuevoEvento);
        }
    }
}
