package snu.kr.helptohelp.activities.personalPage

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.profile.AnswerProfile
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.util.SharedPreferencesHelper

class PersonalPagePresenter(val view: PersonalPage.View) : PersonalPage.Presenter {
    val userId = -1
    lateinit var user: User
    var isEditMode = false


    init {
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
//        name = APIPseudo.getName(1)
//        view.showUser(name)
        val api = API.create()
        api.getUser(1).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val answer = response.body()
                user = answer ?: DummyObjects.getDummyUser()
                view.showUser(user)
                //view.showTags(answer.t ?: arrayListOf())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
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
//        name.name = view.getNewUserName()
//        name.description = view.getNewUserDescription()
    }

}