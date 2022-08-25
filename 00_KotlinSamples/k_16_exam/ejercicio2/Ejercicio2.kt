
/**
 * Ingresar 2 números de teclado y además ingresar por teclado
 * cualquier de los siguientes caractéres: +, -, *, /
 * Y realizar la operación dependiendo el caracter que haya
 * ingresado con las funciones de operaciones aritméticas.
 * En caso que ingrese un caracter distinto, imprimir que
 * ingresó un caracter inválido.
 *
 * Ejemplo:
 * Dato 1 de teclado: 5
 * Dato 2 de teclado: 7
 *
 * Caracter ingresado: +
 *
 * Impresión por pantalla: "La suma es 12"
 *
 * */

fun main() {
    print("Ingrese número 1: ")
    val a = readLine()!!.toInt()
    print("Ingrese número 2: ")
    val b = readLine()!!.toInt()
    println("********************")
    print("Ingrese la operación a realizar: ")
    var res = when(readLine()) {
        "+" -> "La suma es: ${a.plus(b)}"
        "-" -> "La resta es: ${a.minus(b)}"
        "*" -> "La multiplicación es: ${a.times(b)}"
        "/" -> "La división es: ${a.div(b).toFloat()}"
        else -> "Caracter inválido"
    }
    println("*** $res ***")
    print("********************")
}