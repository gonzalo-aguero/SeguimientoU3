package g7.frsf.utn.seguimiento.componentespropios;

public enum Producto{
    BEBIDA_SALUDABLE("Bebida saludable",600.0,1200.0),
    PANADERIA("Panaderia",400.0,850.0);

    private final String nombre;
    private final Double costoUnitario;
    private final Double precioUnitario;

    private Producto(String nombre, Double costoUnitario, Double precioUnitario){
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.precioUnitario = precioUnitario;
    }

    public Double getBeneficioUnitario(){
        return this.precioUnitario - this.costoUnitario;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
