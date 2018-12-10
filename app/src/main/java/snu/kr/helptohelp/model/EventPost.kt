package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName

data class EventPost(@SerializedName("title") var title: String,
                     @SerializedName("host_id") var hostId: Int,
                     @SerializedName("description") var description: String,
                     @SerializedName("location") var location: String,
                     @SerializedName("chatlink") var chatlink: String,
                     @SerializedName("tag_raw") var tagRaw: String) {
    fun getMap() = mapOf(Pair("host_id", hostId.toString()),
            Pair("title", title),
            Pair("description", description),
            Pair("location", location),
            Pair("chatlink", chatlink),
            Pair("tag_raw", tagRaw))
}