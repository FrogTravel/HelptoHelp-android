package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName
import snu.kr.helptohelp.model.event.Event

data class User(@SerializedName("host_id") val id: Int,
                @SerializedName("host_name") val name : String,
                @SerializedName("host_age") val age: Int,
                @SerializedName("host_description") val description : String,
                @SerializedName("profile_pic") val profile_pic : String,
                @SerializedName("host_isVerified") val isVerified : Boolean,
                @SerializedName("host_address") val address: String,
                @SerializedName("future_events") val futureEvents: ArrayList<Event>,
                @SerializedName("past_events") val pastEvents: ArrayList<Event>,
                @SerializedName("host_reviews") val reviews: ArrayList<Review>)