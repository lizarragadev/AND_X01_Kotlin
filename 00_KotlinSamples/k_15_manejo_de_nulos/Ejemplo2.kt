
/*// DESACTIVAR COMPROBACIÓN DE NULOS
var nombre1: String? = null
var longitud: Int = nombre1!!.length

// LLAMADAS SEGURAS
var nombre2: String? = null
// var longitud: Int = nombre?.length // Type mismatch: inferred type is Int? but Int was expected
var longitud2: Int? = nombre2?.length
println("Longitud: $longitud2")


// EL OPERADOR ELVIS (?:)
var nombre3: String? = null
var longitud3: Int = nombre3?.length ?: 0
println("Longitud: $longitud3")

// SACAR LOS VALORES DISTINTOS DE NULL DE UNA LISTA
val listaConNulls = listOf(null, 2, null, 4, null)
println("Con nulls: $listaConNulls")

val listaSinnNulls = listaConNulls.filterNotNull()
println("Sin nulls: $listaSinnNulls")
*/