package src.data

import src.model.Perfil
import src.model.Usuario

class RepoUsuariosMem(
    val listaUsuarios : MutableList<Usuario> = mutableListOf<Usuario>()
) : IRepoUsuarios {
    override fun agregar(usuario: Usuario): Boolean {
        if (buscar(usuario.nombre) == null) {
            listaUsuarios.add(usuario)
            return true
        } else {
            return false
        }
    }

    override fun buscar(nombreUsuario: String): Usuario? {
        return listaUsuarios.find { it.nombre == nombreUsuario }
    }

    override fun eliminar(usuario: Usuario): Boolean {
        return listaUsuarios.remove(usuario)
    }

    override fun eliminar(nombreUsuario: String): Boolean {
        val usuario = buscar(nombreUsuario)
        return usuario != null && eliminar(usuario)
    }

    override fun obtenerTodos(): List<Usuario> {
        return listaUsuarios
    }

    override fun obtener(perfil: Perfil): List<Usuario> {
        return listaUsuarios.filter { it.perfil == perfil }
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        return usuario.cambiarClave(nuevaClave)
    }
}