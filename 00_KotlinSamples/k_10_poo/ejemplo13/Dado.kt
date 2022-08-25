
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio utilizando SETs
 *
 * */

class Dado(valor: Int){
    var valor: Int = 1
        set(valor) {
            field = if (valor in 1..6)
                valor
            else
                1
        }

    init {
        this.valor = valor
    }

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    fun imprimir() = println("Valor del dado: $valor")
}