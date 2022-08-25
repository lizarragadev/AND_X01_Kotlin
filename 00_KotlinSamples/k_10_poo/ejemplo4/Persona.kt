
/**
 * @author Gustavo Lizárraga
 *
 * Una forma para poder crear un constructor con argumentos es colocar
 * la palabra reservada ´constructor´ despues del nombre de la clase y seguido
 * de paréntesis colocar los atributos de ingreso a la clase.
 *
 * */

class Persona constructor(nombre: String, edad: Int) {
    var nombre: String = nombre
    var edad: Int = edad

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