package snu.kr.helptohelp.activities.newEvent

import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.Event

class NewEventPresenter(val view: NewEvent.View) : NewEvent.Presenter{
    override fun onAddEventClicked() {
        API.addEvent(getEventFromView())
    }

    fun getEventFromView() = Event(hostUser = API.getCurrentUser(),title =  view.getEventTitle(),
            description = view.getDescription(), location =  "Seoul")

}