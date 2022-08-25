
/**
 * @author Gustavo Lizárraga
 *
 * Lo que si podemos sobrecargar es las funciones predefinidas que tiene
 * un Data Class como la función toString() la cuál se llama automáticamente
 * cuando imprimimos un objeto.
 *
 * */

data class Dado (var valor: Int) {
    override fun toString(): String {
        var cadena = ""
        for(i in 1..valor)
            cadena = "$cadena*"
        return cadena
    }
}