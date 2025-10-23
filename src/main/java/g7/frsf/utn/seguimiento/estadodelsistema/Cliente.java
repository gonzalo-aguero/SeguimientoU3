package g7.frsf.utn.seguimiento.estadodelsistema;

import g7.frsf.utn.seguimiento.componentespropios.Producto;

public class Cliente {
    private Integer cantidadDeProductos;
    private Producto producto;
    private Double tiempoDeArribo;
    private Double tiempoDeInicioAtencion;
    private Double tiempoDeFinAtencion;

    public Cliente(Double tiempoDeArribo, Producto producto, Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
        this.producto = producto;
        this.tiempoDeArribo = tiempoDeArribo;
    }
    public void setTiempoDeInicioAtencion(Double tiempoDeInicioAtencion) {
        this.tiempoDeInicioAtencion = tiempoDeInicioAtencion;
    }
    public void setTiempoDeFinAtencion(Double tiempoDeFinAtencion) {
        this.tiempoDeFinAtencion = tiempoDeFinAtencion;
    }
    public Double getTiempoDeInicioAtencion() {
        return tiempoDeInicioAtencion;
    }
    public Double getTiempoDeFinAtencion() {
        return tiempoDeFinAtencion;
    }
    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }
    public Producto getProducto() {
        return producto;
    }
    public Double getTiempoDeArribo() {
        return tiempoDeArribo;
    }

    
}
