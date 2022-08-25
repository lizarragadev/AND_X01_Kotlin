
/**
 *
 * Ingresar un número de teclado que simboliza el número de un mes [1 al 12]
 * caso contrario lanzar un mensaje de error.
 * De acuerdo el número lanzar el nombre del mes más la cantidad de días que tiene
 * determinado mes.
 * Pra los meses crear un ENUM con todos los meses del año y como valor debe tener la cantidad
 * de días de cada mes.
 *
 * Ejemplo entrada:
 * Ingrese el número del mes: 10
 *
 * Salida:
 * OCTUBRE tiene 31 días.
 *
 * */

fun main() {
    print("Ingrese el número del mes: ")
    when(readLine()!!.toInt()){
        1 -> print("${MesEnum.ENERO} tiene ${MesEnum.ENERO.dias} días.")
        2 -> print("${MesEnum.FEBRERO} tiene ${MesEnum.FEBRERO.dias} días.")
        3 -> print("${MesEnum.MARZO} tiene ${MesEnum.MARZO.dias} días.")
        4 -> print("${MesEnum.ABRIL} tiene ${MesEnum.ABRIL.dias} días.")
        5 -> print("${MesEnum.MAYO} tiene ${MesEnum.MAYO.dias} días.")
        6 -> print("${MesEnum.JUNIO} tiene ${MesEnum.JUNIO.dias} días.")
        7 -> print("${MesEnum.JULIO} tiene ${MesEnum.JULIO.dias} días.")
        8 -> print("${MesEnum.AGOSTO} tiene ${MesEnum.AGOSTO.dias} días.")
        9 -> print("${MesEnum.SEPTIEMBRE} tiene ${MesEnum.SEPTIEMBRE.dias} días.")
        10 -> print("${MesEnum.OCTUBRE} tiene ${MesEnum.OCTUBRE.dias} días.")
        11 -> print("${MesEnum.NOVIEMBRE} tiene ${MesEnum.NOVIEMBRE.dias} días.")
        12 -> print("${MesEnum.DICIEMBRE} tiene ${MesEnum.DICIEMBRE.dias} días.")
        else -> print("Mes inválido.")
    }
}