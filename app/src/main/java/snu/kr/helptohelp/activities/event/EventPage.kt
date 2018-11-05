package snu.kr.helptohelp.activities.event

import snu.kr.helptohelp.model.Event

interface EventPage {
    interface View {
        fun showEvent(event: Event)
    }

    interface Presenter {
        fun setEventId(id: Int)
    }
}