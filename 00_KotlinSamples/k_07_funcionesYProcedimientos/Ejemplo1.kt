
/**
 * @author Gustavo Lizárraga
 *
 * Creación de procedimientos.
 * Para la creación de un procedimiento (que no devuelve un valor) necesitamos
 * anteceder la palabra reservada FUN antes del nombre y los argumentos
 * ingresan en el siguiente formato: nombreVariable: TipoDeDato, ...
 *
 * */

fun main() {
    mostrarMensaje("El programa realiza la suma de dos numeros")
    cargarSuma()
    mostrarMensaje("Fin del programa")
}

fun cargarSuma() {
    print("Ingrese el primer valor: ")
    val valor1 = readLine()!!.toInt()
    print("Ingrese segundo valor: ")
    val valor2 = readLine()!!.toInt()
    val resultado = valor1.plus(valor2)
    println("La suma de $valor1 y $valor2 es $resultado")
}

fun mostrarMensaje(cadena: String) {
    println("****************************")
    println(cadena)
    println("****************************")
}