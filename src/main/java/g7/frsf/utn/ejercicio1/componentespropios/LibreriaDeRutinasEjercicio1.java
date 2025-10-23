package g7.frsf.utn.ejercicio1.componentespropios;

/**
 * En teoría en esta clase tenemos que definir los métodos para aplicar chi cuadrado y los metodos de 
 * variables aleatorias, pero en la primera clase nos dijo la profe que por ahora
 * "retornemos cualquier cosa".
 */
public class LibreriaDeRutinasEjercicio1 extends g7.frsf.utn.des.LibreriaDeRutinas {
    
    public int tiempoEntreArribosSolicitudes() {
        return (int) Math.ceil(Math.random() * 10);
    }

    public int tiempoDeProcesamiento() {
        return (int) Math.ceil(Math.random() * 10);
    }
}
