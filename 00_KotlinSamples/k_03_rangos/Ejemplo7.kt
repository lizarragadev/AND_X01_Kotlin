
/**
 * @author Gustavo Lizárraga
 *
 * Si necesitamos imprimir el indice de un rango de datos lo creamos con una segunda variable
 * y utilizamos la instrucción withIndex para decir que aparte de obtener los datos de determinado
 * lote o rango, también obtener la posición del mismo.
 *
 * */

fun main() {
    for(i in 100 downTo 2 step 2) {
        print("$i, ")
    }
    println()
    for((index, i) in ((2..100).reversed() step 2).withIndex()) {
        print("$index, ")
    }
}