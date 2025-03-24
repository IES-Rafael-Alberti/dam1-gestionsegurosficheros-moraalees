package src.model

enum class Riesgo(interesAplicado: Double) {

    BAJO(2.0),
    MEDIO(5.0),
    ALTO(10.0);

    companion object{
        fun getRiesgo(valor: String) : Riesgo{
            if (valor.uppercase() == Riesgo.BAJO.toString()){
                return Riesgo.BAJO
            } else if (valor.uppercase() == Riesgo.MEDIO.toString()){
                return Riesgo.MEDIO
            } else if (valor.uppercase() == Riesgo.ALTO.toString()){
                return Riesgo.ALTO
            } else {
                return Riesgo.MEDIO
            }
        }
    }

}