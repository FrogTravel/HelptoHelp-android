package snu.kr.helptohelp.activities.event

import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.event.Event

interface EventPage {
    companion object {
        val EVENT_ID = "id"
    }

    interface View {
        fun showEvent(event: Event)
        fun showUser(user: User)
        fun startUserPage(userId: Int)
        fun startChatIntent(uri: String)
    }

    interface Presenter {
        fun setEventId(id: Int)
        fun onUserCard()
        fun onChatClick()
    }
}