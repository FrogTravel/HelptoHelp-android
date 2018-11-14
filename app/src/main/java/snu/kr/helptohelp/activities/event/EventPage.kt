package snu.kr.helptohelp.activities.event

import snu.kr.helptohelp.model.Event

interface EventPage {
    companion object {
        val EVENT_ID = "event_id"
    }

    interface View {
        fun showEvent(event: Event)
        fun startUserPage(userId: Int)
    }

    interface Presenter {
        fun setEventId(id: Int)
        fun onUserCard()
    }
}