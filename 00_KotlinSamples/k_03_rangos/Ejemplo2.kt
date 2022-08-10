
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo con rangos, se puede asignar un rango de letras,
 * los rangos son básicamente lotes de datos que existen, en este caso
 * se utiliza todas las letras del alfabeto inglés.
 *
 * */

fun main() {
    val rangoLetras = '@'..'z'
    for(i in rangoLetras) {
        print("$i, ")
    }
}