package snu.kr.helptohelp.activities.personalPage

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.Answer
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.util.SharedPreferencesHelper

class PersonalPagePresenter(val view: PersonalPage.View) : PersonalPage.Presenter {
    val userId = -1
    lateinit var user: User
    var isEditMode = false


    init {
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
//        user = APIPseudo.getUser(1)
//        view.showUser(user)
        val api = API.create()
        api.getUser(1).enqueue(object : Callback<Answer> {

            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                val answer = response.body()
                user = answer?.data?.profile ?: User(-1, "NULL", "NULL", -1, "NULL", isVerified = false)
                view.showUser(user)
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

    override fun onModeChange() {
        isEditMode = !isEditMode

        changeView()
    }

    private fun changeView() {
        if (isEditMode) {
            view.showEditMode()
            view.showUserEdit(user)
        } else {
            view.showProfileMode()
            view.showUser(user)
        }
    }

    override fun saveUser() {
        user.name = view.getNewUserName()
        user.description = view.getNewUserDescription()
    }

}