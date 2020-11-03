# Ciclo 1<br> Reto para la semana 2: Tirilla de Compra y Descuento

## Enunciado
El Centro Comercial Unaleño continúa trabajando en la creación de un carrito de compras. Para esto se requiere la creación de varias tareas que deben programarse en funciones detalladas a continuación:

**Lectura de n artículos**

Se requiere leer una cantidad n de artículos que representan la compra de un cliente.
Un artículo por ahora lleva nombre y precio.
Esta función debe retornar la tirilla de compras en texto.

**Cálculo de descuento**
- Dado el valor total de la compra se pretende realizar una nueva campaña titulada compra más y gasta menos con los siguientes descuentos:
  - Por compras mayores a 150000 lleva un 10% de descuento.
  - Por compras mayores a 300000 lleva un 15% de descuento.
  - Por compras mayores a 700000 lleva un 20% de descuento.
Dadas las dos funcionalidades anteriores ayude al centro comercial a generar una tirilla de compra donde se muestren los productos comprados, el valor a pagar y el descuento que se le hizo al cliente.

**Entrada**: Diferentes datos en el siguiente orden:

- La cantidad de artículos en el carrito.
- El nombre y el precio de cada artículo en una línea diferente.

**Salida**: Se debe mostrar lo siguiente:

- La tirilla de compra en el formato especificado
**Nota:** Como el centro comercial está siendo muy generoso con los descuentos, el valor a cobrar en caso de tener centavos se debe aproximar a techo usando la [función `ceil` de python](https://www.tutorialspoint.com/python/number_ceil.htm "función ceil").


**Ejemplo 1:**
|Entrada |Salida |
| --- | --- |
|3<br> Chocolatinas Cohete<br> 300<br> Mora<br> 1000<br> Pan de Maiz<br> 300 | Centro Comercial Unaleño Compra más y Gasta Menos<br> NIT: 899.999.063<br> Chocolatinas Cohete $300<br> Mora $1000<br> Pan de Maiz $300<br> Total: $1600<br> En esta compra tu descuento fue $0<br> Gracias por tu compra |

**Ejemplo 2:**
|Entrada |Salida |
| --- | --- |
| 2<br> Televisor<br> 1500000<br> Teatro en Casa<br> 450000 |Centro Comercial Unaleño<br> Compra más y Gasta Menos<br> NIT: 899.999.063<br> Televisor $1500000<br> Teatro en Casa $450000<br> Total: $1560000<br> En esta compra tu descuento fue $390000<br> Gracias por tu compra |

## Solución
En primer lugar se va a definir el número de artículos a ingresar.
``` pyhton
 cantidad_articulos = int(input())
```
Para ingresar el nombre y el precio de cada artículo en una línea diferente se utilizará un ciclo `for` .
``` python
for i in range(cantidad_articulos):
    nombre = str(input())
    precio = int(input())
```
En la salida se debe mostrar el nombre del producto seguido por el precio y el símbolo "$", por ejemplo: "Mora $1000". Para resolver esto, es posible modificar el ciclo `for` para que incluya la impresión de las entradas (nombre y precio) en el formato deseado.
``` python
for i in range(cantidad_articulos):
    nombre = str(input())
    precio = int(input())
    print(nombre, " $", precio, sep="")
```
Para calcular el descuento se definirá una función que permita calcular el descuento según el monto compra.
``` python
def descuento(compras):
    if compras <= 150000:
        descuento = compras - compras*(1-0)
        return descuento
    elif 150000 < compras <= 300000:
        descuento = compras - compras*(1-0.1)
        return descuento
    elif 300000 < compras <= 700000:
        descuento = compras - compras*(1-0.15)
        return descuento
    elif compras > 700000:
        descuento = compras - compras*(1-0.2)
        return descuento
```
Ahora, para calcular el total de los productos comprados, se inicializará la variable compras. Esta variable se utilizará en el ciclo `for`para guardar la sumatoria de los precios de los productos ingresados.
``` python
compras = 0
for i in range(cantidad_articulos):
    nombre = str(input())
    precio = int(input())
    print(nombre, " $", precio, sep="")
    compras += precio
```
Ya con la variable de las compras definida se pueden hacer las impresiones finales y llamar a la función descuento para calcular para conocer los valores finales. 
``` python
print("Total: $", (int(descuento(compras))), sep="")
print("En esta compra tu descuento fue $", (int(descuento(compras))), sep="")
print("Gracias por tu compra")
```
En el ejercicio hacían la siguiente aclaración:
>Como el centro comercial está siendo muy generoso con los descuentos, el valor a cobrar en caso de tener centavos se debe aproximar a techo usando la función `ceil` de python.

Para utilizar esta función debemos importar el paquete `math` de python.
``` python
import math
```

Sin embargo, la función `ceil` redondea hacia arriba, es decir, el centro comercial no estaría siendo generoso sino tacaño. 

Debido a lo anterior, se usará la [función `floor` de python](https://www.tutorialspoint.com/python/number_floor.htm "función floor") para no cobrar los centavos al cliente.
``` python
print("Total: $", compras-math.floor(int(descuento(compras))), sep="")
print("En esta compra tu descuento fue $", math.floor(int(descuento(compras))), sep="")
print("Gracias por tu compra")
```
**Nota:** Al correr el código en la consola puede creer que la impresión está siendo erronea. No obstante, el evaluador tiene en cuenta las entradas y las salidas, no importa el orden en que aparezcan sino que las salidas aparezcan en el orden previsto y las entradas se ingresen en el orden solicitado.

Es posible modificar el código utilizando una lista para guardar el nombre y el precio de los productos ingresados y luego operar a partir de la lista. Ya que, el tema de listas no se ha visto a la fecha, no se usará esta solución.

## Créditos
[Jaime Andres Tamayo Cardenas](https://github.com/jtamayoc95 "jtamayoc95")
