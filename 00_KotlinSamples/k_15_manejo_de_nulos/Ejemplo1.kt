
/**
 * @author Gustavo Lizárraga
 *
 * Manejo de nulos.
 *
 * 1. Por defecto en Kotlin no existen nulos mientras no se diga lo contrario.
 * 2. Para dar soporte a nulos debemos colocar el operador ? después de la declaración del tipo
 * de dato de una variable. Pero en ese momento se generarán muchos problemas
 * por el hecho que debemos consultar en todos los casos que necesitemos utilizar esa variable
 * si es nulo o no.
 * 3. La opción más segura es utilizar el modifcador de acceso ?.  el cuál se lo coloca
 * luego de la llamada a una variable que soporte nulos. Lo que hará es que mientras no
 * sea nulo realizará las acciones para las cuáles se los programó y si llega a ser nulo
 * simplemente no hará nada.
 * 4. Para dar una acción más por si llega a ser nulo podemos utilizar el operador ELVIS  ?:
 * el cuál es como un IF ELSE que si llega a ser nulo pues podemos asignarle otra acción que
 * deba realizar en ese caso y ésta es la forma más segura de controlar los nulos en Kotlin.
 * 5. También tenemos una salida rápida y es colocar el operador !! con el cuál le decimos que
 * no importa que sea nulo, que haga prioridad que la aplicación funcione.
 *
 * */

fun main() {
    var nombre: String?
    nombre = null

    var x: Int? = null
    if(x != null) {
        val y = x.toDouble()
    } else {
        val y = 0.0
    }

    // Expresion de acceso seguro
    val y = x?.toDouble()

    // Operador ELVIS  ?:
    val y1 = x?.toDouble() ?: 0.0

    // !! (mala practica)
    val y2 = x!!.toDouble()

}