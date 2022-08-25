
/**
 * @author Gustavo Lizárraga
 *
 * Otra forma de poder crear un constructor con varios argumentos,
 * es crear el objeto de la siguiente forma, enviandole entre paréntesis los atributos
 * que tendrá y creando el constructor que tendrá por defecto.
 * Cabe recalcar que de ésta forma se están realizando dos acciones en una:
 * Crear el objeto con sus atributos y crear un contructor con dos argumentos.
 *
 * */

class Persona (var nombre: String, var edad: Int) {

    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}