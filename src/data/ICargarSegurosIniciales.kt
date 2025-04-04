package src.data

import src.model.Seguro

// También será usada en el Main.kt, cuando se cargan los datos desde almacenamiento.

interface ICargarSegurosIniciales {
    fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean
}