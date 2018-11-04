package snu.kr.helptohelp.activities.userPage

import snu.kr.helptohelp.model.API

class UserPagePresenter(val view: UserPage.View): UserPage.Presenter{
    override fun setUserId(id: Int) {
        loadDataForUser(id)
    }

    fun loadDataForUser(id: Int){
        view.showUser(API.getUser(id))
    }

}