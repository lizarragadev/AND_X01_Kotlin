
class Enfermera(nom: String, ape: String, ed: Int, var codInterno: String) : Personal(nom, ape, ed) {
    init {
        if (codInterno == "")
            codInterno = "DEF-00001"
    }

    override fun imprimirPersonal() {
        super.imprimirPersonal()
        println("Codigo interino: $codInterno")
    }
}