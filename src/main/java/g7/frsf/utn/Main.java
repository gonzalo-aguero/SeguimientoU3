package g7.frsf.utn;


import g7.frsf.utn.des.*;
import g7.frsf.utn.seguimiento.componentespropios.ContadoresEstadisticosSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.GeneradorDeReportesSeguimiento;
import g7.frsf.utn.seguimiento.componentespropios.LibreriaDeRutinasSeguimiento;
import g7.frsf.utn.seguimiento.estadodelsistema.SeguimientoU3;
import g7.frsf.utn.seguimiento.eventos.EventoArribarACola;

public class Main {
    private static EstadoDelSistema modelo;
    private static ContadoresEstadisticos contadores;
    private static GeneradorDeReportes reporte;
    private static LibreriaDeRutinas libreria;
    private static ListaDeEventos eventos;
    private static RelojDeSimulacion reloj;

    public static void main(String[] args) {
        //Creación de los componentes propios del ejemplo a ejecutar.
        crearComponentesDependientes();

        //Creación de los componentes generales.
        RutinaDeInicializacion inicializacion = new RutinaDeInicializacion();
        RutinaDeTiempo manejoDeTiempo = new RutinaDeTiempo();
        reloj = new RelojDeSimulacion();

        System.out.println("------------------------------------------------------");
        System.out.println("***INICIALIZACION");
        System.out.println("------------------------------------------------------");

        //Flujo de control
        inicializacion.run(reloj,modelo,contadores,eventos,libreria);

        do {

            System.out.println("------------------------------------------------------");
            System.out.println("***PROGRAMA PRINCIPAL *** t=" + reloj.getValor());
            System.out.println("------------------------------------------------------");

            //Invocar a la rutina de tiempo.
            Evento eventoPorEjecutar = manejoDeTiempo.run(eventos,reloj);

            System.out.println("\t\t-- El SIMULADOR determina que el EVENTO MAS INMINENTE se dará en " + eventoPorEjecutar.getTiempoQueFaltaParaQueOcurra() + " unidades de tiempo.");
            System.out.println("\t\t-- El SIMULADOR actualiza el RELOJ para ejecutar el EVENTO MAS INMINENTE del tipo " + eventoPorEjecutar.getClass().getSimpleName() + ".");

            //Invocar a la rutina de evento.
            eventoPorEjecutar.rutinaDeEvento(modelo,contadores,eventos,libreria);

        }while(!terminoLaSimulacion(reloj,contadores));

        reporte.run(contadores);
    }

    //MODIFICAR para indicar el Estado del Sistema a Simnular
    private static void crearComponentesDependientes() {
        //TODO Aca se crean los componentes propios del modelo a ejecutar.
        modelo = new SeguimientoU3();
        contadores = new ContadoresEstadisticosSeguimiento();
        reporte = new GeneradorDeReportesSeguimiento();
        libreria = new LibreriaDeRutinasSeguimiento();
        Evento primerEvento =
                new EventoArribarACola(((LibreriaDeRutinasSeguimiento) libreria).tiempoEntreArribosClientes());
        eventos = new ListaDeEventos(primerEvento);
    }

    //MODIFICAR para indicar el estado de Fin de Simulación
    private static boolean terminoLaSimulacion(RelojDeSimulacion reloj, ContadoresEstadisticos contadores) {
        //TODO Aca se debe programar según el fin sea por tiempo o cantidad.

        //Ejemplo por tiempo
        int tiempoDeSimulacion = 100;
        if(reloj.getValor() >= tiempoDeSimulacion) return true;
        return false;

        //Ejemplo por cantidad: "Que se hayan procesado 15 solicitudes."
		/*ContadoresEstadisticosEjemplo contadorEjemplo = (ContadoresEstadisticosEjemplo) contadores;
		int cantidadDeSimulacion = contadorEjemplo.getCantProcesadas(), topeDeSimulacion=15;
		if(cantidadDeSimulacion >= topeDeSimulacion) return true;
		return false;*/

    }

    public static double getTiempoActual() {
        return reloj.getValor();
    }
}