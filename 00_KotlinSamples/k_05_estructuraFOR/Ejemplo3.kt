
/**
 * @author Gustavo Lizárraga
 *
 * Ejemplo de uso de la estructura ciclica FOR con ingreso de datos y
 * la condicional IF ELSE
 *
 * */

fun main() {
    var aprobados = 0
    var reprobados = 0
    for(i in 1..10) {
        print("Ingrese nota $i [1-10]: ")
        val nota = readLine()!!.toInt()
        if (nota >= 7)
            aprobados++
        else
            reprobados++
    }
    println("Cantidad de alumnos con notas mayores o iguales a 7: $aprobados")
    println("Cantidad de alumnos con notas menores a 7: $reprobados")
}