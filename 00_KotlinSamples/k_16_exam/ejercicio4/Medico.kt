
class Medico(nom: String, ape: String, ed: Int, var especialidad: String, var nroConsultorio: Int) : Personal(nom, ape, ed) {
    init {
        if (especialidad == "")
            especialidad = "Medicina general"
        if (nroConsultorio < 0)
            nroConsultorio = 1
    }

    override fun imprimirPersonal() {
        super.imprimirPersonal()
        println("Especialidad médico: $especialidad")
        println("Número de consultorio: $nroConsultorio")
    }
}