
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de creación de procedimiento con IF INLINE internos.
 *
 * */

fun main() {
    print("Ingrese numero 1: ")
    val nu1 = readLine()!!.toInt()
    print("Ingrese numero 2: ")
    val nu2 = readLine()!!.toInt()
    println("El mayor entre $nu1 y $nu2 es ${retornaMayor(nu1, nu2)}")
}

fun retornaMayor(v1: Int, v2: Int) : Int {
    return if(v1 > v2) v1 else v2
}