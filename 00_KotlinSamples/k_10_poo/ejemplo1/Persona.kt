
/**
 * @author Gustavo Lizárraga
 *
 * Para crear un objeto en Kotlin, solamente es necesario declarar
 * las variables o atributos que tendrá y si es necesario crear
 * las funciones y/o procedimientos que creas necesario.
 *
 * */

class Persona {
    var nombre = ""
    var edad = 0

    fun inicializar(n: String, e: Int) {
        this.nombre = n
        this.edad = e
    }

    fun imprimir() {
        println("Nombre: $nombre - Edad: $edad")
    }

    fun esMayorDeEdad() {
        if(edad >= 18)
            println("Es mayor de edad.")
        else
            println("No es mayor de edad.")
    }
}
