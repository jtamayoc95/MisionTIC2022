import math

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

cantidad_articulos = int(input())
compras = 0

print("Centro Comercial Unaleño", "Compra más y Gasta Menos", "NIT: 899.999.063", sep="\n" )

for i in range(cantidad_articulos):
    nombre = str(input())
    precio = int(input())
    print(nombre, " $", precio, sep="")
    compras += precio

print("Total: $", compras-math.floor(int(descuento(compras))), sep="")
print("En esta compra tu descuento fue $", math.floor(int(descuento(compras))), sep="")
print("Gracias por tu compra")