package snu.kr.helptohelp.activities.newEvent

interface NewEvent {
    interface View {
        fun getEventTitle() : String
        fun getDescription() : String
    }

    interface Presenter {
        fun onAddEventClicked()
    }
}