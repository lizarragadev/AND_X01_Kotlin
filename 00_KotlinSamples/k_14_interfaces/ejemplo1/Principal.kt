
/**
 * @author Gustavo Lizárraga
 *
 * Como podemos ver, los objetos PuntoPlano y PuntoEspacio
 * tienen en común una función llamada imprimir, pero si vemos
 * en cada clase, la funcionalidad de ´imprimir´ es distinta
 * para cada caso.
 *
 * */

fun main() {
    val puntoPlano1 = PuntoPlano(10, 4)
    puntoPlano1.imprimir()
    val puntoEspacio1 = PuntoEspacio(20, 50, 60)
    puntoEspacio1.imprimir()
}
