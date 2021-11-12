package me.shrikanthravi.lib.chatui.utils

import me.shrikanthravi.libraries.chatuikit.models.JcChatMessage
import me.shrikanthravi.libraries.chatuikit.models.JcChatType
import me.shrikanthravi.libraries.chatuikit.models.JcChatUser
import java.util.*

/**
 * Created by Shrikanth Ravi on 07-11-2021.
 */

val newMessages = arrayListOf(
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Hey guys, have you checked out Jetpack Compose?"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Achyuta Satish", "https://cdn.discordapp.com/attachments/657618845313269808/908825653070159944/312216205002_ACHYUTASATISH.jpeg"),
        Date().time,
        "Nah man, I'm sticking to views."
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Did you know that it accelerates development, causes fewer crashes and is very efficient?"
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("cbx", "Debadyuti Bhattacharya", "https://i.pravatar.cc/150?img=11"),
        Date().time,
        null,
        listOf("https://i.redd.it/2he0amxzms271.jpg")
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Achyuta Satish", "https://cdn.discordapp.com/attachments/657618845313269808/908825653070159944/312216205002_ACHYUTASATISH.jpeg"),
        Date().time,
        "I'm so happy, I'm going to sing! \uD83C\uDFA4"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Please. don't."
    ),
    JcChatMessage(
        JcChatType.AUDIO,
        JcChatUser("cba", "Achyuta Satish", "https://cdn.discordapp.com/attachments/657618845313269808/908825653070159944/312216205002_ACHYUTASATISH.jpeg"),
        Date().time,
        null
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("aas", "Gautham Krishna", "https://i.pravatar.cc/150?img=52"),
        Date().time,
        "Guys, check out pictures from my Andaman trip."
    ),
    JcChatMessage(
        JcChatType.IMAGE,
        JcChatUser("aas", "Gautham Krishna", "https://i.pravatar.cc/150?img=52"),
        Date().time,
        null,
        listOf(
            "https://images.unsplash.com/photo-1497258149552-cf39daacceaa",
            "https://images.unsplash.com/photo-1615966650071-855b15f29ad1",
            "https://images.unsplash.com/photo-1621521089957-5c7b0cd9bf92",
            "https://images.unsplash.com/photo-1593202232996-15662bedb1e1",
            "https://images.unsplash.com/photo-1574616440943-a1fca0fa3216"
        )
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("aas", "Gautham Krishna", "https://i.pravatar.cc/150?img=52"),
        Date().time,
        "This is me scuba diving \uD83E\uDD3F"
    ),
    JcChatMessage(
        JcChatType.VIDEO,
        JcChatUser("aas", "Gautham Krishna", "https://i.pravatar.cc/150?img=52"),
        Date().time,
        "",
        listOf(""),
        previewPictureUrl = "https://images.unsplash.com/photo-1621521089957-5c7b0cd9bf92"
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("abc", "Shrikanth Ravi", "https://i.pravatar.cc/150?img=13"),
        Date().time,
        "Nice."
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cbx", "Debadyuti Bhattacharya", "https://i.pravatar.cc/150?img=11"),
        Date().time,
        "Nice."
    ),
    JcChatMessage(
        JcChatType.TEXT,
        JcChatUser("cba", "Achyuta Satish", "https://cdn.discordapp.com/attachments/657618845313269808/908825653070159944/312216205002_ACHYUTASATISH.jpeg"),
        Date().time,
        "Nice."
    )
)

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