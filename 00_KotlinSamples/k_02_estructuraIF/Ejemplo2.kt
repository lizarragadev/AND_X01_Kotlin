
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo básico de creación de la estructura condicional IF INLINE.
 * Quiere decir que se puede realizar la creación de un IF en una línea.
 *
 * */

fun main() {
    print("Ingrese un valor: ")
    val da = readLine()!!.toInt()
    val resultado = if(da % 2 == 0) {
        print("Cuadrado ")
        da * da
    } else {
        print("Cubo ")
        da * da * da
    }
    println(resultado)
}