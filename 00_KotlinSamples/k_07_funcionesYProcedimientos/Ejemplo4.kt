
/**
 * @author Gustavo Lizárraga
 *
 * Creación de funciones.
 * Las funciones tienen la característica principal de que retorna si o si uno o varios valores
 * a la terminación de la ejecución de la función, para diferenciar una función de un procedimiento
 * luego de los paréntesis de los argumentos de la función colocamos lo siguiente
 * : TipoRetorno en donde TipoRetorno será el tipo de dato a retornar de la función y dentro la función
 * debemos llamar a la instrucción return y retornar un resultado  del tipo de dato que se declaró.
 *
 * */

fun main() {
    print("Ingrese el valor de un lado de un cuadrado: ")
    val la = readLine()!!.toInt()
    val superficie = retornarSuperficie(la)
    println("La superficie del cuadrado es: $superficie")
}

fun retornarSuperficie(l: Int) : Int {
    return l.times(l)
}