
/**
 * @author Gustavo Lizárraga
 *
 * Implementamos la función volar con un comportamiento distinto
 * para un Avion.
 *
 * */

class Avion(var empresa: String) : ComportamientoInterface {
    override fun volar() {
        println("Este es el comportamiento de mi avion: $empresa")
    }

}