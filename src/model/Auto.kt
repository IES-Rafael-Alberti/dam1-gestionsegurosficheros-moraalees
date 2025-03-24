package src.model

enum class Auto {
    COCHE,
    MOTO,
    CAMION;

    companion object{
        fun getAuto(valor: String): Auto{
            if (valor.uppercase() == Auto.COCHE.toString()){
                return Auto.COCHE
            } else if (valor.uppercase() == Auto.MOTO.toString()){
                return Auto.MOTO
            } else if (valor.uppercase() == Auto.CAMION.toString()){
                return Auto.CAMION
            } else {
                return Auto.COCHE
            }
        }
    }

}