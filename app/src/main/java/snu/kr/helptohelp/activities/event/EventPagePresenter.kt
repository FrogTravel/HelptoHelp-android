package snu.kr.helptohelp.activities.event

import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.Event

class EventPagePresenter(val view : EventPage.View) : EventPage.Presenter {
    companion object {
        val EVENT_ID = "event_id"
    }
    lateinit var event : Event

    override fun setEventId(id: Int) {
        event = APIPseudo.getEvent(0)
        view.showEvent(event)

    }

    override fun onUserCard() {
        view.startUserPage(event.hostUser.id)
    }

}