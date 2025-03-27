package src.model

enum class Auto {
    COCHE,
    MOTO,
    CAMION;

    companion object{
        fun getAuto(valor: String): Auto{
            if (valor.uppercase().trim() == Auto.COCHE.toString()){
                return Auto.COCHE
            } else if (valor.uppercase().trim() == Auto.MOTO.toString()){
                return Auto.MOTO
            } else if (valor.uppercase().trim() == Auto.CAMION.toString()){
                return Auto.CAMION
            } else {
                return Auto.COCHE
            }
        }
    }

}