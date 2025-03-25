package src.model

enum class Cobertura(desc: String) {

    TERCEROS("Terceros"),
    TERCEROS_AMPLIADO("Terceros +"),
    FRANQUICIA_200("Todo Riesgo con Franquicia de 200€"),
    FRANQUICIA_300("Todo Riesgo con Franquicia de 300€"),
    FRANQUICIA_400("Todo Riesgo con Franquicia de 400€"),
    FRANQUICIA_500("Todo Riesgo con Franquicia de 500€"),
    TODO_RIESGO("Todo Riesgo");

    companion object{
        fun getCobertura(valor: String): Cobertura{
            if (valor.uppercase().trim() == Cobertura.TERCEROS.toString()){
                return Cobertura.TERCEROS
            } else if (valor.uppercase().trim() == Cobertura.TERCEROS_AMPLIADO.toString()){
                return Cobertura.TERCEROS_AMPLIADO
            } else if (valor.uppercase().trim() == Cobertura.FRANQUICIA_200.toString()){
                return Cobertura.FRANQUICIA_200
            } else if (valor.uppercase().trim() == Cobertura.FRANQUICIA_300.toString()){
                return Cobertura.FRANQUICIA_300
            } else if (valor.uppercase().trim() == Cobertura.FRANQUICIA_400.toString()){
                return Cobertura.FRANQUICIA_400
            } else if (valor.uppercase().trim() == Cobertura.FRANQUICIA_500.toString()){
                return Cobertura.FRANQUICIA_500
            } else if (valor.uppercase().trim() == Cobertura.TODO_RIESGO.toString()){
                return Cobertura.TODO_RIESGO
            } else {
               return Cobertura.TERCEROS_AMPLIADO
            }
        }
    }

}