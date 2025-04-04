package src.model

enum class Riesgo(val interesAplicado: Double) {

    BAJO(2.0),
    MEDIO(5.0),
    ALTO(10.0);

    companion object{
        fun getRiesgo(valor: String) : Riesgo{
            return if (valor.uppercase().trim() == Riesgo.BAJO.toString()){
                Riesgo.BAJO
            } else if (valor.uppercase().trim() == Riesgo.MEDIO.toString()){
                Riesgo.MEDIO
            } else if (valor.uppercase().trim() == Riesgo.ALTO.toString()){
                Riesgo.ALTO
            } else {
                Riesgo.MEDIO
            }
        }
    }

}