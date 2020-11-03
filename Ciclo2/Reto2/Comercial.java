package ciclo2_reto2;

public class Comercial extends Vehiculo {
    
    public final int cargaMaxima; 
            
    Comercial(int velocidadMaxima, int numeroPasajeros, String placa, String tipo, int cargaMaxima) {
        super(velocidadMaxima, numeroPasajeros, placa, tipo);
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "\tCarga máxima: " + cargaMaxima + "kg";
    }
}
