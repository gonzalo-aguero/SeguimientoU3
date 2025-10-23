package g7.frsf.utn.ejercicio1.estadodelsistema;

/* Solicitud que puede ser procesada por el servidor. */

public class Solicitud {
	
	private int clase;

	public Solicitud() {
		super();
		this.clase = (int) ((Math.random()*3) + 1);	
	}

	public int getClase() {
		return clase;
	}
	
}
