package g7.frsf.utn.seguimiento.componentespropios;

public enum Producto{
    BEBIDA_SALUDABLE("Bebida saludable",600.0),
    PANADERIA("Panaderia",450.0);

    private final String nombre;
    private final Double beneficio;

    private Producto(String nombre, Double beneficio){
        this.nombre = nombre;
        this.beneficio = beneficio;
    }

    public Double getBeneficio(){
        return this.beneficio;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
