# Ciclo 1<br> Reto para la semana 1: Lectura y Cálculo de Ganancia

## Enunciado
El Centro Comercial Unaleño desea comenzar a crear un carrito de compras. Para esto se requiere una tarea que será de gran utilidad a futuro: Leer y clasificar la información sobre un producto. 

En esta ocasión se deberá leer el nombre de un producto, el costo unitario, el precio de venta al público y la cantidad de unidades disponibles. Dada esta lectura se debe imprimir el valor total que puede ganar el centro comercial por dicho producto.

<br>

**Entrada**: Los valores de cada producto en una línea de código diferente. En el siguiente orden:
- El nombre del producto.
- El costo unitario CU.
- El precio de venta al público PVP.
- La cantidad de unidades disponibles.

<br>

**Salida**: Se debe mostrar lo siguiente:
- El texto “Producto” sin comillas acompañado del nombre del producto.
- El texto “CU:” sin comillas acompañado del costo unitario del mismo.
- El texto “PVP:” sin comillas acompañado del precio de venta al público.
- El texto “Unidades Disponibles:” acompañado de las unidades disponibles.
- El texto “Ganancia:” acompañado del cálculo de la ganancia por ese producto. 

<br>

**Ejemplo:**
|Entrada |Salida |
| --- | --- |
| Chocolatinas Cohete <br>300 <br>550 <br>1000 | Producto: Chocolatinas Cohete <br>CU: $300 <br>PVP: $550 <br>Unidades Disponibles: 1000 <br>Ganancia: $250000                                        

<br>

## Solución
Primero, se utiliza la función `input` para definir las variables de variables de entrada.
``` python
nombre = input("Producto ")
CU = int(input("Costo Unitario "))
PVP = int(input("Precio de Venta al Público "))
Q = int(input("Cantidad de Unidades Disponibles "))
```
Nótese que se utiliza la función `int` para parsear (pasar de un tipo de variable a otro) las variables de entrada de tipo _String_ (cadena de caracteres) en _Int_ (número entero). 

Ahora, para imprimir las variables se utiliza la función `print`. 
``` python
print("Producto " + nombre) 
print("CU: $" + str(CU))
print("PVP: $" + str(PVP))
print("Unidades Disponibles: " + str(Q))
```
En este caso, se debe usar la función `str` para parsear las variables a tipo _String_ y evitar errores al momento de imprimir los mensajes.

Para calcular la ganancia, se creará una nueva variable en la cuál se realizará la operación de múltiplicar la cantidad por la diferencia entre el precio de venta al público y el costo unitario.
``` python
ganancia = (PVP-CU)*Q
print("Ganancia: $" + str(ganancia))
```

Si lo desea puede saltarse el paso de crear la variable ganancia y calcular el resultado dentro del print. 
``` python
print("Ganancia: $" + str((PVP-CU)*Q))
```
## Créditos
[Jaime Andres Tamayo Cardenas](https://github.com/jtamayoc95 "jtamayoc95")
