
/**
 * @author Gustavo Lizárraga
 *
 * Como podemos ver, como argumento o atributo de éste objeto
 * llamamos a un ENUM que nos facilita el tener datos
 * estáticos y no tener que escribirlos cada vez.
 *
 * */

class Carta(val tipo: TipoCarta, val valor: Int) {
    fun imprimir() {
        println("Carta $tipo y su valor es $valor")
    }
}