package me.shrikanthravi.lib.chatui.data

import kotlinx.coroutines.delay
import me.shrikanthravi.lib.chatui.utils.messages
import me.shrikanthravi.lib.chatui.utils.newMessages
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage

/**
 * Created by Shrikanth Ravi on 12-11-2021.
 */
class MessageApi {
    suspend fun getMessages(page: Int): List<JcChatMessage> {
        return if(page < 1) {
            delay(1000)
             newMessages.reversed()
        } else {
            listOf()
        }
    }
}