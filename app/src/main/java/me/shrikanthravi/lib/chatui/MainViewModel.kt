package me.shrikanthravi.lib.chatui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import me.shrikanthravi.lib.chatui.data.MessageApi
import me.shrikanthravi.lib.chatui.data.MessagesPagingDataSource
import me.shrikanthravi.lib.chatui.utils.messages
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage

/**
 * Created by Shrikanth Ravi on 13-11-2021.
 */
class MainViewModel : ViewModel() {
    val messageItems: Flow<PagingData<JcChatMessage>> = Pager(PagingConfig(pageSize = 6)) {
        MessagesPagingDataSource(MessageApi())
    }.flow.cachedIn(viewModelScope)

    fun addMessage(message: JcChatMessage) {
        messages.add(0, message)
    }
}