
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo básico de creación de variables.
 * VAR : Variable mutable.
 * VAL : Variable inmutable.
 *
 * */

fun main() {
    val valor1 = 4
    val valor2 = 2
    var resultado = valor1.plus(valor2)
    println("La suma es: $resultado")
    resultado = valor1.minus(valor2)
    println("La resta es: $resultado")
    resultado = valor1.times(valor2)
    println("La mutiplicacion es: $resultado")
    val resu = valor1.div(valor2).toDouble()
    println("La division es: $resu")
}
