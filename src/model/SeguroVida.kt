package src.model

import java.time.LocalDate

class SeguroVida : Seguro {

    private var fechaNac: LocalDate
    private var nivelRiesgo: Riesgo
    private var indemnizacion: Double

    companion object{
        private var numPolizasVida: Int = 800000

        fun crearSeguro(datos: List<String>): SeguroVida {
            return SeguroVida(
                numPoliza = datos[0].toInt(),
                dniTitular = datos[1],
                importe = datos[2].toDouble(),
                fechaNac = LocalDate.parse(datos[3]),
                nivelRiesgo = Riesgo.valueOf(datos[4]),
                indemnizacion = datos[5].toDouble()
            )
        }
    }

    constructor(
        dniTitular: String,
        importe: Double,
        fechaNac: LocalDate,
        nivelRiesgo: Riesgo,
        indemnizacion: Double
    ) : super(++numPolizasVida, dniTitular, importe){
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        fechaNac: LocalDate,
        nivelRiesgo: Riesgo,
        indemnizacion: Double
    ) : super(numPoliza, dniTitular, importe){
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val edad = LocalDate.now().year - fechaNac.year
        val interesResidual = edad * 0.05
        val interesRiesgo = nivelRiesgo.interesAplicado

        return importe * (1 + interes + interesRiesgo + interesResidual)
    }

    override fun serializar(separador: String): String {
        return super.numPoliza.toString() + separador + super.serializar(";").split(";")[1] + separador + "%.2f".format(super.importe) + separador + fechaNac.toString() + separador + nivelRiesgo.name + separador + "%.2f".format(indemnizacion)
    }

    override fun toString(): String {
        return "SeguroVida(numPoliza=${super.numPoliza}, dniTitular=${super.serializar(";").split(";")[1]}, importe=$importe, fechaNac=$fechaNac, nivelRiesgo=${nivelRiesgo.name}, indemnizacion=$indemnizacion)"
    }

}