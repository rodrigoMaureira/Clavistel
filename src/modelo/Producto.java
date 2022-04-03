package modelo;

//iniciando el guardado de datos de tipo producto

public class Producto {

    private String modelo, marca, detalles;
    private int precio;
    private int id;

    public Producto(String modelo, String marca, String detalles, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.detalles = detalles;
        this.precio = precio;
    }

    public Producto(String modelo, String marca, String detalles, int precio, int id) {
        this.modelo = modelo;
        this.marca = marca;
        this.detalles = detalles;
        this.precio = precio;
        this.id = id;
    }

    public Producto() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
