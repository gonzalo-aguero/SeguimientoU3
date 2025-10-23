package g7.frsf.utn.des;

/***************************************/
/* NO MODIFICAR PARA USAR EL SIMULADOR */
/***************************************/

public abstract class Evento {
	
	private double tiempoQueFaltaParaQueOcurra;
	private double tiempoDeOcurrencia;//Tiempo Relativo
	
	public Evento(double saltoDeTiempo) {
		super();
		this.setTiempoQueFaltaParaQueOcurra(saltoDeTiempo);
	}

	public double getTiempoDeOcurrencia() {
		return tiempoDeOcurrencia;
	}
	
	public double getTiempoQueFaltaParaQueOcurra() {
		return tiempoQueFaltaParaQueOcurra;
	}
	
	public void refreshTiempo(double elapsedTime) {
		this.tiempoQueFaltaParaQueOcurra -= elapsedTime;	
	}
	
	public void setTiempoDeOcurrencia(double tiempoDeReloj) {
		this.tiempoDeOcurrencia = tiempoDeReloj;
	}
	
	private void setTiempoQueFaltaParaQueOcurra(double saltoDeTiempo) {
		this.tiempoQueFaltaParaQueOcurra = saltoDeTiempo;
	}
	
	/* Subprograma que actualiza el estado del sistema  cuando un tipo particular de evento tiene lugar. */

	public abstract void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria);

}
