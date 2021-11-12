package me.shrikanthravi.lib.chatui.utils

import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage
import me.shrikanthravi.libraries.chatuikit.models.JcChatType
import me.shrikanthravi.libraries.chatuikit.models.JcChatUser
import java.util.*

/**
 * Created by Shrikanth Ravi on 07-11-2021.
 */

val messages = arrayListOf(
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Hi, How are you doing?"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "I'm doing good, What about you?"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Hi, Hope you are doing well"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "I'm doing good, What about you?"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Hi, Hope you are doing well"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "I'm doing good, What about you?"
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "I'm doing good, What about you?",
        listOf("https://i.pravatar.cc/300?img=12"),
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "",
        listOf("https://i.pravatar.cc/300?img=23", "https://i.pravatar.cc/300?img=21")
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "",
        listOf(
            "https://i.pravatar.cc/300?img=23",
            "https://i.pravatar.cc/300?img=21",
            "https://i.pravatar.cc/300?img=20"
        )
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "",
        listOf(
            "https://i.pravatar.cc/300?img=23",
            "https://i.pravatar.cc/300?img=21",
            "https://i.pravatar.cc/300?img=20",
            "https://i.pravatar.cc/300?img=7"
        )
    ),
    JcChatMessage(
        JcChatType.AUDIO,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "",
        listOf(
            "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_1MG.mp3"
        )
    ),
    JcChatMessage(
        JcChatType.AUDIO,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "",
        listOf(
            "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_1MG.mp3"
        )
    ),
    JcChatMessage(
        JcChatType.VIDEO,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "",
        listOf(""),
        "https://i.pravatar.cc/300?img=23"

    ),
    JcChatMessage(
        JcChatType.VIDEO,
        JcChatUser("cba", "Hulda Gudmund", "https://i.pravatar.cc/150?img=1"),
        Date().time,
        "",
        listOf(""),
        "https://i.pravatar.cc/300?img=32"
    )
)