
/**
 * @author Gustavo Lizárraga
 *
 * Un data class nada mas es una clase que solamente contiene
 * los atributos que nosotros queremos guardar y no asi las funciones
 * o procedimientos largos que podamos crear para cualquier otro objeto.
 * Es decir que las data classes no realizan ninguna operación
 * solamente inicializar las variables o atributos del objeto y nada más.
 *
 * */

data class Articulo(var codigo: Int, var descripcion: String, var precio: Float) {
    override fun toString(): String {
        return "$codigo - $descripcion [ $precio ]"
    }
}