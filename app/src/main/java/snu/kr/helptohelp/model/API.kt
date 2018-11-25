package snu.kr.helptohelp.model

import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import snu.kr.helptohelp.BuildConfig

interface API{
    @FormUrlEncoded
    @POST
    fun addNewEvent(@Field("Host_id") hostId : Int,
                    @Field("Title") title: String,
                    @Field("Description") description: String,
                    @Field("Location") location: String,
                    @Field("Longitude") lng: Float,
                    @Field("Latitude") lat: Float)


    @GET("profiles/{id}")
    fun getUser(@Path("id") id: Int) : Call<Answer>

    companion object Factory{
        fun create(): API{
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()

            return retrofit.create(API::class.java)
        }
    }
}