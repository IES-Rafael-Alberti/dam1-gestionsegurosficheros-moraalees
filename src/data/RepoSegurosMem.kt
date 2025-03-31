package src.data

import src.model.Seguro

class RepoSegurosMem(
    val listaSeguros: MutableList<Seguro> = mutableListOf<Seguro>()
) : IRepoSeguros{
    override fun agregar(seguro: Seguro): Boolean {
        if (buscar(seguro.numPoliza) == null) {
            listaSeguros.add(seguro)
            return true
        } else {
            return false
        }
    }

    override fun buscar(numPoliza: Int): Seguro? {
        return listaSeguros.find { it.numPoliza == numPoliza }
    }

    override fun eliminar(seguro: Seguro): Boolean {
        return listaSeguros.remove(seguro)
    }

    override fun eliminar(numPoliza: Int): Boolean {
        val seguro = buscar(numPoliza)
        return seguro != null && eliminar(seguro)
    }

    override fun obtenerTodos(): List<Seguro> {
        return listaSeguros
    }

    override fun obtener(tipoSeguro: String): List<Seguro> {
        return listaSeguros.filter { it.tipoSeguro() == tipoSeguro }
    }


}