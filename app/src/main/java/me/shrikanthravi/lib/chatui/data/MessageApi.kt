package me.shrikanthravi.lib.chatui.data

import kotlinx.coroutines.delay
import me.shrikanthravi.lib.chatui.utils.messages
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage

/**
 * Created by Shrikanth Ravi on 12-11-2021.
 */
class MessageApi {
    suspend fun getMessages(page: Int): List<JcChatMessage> {
        delay(1000)
        return messages.reversed()
    }
}