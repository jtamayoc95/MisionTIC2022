# Ciclo 1<br> Reto para la semana 3: El carrito de compras

## Enunciado
El Centro Comercial Unaleño está muy cerca de crear carrito de compras. Ahora lo que se requiere de su parte es que se puedan agregar un número indefinido de artículos y calcular la cuenta.

Se han definido varios comandos para realizar la prueba de la lógica del carrito de compras a bajo nivel. Para esto se definen ahora diferentes comandos que se realizan al momento de realizar una compra y que presentan la siguiente sintaxis: 

<div align="center">comando&sintaxis_comando</div>

Los comandos definidos ahora son:

**Comando 1:  Añadir ítem al carrito de compras**

La sintaxis del comando 1 es la siguiente:

<div align="center">1&nombre_articulo&cantidad&precio</div>

**Comando 2: Generar tirilla de compras**

La sintaxis del comando 2 es la siguiente:

<div align="center">2&cedula_cliente</div>

- Esta función debe retornar la tirilla de compras en texto
- El cálculo de descuento se mantiene y se debe generar la misma tirilla que se generó en el reto anterior, pero incluyendo la **cédula del cliente y la cantidad de artículos por producto en el formato indicado en el ejemplo**. Dado el valor total de la compra se continúa con la campaña titulada compra más y gasta menos con los siguientes descuentos:
  - Por compras mayores a 150000 lleva un 10% de descuento.
  - Por compras mayores a 300000 lleva un 15% de descuento.
  - Por compras mayores a 700000 lleva un 20% de descuento
- Al imprimir la tirilla, la aplicación elimina ese carrito de compras y queda disponible para ejecutar de nuevo comandos.
Comando 3 – Salir de la aplicación

La sintaxis del comando 3 es la siguiente:

<div align="center">3</div>

Este comando simplemente permite salir de la aplicación

**Entrada:** Diferentes comandos según el cargue y la impresión de tirillas de venta

**Salida:** Salidas dependiendo del comando especificado anteriormente

**Nota:** Como el centro comercial está siendo muy generoso con los descuentos, el valor a cobrar en caso de tener centavos se debe aproximar a techo usando la función ceil de python (https://www.tutorialspoint.com/python/number_ceil.htm)

**Ejemplo:**

| Entrada | Salida |
| --- | --- |
| 1&Chocolatinas Cohete&3&300<br> 1&Mora&1&1000<br> 1&Pan de Maiz&5&300<br> 2&1022734737<br> 1&Televisor&2&1500000<br> 1&Teatro en Casa&1&450000<br> 2&99999287<br> 3 | Centro Comercial Unaleño<br> Compra más y Gasta Menos<br> NIT: 899.999.063<br> Cliente: 1022734737<br> Art Cant Precio<br> Chocolatinas Cohete x3 $900<br> Mora x1 $1000<br> Pan de Maiz x3 $1500<br> Total: $3400<br> En esta compra tu descuento fue $0<br> Gracias por tu compra<br> ---<br> Centro Comercial Unaleño<br> Compra más y Gasta Menos<br> NIT: 899.999.063<br> Cliente: 99999287<br> Art Cant Precio<br> Televisor x2 $3000000<br> Teatro en Casa x1 $450000<br> Total: $2760000<br> En esta compra tu descuento fue $690000<br> Gracias por tu compra<br> ---<br> |

## Solución
Ejercicio resuelto usando el lenguaje de programación Python.

Como hay tres (3) posibles comandos, se utilizará el condicional `if` para definir la acción de cada comando.
``` python
if comando == 1:
# código para el comando 1
if comando == 2:
# código para el comando 2
if comando == 3:
# código para el comando 3
```

Ya que la aplicación continúa en ejecución hasta que se seleccione el comando **3**, se utilizará un ciclo `while` y una variable bandera. Además, se el código del comando **3** permitirá cambiar el valor de la variable bandera y así detener el ciclo `while`. 
``` python
bandera = True

while bandera == True:
  if comando == 1:
  # código para el comando 1
  if comando == 2:
  # código para el comando 2
  if comando == 3:
    bandera = False
```

Analizando la entrada del usuario se puede concluir que está compuesta por varios elementos separados por el carácter "&". Los elementos de la entrada serán separados con la función `split` y almacenarán en una lista.

Además, se comparará el elemento de la posición [0] de la lista para decidir la acción a realizar.
``` python
comando = [] # lista para guardar los elementos de la entrada

while bandera == True:
  comando = input().split('&')

  if comando[0] == '1': # '1' entre comillas para ser leído como String. Otra opción sería convertir comando[0] en un entero para hacerlo comparable con 1 
  # código para el comando 1
  if comando[0] == '2':
  # código para el comando 2
  if comando[0] == '3':
    bandera = False
```
En el comando **1** se crearán tres (3) listas para guardar el nombre, precio y cantidad del elemento ingresado respectivamente. Se utiliza el `append` para añadir el elemento deseado a cada lista.
``` python
if comando[0] == '1': 
  nombre.append(comando[1])
  cantidad.append(comando[2])
  precio.append(comando[3])
```
Para el comando **2** se reutilizará la función descuento utilizada en el Reto 2.
``` python
def descuento(x):
    import math
    if x <= 150000:
        descuento = 0 
        return descuento
    elif 150000 < x <= 300000:
        descuento = x*0.1
        return math.floor(descuento)
    elif 300000 < x <= 700000:
        descuento = x*0.15
        return math.floor(descuento)
    elif x > 700000:
        descuento = x*0.2
        return math.floor(descuento)
```
**Nota:** Se utiliza la función `floor` para retornar el menor número entero para el descuento. Esto tendría el mismo efecto que utilizar la función `ceil` en el valor de la compra.

También se definio la función "sumaproducto" para calcular la suma del producto de los elementos en la misma posición de dos listas independientes. 
``` python
def sumaproducto(lista1,lista2):
    resultado_sumaproducto = 0
    for i in range(len(lista1)):
        resultado_sumaproducto += (float(lista1[i]) * float(lista2[i]))
    return resultado_sumaproducto
```
La operación que realiza la función "sumaproducto" es la siguiente:
<div align="center">resultado_sumaproducto = (lista1[0] * lista2[0]) + (lista1[1] * lista2[1]) + ... + (lista1[len(lista1)] * lista2[len(lista 2)])</div>

Cuando el comando elegido sea el **2** se imprimirá la tirilla de compra. Para esto se creará una variable (compra_total) para guardar el valor de la sumaproducto de los elementos de las listas _precio_ y _cantidad_. Se creará otra variable (descuento_compra) para almacenar el valor retornado por la función descuento(compra_total). Una tercera variable (compra_con_descuento) será el valor de la compra después del descuento.

``` python
    elif comando[0] == '2':
        compra_total = sumaproducto(precio, cantidad)
        descuento_compra = descuento(compra_total)
        compra_con_descuento = int(compra_total - descuento_compra)
```
Para realizar la impresión se usará la función print. Recuerde que `\n` se utiliza para imprimir una nueva línea y la parte `sep=""` define que el separador entre elementos del `print` es vació en vez del espacio " " por defecto.

Al momento de imprimir los elementos almacenados en las listas _nombre_, _cantidad_ y _precio_ se utilizará un ciclo `for` para recorrer estas listas e ir imprimiendo los elementos en el orden en que fueron ingresados por el usuario.
``` python

        print('Centro Comercial Unaleño', '\nCompra más y Gasta Menos', '\nNIT: 899.999.063', '\nCliente: ', comando[1], '\nArt Cant Precio', sep='')
        for i in range(len(nombre)):
            print(nombre[i], ' x', cantidad[i], ' $', int(precio[i])*int(cantidad[i]), sep='')      
        print('Total: $', compra_con_descuento, '', '\nEn esta compra tu descuento fue $', descuento_compra, '\nGracias por tu compra', '\n---', sep='')
```
Para terminar, se borrarán los valores de las listas _nombre_, _precio_ y _cantidad_ para permitir al usuario registrar una nueva compra.
``` python
        nombre = []
        precio = []
        cantidad = []
```
## Créditos
[Jaime Andres Tamayo Cardenas](https://github.com/jtamayoc95 "jtamayoc95")
