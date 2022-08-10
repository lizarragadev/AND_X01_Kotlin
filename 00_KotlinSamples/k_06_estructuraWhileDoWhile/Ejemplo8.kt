
/**
 * @author Gustavo Lizárraga
 *
 * Fusión de manejo de DO WHILE juntamente con la estructura WHEN y sus condicionales.
 *
 * */

fun main() {
    val num1 = 5
    val num2 = 9
    do {
        print("Ingrese operador: ")
        val oper = readLine()
        when(oper) {
            "+" -> print("La suma de $num1 y $num2 es ${num1.plus(num2)}")
            "-" -> print("La resta de $num1 y $num2 es ${num1.minus(num2)}")
            "*" -> print("La multiplicacion de $num1 y $num2 es ${num1.times(num2)}")
            "/" -> print("La division de $num1 y $num2 es ${num1.div(num2)}")
        }
        println()
    } while(oper != "")
}