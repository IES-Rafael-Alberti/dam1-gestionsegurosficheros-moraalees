package src.model

class SeguroAuto : Seguro {

    private var descripcion: String
    private var combustible: Double
    private var tipoAuto: Auto
    private var cobertura: Cobertura
    private var asistenciaCarretera: Boolean
    private var numPartes: Int

    companion object{
        private var numPolizasAuto = 400000
        private const val PORCENTAJE_INCREMENTO_PARTES = 2

        fun crearSeguro(datos: List<String>): SeguroAuto {
            return SeguroAuto(
                numPoliza = datos[0].toInt(),
                dniTitular = datos[1],
                importe = datos[2].toDouble(),
                descripcion = datos[3],
                combustible = datos[4].toDouble(),
                tipoAuto = Auto.valueOf(datos[5]),
                cobertura = Cobertura.valueOf(datos[6]),
                asistenciaCarretera = datos[7].toBoolean(),
                numPartes = datos[8].toInt()
            )
        }
    }

    constructor(
        dniTitular: String,
        importe: Double,
        descripcion: String,
        combustible: Double,
        tipoAuto: Auto,
        cobertura: Cobertura,
        asistenciaCarretera: Boolean,
        numPartes: Int
    ) : super(++numPolizasAuto, dniTitular, importe){
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        descripcion: String,
        combustible: Double,
        tipoAuto: Auto,
        cobertura: Cobertura,
        asistenciaCarretera: Boolean,
        numPartes: Int
    ) : super(numPoliza, dniTitular, importe){
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val incremento = numPartes * (PORCENTAJE_INCREMENTO_PARTES / 100)
        return importe * (1 + interes + incremento)
    }


    override fun serializar(separador: String): String {
        return super.serializar(separador) + descripcion + separador + combustible + separador + tipoAuto + separador + cobertura + separador + asistenciaCarretera + separador + numPartes
    }

    override fun toString(): String {
        return "Seguro Auto(numPoliza=${super.numPoliza}, dniTitular=${super.serializar(";").split(";")[1]}, importe=$importe, descripción='$descripcion', combustible=$combustible, tipoAuto=$tipoAuto, cobertura=$cobertura, asistenciaCarretera=$asistenciaCarretera, numPartes=$numPartes)"
    }

}