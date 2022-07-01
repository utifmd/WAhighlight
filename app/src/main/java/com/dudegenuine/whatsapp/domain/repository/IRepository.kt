package com.dudegenuine.whatsapp.domain.repository

import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.data.remote.model.Chat
import com.dudegenuine.whatsapp.data.remote.model.Conversation
import com.dudegenuine.whatsapp.data.remote.model.Status
import kotlinx.coroutines.flow.Flow

/**
 * Fri, 01 Jul 2022
 * Whatsapp by utifmd
 **/
interface IRepository {
    suspend fun getCalls(): List<Call>
    suspend fun getChats(): List<Chat>
    suspend fun getStatus(): List<Status>
    suspend fun getConversation(): List<Conversation>
}