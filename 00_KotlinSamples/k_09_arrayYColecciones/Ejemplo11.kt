
/**
 * @author Gustavo Lizárraga
 *
 * Creación de Maps mutables en Kotlin.
 * También en lugar de utilizar el objeto Pair para crear un par de datos,
 * podemos utilizar la instrucción ´to´ el cuál será quién separa el primer
 * dato del segundo.
 *
 * */

fun main() {
    val conjunto = mutableSetOf(2, 4, 8, 1, 5, 2)
    println(conjunto)
    conjunto.add(5)
    conjunto.add(4)
    println(conjunto)
    if(8 in conjunto)
        print("El numero 5 Si existe")
    else
        print("El numero 5 No existe")
    val sum = conjunto.count{ it > 5 }
    println("La suma de mayores a 5 es: $sum")
}