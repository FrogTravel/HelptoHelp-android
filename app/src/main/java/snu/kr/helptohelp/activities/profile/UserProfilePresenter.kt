package snu.kr.helptohelp.activities.profile

import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.util.SharedPreferencesHelper

class UserProfilePresenter(val view: UserProfile.View) : UserProfile.Presenter{
    val userId = -1
    val user : User
    var isEditMode = false

    init{
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
        //user = API.getUser(sharedPreferencesHelper.readUserId())
        user = API.getUser(4)

        view.showUser(user)
    }

    override fun onModeChange() {
        isEditMode = !isEditMode

        changeView()
    }

    private fun changeView(){
        if(isEditMode){
            view.showEditMode()
            view.showUserEdit(user)
        }else{
            view.showProfileMode()
            view.showUser(user)
        }
    }

    override fun saveUser() {
        user.name = view.getNewUserName()
        user.description = view.getNewUserDescription()
    }

}