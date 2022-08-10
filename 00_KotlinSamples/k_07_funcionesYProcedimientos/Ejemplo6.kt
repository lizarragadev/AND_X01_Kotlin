
/**
 * @author Gustavo Lizárraga
 *
 * Creación de una función y procedimientos llamados desde una estructura WHEN
 *
 * Enunciado del ejercicio:
 * Ingresar dos nombres (Strings) desde teclado y verificar
 * cual de los dos nombres tiene mayor cantidad de caracteres:
 * cadena.length
 *
 * */

fun main() {
    print("Ingrese nombre 1: ")
    val nom1 = readLine().toString()
    print("Ingrese nombre 2: ")
    val nom2 = readLine().toString()
    when {
        tamanio(nom1) == tamanio(nom2) -> imprimirMsj("$nom1 y $nom2 tienen la misma cantidad de caracteres")
        tamanio(nom1) > tamanio(nom2) -> imprimirMsj("$nom1 tiene mayor cantidad de caracteres que $nom2")
        tamanio(nom1) < tamanio(nom2) -> imprimirMsj("$nom2 tiene mayor cantidad de caracteres que $nom1")
    }
}

fun tamanio(n: String) : Int {
    return n.length
}

fun imprimirMsj(msg: String) {
    println(msg)
}
