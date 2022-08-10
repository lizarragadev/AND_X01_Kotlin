
/**
 * @author Gustavo Lizárraga
 *
 * Otra forma de hacer rangos inversos es colocar de donde a donde queremos ir
 * pero debemos utilizar la instruccion DOWNTO, utilizar esta forma o REVERSED
 * da el mismo resultado.
 *
 * */

fun main() {
    val rangoLetras = 'z' downTo 'a'
    for(letra in rangoLetras) {
        print("$letra, ")
    }
}