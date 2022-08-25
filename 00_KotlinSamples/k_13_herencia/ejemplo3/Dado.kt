
/**
 * @author Gustavo Lizárraga
 *
 * Clase que será heredable.
 *
 * */

open class Dado{
    protected var valor: Int = 1
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    open fun imprimir() {
        println("$valor")
    }
}