
/**
 * @author Gustavo Lizárraga
 *
 * Para poder acceder al valor estático de un ENUM solamente
 * llamamos al enum y el valor que queramos obtener.
 *
 * */

fun main() {
    val carta1 = Carta(TipoCarta.ESPADA, 3)
    carta1.imprimir()

    val carta2 = Carta(TipoCarta.TREBOL, 9)
    carta2.imprimir()
}