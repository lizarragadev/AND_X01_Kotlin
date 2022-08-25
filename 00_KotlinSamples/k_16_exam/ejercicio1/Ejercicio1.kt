
/**
 * Generar la primera letra de tu nombre y la primera letra de tu apellido
 * con cualquier caracter, por ejemplo * o #.
 * Ejemplo: Gustavo Lizarraga
 * 
 *  # # # #   #
 *  #         #
 *  #         #
 *  #   # #   #
 *  #     #   #
 *  # # # #   # # # #
 *
 * */

fun main() {
    val firstMatrix = arrayOf(
        intArrayOf(1, 1, 1, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 1, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 0, 1, 1, 1, 1))

    firstMatrix.forEach { it ->
        it.forEach { it2 ->
            if(it2 == 1)
                print("# ")
            else
                print("  ")
        }
        println()
    }
}
