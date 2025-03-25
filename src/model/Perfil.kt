package src.model

enum class Perfil {
    ADMIN,
    GESTION,
    CONSULTA;

    companion object{
        fun getPerfil(valor: String): Perfil {
            return if (valor.uppercase().trim() == Perfil.CONSULTA.toString()){
                Perfil.CONSULTA
            } else if (valor.uppercase().trim() == Perfil.GESTION.toString()){
                Perfil.GESTION
            } else if (valor.uppercase().trim() == Perfil.ADMIN.toString()) {
                Perfil.ADMIN
            } else {
                Perfil.CONSULTA
            }
        }
    }

}