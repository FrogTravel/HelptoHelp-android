package snu.kr.helptohelp.activities.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.BuildConfig
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.login.LoginView
import snu.kr.helptohelp.activities.myEvents.MyEventsActivity
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.LocalUser
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.util.SharedPreferencesHelper

/**
 * This acrivity is for checking if the name is logged in
 */
class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = API.create()

//        api.getName(1).enqueue(object : Callback<User> {
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                t.printStackTrace()
//            }
//
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                val name = response.body()
//
//
//                LocalUser.name = name ?: DummyObjects.getDummyUser()
//
//                startActivity(Intent(baseContext, MyEventsActivity::class.java))
//
//            }
//
//        })


    }


    override fun onResume() {
        super.onResume()
         requestForLogin()
    }

    fun requestForLogin() {
        val api = API.create()
        val userId = SharedPreferencesHelper(this).readUserId()


        if (userId == -1) {//If there is no ID
            api.getCurrentUser().enqueue(object : Callback<User> {//TODO change to getCurrentUser() it returns 500 error for some reason
                override fun onFailure(call: Call<User>, t: Throwable) {
                    t.printStackTrace()

                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.SUPER_BASE_URL + "visitor/main"))
                    startActivity(browserIntent)
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val user = response.body()

                  //  if (user == null) {
//                        startActivity(Intent(baseContext, LoginView::class.java))
                   //     val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.SUPER_BASE_URL + "visitor/main"))
                     ///   startActivity(browserIntent)
                    //} else {

                    api.getUser(1).enqueue(object : Callback<User> {
                        override fun onFailure(call: Call<User>, t: Throwable) {
                            t.printStackTrace()
                        }

                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            val user = response.body()


                            LocalUser.user = user ?: DummyObjects.getDummyUser()
                            startActivity(Intent(baseContext, MyEventsActivity::class.java))
                            finish()
                        }

                    })
                   // }
                }

            })


        } else {
            api.getUser(userId).enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(baseContext, "User not found!", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val user = response.body()
                    LocalUser.user = user ?: DummyObjects.getDummyUser() //TODO Неправильно. Нужно показывать ошибку

                    startActivity(Intent(baseContext, MyEventsActivity::class.java))

                }

            })
        }
    }


}