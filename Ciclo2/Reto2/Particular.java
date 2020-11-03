package ciclo2_reto2;

public class Particular extends Vehiculo {
    
    public final String color;
    
    Particular(int velocidadMaxima, int numeroPasajeros, String placa, String tipo, String color) {
        super(velocidadMaxima, numeroPasajeros, placa, tipo);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "\tcolor: " + color;
    }
}

