package snu.kr.helptohelp.activities.personalPage

import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.util.SharedPreferencesHelper

class PersonalPagePresenter(val view: PersonalPage.View) : PersonalPage.Presenter{
    val userId = -1
    val user : User
    var isEditMode = false

    init{
        val sharedPreferencesHelper = SharedPreferencesHelper(view.getContext())
        //user = APIPseudo.getUser(sharedPreferencesHelper.readUserId())
        user = APIPseudo.getUser(4)

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