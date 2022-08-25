
/**
 * @author Gustavo Lizárraga
 *
 * Creación de matrices en Kotlin
 * Para manejar matrices en Kotlin debemos crear un arrayOf con vectores y cada vector
 * simboliza una fila de la matriz.
 *
 * */

fun main() {
    val rows = 2
    val columns = 3
    val firstMatrix = arrayOf(intArrayOf(2, 3, 4), intArrayOf(5, 2, 3))
    val secondMatrix = arrayOf(intArrayOf(-4, 5, 3), intArrayOf(5, 6, 3))
    val sum = Array(rows) { IntArray(columns) }
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j]
        }
    }
    println("La suma de las dos matrices es: ")

    for (row in sum) {
        for (column in row) {
            print("$column    ")
        }
        println()
    }
}