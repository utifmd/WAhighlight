package com.dudegenuine.whatsapp.domain.repository

import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.data.remote.model.Chat
import com.dudegenuine.whatsapp.data.remote.model.Conversation
import com.dudegenuine.whatsapp.data.remote.model.Status
import com.dudegenuine.whatsapp.data.remote.service.ServiceInstance

/**
 * Fri, 01 Jul 2022
 * Whatsapp by utifmd
 **/
class Repository: IRepository {
    private val service = ServiceInstance.api

    override suspend fun getCalls(): List<Call> {
        return service.getCalls()
    }

    override suspend fun getChats(): List<Chat> {
        return service.getChats()
    }

    override suspend fun getStatus(): List<Status> {
        return service.getStatus()
    }

    override suspend fun getConversation(): List<Conversation> {
        return service.getConversation()
    }
}