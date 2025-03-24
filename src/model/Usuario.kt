package src.model

class Usuario(
    val nombre: String,
    clave: String,
    var perfil: Perfil
): IExportable{

    var clave: String = clave
        private set

    override fun serializar(separador: String): String {
        TODO("Not yet implemented")
    }

}