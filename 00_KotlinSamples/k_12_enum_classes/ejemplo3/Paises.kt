
/**
 * @author Gustavo Lizárraga
 *
 * Asi como pueden haber pares de datos en un enum, de igual forma
 * podemos almacenar muchas más variables las cuales nos serán
 * muy útiles para distintas cosas, la forma de hacerlo es colocar
 * como argumento del enum las variables que ustedes vean conveniente
 * separados por comas.
 *
 * */

enum class Paises (val habitantes: Int) {
    BRASIL (202450649),
    COLOMBIA (50364000),
    PERU (31151643),
    VENEZUELA (31028337),
    CHILE (18261884),
    ECUADOR (16298217),
    BOLIVIA (10888000),
    PARAGUAY (6460000),
    URUGUAY (3372000)
}