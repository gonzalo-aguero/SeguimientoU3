package g7.frsf.utn.des;

/* Subprograma que determina el próximo evento desde la Lista de Eventos, actualizando el Reloj de Simulación 
 * al instante cuando éste tiene lugar. */

/***************************************/
/* NO MODIFICAR PARA USAR EL SIMULADOR */
/***************************************/

public class RutinaDeTiempo {

	public Evento run(ListaDeEventos eventos, RelojDeSimulacion reloj) {
		
		//Determinar el tipo de evento más inminente.
		Evento e = eventos.obtenerMasInminente();
		
		//Actualizar el reloj al tiempo de e.
		reloj.actualizar(e.getTiempoQueFaltaParaQueOcurra());
		e.setTiempoDeOcurrencia(reloj.getValor());
		
		return e;
				
	}

}
