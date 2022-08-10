
/**
 * @author Gustavo Lizárraga
 *
 * Para poder definir un rango inverso es decir que en cuestion de numeros enteros
 * la accion sea decrementar en N unidades, podemos utilizar la instruccion REVERSED
 * con esa accion hacemos que un rango de datos que le asignamos vaya en forma inversa.
 *
 * */

fun main() {
    val rangoLetras = ('a'..'z').reversed()
    for(letra in rangoLetras) {
        print("$letra, ")
    }
}