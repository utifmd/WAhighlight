package com.dudegenuine.whatsapp.data.remote.service

import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.data.remote.model.Chat
import com.dudegenuine.whatsapp.data.remote.model.Conversation
import com.dudegenuine.whatsapp.data.remote.model.Status
import com.dudegenuine.whatsapp.data.remote.service.IRemoteService.Companion.BASE_URL
import retrofit2.http.GET

/**
 * Fri, 01 Jul 2022
 * Whatsapp by utifmd
 **/
interface RemoteService: IRemoteService {

    @GET("$BASE_URL/calls")
    override suspend fun getCalls(): List<Call>

    @GET("$BASE_URL/chats")
    override suspend fun getChats(): List<Chat>

    @GET("$BASE_URL/status")
    override suspend fun getStatus(): List<Status>

    @GET("$BASE_URL/conversation")
    override suspend fun getConversation(): List<Conversation>
}