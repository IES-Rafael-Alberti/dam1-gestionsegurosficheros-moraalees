package src.model

import java.time.LocalDate

class SeguroHogar: Seguro {

    private var metrosCuadrados: Int
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int

    companion object{
        private var numPolizasHogar: Int = 100000
        private const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        private const val CICLO_ANIOS_INCREMENTO = 5

        fun crearSeguro(datos: List<String>): SeguroHogar {
            return SeguroHogar(
                numPoliza = datos[0].toInt(),
                dniTitular = datos[1],
                importe = datos[2].toDouble(),
                metrosCuadrados = datos[3].toInt(),
                valorContenido = datos[4].toDouble(),
                direccion = datos[5],
                anioConstruccion = datos[6].toInt()
            )
        }
    }

    constructor(
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ) : super(++numPolizasHogar, dniTitular, importe){
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ) : super(numPoliza, dniTitular, importe){
        this.metrosCuadrados = metrosCuadrados
        this.direccion = direccion
        this.valorContenido = valorContenido
        this.anioConstruccion = anioConstruccion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val aniosConstruidos = LocalDate.now().year - anioConstruccion

        val aniosDiferencia = aniosConstruidos.floorDiv(CICLO_ANIOS_INCREMENTO)

        return if (aniosDiferencia < 1){
            interes
        } else {
            interes + aniosDiferencia * PORCENTAJE_INCREMENTO_ANIOS
        }
    }


    override fun serializar(separador: String): String {
        return super.numPoliza.toString() + separador + super.serializar(separador).split(separador)[1] + separador + "%.2f".format(super.importe) + separador + metrosCuadrados + separador + "%.2f".format(valorContenido) + separador + direccion + separador + anioConstruccion
    }

    override fun toString(): String {
        return "Seguro Hogar(numPoliza=${super.numPoliza}, dniTitular=${super.serializar(";").split(";")[1]}, importe=%.2f, ".format(super.importe) + "metrosCuadrados=$metrosCuadrados, valorContenido=%.2f, ".format(valorContenido) + "direccion='$direccion', anioConstruccion=$anioConstruccion)"
    }
}