
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de creación y uso de estructura WHILE, no cambia nada con relación a Java.
 *
 * */

fun main() {
    var x = 1
    var suma = 0
    while (x <= 10) {
        print("Ingrese valor $x: ")
        val valor=readLine()!!.toInt()
        suma = suma.plus(valor)
        x = x.plus(1)
    }
    println("La suma de los 10 valores ingresados es $suma")
    val promedio = suma.div(10)
    println("El promedio es $promedio")
}