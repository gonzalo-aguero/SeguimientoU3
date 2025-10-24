package g7.frsf.utn.seguimiento.componentespropios;

import g7.frsf.utn.des.ContadoresEstadisticos;

public class ContadoresEstadisticosSeguimiento extends ContadoresEstadisticos {
    Integer clientesProcesados;
    @Override
    public void inicializar() {
        clientesProcesados = 0;

    }

    public void actualizarClientesProcesados() {
        clientesProcesados++;
    }
}
