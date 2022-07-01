package com.dudegenuine.whatsapp.data.remote.service

import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.data.remote.model.Chat
import com.dudegenuine.whatsapp.data.remote.model.Conversation
import com.dudegenuine.whatsapp.data.remote.model.Status

/**
 * Fri, 01 Jul 2022
 * Whatsapp by utifmd
 **/
interface IRemoteService {
    suspend fun getCalls(): List<Call>
    suspend fun getChats(): List<Chat>
    suspend fun getStatus(): List<Status>
    suspend fun getConversation(): List<Conversation>

    companion object{
        const val BASE_URL = "https://my-json-server.typicode.com/utifmd/WAhighlight/"
    }
}