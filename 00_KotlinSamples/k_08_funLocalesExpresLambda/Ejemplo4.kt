
/**
 * @author Gustavo Lizárraga
 *
 *  Expresiones lambda.
 *  Las expresiones lambda son funciones sin declarar, las cuales están encerradas entre llaves y
 *  en caso que tenga argumentos de ingreso se los denota asi:
 *  { arg1, arg2 -> Funcionalidad }
 *  Las expresiones lambda se utilizan en su mayoría para simplificar código y volverlo más conciso.
 *
 * */

fun main() {
    val suma = { n1: Int, n2: Int -> n1 + n2 }
    print("${suma(2, 4)}")
}