package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostAnswerMatchUser(@SerializedName("data") val dataArrayList: ArrayList<UserMatch>) : Serializable