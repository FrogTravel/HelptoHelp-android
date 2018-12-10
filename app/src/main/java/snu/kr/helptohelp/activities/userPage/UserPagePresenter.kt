package snu.kr.helptohelp.activities.userPage

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.model.profile.AnswerProfile

class UserPagePresenter(val view: UserPage.View): UserPage.Presenter{
    val api = API.create()

    override fun setUserId(id: Int) {
        loadDataForUser(id)
    }

    fun loadDataForUser(id: Int){
        api.getUser(id).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val answerProfile = response.body()
                val user = answerProfile ?: DummyObjects.getDummyUser()
                view.showUser(user)
            }

        })

    }

}