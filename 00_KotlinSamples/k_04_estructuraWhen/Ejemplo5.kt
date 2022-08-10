
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio utilizando la estructura WHEN.
 *
 * */

fun main() {
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    do {
        print("Ingrese el peso de la pieza (0 para finalizar): ")
        val peso = readLine()!!.toDouble()
        when {
            peso > 10.2 -> cant1++
            peso >= 9.8 -> cant2++
            peso > 0 -> cant3++
        }
    } while(peso != 0.0)
    println("Piezas aptas: $cant2")
    println("Piezas con un peso superior a 10.2: $cant1")
    println("Piezas con un peso inferior a 9.8: $cant3");
    val suma = cant1.plus(cant2).plus(cant3)
    println("Cantidad total de piezas procesadas: $suma")
}