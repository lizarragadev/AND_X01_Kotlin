
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio de objeto con variables privadas.
 * Al utilizar el modificador de acceso privado, hacemos que esa variable
 * y/o funcion/procedimiento solamente puedan ser accedidos desde esa misma
 * clase y no así desde otras clases.
 * En este caso las variables valor1 y valro2 solamente pueden ser accedidas
 * desde ésta clase y no desde otras y lo mismo con los procedimientos
 * sumar y restar.
 *
 * */

class Operaciones {
    private var valor1: Int = 0
    private var valor2: Int = 0

    fun cargar() {
        print("Ingrese primer valor:")
        valor1 = readLine()!!.toInt()
        print("Ingrese segundo valor:")
        valor2 = readLine()!!.toInt()
        sumar()
        restar()
    }

    private fun sumar() {
        val suma = valor1 + valor2
        println("La suma de $valor1 y $valor2 es $suma")
    }

    private fun restar() {
        val resta = valor1 - valor2
        println("La resta de $valor1 y $valor2 es $resta")
    }
}