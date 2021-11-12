package me.shrikanthravi.libraries.chatuikit.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import kotlinx.coroutines.flow.Flow
import me.shrikanthravi.libraries.chatuikit.R
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage
import me.shrikanthravi.libraries.chatuikit.models.JcChatType
import me.shrikanthravi.libraries.chatuikit.models.JcChatConfig
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Shrikanth Ravi on 06-11-2021.
 */

@ExperimentalCoilApi
@Composable
fun ChatViewItem(
    messageItems: Flow<PagingData<JcChatMessage>>,
    chatConfig: JcChatConfig,
    mainViewModifier: Modifier = Modifier.fillMaxSize(),
    ownTextModifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(MaterialTheme.colors.primary)
        .padding(vertical = 8.dp, horizontal = 12.dp),
    otherTextModifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(MaterialTheme.colors.onSurface.copy(0.1f))
        .padding(vertical = 8.dp, horizontal = 12.dp),
    ownTextColor: Color = MaterialTheme.colors.onPrimary,
    otherTextColor: Color = MaterialTheme.colors.onSurface,
    ownTextStyle: TextStyle = MaterialTheme.typography.body2,
    otherTextStyle: TextStyle = MaterialTheme.typography.body2,
    imageMessageModifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .border(
            1.dp,
            MaterialTheme.colors.onSurface.copy(0.1f),
            RoundedCornerShape(8.dp)
        ),
    videoMessageModifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .border(
            1.dp,
            MaterialTheme.colors.onSurface.copy(0.1f),
            RoundedCornerShape(8.dp)
        )
        .width(200.dp)
        .height(200.dp),
    playIconButtonModifier: Modifier = Modifier
        .clip(CircleShape)
        .background(MaterialTheme.colors.onSurface.copy(0.5f)),
    playIconModifier: Modifier = Modifier
        .width(40.dp)
        .height(40.dp),
    playButtonResourceId: Int = R.drawable.ic_baseline_play_arrow_24,
    playIconTint: Color = MaterialTheme.colors.surface,
    onImageClick: (message: JcChatMessage, imageUrl: String) -> Unit,
    onVideoClick: (message: JcChatMessage) -> Unit,
    fullScreenLoadingState: @Composable () -> Unit,
    pageLoadingState: @Composable () -> Unit,
    errorState: @Composable () -> Unit
) {
    val messages = messageItems.collectAsLazyPagingItems()
    val listState = rememberLazyListState()
    if (messages.loadState.refresh is LoadState.Loading) {
        //You can add modifier to manage load state when first time response page is loading
        fullScreenLoadingState()
    } else {
        messages.apply {
            when (loadState.append) {
                is LoadState.Loading -> {
                    //You can add modifier to manage load state when next response page is loading
                    pageLoadingState()
                }
                is LoadState.Error -> {
                    //You can use modifier to show error message
                    errorState()
                }
            }
            LazyColumn(
                reverseLayout = true,
                state = listState,
                contentPadding = PaddingValues(top = 100.dp, bottom = 16.dp),
                modifier = mainViewModifier
            ) {
                items(messages) { _message ->
                    _message?.let { message ->
                        ChatMessageItem(message = message, chatConfig = chatConfig) {
                            when (message.type) {
                                JcChatType.TEXT -> {
                                    ChatMessageTextItem(
                                        ownTextModifier,
                                        otherTextModifier,
                                        ownTextColor,
                                        otherTextColor,
                                        ownTextStyle,
                                        otherTextStyle,
                                        chatConfig = chatConfig,
                                        message = message
                                    )
                                }
                                JcChatType.IMAGE -> {
                                    ChatMessageImageItem(
                                        imageMessageModifier,
                                        chatConfig = chatConfig,
                                        message = message,
                                        onImageClick = onImageClick
                                    )
                                }
                                JcChatType.AUDIO -> {
                                    ChatMessageAudioItem(
                                        chatConfig = chatConfig,
                                        message = message
                                    )
                                }
                                JcChatType.VIDEO -> {
                                    ChatMessageVideoItem(
                                        videoMessageModifier,
                                        playIconButtonModifier,
                                        playIconModifier,
                                        playButtonResourceId,
                                        playIconTint,
                                        chatConfig = chatConfig,
                                        message = message,
                                        onVideoClick = onVideoClick
                                    )
                                }
                                JcChatType.DOCUMENT -> {
                                    ChatMessageDocumentItem(
                                        chatConfig = chatConfig,
                                        message = message
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChatMessageItem(
    message: JcChatMessage,
    chatConfig: JcChatConfig,
    content: @Composable () -> Unit
) {
    val isOwnMessage = message.sentBy.uid == chatConfig.currentUserUid
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
    ) {
        Row(
            modifier = if (isOwnMessage) {
                Modifier.align(Alignment.CenterEnd).padding(start = 100.dp)
            } else {
                Modifier.align(Alignment.CenterStart).padding(end = 100.dp)
            }
        ) {
            if (isOwnMessage) {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    if (chatConfig.shouldDisplayUserNameForOwnImage) {
                        ChatMessageUserName(name = message.sentBy.name)
                    }
                    content()
                    ChatMessageTime(
                        time = message.messageTime
                    )
                }
                if (chatConfig.shouldDisplayUserImageForOwnMessage) {
                    Spacer(
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    UserProfilePicture(url = message.sentBy.profilePicture!!)
                }
            } else {
                if (chatConfig.shouldDisplayUserImageForOtherMessage) {
                    UserProfilePicture(url = message.sentBy.profilePicture!!)
                    Spacer(
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    if (chatConfig.shouldDisplayUserNameForOtherImage) {
                        ChatMessageUserName(name = message.sentBy.name)
                    }
                    content()
                    ChatMessageTime(
                        time = message.messageTime
                    )
                }
            }
        }
    }
}

@Composable
fun UserProfilePicture(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "",
        modifier = Modifier
            .clip(CircleShape)
            .width(30.dp)
            .height(30.dp)
    )
}

@Composable
fun ChatMessageTime(time: Long) {
    val timeText = SimpleDateFormat("h:mm a", Locale.getDefault())
    Text(
        text = timeText.format(Date(time)),
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun ChatMessageUserName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(2.dp)
    )
}