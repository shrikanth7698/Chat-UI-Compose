package me.shrikanthravi.lib.chatui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import me.shrikanthravi.lib.chatui.ui.theme.ChatUIKitTheme
import me.shrikanthravi.libraries.chatuikit.models.JcChatConfig
import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage
import me.shrikanthravi.libraries.chatuikit.models.JcChatType
import me.shrikanthravi.libraries.chatuikit.models.JcChatUser
import me.shrikanthravi.libraries.chatuikit.widgets.ChatViewItem
import java.util.*

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            ChatUIKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ChatComponent(viewModel)
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun ChatComponent(viewModel: MainViewModel) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        val textState = remember {
            mutableStateOf(TextFieldValue())
        }
        ChatViewItem(
            messageItems = viewModel.messageItems,
            chatConfig = JcChatConfig(
                currentUserUid = "abc",
                shouldDisplayUserImageForOwnMessage = false,
                shouldDisplayUserImageForOtherMessage = true,
                shouldDisplayUserNameForOwnImage = false,
                shouldDisplayUserNameForOtherImage = true
            ),
            mainViewModifier = Modifier.weight(1f),
            onImageClick = { message, imageUrl ->

            },
            onVideoClick = { message ->

            },
            fullScreenLoadingState = {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            pageLoadingState = {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                            .background(Color.Transparent)
                    )
                }
            },
            errorState = {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    text = "Something went wrong!"
                )
            }
        )
        Divider()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 8.dp)
        ) {
            BasicTextField(
                value = textState.value,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {
                    textState.value = it
                },
                cursorBrush = SolidColor(MaterialTheme.colors.onSurface),
                textStyle = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onSurface
                )
            )
            IconButton(
                onClick = {
                    viewModel.addMessage(
                        JcChatMessage(
                            type = JcChatType.TEXT,
                            sentBy = JcChatUser(
                                "abc",
                                "Shrikanth Ravi",
                                "https://i.pravatar.cc/150?img=13"
                            ),
                            Date().time,
                            textState.value.text
                        )
                    )
                    textState.value = TextFieldValue("")
                }
            ) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "")
            }
        }
    }
}