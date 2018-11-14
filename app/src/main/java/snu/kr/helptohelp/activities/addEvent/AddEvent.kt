package snu.kr.helptohelp.activities.addEvent

interface AddEvent {
    interface View {
        fun getEventTitle() : String
        fun getDescription() : String
    }

    interface Presenter {
        fun onAddEventClicked()
    }
}