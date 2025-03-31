package src.model

class Usuario(
    val nombre: String,
    clave: String,
    var perfil: Perfil
): IExportable{

    var clave: String = clave
        private set

    companion object{
        fun crearUsuario(datos: List<String>): Usuario? {
            if (datos.size != 3){
                println("ERROR * La lista debe de tener 3 elementos.")
                return null
            }
            try {
                val nombre = datos[0]
                val clave = datos[1]
                val perfil = Perfil.valueOf(datos[2].uppercase())

                return Usuario(nombre, clave, perfil)
            } catch(e: IllegalArgumentException){
                println("ERROR * No se pudo convertir el dato de ${datos[2]} a Enum Class.")
            } catch(e: Exception){
                println("ERROR * Hubo una excepción.")
            }
            return null
        }
    }

    fun cambiarClave(nuevaClave: String): Boolean {
        return if (nuevaClave != clave) {
            this.clave = nuevaClave
            true
        } else {
            false
        }
    }

    override fun serializar(separador: String): String {
        return nombre + separador + clave + separador + perfil
    }

}