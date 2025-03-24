package src.model

enum class Perfil {
    ADMIN,
    GESTION,
    CONSULTA;

    companion object{
        fun getPerfil(valor: String): Perfil {
            return if (valor.uppercase() == Perfil.CONSULTA.toString()){
                Perfil.CONSULTA
            } else if (valor.uppercase() == Perfil.GESTION.toString()){
                Perfil.GESTION
            } else if (valor.uppercase() == Perfil.ADMIN.toString()) {
                Perfil.ADMIN
            } else {
                Perfil.CONSULTA
            }
        }
    }

}