
/**
 * @author Gustavo Lizárraga
 *
 * También podemos simplificar mucho más los IFS con consultas directamente en la condición de
 * validadción de la estructura when.
 * Cabe mencionar que para el caso DEFAULT o por defecto de SWITCH en Java, acá se lo denota
 * con la instrucción ELSE y lo que debe suceder cuando no se cumple ninguna de las anteriores condiciones.
 *
 * */

fun main() {
    print("Ingrese coordenada x del punto: ")
    val x = readLine()!!.toInt()
    print("Ingrese coordenada y del punto: ")
    val y = readLine()!!.toInt()
    when {
        x > 0 && y > 0 -> println("El punto se encuentra en el primer cuadrante")
        x < 0 && y > 0 -> println("El punto se encuentra en el segundo cuadrante")
        x < 0 && y < 0 -> println("El punto se encuentra en el tercer cuadrante")
        x > 0 && y < 0 -> println("El punto se encuentra en el cuarto cuadrante")
        else -> println("El punto se encuentra en un eje")
    }
}