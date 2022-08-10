
/**
 * @author Gustavo Lizárraga
 *
 * Creación de funciones INLINE o funciones en una sola línea.
 * las funciones inline funcionan de la siguiente manera:
 * - No necesitamos una sentencia RETURN
 * - Tampoco necesitamos decirle el tipo de retorno de la función.
 * - Se eliminan las llaves que encierran la funcionalidad de la función.
 * - Solamente se coloca un igual y luego de ello la o las instrucciones para dar funcionalidad a la función.
 *
 * */

fun main() {
    print("Ingrese el valor de un lado de un cuadrado: ")
    val la = readLine()!!.toInt()
    val superficie = retSuperficie(la)
    println("La superficie del cuadrado es: $superficie")
}

fun retSuperficie(l: Int) = l.times(l)
