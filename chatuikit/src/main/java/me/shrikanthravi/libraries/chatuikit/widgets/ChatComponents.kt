package me.shrikanthravi.libraries.chatuikit.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import me.shrikanthravi.libraries.chatuikit.R
import me.shrikanthravi.libraries.chatuikit.models.JcChatConfig
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage

/**
 * Created by Shrikanth Ravi on 07-11-2021.
 */
@Composable
fun ChatMessageTextItem(
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
    chatConfig: JcChatConfig,
    message: JcChatMessage
) {
    val isOwnMessage = message.sentBy.uid == chatConfig.currentUserUid
    Text(
        text = message.message ?: "",
        color = if (isOwnMessage) {
            ownTextColor
        } else {
            otherTextColor
        },
        modifier = if (isOwnMessage) {
            ownTextModifier
        } else {
            otherTextModifier
        },
        style = if (isOwnMessage) {
            ownTextStyle
        } else {
            otherTextStyle
        }
    )
}

@ExperimentalCoilApi
@Composable
fun ChatMessageImageItem(
    imageModifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .border(
            1.dp,
            MaterialTheme.colors.onSurface.copy(0.1f),
            RoundedCornerShape(8.dp)
        ),
    chatConfig: JcChatConfig,
    message: JcChatMessage,
    onImageClick: (message: JcChatMessage, imageUrl: String) -> Unit
) {
    if (!message.attachmentUrls.isNullOrEmpty()) {
        when (message.attachmentUrls.size) {
            1 -> {
                Image(
                    painter = rememberImagePainter(message.attachmentUrls.first()),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                        .width(208.dp)
                        .height(208.dp)
                        .clickable {
                        onImageClick(
                            message,
                            message.attachmentUrls.first()
                        )
                    }
                )
            }
            2 -> {
                Row {
                    Image(
                        painter = rememberImagePainter(message.attachmentUrls[0]),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier
                            .width(100.dp)
                            .height(100.dp)
                            .clickable {
                            onImageClick(
                                message,
                                message.attachmentUrls[0]
                            )
                        }
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Image(
                        painter = rememberImagePainter(message.attachmentUrls[1]),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier =  imageModifier
                            .width(100.dp)
                            .height(100.dp)
                            .clickable {
                            onImageClick(
                                message,
                                message.attachmentUrls[1]
                            )
                        }
                    )
                }
            }
            else -> {
                Column {
                    Row {
                        Image(
                            painter = rememberImagePainter(message.attachmentUrls[0]),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                                .width(208.dp)
                                .height(100.dp)
                                .clickable {
                                onImageClick(
                                    message,
                                    message.attachmentUrls[0]
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Row {
                        Image(
                            painter = rememberImagePainter(message.attachmentUrls[1]),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                onImageClick(
                                    message,
                                    message.attachmentUrls[1]
                                )
                            }
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Box {
                            Image(
                                painter = rememberImagePainter(message.attachmentUrls[2]),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = imageModifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clickable {
                                    onImageClick(
                                        message,
                                        message.attachmentUrls[2]
                                    )
                                }
                            )
                            if (message.attachmentUrls.size > 3) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .width(100.dp)
                                        .height(100.dp)
                                        .background(MaterialTheme.colors.onSurface.copy(0.2f))
                                        .clickable { }
                                ) {
                                    Text(
                                        text = "+${message.attachmentUrls.size - 3}",
                                        color = MaterialTheme.colors.surface,
                                        style = MaterialTheme.typography.h4,
//                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.align(Alignment.Center)
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
fun ChatMessageAudioItem(
    chatConfig: JcChatConfig,
    message: JcChatMessage
) {
    // TODO: 12-11-2021 pending
    val playing = remember {
        mutableStateOf(false)
    }
    val position = remember {
        mutableStateOf(0F)
    }
    val isOwnMessage = remember {
        message.sentBy.uid == chatConfig.currentUserUid
    }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isOwnMessage) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.onSurface.copy(0.1f)
                }
            )
            .width(250.dp)
            .padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { playing.value = !playing.value }) {
            Icon(
                painter = painterResource(
                    if (playing.value) {
                        R.drawable.ic_baseline_pause_24
                    } else {
                        R.drawable.ic_baseline_play_arrow_24
                    }
                ),
                contentDescription = "",
                tint = if (isOwnMessage) {
                    MaterialTheme.colors.onPrimary
                } else {
                    MaterialTheme.colors.onSurface
                },
                modifier = Modifier
                    .width(34.dp)
                    .height(34.dp)
            )
        }
        Slider(
            value = position.value,
            valueRange = 0f..100f,
            onValueChange = {
                position.value = it
            },
            colors = if (isOwnMessage) {
                SliderDefaults.colors(
                    thumbColor = MaterialTheme.colors.onPrimary,
                    activeTrackColor = MaterialTheme.colors.onPrimary,
                    inactiveTickColor = MaterialTheme.colors.onPrimary.copy(0.2f)
                )
            } else {
                SliderDefaults.colors()
            },
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}


@ExperimentalCoilApi
@Composable
fun ChatMessageVideoItem(
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
    chatConfig: JcChatConfig,
    message: JcChatMessage,
    onVideoClick: (message: JcChatMessage) -> Unit
) {
    if (!message.attachmentUrls.isNullOrEmpty()) {
        Box() {
            Image(
                painter = rememberImagePainter(
                    data = message.previewPictureUrl
                ),
                contentDescription = "Video thumbnail",
                contentScale = ContentScale.Crop,
                modifier = videoMessageModifier
                    .clickable {
                        onVideoClick(message)
                    }
            )
            IconButton(
                onClick = {

                },
                modifier = playIconButtonModifier.align(Alignment.Center)
            ) {
                Icon(
                    painter = painterResource(playButtonResourceId),
                    contentDescription = "Play",
                    tint = playIconTint,
                    modifier = playIconModifier
                )
            }
        }
    }
}

@Composable
fun ChatMessageDocumentItem(
    chatConfig: JcChatConfig,
    message: JcChatMessage
) {
    // TODO: 12-11-2021 pending
}