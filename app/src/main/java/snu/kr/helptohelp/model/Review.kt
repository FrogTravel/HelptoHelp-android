package snu.kr.helptohelp.model

import com.google.gson.annotations.SerializedName

data class Review(@SerializedName("review_content") val reviewText : String = "Nothing is here... Sorry",
                  @SerializedName("reviewed_by") val name: String,
                  @SerializedName("reviewer_profile_pic") val picture: String,
                  @SerializedName("review_rating") val userGrade: Int)