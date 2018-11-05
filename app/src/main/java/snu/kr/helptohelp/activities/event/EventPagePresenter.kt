package snu.kr.helptohelp.activities.event

import snu.kr.helptohelp.model.API

class EventPagePresenter(val view : EventPage.View) : EventPage.Presenter {
    companion object {
        val EVENT_ID = "event_id"
    }

    override fun setEventId(id: Int) {
        view.showEvent(API.getEvent(0))

    }

}