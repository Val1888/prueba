package com.example.clone_funalito.API

import com.example.clone_funalito.modelos.Publicacion

class RepositorioFunalito{
    private val servicio_api_jsonplaceholder = InstanciaRetrofitJSONplaceholder.consumir_servicio

    suspend fun obtener_publicaciones(): List<Publicacion> {
        return  servicio_api_jsonplaceholder.obtener_publicaciones()
    }
}