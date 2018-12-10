package snu.kr.helptohelp.activities.addEvent

interface AddEvent {
    interface View {
        fun getEventTitle(): String
        fun getDescription(): String
        fun getLocation(): String
        fun getChatlink(): String
        fun getTagRaw(): String
    }

    interface Presenter {
        fun onAddEventClicked()
    }
}