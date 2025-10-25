package g7.frsf.utn.seguimiento.componentespropios;

import g7.frsf.utn.Main;
import g7.frsf.utn.des.ContadoresEstadisticos;
import g7.frsf.utn.des.GeneradorDeReportes;

public class GeneradorDeReportesSeguimiento extends GeneradorDeReportes {
    @Override
    public void run(ContadoresEstadisticos contadores) {
        ContadoresEstadisticosSeguimiento contadoresSeguimiento = (ContadoresEstadisticosSeguimiento) contadores;
        System.out.println("-----------------------------------------------------------");
        System.out.println("**********REPORTE DE SIMULACION DE SEGUIMIENTO U3**********");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Cantidad de Clientes Atendidos: " + contadoresSeguimiento.getClientesProcesados());
        System.out.println("Beneficio Total Acumulado: " + String.format("%.2f", contadoresSeguimiento.getBeneficioTotalAcumulado()) + " unidades monetarias");

        // Calculo de la longitud promedio de la cola
        Double longitudPromedioCola = contadoresSeguimiento.getLongitudColaAcumulada().doubleValue() / Main.getTiempoASimular();
        System.out.println("Longitud Promedio de la Cola: " + String.format("%.3f", longitudPromedioCola) + " clientes");

        // Calculo del tiempo promedio de los clientes en el kiosco
        Double tiempoPromedioClientesEnKiosco = (contadoresSeguimiento.getTiempoClientesEnKioscoAcumulado() / contadoresSeguimiento.getClientesProcesados()) / 60; // Convertir a horas
        Double minutosPromedioClientesEnKiosco = tiempoPromedioClientesEnKiosco * 60;
        System.out.println("Tiempo Promedio de Clientes en Kiosco: " + String.format("%.3f", tiempoPromedioClientesEnKiosco) + " horas (" + String.format("%.3f", minutosPromedioClientesEnKiosco) + " minutos)");
 
        // Calculo de la tasa de atencion por empleada
        Double tasaAtencionPorEmpleada = contadoresSeguimiento.getClientesProcesados().doubleValue() / Main.getTiempoASimular();
        Double tasaAtencionPorHora = tasaAtencionPorEmpleada * 60;
        System.out.println("Tasa de Atención por Empleada: " + String.format("%.3f", tasaAtencionPorHora) + " clientes por hora");

        // Calculo del porcentaje de tiempo libre de la empleada
        Double tiempoTotalSimulacion = Double.valueOf(Main.getTiempoASimular());
        Double tiempoOcupacion = contadoresSeguimiento.getTiempoTotalOcupacion();
        Boolean empleadaOcupada =  contadoresSeguimiento.getEmpleadaOcupadaAlFinalizarSimulacion();
        if(empleadaOcupada) { // Si la empleada está ocupada al finalizar la simulación, se debe sumar el tiempo que lleva atendiendo al último cliente
            tiempoOcupacion += Main.getTiempoActual() - contadoresSeguimiento.getTiempoDeInicioAtencionUltimoCliente();
        }
        Double porcentajeTiempoLibreEmpleada = ((tiempoTotalSimulacion - contadoresSeguimiento.getTiempoTotalOcupacion()) / tiempoTotalSimulacion) * 100;
        System.out.println("Porcentaje de Tiempo Libre de la Empleada: " + String.format("%.3f", porcentajeTiempoLibreEmpleada) + "%");
    }
}
