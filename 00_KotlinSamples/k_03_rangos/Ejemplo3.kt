
/**
 * @author Gustavo Lizárraga
 *
 * En los rangos también se puede realizar una búsqueda de algun caracter
 * simplement utilizando la instrucción IN con el cuál preguntamos
 * SI la letras B se encuentra en o IN el lote de datos que le enviamos.
 *
 * */

fun main() {
    val rangoCarac = 'a'..'z'
    val letraABuscar = 'B'

    if(letraABuscar in rangoCarac) {
        print("La letra $letraABuscar SI está en el rango de $rangoCarac")
    } else {
        print("La letra $letraABuscar NO está en el rango de $rangoCarac")
    }
}