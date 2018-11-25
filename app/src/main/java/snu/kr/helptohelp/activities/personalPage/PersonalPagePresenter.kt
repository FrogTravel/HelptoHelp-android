package snu.kr.helptohelp.activities.personalPage

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.util.SharedPreferencesHelper

class PersonalPagePresenter(val view: PersonalPage.View) : PersonalPage.Presenter {
    val userId = -1
    lateinit var user: User
    var isEditMode = false
    val api = API.create()

    init {
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
        //user = APIPseudo.getUser(sharedPreferencesHelper.readUserId())
        api.getUser(1).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                user = response.body() ?: User(-1, "NULL", "NULL", -1, "NULL", isVerified = false)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

        })
        view.showUser(user)
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