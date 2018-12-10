package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName

class ProfilePic(url : String? ){
    @SerializedName("url") val url : String? = url
        get() = field ?: "https://reviews.financesonline.com/media/themes/apps/images/img_placeholder_avatar.jpg"
}