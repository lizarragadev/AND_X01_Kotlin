
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de uso de FOR con ingreso de valores por teclado.
 *
 * */

fun main() {
    var suma = 0
    for(i in 1..10) {
        print("Ingrese valor $i: ")
        val valor = readLine()!!.toInt()
        suma += valor
    }
    println("La suma de los valores ingresados es: $suma")
    val promedio = suma.div(10)
    println("Su promedio es $promedio")
}