package g7.frsf.utn.seguimiento.componentespropios;

import g7.frsf.utn.des.LibreriaDeRutinas;

public class LibreriaDeRutinasSeguimiento extends LibreriaDeRutinas {

    public double tiempoEntreArribosClientes() {
        // Exponencial con media 4 minutos
        // TODO: Checkear esto
        double media = 4;
        double lambda = 1.0 / media;
        double u = Math.random();
        double valor = -Math.log(1 - u) / lambda;
        return Math.ceil(valor);
    }

    public Producto tipoProductoAComprar(){
        double aleatorio = Math.random();
        if(aleatorio <= 0.70){
            return Producto.BEBIDA_SALUDABLE;
        }
        else{
            return Producto.PANADERIA;
        }
    }

    public int cantidadDeArticulos(Producto producto){
        if(producto == Producto.BEBIDA_SALUDABLE){
           double aleatorio = Math.random();
           if(aleatorio <= 0.57){
               return 1;
           }
           else if(aleatorio <= 0.90){
               return 2;
           }
           else{
               return 3;
           }
        }
        else{
            double aleatorio = Math.random();
            if(aleatorio <= 0.27){
                return 1;
            }
            else if(aleatorio <= 0.52){
                return 2;
            }
            else if (aleatorio <= 0.87){
                return 3;
            }
            else{
                return 4;
            }
        }
    }

    public double tiempoDeProcesamiento(Producto producto, Integer cantidad) {
        if(producto == Producto.BEBIDA_SALUDABLE){
            // Exponencial con media 2.4 minutos
            double media = 2.4;
            double lambda = 1.0 / media;
            double u = Math.random();
            double valor = -Math.log(1 - u) / lambda;
            double tiempoProc = Math.ceil(valor);
            switch (cantidad) {
                case 1:
                    return tiempoProc;
                case 2:
                    return tiempoProc * 1.10;
                case 3:
                    return tiempoProc * 1.13;
            }
        }
        else{
            // Exponencial con media 3.5 minutos
            double media = 3.5;
            double lambda = 1.0 / media;
            double u = Math.random();
            double valor = -Math.log(1 - u) / lambda;
            double tiempoProc = Math.ceil(valor);
            switch (cantidad) {
                case 1:
                    return tiempoProc;
                case 2:
                    return tiempoProc * 1.12;
                case 3:
                    return tiempoProc * 1.15;
                case 4:
                    return tiempoProc * 1.20;
            }
        }
        return 0;
    }
}
