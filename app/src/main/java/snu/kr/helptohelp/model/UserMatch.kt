package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName

data class UserMatch(@SerializedName("id")val id: Int,
                     @SerializedName("name")val name: String,
                     @SerializedName("description") val description: String,
                     @SerializedName("profile_pic") val profilePic: String,
                     @SerializedName("address") val address: String?)