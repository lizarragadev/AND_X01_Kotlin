
/**
 * @author Gustavo Lizárraga
 *
 * Creación de Listas inmutables en Kotlin.
 * Para el manejo de listas en Kotlin utilizamos la colección listOf el cuál devuelve un objeto de tipo: List
 * el cuál es un objeto inmutable, es decir que no podemos modificar nada del mismo.
 *
 * */

fun main() {
    var lista1 = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo")
    println("Imprimir la lista completa")
    println(lista1)
    println("Imprimir el primer elemento de la lista")
    println(lista1[0])
    println("Imprimir el primer elemento de la lista")
    println(lista1.first())
    println("Imprimir el último elemento de la lista")
    println(lista1.last())
    println("Imprimir el último elemento de la lista")
    println(lista1[lista1.size-1])
    println("Imprimir la cantidad de elementos de la lista")
    println(lista1.size)
    println("Recorrer la lista completa con un for")
    for(elemento in lista1)
        print("$elemento ")
    println()
    println("Imprimir el elemento y su posición")
    for(posicion in lista1.indices)
        print("[$posicion]${lista1[posicion]} ")
}