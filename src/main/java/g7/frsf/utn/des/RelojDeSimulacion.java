package g7.frsf.utn.des;

/* Variable que mantiene el valor actual del tiempo simulado. */

/***************************************/
/* NO MODIFICAR PARA USAR EL SIMULADOR */
/***************************************/

public class RelojDeSimulacion {

	private double valor;

	public RelojDeSimulacion() {
		super();
	}

	public void actualizar(double valor) {
		this.valor += valor;
	}

	public double getValor() {
		return this.valor;
	}

	public void inicializar() {
		this.valor = 0;
	}
	
}
