
/**
 * @author Gustavo Lizárraga
 *
 * Creación de Listas inmutables en Kotlin.
 * También podemos hacer uso de List para crear la colección.
 *
 * */

fun main() {
    var lista1: List<Int> = List(5) {cargarLista()}
    println(lista1)
}

fun cargarLista(): Int {
    print("Ingrese un entero: ")
    return readLine()!!.toInt()
}
