public class Bicho
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int salud;

    /**
     * Constructor for objects of class Bicho
     */
    public Bicho(String nombre, int salud)
    {
        this.nombre = nombre;
        this.salud = salud;
    }
    
    public int getSalud(){
        return this.salud;
    }

    public void setSalud(int id){
        this.salud = id;
    }
    
    public String  getNombre(){
        return this.nombre;
    }

    public void setNombre(String id){
        this.nombre = id;
    }

    public void sumarVida(int valor) {
        this.salud -= valor;
    }
    
    public void multiplicarVida() {
        this.salud *= 2;
    }
}
