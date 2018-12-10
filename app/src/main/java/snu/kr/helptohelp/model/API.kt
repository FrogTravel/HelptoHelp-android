package snu.kr.helptohelp.model

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import snu.kr.helptohelp.BuildConfig
import snu.kr.helptohelp.model.event.AnswerEvent
import snu.kr.helptohelp.model.event.Event
import snu.kr.helptohelp.model.profile.AnswerProfile

interface API{
    @FormUrlEncoded
    @POST
    fun addNewEvent(@Field("Host_id") hostId : Int,
                    @Field("Title") title: String,
                    @Field("Description") description: String,
                    @Field("Location") location: String,
                    @Field("Longitude") lng: Float,
                    @Field("Latitude") lat: Float)


    @GET("profiles/{host_user}")
    fun getUser(@Path("host_user") id: Int) : Call<User>

    @GET("events/{id}")
    fun getEvent(@Path("id") eventId: Int) : Call<Event>

    @GET("profiles/mypage")
    fun getCurrentUser() : Call<User>

    @POST()
    fun matchUser()

    @POST("events/")
    @FormUrlEncoded
    fun addEvent(@FieldMap params : Map<String, String>) : Call<Event>


    companion object Factory{
        fun create(): API{
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(OkHttpClient())
                    .build()

            return retrofit.create(API::class.java)
        }
    }
}