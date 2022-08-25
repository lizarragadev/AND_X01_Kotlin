
/**
 * Programar los siguientes objetos:
 * "Personal" con los atributos: nombres (String), apellidos (String), edad (Int)
 * "Enfermera" que herede de "Personal" y adicionalmente el atributo: codInterno (String)
 * "Medico" que herede de "Personal" y adicionalmente los atributos: especialidad (String) y nroConsultorio (Int)
 *
 * Validar lo siguiente:
 * - El nombre y apellido convertirlo a mayúsculas.
 * - Si la edad es negativa asignarle edad de 0.
 * - Si la especialidad del médico es vacio asignarle por defecto: "Medicina General".
 * - Si el número de consultorio es negativo asignarle el consultorio número 1.
 * - Si el código interino de la enfermera es vacio, asignarle por defecto el código: DEF-00001
 *
 * En la clase Personal, crear la función imprimir y sobrecargarla en las demás clases para imprimir todos los
 * atributos, tanto los que se heredan como los de la propia clase.
 *
 * Ejemplo entrada:
 *  val enf = Enfermera("Adela", "Lopez", 53, "ENF-3214")
 *  enf.imprimirPersonal()
 *  val med = Medico("Ramiro", "Alcazar", 55, "Cirujano", 4)
 *  med.imprimirPersonal()
 *
 *  Salida:
 *
 *  Nombre: ADELA
 *  Apellidos: LOPEZ
 *  Edad: 53
 *  Codigo interino: ENF-3214
 *
 *  Nombre: RAMIRO
 *  Apellidos: ALCAZAR
 *  Edad: 55
 *  Especialidad médico: Cirujano
 *  Número de consultorio: 4
 *
 * */

fun main() {
    val enf = Enfermera("Adela", "Lopez", 53, "ENF-3214")
    enf.imprimirPersonal()

    val med = Medico("Ramiro", "Alcazar", 55, "Cirujano", 4)
    med.imprimirPersonal()
}