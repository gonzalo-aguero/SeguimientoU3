package g7.frsf.utn.ejercicio1.estadodelsistema;

import g7.frsf.utn.des.EstadoDelSistema;

public class Ejercicio1 extends EstadoDelSistema {
    private ColaDeSolicitudes cola;
    private Servidor servidor;

    @Override
    public void inicializar(){
        cola = new ColaDeSolicitudes();
        servidor = new Servidor(false);
    }

    public void encolarSolicitud(Solicitud solicitud){
        cola.encolarSolicitud(solicitud);
    }
    
    public boolean estaServidorOcupado(){
        return servidor.isOcupado();
    }
    
    public void atenderSolicitud(Solicitud solicitud){
        servidor.pasarAOcupado(solicitud);
    }

    public boolean haySolicitudesEnEspera(){
        return cola.getCantSolicitudesEsperando()>0;
    }

    public Solicitud obtenerSolicitudPrioritaria(){
        return cola.solicitudPrioritaria();
    }

    public void actualizarServidorDisponible(){
        servidor.pasarADisponible();
    }
}