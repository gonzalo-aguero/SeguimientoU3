package g7.frsf.utn.seguimiento.componentespropios;

import g7.frsf.utn.des.ContadoresEstadisticos;

public class ContadoresEstadisticosSeguimiento extends ContadoresEstadisticos {
    Integer clientesProcesados;
    Double beneficioTotalAcumulado;
    Integer longitudColaAcumulada; // Para calcular longitud promedio de la cola al finalizar la simulación
    Double tiempoClientesEnKioscoAcumulado;
    Double tiempoTotalOcupacion;
    Double tiempoDeInicioAtencionUltimoCliente; // Para considerar el tiempo de ocupación del último cliente atendido si la empleada está ocupada al finalizar la simulación
    
    @Override
    public void inicializar() {
        clientesProcesados = 0;
        beneficioTotalAcumulado = 0.0;
        longitudColaAcumulada = 0;
        tiempoClientesEnKioscoAcumulado = 0.0;
        tiempoTotalOcupacion = 0.0;
        tiempoDeInicioAtencionUltimoCliente = 0.0;
    }

    public void actualizarClientesProcesados() {
        clientesProcesados++;
    }
    public void actualizarBeneficioTotalAcumulado(Double beneficio) {
        beneficioTotalAcumulado += beneficio;
    }
    public void actualizarLongitudColaAcumulada(Integer longitudColaActual) {
        longitudColaAcumulada += longitudColaActual;
    }
    public void actualizarTiempoClientesEnKioscoAcumulado(Double tiempoClienteActual) {
        tiempoClientesEnKioscoAcumulado += tiempoClienteActual;
    }
    public void actualizarTiempoTotalOcupacion(Double tiempoOcupacionActual) {
        tiempoTotalOcupacion += tiempoOcupacionActual;
    }
    public void setTiempoDeInicioAtencionUltimoCliente(Double tiempoInicio) {
        this.tiempoDeInicioAtencionUltimoCliente = tiempoInicio;
    }
}
