
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio aplicando lectura de datos de teclado, if else y operadores matemáticos.
 *
 * */

fun main() {
    print("Ingrese el primer valor: ")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor: ")
    val valor2 = readLine()!!.toInt()
    if (valor1 < valor2) {
        val suma = valor1.plus(valor2)
        val resta = valor1.minus(valor2)
        println("La suma de los dos valores es: $suma")
        println("La resta de los dos valores es: $resta")
    } else {
        val producto = valor1.times(valor2)
        val division = valor1.div(valor2)
        println("El producto de los dos valores es: $producto")
        println("La división de los dos valores es: $division")
    }
}