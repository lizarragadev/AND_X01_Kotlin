
/**
 * @author Gustavo Lizárraga
 *
 * HERENCIA:
 * Para poder decir que una clases es heredable debemos asignar
 * la palabra reservada: OPEN antes de la declaración de dicha
 * clase, también eso va para las funciones, entonces si queremos
 * decir que una clase o función puede ser heredable, colocamos
 * la palabra reservada OPEN, caso contrario no se podrá heredar
 * ninguno de sus métodos o funciones.
 *
 * */

open class Persona(val nombre: String, val edad: Int) {
    open fun imprimir() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }
}