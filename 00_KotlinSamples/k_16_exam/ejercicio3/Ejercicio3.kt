
/**
 *
 * Ingresar 2 lotes de 3 números y de cada lote imprimir:
 * a) El número mayor.
 * b) El número menor.
 * c) El número central.
 * Sin utilizar ni un IF ni WHEN (Si pueden, sino como puedan).
 *
 * */

fun main() {
    for (i in 1..2) {
        var count = 0
        var numbers = mutableListOf<Int>()
        while (count < 3) {
            print("Ingrese número ${count+1}: ")
            val num = readLine()!!.toInt()
            numbers.add(num)
            count++
        }
        numbers.sort()
        println("Mayor: ${numbers.last()}")
        println("Menor: ${numbers.first()}")
        println("Central: ${numbers[1]}")
        println()
    }
}