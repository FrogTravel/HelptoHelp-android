package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName
import snu.kr.helptohelp.model.event.Event
import java.io.Serializable

data class User(@SerializedName("host_id") val id: Int,
                @SerializedName("host_name") var name : String,
                @SerializedName("host_age") var age: Int,
                @SerializedName("host_gender") var gender: String,
                @SerializedName("host_experience") val experience: Int,
                @SerializedName("host_language") var language : String,
                @SerializedName("host_description") var description : String,
                @SerializedName("host_tag") val tags : ArrayList<HostTag>,
                @SerializedName("profile_pic") val profile_pic : String,
                @SerializedName("host_isVerified") val isVerified : Boolean,
                @SerializedName("host_address") var address: String,
                @SerializedName("future_events") val futureEvents: ArrayList<Event>,
                @SerializedName("past_events") val pastEvents: ArrayList<Event>,
                @SerializedName("host_reviews") val reviews: ArrayList<Review>) : Serializable