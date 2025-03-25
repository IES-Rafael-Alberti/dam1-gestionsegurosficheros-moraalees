package src.model

class SeguroHogar: Seguro {

    private var metrosCuadrados: Int = 0
    private var valorContenido: Double = 0.0
    private var direccion: String = ""
    private var anioConstruccion: Int = 0

    companion object{
        private var numPolizasAuto: Int = 100000
        private const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        private const val CICLO_ANIOS_INCREMENTO = 5

        private var numPolizasHogar: Int = 100000
            private set

        fun crearSeguro(datos: List<String>): SeguroHogar? {
            if (datos.size != 6 && datos.size != 7){
                println("ERROR * La lista debe tener entre 6 o 7 elementos.")
                return null
            }
            try {
                if (datos.size == 6) {
                    val dniTitular = datos[0]
                    val importe = datos[1].toDouble()
                    val metrosCuadrados = datos[2].toInt()
                    val valorContenido = datos[3].toDouble()
                    val direccion = datos[4]
                    val anioConstruccion = datos[5].toInt()

                    return SeguroHogar(dniTitular, importe, metrosCuadrados, valorContenido, direccion, anioConstruccion)
                } else {
                    val numPoliza = datos[0].toInt()
                    val dniTitular = datos[1]
                    val importe = datos[2].toDouble()
                    val metrosCuadrados = datos[3].toInt()
                    val valorContenido = datos[4].toDouble()
                    val direccion = datos[5]
                    val anioConstruccion = datos[6].toInt()

                    return SeguroHogar(numPoliza, dniTitular, importe, metrosCuadrados, valorContenido, direccion, anioConstruccion)
                }
            } catch (e: NumberFormatException) {
                println("ERROR * Formato numérico incorrecto: ${e.message}")
                return null
            } catch (e: IllegalArgumentException) {
                println("ERROR * ${e.message}")
                return null
            }
        }
    }

    constructor(
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ) : super(++numPolizasAuto, dniTitular, importe) {
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
    ) : super(numPoliza, dniTitular, importe) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
    }

    override fun tipoSeguro(): String {
        return this::class.simpleName ?: "Desconocido"
    }

    override fun serializar(separador: String): String {
        return super.numPoliza.toString() + separador + super.serializar(separador).split(separador)[1] + separador + "%.2f".format(super.importe) + separador + metrosCuadrados + separador + "%.2f".format(valorContenido) + separador + direccion + separador + anioConstruccion
    }

    override fun toString(): String {
        return "Seguro Hogar(numPoliza=${super.numPoliza}, dniTitular=${super.serializar(";").split(";")[1]}, importe=%.2f, ".format(super.importe) + "metrosCuadrados=$metrosCuadrados, valorContenido=%.2f, ".format(valorContenido) + "direccion='$direccion', anioConstruccion=$anioConstruccion)"
    }
}