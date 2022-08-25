
/**
 * @author Gustavo Lizárraga
 *
 * Como ya vimos, colocamos la instrucción OPEN al principio
 * de la declaración de la clase y las funciones que necesitamos
 * que sean heredables.
 *
 * */

open class Calculadora(val valor1: Double, val valor2: Double ){
    var resultado: Double = 0.0
    fun sumar() {
        resultado = valor1 + valor2
    }

    fun restar() {
        resultado = valor1 - valor2
    }

    fun multiplicar() {
        resultado = valor1 * valor2
    }

    fun dividir() {
        resultado = valor1 / valor2
    }

    fun imprimir() {
        println("Resultado: $resultado")
    }
}