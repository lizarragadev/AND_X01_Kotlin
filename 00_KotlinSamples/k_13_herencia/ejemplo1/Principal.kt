
/**
 * @author Gustavo Lizárraga
 *
 * Y si realizamos una prueba, podemos percatarnos que no
 * podremos acceder a las variables y/o funciones que no hayamos
 * colocado la palabra OPEN.
 *
 * */

fun main() {
    val p1 = Persona("Gustavo", 28)
    p1.imprimir()

    val e1 = Empleado("Josue", 23, 2500)
    e1.imprimir()
    e1.pagaImpuestos()
}