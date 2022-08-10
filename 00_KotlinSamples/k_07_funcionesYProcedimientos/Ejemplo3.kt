
/**
 * @author Gustavo Lizárraga
 *
 * Creación de procedimientos y llamados desde una estructura WHEN.
 *
 * Enunciado del ejercicio:
 * Ingresar 1 dato entero de teclado (el lado de un cuadrado),
 * E ingresar el texto ["perimetro" o "superficie"] y validarlo con la
 * estructura WHEN para sacar alguno de los dos valores utilizando
 * procedimientos (perimetro: lado * 4 , superficie: lado * lado)
 *
 * */

fun main() {
    print("Ingrese el valor de un lado del cuadrado: ")
    val lado = readLine()!!.toInt()
    print("Quiere calcular el perímetro o superficie? [superficie/perimetro]")
    val calc = readLine()
    when(calc) {
        "superficie" -> mostrarSuperficie(lado)
        "perimetro" -> mostrarPerimetro(lado)
        else -> errorIngreso()
    }
}

fun mostrarSuperficie(l: Int) {
    val superficie = l.times(l)
    print("La superficie es: $superficie")
}

fun mostrarPerimetro(l: Int) {
    val perimetro = l.times(4)
    print("El perimetro es: $perimetro")
}

fun errorIngreso() {
    println("Cometió un error al escribir la instrucción.")
}
