
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de creación de procedimiento con IF INLINE internos.
 *
 * */

fun main() {
    print("Ingrese numero 1: ")
    val num1 = readLine()!!.toInt()
    print("Ingrese numero 2: ")
    val num2 = readLine()!!.toInt()
    print("Ingrese numero 3: ")
    val num3 = readLine()!!.toInt()
    mostrarMayor(num1, num2, num3)
}

fun mostrarMayor(n1: Int, n2: Int, n3: Int) {
    print("El Mayor es: ")
    if(n1 > n2 && n1 > n3)
        print(n1)
    else
        if(n2 > n3)
            print(n2)
        else
            print(n3)
}