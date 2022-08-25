
/**
 * @author Gustavo Lizárraga
 *
 * Para poder heredar algun objeto colocamos el operador :
 * con ese operador le mencionamos que vamos a heredar
 * características de otra clase y luego del : debemos colocar
 * la clase más su constructor que requiere.
 *
 * */

class Empleado(nombre: String, edad: Int, val sueldo: Int) : Persona(nombre, edad) {
    override fun imprimir() {
        super.imprimir()
        println("Sueldo: $sueldo")
    }

    fun pagaImpuestos() {
        if(sueldo > 3000)
            println("El empleado $nombre paga impuestos")
        else
            println("El empleado $nombre NO paga impuestos")
    }
}