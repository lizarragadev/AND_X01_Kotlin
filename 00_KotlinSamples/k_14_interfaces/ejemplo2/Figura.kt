
/**
 * @author Gustavo Lizárraga
 *
 * Declaramos 2 funciones e implementamos una con la misma funcionalidad
 * para cualquier objeto que quiera hacer uso de esta interface.
 *
 * */

interface Figura {
    fun calcularSuperficie(): Int
    fun calcularPerimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}