
/**
 * @author Gustavo Lizárraga
 *
 * Para utilizar IntArray en funciones la forma de retorno de una función será
 * como se ve en el ejemplo
 *
 * */

fun main() {
    val sueldos = cargar()
    imprimir(sueldos)

    sueldos.forEach { print("[$it] ") }
}

fun cargar(): IntArray {
    print("Cuantos sueldos quiere cargar: ")
    val cantidad = readLine()!!.toInt()
    val sueldos = IntArray(cantidad)
    for(i in sueldos.indices) {
        print("Ingrese elemento: ")
        sueldos[i] = readLine()!!.toInt()
    }
    return sueldos
}

fun imprimir(sueldos: IntArray) {
    println("Listado de todos los sueldos")
    for(sueldo in sueldos)
        print("$sueldo, ")
}
