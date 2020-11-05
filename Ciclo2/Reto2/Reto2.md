# Ciclo 2<br> Reto semana 2: Inventario de Vehiculos

## Enunciado
Un gran empresario del gremio automovilístico quiere encomendarle el desarrollo de un pequeño demo de aplicación de tienda de autos. Todos, los Vehículos tienen como atributos velocidad y cantidad de pasajeros y tipo de combustible (diesel, gasolina, híbrido ó eléctrico).

Se tienen dos tipos principales de Vehículo: Comercial que es capaz de transportar una cierta carga límite y particular y uno Particular en la que interesa tener almacenada la información del Color de dicho auto.

 Considere la especificación del siguiente diagrama de clases para este reto:

![](Ciclo2_Reto2_DiagramaUML.PNG)
**Procesar Comandos**

En la clase Inventario, se debe definir la función procesarComandos() que realiza las siguientes operaciones:

**Agregar vehículo:** Opción 1

- Se puede añadir un vehículo de tipo comercial con el siguiente comando: 
    1&Comercial&numeroPasajeros&velocidadMaxima&placa&peso_maximo

    **Ejemplo:**
    1&Comercial&2&150&FFF 222&250

- Se puede añadir un vehículo de tipo particular con el siguiente comando:
    1&Particular&numeroPasajeros&velocidadMaxima&placa&color

    **Ejemplo:**
    1&Particular&8&160&EEE 111&Verde

**Listar ítems del inventario:** Opción 2

Se debe mostrar la frase: “***Inventario de vehículos***” Seguida por los vehículos en el orden en el que fueron agregados.

Si se trata de un vehículo particular se mostrará así. Recuerde que \t implica correr el ítem unos espacios a la derecha:

\tVehiculo Particular - Placa: FFE 000

\tvelocidad: 180 km/h

\tpasajeros: 4

\tcolor: Rojo

 Si se trata de un vehículo comercial se mostrará así:

\tVehiculo Comercial - Placa: FFF 222

\tvelocidad: 150 km/h

\tpasajeros: 2

\tCarga máxima: 250kg

**Salir:** Opción 3

**Nota 1:** Observe que el único comando que tiene salida es el listar.

**Nota 2:** En este ejercicio se requiere subir cuatro archivos. 

- Uno correspondiente a la clase Vehiculo llamado Vehiculo.java,
- otro correspondiente al Vehiculo particular llamado Particular.java,
- otro correspondiente al Vehiculo comercial llamado Comercial.java,
- otro correspondiente al Inventario llamado Inventario.java (Aquí puede colocar el main),
- Recuerde eliminar la línea de package al hacer el envío y utilizar el botón de [+] para agregar más de un archivo de código fuente. 

**Ejemplo:** Un ejemplo de ejecución del programa es el siguiente:
|Entrada |Salida |
| --- | --- |
| 1&Particular&4&180&FFE 000&Rojo<br> 1&Particular&2&240&GOK 223&Azul<br> 1&Particular&8&160&EEE 111&Verde<br> 2&Comercial&2&150&FFF 222&250<br> 2<br> 3<br> | \*\*\*Inventario de vehículos\*\*\*<br> Vehículo Particular - Placa: FFE 000<br> velocidad: 180 km/h<br> pasajeros: 4<br> color: Rojo<br> Vehículo Particular - Placa: GOK 223<br> velocidad: 240 km/h<br> pasajeros: 2<br> color: Azul<br> Vehículo Particular - Placa: EEE 111<br> velocidad: 160 km/h<br> pasajeros: 8<br> color: Verde<br> Vehículo Comercial - Placa: FFF 222<br> velocidad: 150 km/h<br> pasajeros: 2<br> Carga máxima: 250kg<br> |

## Solución
Este ejercicio se solucionó utilizando Java.

Primero, se creará un nuevo archivo llamado Vehiculo.java en donde estará la clase _Vehículo_ (esta será la clase padre de _Comercial_ y _Particular_).
``` java
public class Vehiculo {

}
```
La clase Vehículo tiene los siguientes atributos:
- Velocidad: es la velocidad máxima del vehículo, un número entero.
- Pasajeros: cantidad de pasajeros que pueden ingresar en el vehículo, un número entero.
- Placa: identificación del vehículo, cadena de caracteres. Por ejemplo "FFF 222".
- Tipo: puede ser Comercial o Particular, cadena de caracteres.

Estos atributos se inicializan en java de la siguiente manera: 
``` java
public final int velocidadMaxima;
public final int numeroPasajeros;
public final String placa;
public final String tipo;
```
La clase vehículo también tiene un constructor que permitirá crear un objeto del tipo Vehículo.
``` java
Vehiculo(int velocidadMaxima, int numeroPasajeros, String placa, String tipo) {
    this.velocidadMaxima = velocidadMaxima;
    this.numeroPasajeros = numeroPasajeros;
    this.placa = placa;
    this.tipo = tipo;
}
```
Se utiliza `this.` para que el constructor sepa que la variable velocidadMaxima es un atributo. Esto sirve para diferenciar la variable atributo de la variable del constructor (en `Vehiculo(int velocidadMaxima)`). Si no se hace esta diferenciación, habría un error porque se estaría referenciado a si mismo.

**Nota**: se podría evitar el uso de `this.` utilizando nombres de variables distintas para los atributos y en el constructor. Ejemplo:
``` java
public class Vehiculo {

    public final int velocidadAtributo;
    public final int pasajerosAtributo;
    public final String placaAtributo;
    public final String tipoAtributo;
    
    Vehiculo(int velocidadConstructor, int pasajerosConstructor, String placaConstructor, String tipoConstructor) {
        velocidadAtributo = velocidadConstructor;
        pasajerosAtributo = pasajerosConstructor;
        placaAtributo = placaConstructor;
        tipoAtributo = tipoConstructor;
    }
}
```
**Nota**: Si se imprime un objeto Vehículo en estos momentos el resultado va a ser la posición en memoria del objeto.
Para imprimir los objetos Vehículo como los pide el enunciado:
> \tVehículo _tipo_ - Placa: _placa_<br> \tvelocidad: _velocidadMaxima_ km/h<br> \tpasajeros: _numeroPasajeros_

Se debe sobreescribir el método `String` con un nuevo método que en este caso se llamará `toString()`. 
``` java
@Override
public String toString() {
    return "\tVehículo " + tipo + " - Placa: " + placa + "\n"
            + "\tvelocidad: " + velocidadMaxima + " km/h" + "\n"
            + "\tpasajeros: " + numeroPasajeros + "\n";
}
```
Ahora, se creará un nuevo archivo llamado Particular.java con la clase _Particular_ que heredará atributos y métodos de la clase _Vehículo_ para lo cual se utilizará la función `extends`.
``` java
public class Particular extends Vehiculo {

}
```
Revisando el diagrama UML se puede identificar que la clase _Particular_ incluye además el atributo "Color".
``` java
public final String color;
```
Para el constructor de la clase _Particular_ se debe usar la palabra reservada `super` para indicar que las variables velocidadMaxima, numeroPasajeros, placa y tipo son atributos heredados de la superclase _Vehículo_.
``` java
Particular(int velocidadMaxima, int numeroPasajeros, String placa, String tipo, String color) {
    super(velocidadMaxima, numeroPasajeros, placa, tipo);
    this.color = color;
}
```
En el caso de los objetos _Particular_, la impresión debe incluir el atributo "Color".
> \tVehículo _tipo_ - Placa: _placa_<br> \tvelocidad: _velocidadMaxima_ km/h<br> \tpasajeros: _numeroPasajeros_<br> \tcolor: _color_
Entonces, se sobrescribirá la función String teniendo como base la función toString() de la clase _Vehiculo_.
``` java
@Override
public String toString() {
    return super.toString() + "\tcolor: " + color;
}
```
En la clase _Comercial_ se siguen los mismos pasos que en particular pero se reemplazará el atributo "Color" por el atributo "Carga Máxima". Este cambio debe ser tenido en cuenta tanto en el constructor como en el método `toString()`.
``` java
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
```
Ya con las clases definidas, se puede proceder a crear el archivo Inventario.java que incluirá la función procesarComandos() y el main.

El usuario tiene tres opciones de entrada que ejecutarán código:
- **1**: para agregar un vehículo.
- **2**: imprimir los vehículos ingresados en el orden que se crearon.
- **3**: salir de la aplicación.

En primera instancia, se importará el Scanner para poder recibir entrada del usuario.
``` java
import java.util.Scanner;

public class Inventario {
    // todavía no escribimos el código
    public static void main(String[] args) {
        // función main, aquí va el código que se ejecutará
    }
}
```


Se usará un `switch` para evaluar el comando a procesar en la función procesarComando.
``` java
public static void procesarComandos(int opcion) {
    switch (opcion) {
        case 1:
            comando1(); //todavía no se han definido cada uno de los comandos
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
```
Ya que el programa seguirá iterando hasta que se utilicé la opción **3** se usará un ciclo `do while` para asegurar que el programa se ejecute por lo menos una vez. También se agregará una variable `boolean` para determinar cuando terminar el ciclo.

``` java
static boolean bandera = true;    

public static void main(String[] args) {
    
    do {

    procesarComandos(comando); //todavía no se ha definido la variable comando
        
    } while (bandera == true);
}
```
Se utilizará el Scanner para recibir la entrada del usuario y teniendo en cuenta que la opción **1** sigue el siguiente formato _1&(Comercial/Particular)&numeroPasajeros&velocidadMaxima&placa&(peso_maximo/color)_, se usará el `split()` para separar el inputs en varias cadenas de texto. Además, se creará un `Array` (Arreglo) para guardar estas cadenas de texto, en donde la posición [0] del arreglo para determinar el comando a ejecutar.
``` java
static boolean bandera = true;    
static String[] arregloEntrada;

public static void main(String[] args) {
    
    do {
    System.out.print("Input: ");
    arregloEntrada = sc.nextLine().split("&");
    int comando = Integer.parseInt(arregloEntrada[0]); // la variable comando se guarda como un int porque la función procesarComandos evalúa los casos utilizando números enteros.  
    procesarComandos(comando); //todavía no se ha definido la variable comando
        
    } while (bandera == true);
}
```
Ahora, se procede a crear cada uno de los métodos para la función procesarComandos. Para el comando **1** se usará un `ArrayList` para guardar los vehículos (objetos) creados por el usuario. Para esto se requiere importar de la librería "util" de java.
``` java
import java.util.*; // para hacer el ArrayList
```
Con esta importación hecha es posible crear el arreglo. Recuerde que esta variable se crea por fuera de la main para que sea accesible por todas las funciones de la clase.
``` java
static ArrayList inventario = new ArrayList<>();
```
En el comando **1** se usarán los elementos del `Array` arregloEntrada para definir los atributos del objeto y un `if` para determinar el tipo de objeto a crear según el tipo de véhiculo (Particular o Comercial).
Una vez se haya creado el objeto, se utilizará `.add()` para agregarlo como un nuevo elemento en el `ArrayList` inventario.
``` java
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
```
**Nota:** Se utiliza `.equals()` para evaluar la igualdad entre `Strings`. Esto evita errores en el compilador.

Para el comando **2** se debe imprimir el mensaje "\*\*\*Inventario de vehículos\*\*\*" seguido por la impresión de cada uno de los vehículos creados. Para imprimir los vehículos, se usa un ciclo `for` que recorra el `ArrayList` "inventario" e imprima cada uno de sus elementos.
``` java
public static void comando2() {
    System.out.println("***Inventario de vehículos***");
    for (int i = 0; i < inventario.size(); i++) {
        System.out.println(inventario.get(i));
    } 
} 
```
El comando **3** hará que la bandera = `false` y así terminará el ciclo `do while`.
``` java
public static boolean comando3() {
    bandera = false;
    return bandera;
} 
```
Con esto está listo el código. Recuerde tener cuidado al momento de ingresar cada uno de los bloques de código, especialmente en la clase Inventario. Las importaciones van por fuera de la clase mientras que las funciones se hacen por separado dentro de la clase Inventario al igual que la función main.
## Créditos
[Jaime Andres Tamayo Cardenas](https://github.com/jtamayoc95 "jtamayoc95")
