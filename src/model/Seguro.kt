package src.model

abstract class Seguro(
    val numPoliza: Int,
    private val dniTitular: String,
    protected val importe: Double
): IExportable {

    abstract fun calcularImporteAnioSiguiente(interes: Double): Double

    fun tipoSeguro(): String{
        return this::class.simpleName ?: "Desconocido"
    }

    override fun serializar(separador: String): String {
        return numPoliza.toString() + separador + dniTitular + separador + importe + separador
    }

    override fun toString(): String {
        return "Seguro(numPoliza = $numPoliza, dniTitular = $dniTitular, importe = ${"%.2f".format(importe)})"
    }

    override fun hashCode(): Int {
        return numPoliza.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Seguro) return false
        return numPoliza == other.numPoliza
    }
}