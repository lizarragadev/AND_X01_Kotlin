
open class Personal(var nombres: String, var apellidos: String, var edad: Int) {
    init {
        nombres = nombres.toUpperCase()
        apellidos = apellidos.toUpperCase()
        if(edad < 1)
            edad = 0
    }

    open fun imprimirPersonal() {
        println("Nombre: $nombres")
        println("Apellidos: $apellidos")
        println("Edad: $edad")
    }
}