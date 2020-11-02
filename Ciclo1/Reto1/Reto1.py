# Carrito de Mercado

nombre = input("Producto ") # input para ingresar en la terminal 
CU = int(input("Costo Unitario ")) # int() para que python reconozca que es un número
PVP = int(input("Precio de Venta al Público "))
Q = int(input("Cantidad de Unidades Disponibles "))

print("Producto " + nombre) 
print("CU: $" + str(CU))
print("PVP: $" + str(PVP))
print("Unidades Disponibles: " + str(Q))
ganancia = (PVP-CU)*Q
print("Ganancia: $" + str(ganancia))