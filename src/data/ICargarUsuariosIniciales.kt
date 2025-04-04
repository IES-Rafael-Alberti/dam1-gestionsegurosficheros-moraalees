package src.data

// Será llamada desde Main.kt si el usuario elige trabajar en modo persistente.

interface ICargarUsuariosIniciales {
    fun cargarUsuarios(): Boolean
}