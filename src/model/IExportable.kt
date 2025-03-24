package src.model

interface IExportable {
    fun serializar(separador: String = ";"): String
}