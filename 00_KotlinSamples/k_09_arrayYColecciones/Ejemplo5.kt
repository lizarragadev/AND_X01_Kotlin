
/**
 * @author Gustavo Lizárraga
 *
 * Ejercicio aplicando IntArray
 *
 *  Cargar un arreglo de n elementos. Imprimir el menor elemento y un mensaje si se repite dentro del arreglo.
 *
 * */

fun main() {
    var arreglo = cargar2()
    imprimir2(arreglo)
    println("El elemento mayor es ${mayor(arreglo)}")
    if (repite(arreglo,mayor(arreglo)))
        println("Se repite el mayor en el arreglo")
    else
        println("No se repite el mayor en el arreglo")
}

fun cargar2(): IntArray {
    print("Cuantos elementos tendrá el arreglo: ")
    val cantidad = readLine()!!.toInt()
    val arreglo = IntArray(cantidad)
    for(i in arreglo.indices) {
        print("Ingrese elemento ${i+1}: ")
        arreglo[i] = readLine()!!.toInt()
    }
    return arreglo
}

fun imprimir2(arreglo: IntArray) {
    println("Listado completo del arreglo")
    for(elemento in arreglo)
        print("[$elemento] ")
    println()
}

fun mayor(arreglo: IntArray): Int {
    var may = arreglo[0]
    for(elemento in arreglo)
        if (elemento > may)
            may = elemento
    return may
}

fun repite(arreglo: IntArray, buscar: Int): Boolean {
    var cant = 0
    for(elemento in arreglo)
        if (elemento == buscar)
            cant++
    return cant > 1
}
