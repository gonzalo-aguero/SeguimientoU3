package g7.frsf.utn.ejercicio1.componentespropios;

import g7.frsf.utn.des.ContadoresEstadisticos;
import g7.frsf.utn.des.GeneradorDeReportes;

public class GeneradorDeReportesEjercicio1 extends GeneradorDeReportes {

    @Override
    public void run(ContadoresEstadisticos contadores) {
        ContadoresEstadisticosEjercicio1 contadoresEjemplo = (ContadoresEstadisticosEjercicio1) contadores;
        System.out.println("----------------------------------------------------");
        System.out.println("*** GENERADOR DE REPORTES ***");
        System.out.println("----------------------------------------------------");
        System.out.println("Cantidad de solicitudes procesadas: " + contadoresEjemplo.getCantSolicitudesProcesadas());
    }
}
