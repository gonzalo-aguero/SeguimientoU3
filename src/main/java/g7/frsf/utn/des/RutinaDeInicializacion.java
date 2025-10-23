package g7.frsf.utn.des;

/* Subprograma que inicializa el modelo en t=0.*/

/***************************************/
/* NO MODIFICAR PARA USAR EL SIMULADOR */
/***************************************/

public class RutinaDeInicializacion {
	
	public void run(RelojDeSimulacion reloj, EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria) {
		
		//Setear el reloj de simulación en 0.
		reloj.inicializar();
		
		//Inicializar el estado del sistema.
		modelo.inicializar();
		
		//Inicializar  los contadores estadísticos.
		contadores.inicializar();
		
		//Inicializar la lista de eventos.
		eventos.inicializar();
		
	}

}
