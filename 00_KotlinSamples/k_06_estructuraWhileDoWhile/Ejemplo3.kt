
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de creación y uso de estructura WHILE, con operaciones.
 *
 * */

fun main() {
    print("Cuantas piezas procesará: ")
    val n = readLine()!!.toInt()
    var x = 1
    var cantidad = 0
    while (x <= n) {
        print("Ingrese la medida de la pieza $x: ")
        val largo = readLine()!!.toDouble()
        if (largo in 1.20..4.30)
            cantidad = cantidad.plus(1)
        x = x.plus(1)
    }
    print("La cantidad de piezas aptas son: $cantidad")
}