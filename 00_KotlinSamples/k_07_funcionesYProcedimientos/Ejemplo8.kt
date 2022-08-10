
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de funciones en línea utilizando IF INLINE
 *
 * Ingresar dos valores de teclado y verificar el mayor de ellos
 *
 * */

fun main() {
    print("Ingrese numero 1: ")
    val nume1 = readLine()!!.toInt()
    print("Ingrese numero 2: ")
    val nume2 = readLine()!!.toInt()
    println("El mayor entre $nume1 y $nume2 es ${retMayor(nume1, nume2)}")
}

fun retMayor(n1: Int, n2: Int) = if(n1 > n2) n1 else n2

