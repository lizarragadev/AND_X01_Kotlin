
/**
 * @author Gustavo Lizárraga
 *
 * Si vemos acá, en ningún lugar llamamos a la instrucción init,
 * ya que se ejecuta automáticamente con el objeto.
 *
 * */

fun main() {
    val p1 = Persona("Gustavo", 28)
    p1.imprimePersona()

    val p2 = Persona("Valeria", -5)
    p2.imprimePersona()
}