
/**
 * @author Gustavo Lizárraga
 *
 * Creación de Maps inmutables en Kotlin.
 * Un par nada más es una colección que almacena un par de datos,
 * Ese par de datos se los crea con el objeto Pair, dentro podemos almacenar
 * cualquier tipo de dato, pero siempre se lo llamará a traves de la
 * clave que tiene el cuál es el primer elemento.
 *
 * */

fun main() {
    val paises = mapOf(
                    Pair("argentina", 4000),
                    Pair("brasil", 5000000),
                    Pair("bolivia", 30000))
    println(paises)

    for ((clave, valor) in paises) {
        println("Para la clave $clave su valor es $valor.")
    }
    // cantidad de habitantes de brasil
    val cantHabBrasil = paises["brasil"]
    println("Cantidad de hab de Brasil: $cantHabBrasil")
    // cantidad total de habitantes de todos los paises
    var suma = 0
    paises.forEach { suma += it.value }
    println("la suma de todos los paises es: $suma")

}