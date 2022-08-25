
/**
 * @author Gustavo Lizárraga
 *
 * Existe una instruccion llamada init { }
 * La cuál se ejecuta despues de que se crea el objeto y se ejecuta un constructor,
 * es decir que si o si se ejecutará y dentro de el es común colocar
 * código para validar los datos de ingreso al objeto.
 *
 * */

class Persona(var nombre: String, var edad: Int) {
    init {
        if(edad < 0)
            edad = 0
    }

    fun imprimePersona() {
        println("Nombre: $nombre - Edad: $edad")
    }
}