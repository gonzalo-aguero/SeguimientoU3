package g7.frsf.utn.seguimiento.estadodelsistema;

import g7.frsf.utn.des.EstadoDelSistema;

public class SeguimientoU3 extends EstadoDelSistema {
    private Cola colaClientes;
    private Empleada empleada;

    @Override
    public void inicializar() {
        colaClientes = new Cola();
        empleada = new Empleada();
    }

    public boolean estaEmpleadaOcupada(){
        return empleada.estaOcupado();
    }

    public void atenderCliente(Cliente cliente){
        empleada.atenderCliente(cliente);
    }

    public void encolarCliente(Cliente cliente){
        colaClientes.encolarCliente(cliente);
    }

    public Cliente finalizarAtencionSolicitud(){
        return empleada.finalizarAtencionSolicitud();
    }
}
