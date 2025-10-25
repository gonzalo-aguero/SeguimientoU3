package g7.frsf.utn.seguimiento.componentespropios;

import g7.frsf.utn.des.ContadoresEstadisticos;

public class ContadoresEstadisticosSeguimiento extends ContadoresEstadisticos {
    private Integer clientesProcesados;
    private Double beneficioTotalAcumulado;
    private Integer longitudColaAcumulada; // Para calcular longitud promedio de la cola al finalizar la simulación
    private Double tiempoClientesEnKioscoAcumulado;// en minutos
    private Double tiempoTotalOcupacion;  // en minutos para calcular el porcentaje de tiempo libre de la empleada
    private Double tiempoDeInicioAtencionUltimoCliente; // Para considerar el tiempo de ocupación del último cliente atendido si la empleada está ocupada al finalizar la simulación
    private Boolean empleadaOcupadaAlFinalizarSimulacion;
    
    @Override
    public void inicializar() {
        clientesProcesados = 0;
        beneficioTotalAcumulado = 0.0;
        longitudColaAcumulada = 0;
        tiempoClientesEnKioscoAcumulado = 0.0;
        tiempoTotalOcupacion = 0.0;
        tiempoDeInicioAtencionUltimoCliente = 0.0;
        empleadaOcupadaAlFinalizarSimulacion = false;
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
    public void setEmpleadaOcupadaAlFinalizarSimulacion(Boolean ocupada) {
        this.empleadaOcupadaAlFinalizarSimulacion = ocupada;
    }
    public Boolean getEmpleadaOcupadaAlFinalizarSimulacion() {
        return empleadaOcupadaAlFinalizarSimulacion;
    }

    public Integer getClientesProcesados() {
        return clientesProcesados;
    }

    public void setClientesProcesados(Integer clientesProcesados) {
        this.clientesProcesados = clientesProcesados;
    }

    public Double getBeneficioTotalAcumulado() {
        return beneficioTotalAcumulado;
    }

    public void setBeneficioTotalAcumulado(Double beneficioTotalAcumulado) {
        this.beneficioTotalAcumulado = beneficioTotalAcumulado;
    }

    public Integer getLongitudColaAcumulada() {
        return longitudColaAcumulada;
    }

    public void setLongitudColaAcumulada(Integer longitudColaAcumulada) {
        this.longitudColaAcumulada = longitudColaAcumulada;
    }

    public Double getTiempoClientesEnKioscoAcumulado() {
        return tiempoClientesEnKioscoAcumulado;
    }

    public void setTiempoClientesEnKioscoAcumulado(Double tiempoClientesEnKioscoAcumulado) {
        this.tiempoClientesEnKioscoAcumulado = tiempoClientesEnKioscoAcumulado;
    }

    public Double getTiempoTotalOcupacion() {
        return tiempoTotalOcupacion;
    }

    public void setTiempoTotalOcupacion(Double tiempoTotalOcupacion) {
        this.tiempoTotalOcupacion = tiempoTotalOcupacion;
    }

    public Double getTiempoDeInicioAtencionUltimoCliente() {
        return tiempoDeInicioAtencionUltimoCliente;
    }
}
