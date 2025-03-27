package src

import src.model.Cobertura

/*
    EXPLICACIÓN SISTEMA

    App, Relación SERVICE;UI;UTILS: Encargada del flujo del programa
        Clase ControlAcceso: Intenta autenticar un usuario. Después pide iniciar sesión (UI)
        Clase CargaInicial: Carga los seguros (si son de almacenamiento, si son de simulación no) (UI)
        Clase GestorMenu: Gestiona el programa

    Service, Relación APP;MODEL;DATA:
        Clase GestorUsuarios:  (Repos, DATA)
        Clase GestorSeguros:  (Repos, DATA)

    Data, Relación MODEL;SERVICE:
        RepoUsuarioMem: Hereda de IRepoUsuario
        RepoUsuarioFich: Hereda de RepoUsuarioMem
        Lo mismo de Seguros

    Model, Relación DATA;SERVICE:
        Clases de Lógica de Negocio

    UI, Relación APP:

    Utils, Relación APP:
        Ficheros: Se inyecta en el control de acceso (APP)
        Seguridad: Se inyecta en el control de acceso (APP)
*/

fun main(){

}