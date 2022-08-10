
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de funciones en línea utilizando WHEN
 *
 * Convertir a literal los numeros del 1 al 10 con funciones en linea.
 *
 * */

fun main() {
    for (i in 1..10)
        print("${convertirLiteral(i)}, ")
}

fun convertirLiteral(pos: Int) =
     when(pos) {
         1 -> "Uno"
         2 -> "Dos"
         3 -> "Tres"
         4 -> "Cuatro"
         5 -> "Cinco"
         6 -> "Seis"
         7 -> "Siete"
         8 -> "Ocho"
         9 -> "Nueve"
         10 -> "Diez"
        else -> ""
    }

