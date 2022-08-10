
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio de fusión con estructura WHEN y DO WHILE
 *
 * */

fun main() {
    var cant = 0
    var cantMenor50 = 0
    var cantMayor50 = 0
    var cantPar = 0
    var cantImpar = 0
    do {
        print("Ingrese un numero [0 para finalizar]: ")
        val valor = readLine()!!.toInt()
        when {
            valor % 2 == 0 -> cantPar++
            valor % 2 != 0 -> cantImpar++
        }
        when {
            valor in 1..50 -> cantMenor50++
            valor in 51..100 -> cantMayor50++
        }
        cant++
    } while (valor != 0)
    println("Cantidad de numeros leidos: $cant")
    println("Cantidad de numeros pares: $cantPar")
    println("Cantidad de numeros impares: $cantImpar")
    println("Numeros del 1 al 50: $cantMenor50")
    println("Numeros del 51 al 100: $cantMayor50")

}