
/**
 * @author Gustavo Lizárraga
 *
 * Una función local es aquella función que se crea dentro de otra función, y esa
 * función se lo crea en formato función en línea.
 *
 * */
fun multiplos2y5() {

    fun multiplo(numero: Int, valor: Int) = numero % valor == 0

    var mult2 = 0
    var mult5 = 0
    for(i in 1..10) {
        print("Ingrese valor: ")
        val valor = readLine()!!.toInt()
        if (multiplo(valor, 2))
            mult2++
        if (multiplo(valor, 5))
            mult5++
    }
    println("Cantidad de múltiplos de 2 : $mult2")
    println("Cantidad de múltiplos de 5 : $mult5")
}

fun main() {
    multiplos2y5()
}