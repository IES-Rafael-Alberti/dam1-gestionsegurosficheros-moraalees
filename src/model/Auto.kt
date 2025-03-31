package src.model

enum class Auto {
    COCHE,
    MOTO,
    CAMION;

    companion object{
        fun getAuto(valor: String): Auto{
            return if (valor.uppercase().trim() == Auto.COCHE.toString()){
                Auto.COCHE
            } else if (valor.uppercase().trim() == Auto.MOTO.toString()){
                Auto.MOTO
            } else if (valor.uppercase().trim() == Auto.CAMION.toString()){
                Auto.CAMION
            } else {
                Auto.COCHE
            }
        }
    }

}