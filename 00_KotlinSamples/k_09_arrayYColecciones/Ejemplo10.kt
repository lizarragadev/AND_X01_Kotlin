
/**
 * @author Gustavo Lizárraga
 *
 * Creación de Maps mutables en Kotlin.
 * También en lugar de utilizar el objeto Pair para crear un par de datos,
 * podemos utilizar la instrucción ´to´ el cuál será quién separa el primer
 * dato del segundo.
 *
 * Ejercicio:
 * Crear un mapa que permita almacenar 5 artículos, utilizar como clave el nombre
 * de productos y como valor el precio del mismo. Desarrollar además las funciones de:
 * 1) Imprimir en forma completa el diccionario
 * 2) Mostrar la cantidad de artículos con precio superior a 20.
 *
 * */

fun main() {
    val producto = mutableMapOf(
        "papas" to 22.5f,
        "manzanas" to 3.5f,
        "mandarinas" to 5f,
        "pomelos" to 27.5f)
    imprimirMap(producto)
    cantidadPrecioMayor20(producto)
}

fun imprimirMap(prod: Map<String, Float>) {
    prod.forEach { println("${it.key} tiene un precio de ${it.value}") }
}

fun cantidadPrecioMayor20(prod: Map<String, Float>) {
    val cant = prod.count { it.value > 20 }
    println("Cantidad de productos con precio superior a 20: $cant")
}