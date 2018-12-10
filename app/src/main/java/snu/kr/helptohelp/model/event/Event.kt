package snu.kr.helptohelp.model.event

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field
import snu.kr.helptohelp.model.User

data class Event(@SerializedName("event_id") val id: Int = -1,
                 @SerializedName("host_profile") val host_user: User,
                 @SerializedName("event_title") val title: String,
                 @SerializedName("event_description") val description: String,
                 @SerializedName("event_location") val location: String,
                 @SerializedName("event_hosted") val hosted_date: String /*Date of event if it is finished (?)*/,
                 @SerializedName("event_chatlink") val chatlink: String,
                 val reviewed: Boolean /*Has some reviews on the event*/)