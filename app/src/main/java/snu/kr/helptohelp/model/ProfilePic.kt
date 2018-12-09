package snu.kr.helptohelp.model

class ProfilePic(url : String ){
    val url : String = url
        get() = field ?: "https://reviews.financesonline.com/media/themes/apps/images/img_placeholder_avatar.jpg" //Only Kotlin thinks that it is redundant though. It might be null if null comes from server
}