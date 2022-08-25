
/**
 * @author Gustavo Lizárraga
 *
 * Si creamos un objeto de la siguiente forma, solamente tenemos un
 * constructor sin argumentos por defecto, es decir que no podremos
 * crear el objeto enviándole atributos a través de su constructor.
 *
 * */

class Triangulo {
    var lado1 = 0
    var lado2 = 0
    var lado3 = 0

    fun inicializar() {
        this.lado1 = readLine()!!.toInt()
        this.lado2 = readLine()!!.toInt()
        this.lado3 = readLine()!!.toInt()
    }

    fun ladoMayor() {
        when {
            lado1 > lado2 && lado1 > lado3 -> println(lado1)
            lado2 > lado3 -> println(lado2)
            else -> println(lado3)
        }
    }

    fun esEquilatero() {
        if(lado1 == lado2 && lado1 == lado3)
            print("El triangulo es equilatero")
        else
            print("El triangulo NO es equilatero")
    }
}