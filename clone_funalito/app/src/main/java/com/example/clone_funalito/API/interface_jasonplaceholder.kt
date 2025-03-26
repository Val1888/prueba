package com.example.clone_funalito.API

import com.example.clone_funalito.modelos.Publicacion
import retrofit2.http.GET


interface FunalitoAPIServicio{
   //Cuando se use la respuesta de internet se resolvera como : https://jsonplaceholder.typicode.com/posts
   @GET("/posts")
   suspend fun obtener_publicaciones(): List<Publicacion>
}