package ciclo2_reto2;

public class Vehiculo {

    public final int velocidadMaxima;
    public final int numeroPasajeros;
    public final String placa;
    public final String tipo;
    
    Vehiculo(int velocidadMaxima, int numeroPasajeros, String placa, String tipo) {
        this.velocidadMaxima = velocidadMaxima;
        this.numeroPasajeros = numeroPasajeros;
        this.placa = placa;
        this.tipo = tipo;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\tVehículo " + tipo + " - Placa: " + placa + "\n"
                + "\tvelocidad: " + velocidadMaxima + " km/h" + "\n"
                + "\tpasajeros: " + numeroPasajeros + "\n";
    }
}
