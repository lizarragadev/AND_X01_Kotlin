
/**
 * @author Gustavo Lizárraga
 *
 * También con la estructura WHEN podemos mencionar si la variable de ingreso
 * a dicha estructura es alguna de las de la condición, como muestra el
 * siguiente ejemplo.
 *
 * */

fun main() {
    var cant1_3 = 0
    var cant2_4 = 0
    var cantX = 0
    for(i in 1..10) {
        print("Ingrese valor $i: ")
        val dato = readLine()!!.toInt()
        when(dato) {
            1, 3 -> cant1_3++
            2, 4 -> cant2_4++
            else -> cantX++
        }
    }
    println("Cantidad de numeros 1 y 3: $cant1_3")
    println("Cantidad de numeros 2 y 4: $cant2_4")
    println("Cantidad de numeros X: $cantX")
}