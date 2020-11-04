package ciclo2_reto2;

import java.util.Scanner; // para usar el Scanner (inputs de usuario)
import java.util.*; // para hacer el ArrayList

public class Inventario {

    static Scanner sc = new Scanner(System.in);
    
    static boolean bandera = true;    
    static String[] arregloEntrada;
    static ArrayList<> inventario = new ArrayList<>();

    public static void procesarComandos(int opcion) {
        switch (opcion) {
            case 1:
                comando1();
                break;
            case 2:
                comando2();
                break;
            case 3:
                comando3();
                break;
            default:
                break;
        }
    }

    public static void comando1() {
        String tipo = arregloEntrada[1];
        int numeroPasajeros = Integer.parseInt(arregloEntrada[2]);
        int velocidadMaxima = Integer.parseInt(arregloEntrada[3]);
        String placa = arregloEntrada[4];

        if ("Comercial".equals(tipo)) {
            int cargaMaxima = Integer.parseInt(arregloEntrada[5]);
            Comercial vehiculoComercial = new Comercial(velocidadMaxima, numeroPasajeros, placa, tipo, cargaMaxima);
            inventario.add(vehiculoComercial);

        } else if ("Particular".equals(tipo)) {
            String color = arregloEntrada[5];
            Particular vehiculoParticular = new Particular(velocidadMaxima, numeroPasajeros, placa, tipo, color);
            inventario.add(vehiculoParticular);
        }
    }
    
    public static void comando2() {
        System.out.println("***Inventario de vehículos***");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i));
        } 
    } 
    
    public static boolean comando3() {
        bandera = false;
        return bandera;
    } 
    
    public static void main(String[] args) {
        
        do {
            System.out.print("Input: ");
            arregloEntrada = sc.nextLine().split("&");
            int comando = Integer.parseInt(arregloEntrada[0]);
            
        procesarComandos(comando);
            
        } while (bandera == true);
    }
}
