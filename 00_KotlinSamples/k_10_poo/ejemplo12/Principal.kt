
/**
 * @author Gustavo Lizárraga
 *
 * Y como vemos, no es necesario llamar a los getters y setters
 * ya que implícitamente se están ejecutando.
 *
 * */

fun main() {
    val persona = Persona()
    persona.nombre = "gustavo"
    persona.edad = -2
    println(persona.nombre)
    println(persona.edad)

    val persona2 = Persona()
    persona2.nombre = "josue"
    persona2.edad = 20
    println(persona2.nombre)
    println(persona2.edad)
}