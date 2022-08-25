
/**
 * @author Gustavo Lizárraga
 *
 *  Una colección es una estructura encargada de almacenar información,
 *  existen varios tipos de colecciones como ser: IntArray, DoubleArray, etc
 *
 * */

fun main() {
    val sueldos = IntArray(5)
    for(i in 0..4) {
        print("Ingrese sueldo ${i+1}: ")
        sueldos[i] = readLine()!!.toInt()
    }

    for(i in 0..4) {
        println("Sueldo ${i+1}: ${sueldos[i]}")
    }
}