package me.shrikanthravi.libraries.chatuikit.models

/**
 * Created by Shrikanth Ravi on 07-11-2021.
 */
data class JcChatMessage(
    val type: JcChatType = JcChatType.TEXT,
    val sentBy: JcChatUser,
    val messageTime: Long,
    val message: String? = null,
    val attachmentUrls: List<String>? = null,
    val previewPictureUrl: String? = null
)
