
/**
 * @author Gustavo Lizárraga
 *
 * Realizamos la implementación de las funciones
 * de la interface Figura
 *
 * */

class Rectangulo(val ladoMayor:Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }

    override fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}