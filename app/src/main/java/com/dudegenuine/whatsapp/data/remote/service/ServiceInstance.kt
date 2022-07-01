package com.dudegenuine.whatsapp.data.remote.service

import com.dudegenuine.whatsapp.data.remote.service.IRemoteService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Fri, 01 Jul 2022
 * Whatsapp by utifmd
 **/
object ServiceInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: RemoteService by lazy {
        retrofit.create(RemoteService::class.java)
    }
}