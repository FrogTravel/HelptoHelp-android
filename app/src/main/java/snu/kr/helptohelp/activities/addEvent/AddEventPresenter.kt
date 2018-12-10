package snu.kr.helptohelp.activities.addEvent

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.EventPost
import snu.kr.helptohelp.model.LocalUser
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.model.event.Event

class AddEventPresenter(val view: AddEvent.View) : AddEvent.Presenter {
    override fun onAddEventClicked() {
        val api = API.create()
        val eventPost = EventPost(title = view.getEventTitle(),
                hostId = LocalUser.user.id,
                description = view.getDescription(),
                location = view.getLocation(),
                chatlink = view.getChatlink(),
                tagRaw = view.getTagRaw())

        api.addEvent(eventPost.getMap()).enqueue(object : Callback<Event> {
            override fun onFailure(call: Call<Event>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                val event = response.body()
            }

        })
    }

    //TODO change to get current name
    fun getEventFromView() = DummyObjects.getDummyEvent()

}