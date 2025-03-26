package com.example.clone_funalito.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanciaRetrofitJSONplaceholder {
    private  const val url_base = "https://jsonplaceholder.typicode.com"

    private val servicio: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // lazy es un constructor que solo va a crear el objeto cuando sea solicitado y no desde un inicio. Para evitar tener muchas cosas en las llamadas generales
    val consumir_servicio:  FunalitoAPIServicio by lazy{
        servicio.create( FunalitoAPIServicio::class.java)

    }
}
