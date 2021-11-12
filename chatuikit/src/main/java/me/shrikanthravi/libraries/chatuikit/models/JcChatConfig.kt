package me.shrikanthravi.libraries.chatuikit.models

/**
 * Created by Shrikanth Ravi on 07-11-2021.
 */
data class JcChatConfig(
    val currentUserUid: String,
    val shouldDisplayUserImageForOwnMessage: Boolean = false,
    val shouldDisplayUserImageForOtherMessage: Boolean = false,
    val shouldDisplayUserNameForOwnImage: Boolean = false,
    val shouldDisplayUserNameForOtherImage: Boolean = false
)
