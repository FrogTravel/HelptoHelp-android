package snu.kr.helptohelp.activities.event

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.model.event.Event
import snu.kr.helptohelp.model.profile.AnswerProfile

class EventPagePresenter(val view: EventPage.View) : EventPage.Presenter {
    companion object {
        val EVENT_ID = "id"
    }

    lateinit var event: Event
    val api = API.create()

    override fun setEventId(id: Int) {
        api.getEvent(id).enqueue(object : Callback<Event> {
            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                val eventResponce = response.body()
                event = eventResponce ?: DummyObjects.getDummyEvent()
                view.showEvent(event)
                view.showUser(event.host_user)
            }

            override fun onFailure(call: Call<Event>, t: Throwable) {
                t.printStackTrace()
            }

        })


    }

    private fun askForUser(id: Int){
        api.getUser(id).enqueue(object : Callback<User>{
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

    override fun onUserCard() {
        view.startUserPage(event.host_user.id)
    }

    override fun onChatClick() {
        view.startChatIntent(event.chatlink)
    }
}