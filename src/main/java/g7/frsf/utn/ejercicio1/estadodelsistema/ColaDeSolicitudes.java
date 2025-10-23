package g7.frsf.utn.ejercicio1.estadodelsistema;

import java.util.LinkedList;
import java.util.Queue;

public class ColaDeSolicitudes {

	private Queue<Solicitud> colaClase1;
	private Queue<Solicitud> colaClase2;
	private Queue<Solicitud> colaClase3;
	private Queue<Solicitud> colaClase4;
	
	public ColaDeSolicitudes() {
		super();
		colaClase1 = new LinkedList<Solicitud>();
		colaClase2 = new LinkedList<Solicitud>();
		colaClase3 = new LinkedList<Solicitud>();
		colaClase4 = new LinkedList<Solicitud>();
	}

	public void encolarSolicitud(Solicitud solicitudParaAgregar) {
		switch(solicitudParaAgregar.getClase()) {
		case 1: colaClase1.add(solicitudParaAgregar); break;
		case 2: colaClase2.add(solicitudParaAgregar); break;
		case 3: colaClase3.add(solicitudParaAgregar); break;
		case 4: colaClase4.add(solicitudParaAgregar); break;
		}
	}

	public int getCantSolicitudesEsperando() {
		return colaClase1.size()+colaClase2.size()+colaClase3.size()+colaClase4.size();
	}

	public Solicitud solicitudPrioritaria() {
		Solicitud ret;
		if(colaClase4.size()>0) ret = colaClase4.remove();
		else if(colaClase3.size()>0) ret = colaClase3.remove();
		else if(colaClase2.size()>0) ret = colaClase2.remove();
		else ret = colaClase1.remove();
		return ret;
	}
	
}
