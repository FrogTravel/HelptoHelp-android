package snu.kr.helptohelp.activities.profile

import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.util.SharedPreferencesHelper

class UserProfilePresenter(val view: UserProfile.View) : UserProfile.Presenter{
    val userId = -1
    val user : User

    init{
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
        user = API.getUser(sharedPreferencesHelper.readUserId())

        view.showUser(user)
    }
}