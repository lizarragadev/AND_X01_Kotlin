
/**
 * @author Gustavo Lizárraga
 *
 *  Ejemplo de uso de FloatArray en Coleccion inmutable.
 *
 * */

fun main() {
    val alturas = FloatArray(5)
    var suma = 0F
    for(i in alturas.indices){
        print("Ingrese la altura: ")
        alturas[i] = readLine()!!.toFloat()
        suma = suma.plus(alturas[i])
    }
    val promedio = suma.div(alturas.size)
    println("Altura promedio: $promedio")
    var altos = 0
    var bajos = 0
    for(element in alturas)
        if (element > promedio)
            altos++
        else
            bajos++
    println("Cantidad de personas más altas que el promedio: $altos")
    println("Cantidad de personas más bajas que el promedio: $bajos")
}