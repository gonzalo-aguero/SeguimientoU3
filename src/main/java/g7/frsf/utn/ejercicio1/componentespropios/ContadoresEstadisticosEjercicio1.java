package g7.frsf.utn.ejercicio1.componentespropios;

import g7.frsf.utn.des.ContadoresEstadisticos;

public class ContadoresEstadisticosEjercicio1 extends ContadoresEstadisticos {
    private int cantSolicitudesProcesadas;

    @Override
    public void inicializar() {
        cantSolicitudesProcesadas = 0;
    }

    public int getCantSolicitudesProcesadas() {
        return cantSolicitudesProcesadas;
    }
    
    public void actualizarCantProcesadas(){
        cantSolicitudesProcesadas++;
    }
}
